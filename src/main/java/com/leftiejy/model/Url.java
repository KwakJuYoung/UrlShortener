package com.leftiejy.model;

/**
 * Created by leftiejy on 2018. 2. 3..
 */
public class Url {
    private long id;
    private String key;
    private String originUrl;

    public Url() {
    }

    public Url(long id, String key, String originUrl) {
        this.id = id;
        this.key = key;
        this.originUrl = originUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Url url = (Url) o;

        if (id != url.id) return false;
        if (key != null ? !key.equals(url.key) : url.key != null) return false;
        return !(originUrl != null ? !originUrl.equals(url.originUrl) : url.originUrl != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (originUrl != null ? originUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Url{" +
            "id=" + id +
            ", key='" + key + '\'' +
            ", originUrl='" + originUrl + '\'' +
            '}';
    }
}
