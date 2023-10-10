package com.majidmostafavi.sbwm.service;


import com.majidmostafavi.sbwm.dto.ProductDTO;
import com.majidmostafavi.sbwm.entiry.ProductMapper;
import com.majidmostafavi.sbwm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Flux<ProductDTO> findAllProduct() {
        return repository.findAll().map(ProductMapper::entityToDTO);
    }

    public Mono<ProductDTO> findByID(String id) {
        return repository.findById(id).map(ProductMapper::entityToDTO);
    }

    public Flux<ProductDTO> findByPrice(double min, double max) {
        return repository.findByPrice(Range.closed(min,max));
    }

    public Mono<ProductDTO> create(Mono<ProductDTO> productDTOMono){
        return  productDTOMono.map(ProductMapper :: dtoToEntity)
                .flatMap(repository :: insert)
                .map(ProductMapper :: entityToDTO);
    }


    public Mono<ProductDTO> edit(Mono<ProductDTO> productDTOMono,String id){
        return repository.findById(id)
                .flatMap(product -> productDTOMono.map(ProductMapper :: dtoToEntity).doOnNext(e->e.setId(id)))
                .flatMap(repository :: save)
                .map(ProductMapper :: entityToDTO);
    }

    public Mono<Void> deleteProduct(String id){
        return repository.deleteById(id);
    }

}
