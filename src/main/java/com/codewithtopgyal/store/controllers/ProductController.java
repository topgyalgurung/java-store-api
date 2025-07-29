package com.codewithtopgyal.store.controllers;

import com.codewithtopgyal.store.dtos.ProductDto;
import com.codewithtopgyal.store.dtos.UserDto;
import com.codewithtopgyal.store.entities.Product;
import com.codewithtopgyal.store.mappers.ProductMapper;
import com.codewithtopgyal.store.repositories.ProductRepository;
import com.codewithtopgyal.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> getAllProducts(
            @RequestParam (name="categoryId", required=false) Byte categoryId
    ){
        List <Product> products;
        if(categoryId != null){
            products = productRepository.findByCategoryId(categoryId);
        }else{
            products= productRepository.findAllWithCategory();
        }
        return products.stream().map(productMapper::toDto).toList();
    }

}
