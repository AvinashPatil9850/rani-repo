package com.example.crud.controller;

import com.example.crud.entity.Product;
import com.example.crud.serivce.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

   @PostMapping
   public void addProduct(@RequestBody Product product){
       productService.saveProduct(product);
   }

   @GetMapping("/getAll")
    public List<Product> getAll(){
       return productService.getAllProduct();
   }
}
