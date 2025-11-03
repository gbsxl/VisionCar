package unifecaf.gabriel.sousa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unifecaf.gabriel.sousa.entity.Car;
import unifecaf.gabriel.sousa.enums.Brand;

import java.util.List;

@Repository
public interface CarRespository extends JpaRepository<Car, Long> {
    List<Car> findByModel(String model);
    List<Car> findByBrand(Brand brand);
    List<Car> findByPriceBetween(Double min, Double max);
    List<Car> findByIsAvaliableTrue();
}
