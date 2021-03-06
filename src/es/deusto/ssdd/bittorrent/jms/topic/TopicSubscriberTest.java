package es.deusto.ssdd.bittorrent.jms.topic;

import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;

public class TopicSubscriberTest {	
	
	public static void main(String[] args) {
		String connectionFactoryName = "TopicConnectionFactory";		
		String topicJNDIName = "jndi.ssdd.topic";		
		String subscriberID = "SubscriberID";
		
		TopicConnection topicConnection = null;
		TopicSession topicSession = null;
		TopicSubscriber topicSubscriber = null;
		TopicSubscriber topicSubscriber2 = null;
				
		try {
			Context ctx = new InitialContext();
		
			//Connection Factories
			TopicConnectionFactory topicConnectionFactory = (TopicConnectionFactory) ctx.lookup(connectionFactoryName);
			
			//Message Destinations
			Topic myTopic = (Topic) ctx.lookup(topicJNDIName);			
	
			//Connections			
			topicConnection = topicConnectionFactory.createTopicConnection();
			topicConnection.setClientID("SSDD_TopicSubscriber");
			System.out.println("- Topic Connection created!");
			
			//Sessions
			topicSession = topicConnection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			System.out.println("- Topic Session created!");

			topicSubscriber = topicSession.createDurableSubscriber(myTopic, subscriberID, "Filter = '1'", false);
			topicSubscriber2 = topicSession.createSubscriber(myTopic, "Filter = '2'", false);
			
			//Topic Listener
			TopicListener topicListener = new TopicListener();
			topicSubscriber.setMessageListener(topicListener);
			topicSubscriber2.setMessageListener(topicListener);
			
			//Begin message delivery
			topicConnection.start();
			
			//Wait for messages
			System.out.println("- Waiting 10 seconds for messages...");
			Thread.sleep(10000);			
		} catch (Exception e) {
			System.err.println("# TopicSubscriberTest Error: " + e.getMessage());			
		} finally {
			try {
				//Close resources
				topicSubscriber.close();
				topicSubscriber2.close();
				topicSession.unsubscribe(subscriberID);
				topicSession.close();
				topicConnection.close();
				System.out.println("- Topic resources closed!");				
			} catch (Exception ex) {
				System.err.println("# TopicSubscriberTest Error: " + ex.getMessage());
			}
		}
	}
}
