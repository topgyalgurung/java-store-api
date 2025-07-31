package com.codewithtopgyal.store.mappers;

import com.codewithtopgyal.store.dtos.ProductDto;
import com.codewithtopgyal.store.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target="categoryId", source= "category.id")
    ProductDto toDto(Product product);
    Product toEntity(ProductDto productDto);


    @Mapping(target = "id", ignore = true)
    void update(ProductDto productDto, @MappingTarget Product product);
}
