package dev.bcv.bootrepository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.onehippo.cms7.event.HippoEvent;
import org.onehippo.cms7.event.HippoEventConstants;
import org.onehippo.cms7.services.HippoServiceRegistry;
import org.onehippo.repository.events.HippoWorkflowEvent;
import org.onehippo.repository.events.PersistedHippoEventListener;
import org.onehippo.repository.events.PersistedHippoEventsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyPersistedEventListener implements PersistedHippoEventListener {

    Logger logger = LoggerFactory.getLogger(MyPersistedEventListener.class);

    @Override
    public String getEventCategory() {
        return HippoEventConstants.CATEGORY_WORKFLOW;
    }

    @Override
    public String getChannelName() {
        return "my-publication-listener";
    }

    @Override
    public boolean onlyNewEvents() {
        return true;
    }

    @Override
    public void onHippoEvent(final HippoEvent event) {
        HippoWorkflowEvent workflowEvent = new HippoWorkflowEvent(event);
        // respond to event
        logger.info("{} event, path: {} ", workflowEvent.get("methodName"), workflowEvent.get("documentPath"));
    }

    @PostConstruct
    public void init() {
        HippoServiceRegistry.registerService(this, PersistedHippoEventsService.class);
    }

    @PreDestroy
    public void destroy() throws Exception {
        HippoServiceRegistry.unregisterService(this, PersistedHippoEventsService.class);
    }
}