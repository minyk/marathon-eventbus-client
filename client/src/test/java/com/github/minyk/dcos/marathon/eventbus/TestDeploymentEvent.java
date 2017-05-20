package com.github.minyk.dcos.marathon.eventbus;


import com.github.minyk.dcos.marathon.eventbus.event.deployment.MarathonDeploymentEvent;
import com.github.minyk.dcos.marathon.eventbus.event.healthcheck.MarathonHealthcheckEvent;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestDeploymentEvent extends  TestEventBuilderBase {

    MarathonDeploymentEvent event;

    @After
    public void cleanup() {
        event = null;
    }

    @Test
    public void evaluateDeploymentInfoEventType() {

        event = MarathonDeploymentEvent.build(readJsonFromResource("deployments/deployment/deployment_info.json"));

        // Assert event properties.
        assertEquals(MarathonDeploymentEvent.DEPLOYMENT_INFO, event.eventType);

        // too long
        //assertEquals(1393684170518, event.timestamp.getTime());

        // deployment plan
        assertEquals("867ed450-f6a8-4d33-9b0e-e11c5513990b", event.plan.id);

        // target
        assertEquals(1, event.plan.target.apps.size());

        // currentStep
        assertEquals(1, event.currentStep.actions.size());
        assertEquals("ScaleApplication", event.currentStep.actions.get(0).type);

    }

    @Test
    public void evaluateDeploymentStepSuccessEventType() {

        event = MarathonDeploymentEvent.build(readJsonFromResource("deployments/deployment/deployment_step_success.json"));

        // Assert event properties.
        assertEquals(MarathonDeploymentEvent.DEPLOYMENT_STEP_SUCCESS, event.eventType);

        // too long
        //assertEquals(1393684170518, event.timestamp.getTime());

        // deployment plan
        assertEquals("867ed450-f6a8-4d33-9b0e-e11c5513990b", event.plan.id);

        // target
        assertEquals(1, event.plan.target.apps.size());

        // currentStep
        assertEquals(1, event.currentStep.actions.size());
        assertEquals("ScaleApplication", event.currentStep.actions.get(0).type);

    }

    @Test
    public void evaluateDeploymentStepFailureEventType() {

        event = MarathonDeploymentEvent.build(readJsonFromResource("deployments/deployment/deployment_step_failure.json"));

        // Assert event properties.
        assertEquals(MarathonDeploymentEvent.DEPLOYMENT_STEP_FAILURE, event.eventType);

        // too long
        //assertEquals(1393684170518, event.timestamp.getTime());

        // deployment plan
        assertEquals("867ed450-f6a8-4d33-9b0e-e11c5513990b", event.plan.id);

        // target
        assertEquals(1, event.plan.target.apps.size());

        // currentStep
        assertEquals(1, event.currentStep.actions.size());
        assertEquals("ScaleApplication", event.currentStep.actions.get(0).type);

    }

}
