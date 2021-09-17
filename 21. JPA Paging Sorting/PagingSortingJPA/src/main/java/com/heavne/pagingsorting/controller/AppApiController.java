package com.heavne.pagingsorting.controller;

import com.heavne.pagingsorting.model.Product;
import com.heavne.pagingsorting.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AppApiController {
    @Autowired
    private ProductService service;
    @GetMapping
    public ResponseEntity<?> viewHomePage(){
        return listPage(1,"name","asc");
    }
    @GetMapping("/page/{pageNumber}")
    public ResponseEntity<?> listPage(@PathVariable("pageNumber") int pageNumber,
                                   @Param("sortField") String sortField,
                                   @Param("sortDir") String sortDir){
        Map<String,Object> result = new HashMap<>();
        int currentPage = pageNumber;
        Page<Product> page = service.listAll(pageNumber,sortField,sortDir);
        List<Product> listProducts = page.getContent();

        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();

        result.put("listProducts",listProducts);
        result.put("currentPage",currentPage);
        result.put("totalItems",totalItems);
        result.put("totalPages",totalPages);
        result.put("sortField",sortField);
        result.put("sortDir",sortDir);

        return ResponseEntity.ok(result);
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        service.save(product);
        return new ResponseEntity<>("Save product successfully", HttpStatus.CREATED);
    }
    @GetMapping("/edit/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Integer id){
        var product = service.get(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id){
        service.delete(id);
        return new ResponseEntity<>("Delete successfully",HttpStatus.OK);
    }
}
