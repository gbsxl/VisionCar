package unifecaf.gabriel.sousa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unifecaf.gabriel.sousa.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
