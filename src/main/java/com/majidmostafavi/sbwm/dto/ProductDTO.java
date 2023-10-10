package com.majidmostafavi.sbwm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private  String id;
    private String name;
    private String code;
    private  boolean price;
}
