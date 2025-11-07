package unifecaf.gabriel.sousa.configuration;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import unifecaf.gabriel.sousa.service.BrandService;

@Configuration
@RequiredArgsConstructor
public class CreationOfBrandsKnowledged implements WebMvcConfigurer {

    private final BrandService brandService;

    private static final String[] BRANDS = {
            "CHEVROLET", "FIAT", "FORD", "VOLKSWAGEN", "HONDA", "TOYOTA", "HYUNDAI",
            "RENAULT", "PEUGEOT", "CITROEN", "NISSAN", "JEEP", "MITSUBISHI", "BMW",
            "MERCEDES_BENZ", "AUDI", "VOLVO", "KIA", "LAND_ROVER", "SUZUKI", "TESLA"
    };
    @PostConstruct
    public void instanciaBrandsConhecidas() {
        for (String brand : BRANDS) {
            brandService.createBrand(brand);
        }
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("*")
                .allowedHeaders("*");
    }
}
