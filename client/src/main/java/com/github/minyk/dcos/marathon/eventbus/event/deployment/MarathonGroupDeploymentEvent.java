package com.github.minyk.dcos.marathon.eventbus.event.deployment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mesosphere.marathon.client.utils.ModelUtils;

import java.util.Date;

public class MarathonGroupDeploymentEvent {
    public static final String GROUP_CHANGE_SUCCESS = "group_change_success";
    public static final String GROUP_CHANGE_FAILED = "group_change_failed";

    /***
     * {  "eventType": "group_change_failed",
      "timestamp": "2014-03-01T23:29:30.158Z",
      "groupId": "/product-a/backend",
      "version": "2014-04-04T06:26:23.051Z",
      "reason": ""
     * }
     */

    public String eventType;
    public Date timestamp;
    public String groupId;
    public String version;
    public String reason;

    public static MarathonGroupDeploymentEvent build (String json) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
        return gson.fromJson(json, MarathonGroupDeploymentEvent.class);
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
