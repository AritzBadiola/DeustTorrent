package es.deusto.ssdd.bittorrent.modelo;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

public class Tracker {

	private void keepAliveOut() {

		Thread KeepAliveOut = new Thread( new Runnable() {

			@Override
			public void run() {
				try {
					// Create a ConnectionFactory
					ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");

					// Create a Connection
					Connection connection = connectionFactory.createConnection();
					connection.start();

					// Create a Session
					Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

					// Create the destination Queue
					Destination destination = session.createTopic("keepAlive");

					// Create a MessageProducer from the Session to the Queue
					MessageProducer producer = session.createProducer(destination);
					producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

					// Create a messages
					String text = "Hello world! From: " + Thread.currentThread().getName() + " : " + this.hashCode();
					TextMessage message = session.createTextMessage(text);

					// Tell the producer to send the message
					System.out.println("-> Sent message: " + message.hashCode() + " : " + Thread.currentThread().getName());
					producer.send(message);

					// Clean up
					session.close();
					connection.close();
				} catch (Exception ex) {
					System.err.println("# Tracker error: " + ex.getMessage());
				}
			}
		});
		KeepAliveOut.start();
	}
	
	private void keepAliveIn() {

		Thread KeepAliveIn = new Thread( new Runnable() {

			@Override
			public void run() {
				try {
					// Create a ConnectionFactory
					ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://0.0.0.0:61616");

					// Create a Connection
					Connection connection = connectionFactory.createConnection();
					connection.start();

					// Create a Session
					Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

					// Create the destination Queue
					Destination destination = session.createTopic("keepAlive");

					// Create a MessageProducer from the Session to the Queue
					MessageConsumer consumer = session.createConsumer(destination);

					//Wait for message
					Message message = consumer.receive(1000);


					if (message.getClass().equals(ActiveMQTextMessage.class)) {
						TextMessage textMessage = (TextMessage) message;
						System.err.println("<- Received TextMessage: " + textMessage.getText());
					} else {
						System.err.println("<- Received a Message: " + message);
					}

					// Clean up
					session.close();
					connection.close();
				} catch (Exception ex) {
					System.err.println("# Tracker error: " + ex.getMessage());
				}
			}
		});
		KeepAliveIn.start();
	}
	public static void main(String[] args) {
		Tracker a = new Tracker();
		a.keepAliveOut();
		a.keepAliveIn();
		//		a.keepAliveOut.start();
		//		a.KeepAliveIn.start();
	}
}


