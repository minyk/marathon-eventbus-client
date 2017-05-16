package com.github.minyk.dcos.marathon.eventbus.event.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mesosphere.marathon.client.utils.ModelUtils;

import java.util.Date;

public class MarathonEventSubscriptionEvent {
    public static final String SUBSCRIBE_EVENT = "subscribe_event";
    public static final String UNSUBSCRIBE_EVENT = "unsubscribe_event";

    /***
     * {
     "eventType": "subscribe_event",
     "timestamp": "2014-03-01T23:29:30.158Z",
     "clientIp": "1.2.3.4",
     "callbackUrl": "http://subscriber.acme.org/callbacks"
     }
     */

    public String eventType;
    public Date timestamp;
    public String clientIp;
    public String callbackUrl;

    public static MarathonEventSubscriptionEvent build(String json) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(json, MarathonEventSubscriptionEvent.class);
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
