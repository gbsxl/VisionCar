package unifecaf.gabriel.sousa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unifecaf.gabriel.sousa.entity.Brand;
import unifecaf.gabriel.sousa.entity.Car;
import unifecaf.gabriel.sousa.service.BrandService;
import unifecaf.gabriel.sousa.service.CarService;

import java.util.List;

@RestController
@RequestMapping("/visionCar")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;
    private final BrandService brandService;

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car newCar = carService.createCar(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCar);
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/model/{model}")
    public ResponseEntity<List<Car>> getCarsByModel(@PathVariable String model) {
        return ResponseEntity.ok(carService.getCarsByModel(model));
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Car>> getCarsByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(carService.getCarsByBrand(brand));
    }

    @GetMapping("/price/{minPrice}/{maxPrice}")
    public ResponseEntity<List<Car>> getCarsByPriceRange(@PathVariable Double minPrice, @PathVariable Double maxPrice) {
        return ResponseEntity.ok(carService.getCarsByPriceRange(minPrice, maxPrice));
    }

    @GetMapping("/avaliable")
    public ResponseEntity<List<Car>> getAvaliableCars() {
        return ResponseEntity.ok(carService.getAvaliableCars());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car updatedCar) {
        Car newCar = carService.updateCar(id, updatedCar);
        return ResponseEntity.ok(newCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarById(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/brand")
    public ResponseEntity<Brand> createBrand(String name){
        Brand brand = brandService.createBrand(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(brand);
    }
    @GetMapping("/brand")
    public ResponseEntity<List<Brand>> getAllBrands() {
        return ResponseEntity.ok(brandService.getAllBrands());
    }

}
