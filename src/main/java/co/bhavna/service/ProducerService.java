package co.bhavna.service;

import co.bhavna.model.Employee;

public interface ProducerService {
     /**
      * This service is used to transfer object to the topic to the zookeeper
      * @param payload
      */
     void send(Employee payload);
}
