package com.github.minyk.dcos.marathon.eventbus;


import com.github.minyk.dcos.marathon.eventbus.event.healthcheck.MarathonHealthcheckEvent;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class TestEventBuilderBase {
    Logger logger = LoggerFactory.getLogger(TestEventBuilderBase.class);

    String readJsonFromResource(String filename) {
        URL file = MarathonHealthcheckEvent.class.getClassLoader().getResource(filename);
        try {
            InputStream input = file.openStream();
            return IOUtils.toString(input);
        } catch (IOException e) {
            logger.error("Could not read resource file: " + e.getMessage());
            return null;
        }
    }
}
