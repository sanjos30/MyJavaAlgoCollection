package com.sj.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.atlassian.interviews.eventsystem.EventManager;
import com.atlassian.interviews.eventsystem.events.Creation;
import com.atlassian.interviews.eventsystem.events.CreationEvent;
import com.atlassian.interviews.eventsystem.events.SimpleEvent;
import com.atlassian.interviews.eventsystem.events.SubEvent;
import com.atlassian.interviews.eventsystem.impl.DefaultEventManager;

public class TestSandeepJoshiEventManager {

	EventManager eventMngr = new DefaultEventManager();

	/**
	 * Scenario 1 - Register a subsciber and publish a valid event
	 * 
	 */
	@Test
	public void testRegisterListenerAndPublishValidEvent() {
		// Create a new listener object
		SandeepJoshiListener sjlistener = new SandeepJoshiListener((new Class[]{SimpleEvent.class}));
		eventMngr.registerListener("JavaJobs", sjlistener);

		eventMngr.publishEvent(new SimpleEvent("Java Event"));

		assertTrue(sjlistener.getCount() > 0);
	}
	
	

	/**
	 * Scenario 2 - Register a subsciber and publish an un-related or unscribed event
	 * 
	 */
	@Test
	public void testRegisterListenerAndPublishInvalidEvent(){
		SandeepJoshiListener sListener=new SandeepJoshiListener(new Class[]{SimpleEvent.class});
		eventMngr.registerListener("Oracle Jobs", sListener);
		eventMngr.publishEvent(new CreationEvent("Creation Event"));
		
		assertTrue(sListener.getCount()==0);
	}
	
	
	/**
	 * Scenario 3 - Publish an event 3 times and test if called count is 3
	 * 
	 */
	@Test
	public void testRegisterListenerAndPublishValiddEventCount(){
		SandeepJoshiListener sListener=new SandeepJoshiListener(new Class[]{SimpleEvent.class,CreationEvent.class,SubEvent.class});
		
		eventMngr.registerListener("Oracle Jobs", sListener);
		eventMngr.publishEvent(new CreationEvent("Creation Event"));
		eventMngr.publishEvent(new SimpleEvent("SimpleEvent Event"));
		eventMngr.publishEvent(new SubEvent("SubEvent Event"));
		
		System.out.println(sListener.getCount());
		assertTrue(sListener.getCount()==3);
	}
	
	
	/**
	 * 
	 * Scenario 4 - Test unregistering an event and fire a related event and check count.
	 * 
	 * OBSERVATION - On unregistering, the key from the map is not removed.
	 */
	
	
	@Test
	public void testUnregisterListener(){
		SandeepJoshiListener sListner = new SandeepJoshiListener(new Class[]{SimpleEvent.class});
		
		eventMngr.registerListener("Management Jobs", sListner);
		eventMngr.publishEvent(new SimpleEvent("Simple Event"));
		
		//assertTrue(sListner.getCount()==1);
		System.out.println("The count before unregistering is: " + sListner.getCount());
		
		eventMngr.unregisterListener("Management Jobs");
		eventMngr.publishEvent(new SimpleEvent("Simple Event"));
		
		System.out.println("The count after unregistering is: " + sListner.getCount());
		//This would become 2 otherwise
		assertTrue(sListner.getCount()==1);
		
	}
}
