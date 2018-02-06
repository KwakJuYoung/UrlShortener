var UrlList = function () {
	var _urlList;
	var url = "/urls";

	var init = function (urlList) {
		_urlList = urlList;
		redraw();
		bindEvent();
	};

	var addUrl = function() {
		var originUrl = $("#input_url").val().trim();
		if (originUrl.length == 0) {
			PopUp.openMessageModal("url을 입력해주세요");
			return;
		}

		var urlObj = {
			originUrl : originUrl
		};
		$.ajax({
			url: url,
			type: "post",
			data: JSON.stringify(urlObj),
			contentType: "application/json"
		}).done(function (result) {
			PopUp.openAddSuccessModal(result);
			redraw();
			$("#input_url").val("");
		}).fail(function (result) {
			PopUp.openFailModal(result);
			console.error(result);
		});
	};

	var deleteUrl = function(id) {
		$.ajax({
			url: url + "/" + id,
			type: "delete",
			contentType: "application/json"
		}).done(function (result) {
			PopUp.openMessageModal("삭제되었습니다.");
			redraw();
			$("#input_url").val("");
		}).fail(function (result) {
			PopUp.openFailModal(result);
			console.error(result);
		});
	};

	var getUrl = function (callback) {
		$.ajax({
			url: url,
			type: "get",
			contentType: "application/json"
		}).done(function (result) {
			if (callback) {
				callback.call(null, result);
			}
		}).fail(function (result) {
			PopUp.openFailModal(result);
			console.error(result);
		});
	};

	var redraw = function () {
		var redrawCallback = function(result) {
			_urlList = result;
			var $urlList = $("#url_list tbody");
			$urlList.empty();
			for (var i = 0; i < _urlList.length; i++) {
				var url = _urlList[i];
				var $urlItem = new UrlItem(url, deleteUrl);
				$urlList.append($urlItem);
			}
		};
		getUrl(redrawCallback);
	};

	var bindEvent = function () {
		$("#add_btn").click(function() {
			addUrl();
		})
	};
	return {
		init: init
	};
};

var UrlItem = function (urlObj, deleteCallback) {
	var _urlObj = urlObj;

	var drawDeleteBtn = function (urlid) {
		var $deleteBtnArea = $("<td>")
			.addClass("delete-btn-area");

		var $deleteBtn = $("<input type='button'>")
			.addClass("delete-btn")
			.addClass("btn btn-default")
			.attr("urlid", urlid)
			.val("삭제")
			.click(function () {
				var urlid = $(this).attr("urlid");
				deleteCallback.call(null, urlid);
			});

		$deleteBtnArea.append($deleteBtn);

		return $deleteBtnArea;
	};

	var drawCallCount = function (callCount) {
		return $("<td>")
			.addClass("call-count")
			.text(callCount);
	};

	var drawShortenUrl = function (shortenUrl) {
		return $("<td>")
			.addClass("shorten-url")
			.text(shortenUrl);
	};

	var drawOriginUrl = function (originUrl) {
		$originUrl = $("<td>")
			.addClass("origin-url")
			.text(originUrl);
		//TODO 툴팁
		return $originUrl
	};

	var $item = $("<tr>").addClass("url-item");
	$item.attr("urlid", _urlObj.id);


	var $originUrl = drawOriginUrl(_urlObj.originUrl);
	var $shortenUrl = drawShortenUrl(document.URL + _urlObj.hashKey + _urlObj.encodedIndex);
	var $count = drawCallCount(_urlObj.callCount);
	var $deleteBtn = drawDeleteBtn(_urlObj.id);

	$item.append($originUrl);
	$item.append($shortenUrl);
	$item.append($count);
	$item.append($deleteBtn);

	return $item;
};

var PopUp = {
	openMessageModal : function(message) {
		var $popup = $("#popup");
		var $content = $popup.find("#content");
		$content.empty();
		$content.append($("<h2>").text(message));

		$popup.modal();
	},
	openFailModal : function(result) {
		var $popup = $("#popup");
		var $content = $popup.find("#content");
		$content.empty();
		var urlObj = result.responseJSON;
		switch (result.status) {
			case 409:
				$content.append($("<h4>").text("이미 등록된 URL 입니다."));
				$content.append($("<h5>").text(urlObj.originUrl));
				$content.append($("<h5>").text(document.URL + urlObj.hashKey + urlObj.encodedIndex));
				break;
			case 204:
				$content.append($("<h4>").text("존재하지 않는 URL 입니다."));
				break;
			case 200:
				$content.append($("<h4>").text("등록되었습니다."));
				$content.append($("<h5>").text(urlObj.originUrl));
				$content.append($("<h5>").text(document.URL + urlObj.hashKey + urlObj.encodedIndex));
				break;
			default:
				$content.append(result);
				break;
		}

		$popup.modal();
	},
	openAddSuccessModal : function(result) {
		var $popup = $("#popup");
		var $content = $popup.find("#content");
		var urlObj = result;
		$content.empty();
		$content.append($("<h4>").text("등록되었습니다."));
		$content.append($("<h5>").text(urlObj.originUrl));
		$content.append($("<h5>").text(document.URL + urlObj.hashKey + urlObj.encodedIndex));

		$popup.modal();
	}
};