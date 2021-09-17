package com.heavne.pagingsorting.repository;

import com.heavne.pagingsorting.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
