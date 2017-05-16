package com.github.minyk.dcos.marathon.eventbus;

import com.launchdarkly.eventsource.EventSource;
import okhttp3.Headers;

import java.io.IOException;
import java.net.URI;


public class MarathonEventBus {
    private volatile EventSource es;

    public MarathonEventBus(String marathonEndpoint, MarathonEventHandler handler) {

        Headers headers = new Headers.Builder()
                .add("User-Agent", "JavaClient/MarathonEventHandler")
                .build();

        EventSource.Builder builder = new EventSource.Builder(handler, URI.create(marathonEndpoint + "/v2/events"))
                .headers(headers)
                .reconnectTimeMs(3000);

//        if (config.proxy != null) {
//            builder.proxy(config.proxy);
//            if (config.proxyAuthenticator != null) {
//                builder.proxyAuthenticator(config.proxyAuthenticator);
//            }
//        }

        es = builder.build();
    }

    public void start() {
        es.start();
    }

    public void close() throws IOException {
        es.close();
    }

}
