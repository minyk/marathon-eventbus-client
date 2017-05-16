package com.github.minyk.dcos.marathon.eventbus.event.deployment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mesosphere.marathon.client.utils.ModelUtils;

import java.util.Date;

public class MarathonDeploymentResultEvent {
    public static final String DEPLOYMENT_SUCCESS = "deployment_success";
    public static final String DEPLOYMENT_FAILED = "deployment_failed";

    /***
     * {
     "eventType": "deployment_success",
     "timestamp": "2014-03-01T23:29:30.158Z",
     "id": "867ed450-f6a8-4d33-9b0e-e11c5513990b"
     }
     {
     "eventType": "deployment_failed",
     "timestamp": "2014-03-01T23:29:30.158Z",
     "id": "867ed450-f6a8-4d33-9b0e-e11c5513990b"
     }
     */

    public String eventType;
    public Date timestamp;
    public String id;

    public static MarathonDeploymentResultEvent build(String json) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(json, MarathonDeploymentResultEvent.class);
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
