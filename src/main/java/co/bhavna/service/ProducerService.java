package co.bhavna.service;

public interface ProducerService {
     /**
      * This service is used to transfer object to the topic to the zookeeper
      * @param payload
      */
     void send(String payload);
}
