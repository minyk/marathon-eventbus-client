package com.github.minyk.dcos.marathon.eventbus.sample;

import com.github.minyk.dcos.marathon.eventbus.MarathonEventBusListener;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarathonEventViewer {

    private static final Logger logger = LoggerFactory.getLogger(MarathonEventViewer.class);
    private static final int DEAD_CONNECTION_INTERVAL_SECONDS = 300;

    private volatile EventSource es;

    public static void main(String[] args) {
        MarathonEventBusListener meb = new MarathonEventBusListener("http://marathon.mesos/marathon", new MarathonEventHandler());
        logger.info("Marathon Event Viewer starting...");
        meb.start();
    }
}
