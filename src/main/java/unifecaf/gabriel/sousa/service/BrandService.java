package unifecaf.gabriel.sousa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unifecaf.gabriel.sousa.entity.Brand;
import unifecaf.gabriel.sousa.repository.BrandRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository repository;

    public Brand createBrand(String name){
        Brand brand = new Brand();
        brand.setName(name.toUpperCase());
        return repository.save(brand);
    }
    public List<Brand> getAllBrands(){
        return repository.findAll();
    }
}
