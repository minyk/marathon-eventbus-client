package com.github.minyk.dcos.marathon.eventbus.event.deployment;


import com.google.gson.annotations.SerializedName;
import mesosphere.marathon.client.model.v2.App;
import mesosphere.marathon.client.utils.ModelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MarathonDeploymentEvent {
    private static final Logger logger = LoggerFactory.getLogger(MarathonDeploymentEvent.class);

    public static final String DEPLOYMENT_INFO = "deployment_info";
    public static final String DEPLOYMENT_STEP_SUCCESS = "deployment_step_success";
    public static final String DEPLOYMENT_STEP_FAILURE = "deployment_step_failure";


    public static class Action {
        public String type;
        public String app;
    }

    public static class CurrentStep {
        public List<Action> actions;
    }

    public static class Step {
        public String action;
        public String app;
    }

    public class MarathonDeploymentPlan {

        @SerializedName("apps")
        public List<App> apps;

        public List<String> dependencies;
        public List<String> groups;
        public String id;
        public String version;

    }

    public static class Plan {
        public String id;
        public MarathonDeploymentPlan original;
        public MarathonDeploymentPlan target;
        public List<Step> steps;
        public String version;
    }

    public String eventType;
    public String timestamp;

    public Plan plan;

    public CurrentStep currentStep;

    @Override
    public String toString() {
        return ModelUtils.toString(this);
    }
}
