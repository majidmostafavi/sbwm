package com.majidmostafavi.sbwm.repository;

import com.majidmostafavi.sbwm.dto.ProductDTO;
import com.majidmostafavi.sbwm.entiry.Product;
import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<Product,String> {
    Flux<ProductDTO> findByPrice(Range<Double> price);
}
