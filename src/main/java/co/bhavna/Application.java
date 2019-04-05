package co.bhavna;

import co.bhavna.model.Employee;
import co.bhavna.service.ProducerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.kafka.annotation.EnableKafka;


@EnableEurekaServer
@SpringBootApplication
@EnableKafka
public class Application implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private ProducerService producerService;
	@Autowired
	private ObjectMapper mapper;

	@Override
	public void run(String... args) throws Exception {
		Employee e = new Employee();
		e.setEmailId("santosh@gmail.com");
		e.setEmpId(100);
		e.setFirstName("santosh");
		e.setLastName("kumar");
		e.setPassword("qwerty16868");
		String payload = mapper.writeValueAsString(e);
		producerService.send(e);
	}


}
