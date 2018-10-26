package com.sj.test;

import com.atlassian.interviews.eventsystem.InterviewEvent;
import com.atlassian.interviews.eventsystem.InterviewEventListener;

public class SandeepJoshiListener implements InterviewEventListener {

	
	private int count=0;
	private Class[] subscribedEvents;

    public SandeepJoshiListener(Class[] subscribedEvents)
    {
        this.subscribedEvents = subscribedEvents;
    }
    
	public int getCount() {
		return count;
	}

	@Override
	public void handleEvent(InterviewEvent event) {
		count++;
	}

	@Override
	public Class[] getHandledEventClasses() {
		return subscribedEvents;
	}

}
