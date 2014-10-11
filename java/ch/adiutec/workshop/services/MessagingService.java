package ch.adiutec.workshop.services;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MessagingService {
	public void sendMessage(Serializable param) throws JMSException {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
		"tcp://localhost:61616");

	Connection connection = connectionFactory.createConnection();
	Session session = connection.createSession(false,
			Session.AUTO_ACKNOWLEDGE);

	Topic topic = session.createTopic("saveVehicle");
	MessageProducer producer = session.createProducer(topic);
	connection.start();
	Message message = (Message) session.createObjectMessage(param);
	producer.send(message);
	session.close();
	connection.close();
	}
}
