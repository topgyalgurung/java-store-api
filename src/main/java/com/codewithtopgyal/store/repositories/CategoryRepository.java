package com.codewithtopgyal.store.repositories;

import com.codewithtopgyal.store.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}