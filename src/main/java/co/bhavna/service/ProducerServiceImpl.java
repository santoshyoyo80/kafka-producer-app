package co.bhavna.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * This represents the service of the Ka
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerServiceImpl.class);
        @Autowired
        private KafkaTemplate<String,String> kafkaTemplate;
        @Autowired
        private String topicName;


    @Override
    public void send(String payload) {
        LOGGER.info("Kafka Payload {} "+payload);
        kafkaTemplate.send(topicName,payload);
        LOGGER.info("Payload Sent Successfully.");
    }
}
