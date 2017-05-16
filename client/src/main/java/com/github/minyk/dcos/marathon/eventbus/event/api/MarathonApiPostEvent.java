package com.github.minyk.dcos.marathon.eventbus.event.api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import mesosphere.marathon.client.model.v2.App;
import mesosphere.marathon.client.utils.ModelUtils;

public class MarathonApiPostEvent {

    @Expose(serialize = false, deserialize = false)
    public static final String API_POST_EVENT = "api_post_event";

    public String eventType;
    public String timestamp;
    public String clientIp;
    public String uri;

    @SerializedName("appDefinition")
    public App appDefinition = new App();

    public static MarathonApiPostEvent build(String json) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").serializeNulls().create();
        return gson.fromJson(json, MarathonApiPostEvent.class);
    }

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
