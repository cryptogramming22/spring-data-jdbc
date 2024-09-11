package com.cryptogramming.springdatajdbc.service;

import com.cryptogramming.springdatajdbc.datasource.ProductDataSource;
import com.cryptogramming.springdatajdbc.domain.Product;
import com.cryptogramming.springdatajdbc.dto.ProductDTO;
import com.cryptogramming.springdatajdbc.dto.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public  class ProductService {

    @Autowired
    ProductDataSource dataSource;

    public List<ProductDTO> getAllProducts() {

        List<Product>  products = dataSource.getAllProducts();

        List<ProductDTO> productDTOS = products.stream().map(
                product -> ProductMapper.mapper.productToProductDto(product)).collect(Collectors.toList());

        return productDTOS;
    }

    public ProductDTO getProductById(int id) {

        Product  product = dataSource.getProductById(id);

        ProductDTO productDTO = ProductMapper.mapper.productToProductDto(product);

        return productDTO;
    }



    public void createProduct(ProductDTO productDTO) {

        Product product = ProductMapper.mapper.productDtoToProduct(productDTO);
        product.setDistributor("ACME");
        Date dateNow = new Date();
        product.setReleaseDate(dateNow);
        dataSource.addProduct(product);


    }

    public void updateProduct(ProductDTO productDTO) {
         dataSource.updateProduct(ProductMapper.mapper.productDtoToProduct(productDTO));
    }

    public void deleteProduct(int productId) {
        Product product = dataSource.getProductById(productId);

        if (product!=null){
            dataSource.deleteProduct(product.getId());
        }
    }




}
