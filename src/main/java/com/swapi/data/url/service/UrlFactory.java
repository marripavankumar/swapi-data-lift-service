package com.swapi.data.url.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UrlFactory {

    @Autowired
    private List<UrlService> services;

    private static final Map<String, UrlService> urlServiceCache = new HashMap<>();

    @PostConstruct
    public void initMyServiceCache() {
        for(UrlService service : services) {
            urlServiceCache.put(service.getType(), service);
        }
    }

    public static UrlService getService(String type) {
    	UrlService service = urlServiceCache.get(type);
        return service;
    }
}
