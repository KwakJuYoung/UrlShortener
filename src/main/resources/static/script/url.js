var UrlList = function () {
	var _urlList;
	var init = function (urlList) {
		_urlList = urlList;
		redraw();
		bindEvent();
	};

	var redraw = function () {
		var url = "/urls/";

		$.ajax({
			url: url,
			type: "get",
			contentType: "application/json"
		}).done(function (result) {
			_urlList = result;
			var $urlList = $("#url_list");
			$urlList.empty();
			for (var i = 0; i < _urlList.length; i++) {
				var url = _urlList[i];
				var $urlItem = new UrlItem(url);

				$urlList.append($urlItem);
			}

		}).fail(function (result) {
			console.error(result);
		})
	};

	var addUrl = function() {
		var url = $("#input_url").val();
		var data = {
			originUrl : url
		};
		$.ajax({
			url: "/urls",
			type: "post",
			data: JSON.stringify(data),
			contentType: "application/json"
		}).done(function (result) {
			console.log(result);
			redraw();
			$("#input_url").val("");
		}).fail(function (result) {
			console.error(result);
		})
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

var UrlItem = function (url) {
	var _url = url;

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
				alert(urlid);
			});

		$deleteBtnArea.append($deleteBtn);

		return $deleteBtnArea;
	};

	var drawCallCount = function (callCount) {
		var $count = $("<td>")
			.addClass("call-count")
			.text(callCount);
		return $count;
	};

	var drawShortenUrl = function (shortenUrl) {
		var $shortenUrl = $("<td>")
			.addClass("shorten-url")
			.text(shortenUrl);
		return $shortenUrl;
	};

	var drawOriginUrl = function (originUrl) {
		var $originUrl = $("<td>")
			.addClass("origin-url")
			.text(originUrl);
		return $originUrl;
	};

	var $item = $("<tr>").addClass("url-item");
	$item.attr("urlid", _url.id);


	var $originUrl = drawOriginUrl(_url.originUrl);
	var $shortenUrl = drawShortenUrl(document.URL + _url.hashKey + _url.encodedIndex);
	var $count = drawCallCount(_url.callCount);
	var $deleteBtn = drawDeleteBtn(_url.id);

	$item.append($originUrl);
	$item.append($shortenUrl);
	$item.append($count);
	$item.append($deleteBtn);

	return $item;
};
