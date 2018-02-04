package com.leftiejy.repository;

import com.leftiejy.model.Url;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class UrlRepository extends CommonRepository<Url, Long>{
    public long getNextId() {
        BigInteger nextId = (BigInteger) createSQLQuery(
                "SELECT AUTO_INCREMENT as nextId\n" +
                "FROM information_schema.tables\n" +
                "WHERE table_name = 'shorten_url'")
            .addScalar("nextId")
            .uniqueResult();
        return nextId.longValue();
    }

    public Url findByKey(String hashKey, String encodedIndex) {
        return (Url) this.createCriteria()
            .add(Restrictions.eq("hashKey", hashKey))
            .add(Restrictions.eq("encodedIndex", encodedIndex))
            .uniqueResult();
    }

    public Url findByOriginUrl(String hashKey, String originUrl) {
        return (Url) this.createCriteria()
            .add(Restrictions.eq("hashKey", hashKey))
            .add(Restrictions.eq("originUrl", originUrl))
            .uniqueResult();
    }
}
