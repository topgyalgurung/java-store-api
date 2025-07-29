package com.codewithtopgyal.store.mappers;

import com.codewithtopgyal.store.dtos.ProductDto;
import com.codewithtopgyal.store.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target="categoryId", source= "category.id")
    ProductDto toDto(Product product);
}
