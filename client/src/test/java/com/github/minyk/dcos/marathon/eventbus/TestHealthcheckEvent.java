package com.github.minyk.dcos.marathon.eventbus;


import com.github.minyk.dcos.marathon.eventbus.event.healthcheck.MarathonHealthcheckEvent;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TestHealthcheckEvent extends  TestEventBuilderBase {

    MarathonHealthcheckEvent event;

    @After
    public void cleanup() {
        event = null;
    }

    @Test
    public void evaluateAddHealthcheckEventType() {

        event = MarathonHealthcheckEvent.build(readJsonFromResource("healthcheck/add_health_check_event.json"));

        // Assert event properties.
        assertEquals("add_health_check_event", event.eventType);

        // too long
        //assertEquals(1393684170518, event.timestamp.getTime());

        assertEquals("/my-app", event.appId);

        assertEquals(MarathonHealthcheckEvent.HealthcheckOption.class, event.option.getClass());

        assertEquals("HTTP", event.option.protocol);

        assertEquals(0,event.option.portIndex);

        assertEquals(null, event.taskId);

        // should be null.
        //assertEquals(null, event.alive);
    }

    @Test
    public void evaluateFailedHealthcheckEventType() {
        event = MarathonHealthcheckEvent.build(readJsonFromResource("healthcheck/failed_health_check_event.json"));

        // Assert event properties.
        assertEquals("failed_health_check_event", event.eventType);

        // Assert Task ID
        assertEquals("my-app_0-1396592784349", event.taskId);
    }

    @Test
    public void evaluateRemoveHealthcheckEventType() {
        event = MarathonHealthcheckEvent.build(readJsonFromResource("healthcheck/remove_health_check_event.json"));

        // Assert event properties.
        assertEquals("remove_health_check_event", event.eventType);

    }

    @Test
    public void evaluateHealthStatusChangedEventType() {
        event = MarathonHealthcheckEvent.build(readJsonFromResource("healthcheck/health_status_changed_event.json"));

        // Assert event properties.
        assertEquals("health_status_changed_event", event.eventType);

        // Assert Instance ID
        assertEquals("my-app.instance-c7c311a4-b669-11e6-a48f-0ea4f4b1778c", event.instanceId);

        // Assert alive
        assertTrue(event.alive);

        // Assert null
        //assertNull(event.option);

        // Assert null
        assertNull(event.option.protocol);
    }
}
