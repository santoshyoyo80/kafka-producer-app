package co.bhavna.service;

import co.bhavna.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * This represents the service of the Ka
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerServiceImpl.class);

    /**
     * This is Kafka Producer Client which will send the Employee Object
     */
    @Autowired
        private KafkaTemplate<String,Employee> kafkaTemplate;
        @Autowired
        private String topicName;


    @Override
    public void send(Employee payload) {
        LOGGER.info("Topic Name {}, Kafka Payload {} ", topicName,payload);
        Message<Employee> message = MessageBuilder.withPayload(payload).setHeader(KafkaHeaders.TOPIC,topicName).build();
        kafkaTemplate.send(message);
        LOGGER.info("Payload Sent to the Kafka Topic Successfully.");
    }
}
