package com.github.minyk.dcos.marathon.eventbus;


import com.github.minyk.dcos.marathon.eventbus.event.api.MarathonApiPostEvent;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestApiPostEvent extends TestEventBuilderBase {

    MarathonApiPostEvent event;

    @After
    public void cleanup() {
        event = null;
    }

    @Test
    public void evaluateApiPostEvent() {
        event = MarathonApiPostEvent.build(readJsonFromResource("apipost/api_post_event.json"));

        // Assert
        assertEquals("api_post_event", event.eventType);

        // Assert app id
        assertEquals("/my-app", event.appDefinition.getId());
    }
}
