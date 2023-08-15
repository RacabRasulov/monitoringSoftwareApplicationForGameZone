package az.monitoringSoftware.monitoringSoftware;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MonitoringSoftwareApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitoringSoftwareApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}
}
