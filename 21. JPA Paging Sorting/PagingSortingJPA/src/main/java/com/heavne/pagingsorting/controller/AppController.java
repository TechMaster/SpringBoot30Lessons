package com.heavne.pagingsorting.controller;


import com.heavne.pagingsorting.model.Product;
import com.heavne.pagingsorting.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {
    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {

        return listByPage(1,model,"name","asc");
    }

    @GetMapping("/page/{pageNumber}")
    public String listByPage(@PathVariable("pageNumber") int pageNumber, Model model,
                             @Param("sortField") String sortField,
                             @Param("sortDir") String sortDir){
        int currentPage = pageNumber;

        Page<Product> page = service.listAll(pageNumber,sortField,sortDir);
        List<Product> listProducts = page.getContent();

        long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();

        model.addAttribute("currentPage",currentPage);
        model.addAttribute("totalItems",totalItems);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("sortField",sortField);
        model.addAttribute("sortDir",sortDir);

        String reverseSortDir = sortDir.equals("asc") ? "desc":"asc";
        model.addAttribute("reverseSortDir",reverseSortDir);
        return "index";
    }

    @GetMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Integer id, Model model ){
        var product = service.get(id);
        model.addAttribute("product",product);
        return "edit_product";
    }

    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, Model model){
        service.delete(id);
        return "redirect:/";
    }


}
