package com.heavne.pagingsorting.service;

import com.heavne.pagingsorting.model.Product;
import com.heavne.pagingsorting.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProduct{
    @Autowired
    ProductRepository repo;

    @Override
    public Page<Product> listAll(int pageNumber,String sortField, String sortDir) {
        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc")?sort.ascending():sort.descending();
        Pageable pageable = PageRequest.of(pageNumber-1,10,sort);
        return repo.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        repo.save(product);
    }

    @Override
    public Product get(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
