package com.majidmostafavi.sbwm.controller;

import com.majidmostafavi.sbwm.dto.ProductDTO;
import com.majidmostafavi.sbwm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(
    produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ProductDTO> getProducts(){
        return service.findAllProduct();
    }

    @GetMapping("/{id}")
    public Mono<ProductDTO> getProduct(@PathVariable String id){
        return service.findByID(id);
    }

    @GetMapping("/product-price")
    public Flux<ProductDTO> getProduct(@RequestParam("min") double min,@RequestParam("max") double max){
        return service.findByPrice(min,max);
    }

    @PostMapping
    public Mono<ProductDTO> postProduct(@RequestBody Mono<ProductDTO> productDTOMono){
        return service.create(productDTOMono);
    }

    @PutMapping("/update/{id}")
    public Mono<ProductDTO> postProduct(@RequestBody Mono<ProductDTO> productDTOMono,@PathVariable String id){
        return service.edit(productDTOMono,id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteProduct(@PathVariable String id){
        return service.deleteProduct(id);
    }
}
