package unifecaf.gabriel.sousa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unifecaf.gabriel.sousa.entity.Car;
import unifecaf.gabriel.sousa.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/visionCar/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService service;

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car newCar = service.createCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCar);
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(service.getAllCars());
    }

    @GetMapping("/model/{model}")
    public ResponseEntity<List<Car>> getCarsByModel(@PathVariable String model) {
        return ResponseEntity.ok(service.getCarsByModel(model));
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Car>> getCarsByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(service.getCarsByBrand(brand));
    }

    @GetMapping("/price/{minPrice}/{maxPrice}")
    public ResponseEntity<List<Car>> getCarsByPriceRange(@PathVariable Double minPrice, @PathVariable Double maxPrice) {
        return ResponseEntity.ok(service.getCarsByPriceRange(minPrice, maxPrice));
    }

    @GetMapping("/avaliable")
    public ResponseEntity<List<Car>> getAvaliableCars() {
        return ResponseEntity.ok(service.getAvaliableCars());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car updatedCar) {
        Car newCar = service.updateCar(id, updatedCar);
        return ResponseEntity.ok(newCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable Long id) {
        service.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}
