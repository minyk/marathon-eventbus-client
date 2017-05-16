package com.github.minyk.dcos.marathon.eventbus;


import com.github.minyk.dcos.marathon.eventbus.event.status.MarathonStatusUpdateEvent;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestStatusUpdateEvent extends TestEventBuilderBase {

    MarathonStatusUpdateEvent event;

    @After
    public void cleanup() {
        event = null;
    }

    @Test
    public void evaluateStatusUpdateEventType() {
        event = MarathonStatusUpdateEvent.build(readJsonFromResource("statusupdate/status_update_event.json"));

        // Assert event
        assertEquals("status_update_event", event.eventType);

        // Assert slaveId
        assertEquals("20140909-054127-177048842-5050-1494-0", event.slaveId);

        // Assert taskStatus
        assertEquals("TASK_RUNNING", event.taskStatus);

        // Assert ports
        assertEquals(1, event.ports.size());
        assertEquals(31372, event.ports.get(0).longValue());
    }
}
