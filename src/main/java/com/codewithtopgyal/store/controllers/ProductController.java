package com.codewithtopgyal.store.controllers;

import com.codewithtopgyal.store.dtos.ProductDto;
import com.codewithtopgyal.store.entities.Product;
import com.codewithtopgyal.store.mappers.ProductMapper;
import com.codewithtopgyal.store.repositories.CategoryRepository;
import com.codewithtopgyal.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    @GetMapping
    public List<ProductDto> getAllProducts(
//            @RequestHeader (required=false,name = "x-auth-token") String authToken,
            @RequestParam (name="categoryId", required=false) Byte categoryId
    ){
//        System.out.println(authToken);
        List <Product> products;
        if(categoryId != null){
            products = productRepository.findByCategoryId(categoryId);
        }else{
            products= productRepository.findAllWithCategory();
        }
        return products.stream().map(productMapper::toDto).toList();
    }

    // add new product
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(
            @RequestBody ProductDto productDto,
            UriComponentsBuilder uriBuilder) {
        var category = categoryRepository.findById(productDto.getCategoryId()).orElse(null);
        if (category == null) {
            return ResponseEntity.badRequest().build();
        }

        var product = productMapper.toEntity(productDto);
        product.setCategory(category);
        productRepository.save(product);
        productDto.setId(product.getId());

        var uri = uriBuilder.path("/products/{id}").buildAndExpand(productDto.getId()).toUri();

        return ResponseEntity.created(uri).body(productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        productRepository.delete(product);

        return ResponseEntity.noContent().build();
    }



}
