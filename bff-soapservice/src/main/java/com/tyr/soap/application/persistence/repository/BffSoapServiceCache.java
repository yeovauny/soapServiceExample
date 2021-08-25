package com.tyr.soap.application.persistence.repository;


import com.tyr.soap.application.domain.User;
import com.tyr.soap.application.domain.generated.SearchUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@DependsOn("CacheConfig")
public class BffSoapServiceCache {
    private static final String CACHE_NAME = "BffSoapServiceCache";

    private  CacheManager cacheManager;


    private Cache bffSoapServiceCache;

    public BffSoapServiceCache(CacheManager cacheManager){
        this.cacheManager =cacheManager;
        this.bffSoapServiceCache = this.cacheManager.getCache(CACHE_NAME);


    }

    public void set(String key, SearchUserResponse user){
        this.bffSoapServiceCache.put(key,user);
    }

    public SearchUserResponse get(String key){
        SearchUserResponse user =bffSoapServiceCache.get(key, SearchUserResponse.class);
        return user;
    }

}
