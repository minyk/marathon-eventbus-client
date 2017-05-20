package com.github.minyk.dcos.marathon.eventbus;


import com.github.minyk.dcos.marathon.eventbus.event.deployment.MarathonGroupDeploymentEvent;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDeploymentGroupEvent extends  TestEventBuilderBase {

    MarathonGroupDeploymentEvent event;

    @After
    public void cleanup() {
        event = null;
    }

    @Test
    public void evaluateGroupDeploymentSuccessEventType() {

        event = MarathonGroupDeploymentEvent.build(readJsonFromResource("deployments/group/group_change_success.json"));

        // Assert event properties.
        assertEquals(MarathonGroupDeploymentEvent.GROUP_CHANGE_SUCCESS, event.eventType);

        // too long
        //assertEquals(1393684170518, event.timestamp.getTime());

        // group id
        assertEquals("/product-a/backend", event.groupId);

    }


    @Test
    public void evaluateGroupDeploymentFailedEventType() {

        event = MarathonGroupDeploymentEvent.build(readJsonFromResource("deployments/group/group_change_failed.json"));

        // Assert event properties.
        assertEquals(MarathonGroupDeploymentEvent.GROUP_CHANGE_FAILED, event.eventType);

        // too long
        //assertEquals(1393684170518, event.timestamp.getTime());

        // group id
        assertEquals("/product-a/backend", event.groupId);
    }

}
