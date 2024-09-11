package com.cryptogramming.springdatajdbc.controller;

import com.cryptogramming.springdatajdbc.dto.ProductDTO;
import com.cryptogramming.springdatajdbc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping(value="/products",produces = "application/json")
    public ResponseEntity getProducts() {

        List<ProductDTO> response = productService.getAllProducts();

        return new ResponseEntity(response,HttpStatus.CREATED);

    }

    @PostMapping(value = "/products")
    public ResponseEntity  saveProduct(@RequestBody ProductDTO productDTO){

        productService.createProduct(productDTO);
        return new ResponseEntity(HttpStatus.CREATED);

    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity  updateProduct(@PathVariable int productId){

        ProductDTO response =  productService.getProductById(productId);
        return new ResponseEntity(response,HttpStatus.OK);

    }


    @PutMapping(value = "/")
    public ResponseEntity  updateProduct(@RequestBody ProductDTO productDTO){

         productService.updateProduct(productDTO);
        return new ResponseEntity(HttpStatus.OK);

    }


    @DeleteMapping(value = "/{productId}")
    public ResponseEntity  deleteProduct(@PathVariable int productId){

        productService.deleteProduct(productId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
}
