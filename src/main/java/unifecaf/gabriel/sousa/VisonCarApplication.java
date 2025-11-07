package unifecaf.gabriel.sousa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import unifecaf.gabriel.sousa.configuration.CreationOfBrandsKnowledged;
import unifecaf.gabriel.sousa.service.BrandService;

@SpringBootApplication
public class VisonCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(VisonCarApplication.class, args);
	}

}
