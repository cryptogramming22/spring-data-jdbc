package com.cryptogramming.springdatajdbc.datasource;

import com.cryptogramming.springdatajdbc.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDataSource {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addProduct(Product product) {
        String sql = "INSERT INTO food.product (image_path, title, description, distributor, release_date) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, product.getImagePath(), product.getTitle(), product.getDescription(), product.getDistributor(), product.getReleaseDate());
    }

    public Product getProductById(int id) {
        String sql = "SELECT * FROM food.product WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Product.class));
    }

    public void updateProduct(Product product) {
        String sql = "UPDATE food.product SET imagePath = ?, title = ?, description = ?, distributor = ?, releaseDate = ? WHERE id = ?";
        jdbcTemplate.update(sql, product.getImagePath(), product.getTitle(), product.getDescription(), product.getDistributor(), product.getReleaseDate(), product.getId());
    }

    public void deleteProduct(int id) {
        String sql = "DELETE FROM food.product WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM food.product";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));
    }
}
