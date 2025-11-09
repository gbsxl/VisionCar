package unifecaf.gabriel.sousa.configuration;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import unifecaf.gabriel.sousa.entity.Brand;
import unifecaf.gabriel.sousa.entity.Car;
import unifecaf.gabriel.sousa.enums.Color;
import unifecaf.gabriel.sousa.service.BrandService;
import unifecaf.gabriel.sousa.service.CarService;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class MockDataToTest implements WebMvcConfigurer {

    private final BrandService brandService;
    private final CarService carService;

    private static final String[] BRANDS = {
            "CHEVROLET", "FIAT", "FORD", "VOLKSWAGEN", "HONDA", "TOYOTA", "HYUNDAI",
            "RENAULT", "PEUGEOT", "CITROEN", "NISSAN", "JEEP", "MITSUBISHI", "BMW",
            "MERCEDES_BENZ", "AUDI", "VOLVO", "KIA", "LAND_ROVER", "SUZUKI", "TESLA"
    };

    @PostConstruct
    public void initializeDatabase() {
        createBrands();
        createSampleCars();
    }

    private void createBrands() {
        for (String brandName : BRANDS) {
            brandService.createBrand(brandName);
        }
    }

    private void createSampleCars() {
        List<Brand> brands = brandService.getAllBrands();

        // Carro 1 - Chevrolet Onix
        createCar("Onix 1.0", brands.get(0), Color.BRANCO, 75000.0, 2023, true, 0f, true);

        // Carro 2 - Fiat Argo
        createCar("Argo 1.3", brands.get(1), Color.PRATA, 68000.0, 2022, false, 25000f, true);

        // Carro 3 - Ford Ka
        createCar("Ka SE 1.0", brands.get(2), Color.PRETO, 62000.0, 2021, false, 45000f, true);

        // Carro 4 - Volkswagen Gol
        createCar("Gol 1.6", brands.get(3), Color.VERMELHO, 58000.0, 2020, false, 60000f, false);

        // Carro 5 - Honda Civic
        createCar("Civic EXL 2.0", brands.get(4), Color.CINZA, 145000.0, 2023, true, 0f, true);

        // Carro 6 - Toyota Corolla
        createCar("Corolla XEI 2.0", brands.get(5), Color.PRATA, 138000.0, 2022, false, 35000f, true);

        // Carro 7 - Hyundai HB20
        createCar("HB20 1.0", brands.get(6), Color.AZUL, 72000.0, 2023, true, 0f, true);

        // Carro 8 - Jeep Compass
        createCar("Compass Sport 1.3", brands.get(11), Color.BRANCO, 165000.0, 2023, true, 0f, true);

        // Carro 9 - BMW 320i
        createCar("320i M Sport", brands.get(13), Color.PRETO, 285000.0, 2022, false, 18000f, true);

        // Carro 10 - Tesla Model 3
        createCar("Model 3 Standard Range", brands.get(20), Color.VERMELHO, 320000.0, 2023, true, 0f, true);
    }

    private void createCar(String model, Brand brand, Color color, Double price,
                           Integer year, Boolean isNew, Float km, Boolean available) {
        Car car = new Car();
        car.setModel(model);
        car.setBrand(brand);
        car.setColor(color);
        car.setPrice(price);
        car.setManufacturingYear(year);
        car.setIsNew(isNew);
        car.setKilometersDriven(km);
        car.setIsAvaliable(available);
        carService.createCar(car);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080", "http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}