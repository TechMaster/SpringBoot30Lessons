package com.heavne.pagingsorting.service;

import com.heavne.pagingsorting.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProduct {
    Page<Product> listAll(int pageNumber,String sortField, String sortDir);
    void save(Product product);
    Product get(Integer id);
    void delete(Integer id);
}
