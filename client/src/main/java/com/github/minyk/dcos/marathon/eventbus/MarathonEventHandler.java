package com.github.minyk.dcos.marathon.eventbus;

import com.github.minyk.dcos.marathon.eventbus.event.deployment.MarathonDeploymentResultEvent;
import com.github.minyk.dcos.marathon.eventbus.event.healthcheck.MarathonHealthcheckEvent;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarathonEventHandler implements EventHandler {
    private static final Logger logger = LoggerFactory.getLogger(MarathonEventHandler.class);

    @Override
    public void onOpen() throws Exception {
        System.out.println("stream opened");
    }

    @Override
    public void onClosed() throws Exception {
        System.out.println("stream closed");
    }

    @Override
    public void onMessage(String name, MessageEvent event) throws Exception {
        System.out.println("event found in stream.");
        switch (name) {
            case MarathonHealthcheckEvent.FAILED_HEALTH_CHECK_EVENT:
                healthcheckFail(event);
                break;
            case MarathonHealthcheckEvent.HEALTH_STATUS_CHANGED_EVENT:
                healthcheckChanged(event);
                break;
            case MarathonHealthcheckEvent.UNHEALTHY_TASK_KILL_EVENT:
                logger.info("task kill event received.");
                break;
            case MarathonDeploymentResultEvent.DEPLOYMENT_SUCCESS: {
                logger.info("deployment success event received.");
                break;
            }
            case MarathonDeploymentResultEvent.DEPLOYMENT_FAILED: {
                logger.info("deployment failed event received.");
                break;
            }
            default:
                logger.warn("event found in stream: " + event.getData());
                System.out.println("event found in stream: ");
                break;
        }
    }

    @Override
    public void onComment(String comment) {
        logger.debug("Received a marathon event");
    }

    @Override
    public void onError(Throwable throwable) {
        logger.error("Encountered EventSource error: " + throwable.getMessage());
        logger.debug("", throwable);
    }

    private void healthcheckFail(MessageEvent event) {
        logger.debug("failed healthcheck event received.");
        MarathonHealthcheckEvent e = MarathonHealthcheckEvent.build(event.getData());
    }

    private void healthcheckChanged(MessageEvent event) {
        logger.debug("Health check changed:");
        MarathonHealthcheckEvent e = MarathonHealthcheckEvent.build(event.getData());
    }
}
