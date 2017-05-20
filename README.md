Marathon-EventBus-Client
=======================

*WARNING:* These are very early stage of bits. Some code are not tested yet.

# What is Marathon?
Marathon is an `initd` for an Apache Mesos cluster. See more: https://github.com/mesosphere/marathon

# What is this?
Marathon has an event bus for notification. It's normally `http://marathon:port/v2/events`. This endpoint is a bit different from other REST APIs. 
* It's a `server-sent-event` stream. Clients should be connect with `Accpet: text/event-stream` header.
* Connection for this endpoint is never-ending. 
* There're some events in the bus. Each event has data which is JSON formatted.

So, I decided make code for this.

# Currently Implemented events
* Marathon Api Post event
* Marathon eventbus subscription/unsubscription events
* Marathon framework message event
* Group/App Deployment events
* Task Healthcheck events
* Task Status Update event

# How to use?
```
$ mvn clean package install
$ java -jar sample/target/marathon-eventbus-viewer-0.1-jar-with-dependencies.jar 
```

# Acknowledgement
* This program is heavily relied on [okhttp-eventsource](https://github.com/launchdarkly/okhttp-eventsource). Thanks a lot!
* Marathon related JSON schema (like app definition) is defined in [mesosphere/marathon-client](https://github.com/mesosphere/marathon-client).