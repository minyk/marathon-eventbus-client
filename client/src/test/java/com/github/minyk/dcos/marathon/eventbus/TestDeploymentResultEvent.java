package com.github.minyk.dcos.marathon.eventbus;


import com.github.minyk.dcos.marathon.eventbus.event.deployment.MarathonDeploymentResultEvent;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDeploymentResultEvent extends  TestEventBuilderBase {

    MarathonDeploymentResultEvent event;

    @After
    public void cleanup() {
        event = null;
    }

    @Test
    public void evaluateDeploymentResultSuccessEventType() {

        event = MarathonDeploymentResultEvent.build(readJsonFromResource("deployments/result/deployment_success.json"));

        // Assert event properties.
        assertEquals(MarathonDeploymentResultEvent.DEPLOYMENT_SUCCESS, event.eventType);

        // too long
        //assertEquals(1393684170518, event.timestamp.getTime());

        // group id
        assertEquals("867ed450-f6a8-4d33-9b0e-e11c5513990b", event.id);

    }


    @Test
    public void evaluateGroupDeploymentFailedEventType() {

        event = MarathonDeploymentResultEvent.build(readJsonFromResource("deployments/result/deployment_failed.json"));

        // Assert event properties.
        assertEquals(MarathonDeploymentResultEvent.DEPLOYMENT_FAILED, event.eventType);

        // too long
        //assertEquals(1393684170518, event.timestamp.getTime());

        // group id
        assertEquals("867ed450-f6a8-4d33-9b0e-e11c5513990b", event.id);
    }

}
