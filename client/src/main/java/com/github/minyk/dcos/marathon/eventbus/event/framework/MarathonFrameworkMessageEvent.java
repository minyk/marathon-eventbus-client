package com.github.minyk.dcos.marathon.eventbus.event.framework;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mesosphere.marathon.client.utils.ModelUtils;

public class MarathonFrameworkMessageEvent {

    public static final String FRAMEWORK_MESSAGE_EVENT = "framework_message_event";

    /***
     * {
     "eventType": "framework_message_event",
     "timestamp": "2014-03-01T23:29:30.158Z",
     "slaveId": "20140909-054127-177048842-5050-1494-0",
     "executorId": "my-app.3f80d17a-37e6-11e4-b05e-56847afe9799",
     "message": "aGVsbG8gd29ybGQh"
     }
     */

    public String eventType;
    public String timestamp;
    public String slaveId;
    public String executorId;
    public String message;

    public static MarathonFrameworkMessageEvent build(String json) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(json, MarathonFrameworkMessageEvent.class);
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
