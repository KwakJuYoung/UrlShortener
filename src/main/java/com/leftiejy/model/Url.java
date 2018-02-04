package com.leftiejy.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by leftiejy on 2018. 2. 3..
 */
@Entity
@Table(name = "SHORTEN_URL",
    indexes = @Index(name = "HASH_KEY", columnList = "HASH_KEY")
)
public class Url implements Serializable{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "HASH_KEY", nullable = false, length = 3)
    private String hashKey;

    @Column(name = "ENCODED_INDEX", nullable = false, length=8)
    private String encodedIndex;

    @Column(name = "ORIGIN_URL", nullable = false, columnDefinition = "text")
    private String originUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false, nullable = false)
    private Date registeredDate = new Date(System.currentTimeMillis());

    @Column(name = "CALL_COUNT")
    private Integer callCount = 0;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date lastUpdateDate = null;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEncodedIndex() {
        return encodedIndex;
    }

    public void setEncodedIndex(String encodedIndex) {
        this.encodedIndex = encodedIndex;
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

    public Integer getCallCount() {
        return callCount;
    }

    public void setCallCount(Integer callCount) {
        this.callCount = callCount;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public void increaseCallCount() {
        this.callCount++;
    }

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }


}
