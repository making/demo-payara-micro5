package com.example;

import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheResult;
import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.TimeUnit;

/**
 * https://github.com/kazuhira-r/hazelcast-examples/blob/master/payara-micro-jcache-example/src/main/java/org/littlewings/hazelcast/service/CalcService.java
 */
@CacheDefaults(cacheName = "calcCache")
@ApplicationScoped
public class CalcService {
    @CacheResult
    public int add(int a, int b) {
        try {
            TimeUnit.SECONDS.sleep(5L);
        } catch (InterruptedException e) {
        }

        return a + b;
    }
}