package com.revature.product.controller;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.revature.product.model.Product;
import com.revature.product.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    
    // Test for a failure scenario (product not found)
    @Test
    public void testGetProductById_Failure() {
        Long productId = 1L;

        when(productService.getProductById(productId)).thenReturn(Optional.empty());

        ResponseEntity<Product> response = productController.getProductById(productId);

        // Assert that the response is 404 Not Found
        assert(response.getStatusCode() == HttpStatus.NOT_FOUND);
        assert(response.getBody() == null);
    }

   

    // Test for getting products by category ID (Failure)
    @Test
    public void testGetProductsByCategoryId_Failure() {
        Long categoryId = 1L;

        when(productService.getProductsByCategoryId(categoryId)).thenReturn(new ArrayList<>());

        ResponseEntity<List<Product>> response = productController.getProductsByCategoryId(categoryId);

        // Assert that the response is 204 No Content
        assert(response.getStatusCode() == HttpStatus.NO_CONTENT);
        assert(response.getBody() == null);
    }
}

