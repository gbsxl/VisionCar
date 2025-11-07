package unifecaf.gabriel.sousa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unifecaf.gabriel.sousa.entity.Car;
import unifecaf.gabriel.sousa.repository.CarRespository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRespository carRespository;

    public Car createCar(Car newCar) {
        return carRespository.save(newCar);
    }

    public List<Car> getAllCars() {
        return carRespository.findAll();
    }

    public List<Car> getCarsByModel(String model) {
        return carRespository.findByModel(model);
    }

    public List<Car> getCarsByBrand(String brand) {
        return carRespository.findByBrand_Name(brand);
    }

    public List<Car> getCarsByPriceRange(Double minimumPrice, Double maximumPrice) {
        return carRespository.findByPriceBetween(minimumPrice, maximumPrice);
    }

    public List<Car> getAvaliableCars() {
        return carRespository.findByIsAvaliableTrue();
    }

    public Car updateCar(Long id, Car updatedCar) {
        return carRespository.findById(id)
                .map(existingCar -> {
                    existingCar.setModel(updatedCar.getModel());
                    existingCar.setBrand(updatedCar.getBrand());
                    existingCar.setPrice(updatedCar.getPrice());
                    existingCar.setManufacturingYear(updatedCar.getManufacturingYear());
                    existingCar.setIsAvaliable(updatedCar.getIsAvaliable());
                    return carRespository.save(existingCar);
                })
                .orElseThrow(() -> new RuntimeException("Carro não encontrado com ID: " + id));
    }

    public void deleteCar(Long id) {
        carRespository.deleteById(id);
    }
}
