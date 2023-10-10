package com.majidmostafavi.sbwm.entiry;

import com.majidmostafavi.sbwm.dto.ProductDTO;
import org.springframework.beans.BeanUtils;

public class ProductMapper {

    public static ProductDTO entityToDTO(Product product){

        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product,productDTO);
        return productDTO;
    }

    public static Product dtoToEntity(ProductDTO productDTO){

        Product product = new Product();
        BeanUtils.copyProperties(productDTO,product);
        return product;
    }
}
