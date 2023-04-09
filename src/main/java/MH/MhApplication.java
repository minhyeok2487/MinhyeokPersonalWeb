package MH;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MhApplication {

	public static void main(String[] args) {
		SpringApplication.run(MhApplication.class, args);
	}

}
