package com.leftiejy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by leftiejy on 2018. 2. 3..
 */
@Entity
@Table(name = "SHORTEN_URL",
    indexes = @Index(name = "SHORTEN_PATH", columnList = "SHORTEN_PATH")
)
public class Url implements Serializable{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "SHORTEN_PATH", nullable = false, length=8)
    private String shortenPath;

    @Column(name = "ORIGIN_URL", nullable = false, columnDefinition = "text")
    private String originUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date registeredDate = new Date(System.currentTimeMillis());

    public Url() {
    }

    public Url(long id, String key, String originUrl) {
        this.id = id;
        this.shortenPath = key;
        this.originUrl = originUrl;
        this.registeredDate = new Date(System.currentTimeMillis());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShortenPath() {
        return shortenPath;
    }

    public void setShortenPath(String shortenPath) {
        this.shortenPath = shortenPath;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Url url = (Url) o;

        if (id != url.id) return false;
        if (shortenPath != null ? !shortenPath.equals(url.shortenPath) : url.shortenPath != null) return false;
        return !(originUrl != null ? !originUrl.equals(url.originUrl) : url.originUrl != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (shortenPath != null ? shortenPath.hashCode() : 0);
        result = 31 * result + (originUrl != null ? originUrl.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Url{" +
            "id=" + id +
            ", shortenPath='" + shortenPath + '\'' +
            ", originUrl='" + originUrl + '\'' +
            '}';
    }
}
