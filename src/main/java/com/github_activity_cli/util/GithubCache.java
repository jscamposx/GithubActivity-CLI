package com.github_activity_cli.util;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GithubCache {

    private static final long CACHE_EXPIRATION_TIME_MS = 5 * 60 * 1000;
    private static final Map<String, CacheEntry> cache = new ConcurrentHashMap<>();

    public static void put(String key, Object value) {
        cache.put(key, new CacheEntry(value, Instant.now().toEpochMilli()));
    }

    public static Object get(String key) {
        CacheEntry cacheEntry = cache.get(key);
        if (cacheEntry != null && (Instant.now().toEpochMilli() - cacheEntry.timestamp) < CACHE_EXPIRATION_TIME_MS) {
            return cacheEntry.value;
        } else {
            cache.remove(key);
            return null;
        }
    }

    private static class CacheEntry {
        private final Object value;
        private final long timestamp;

        public CacheEntry(Object value, long timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
