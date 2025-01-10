package com.revature.product.service;

import com.revature.product.model.Product;
import com.revature.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

   

    // Test for getting a product by ID (Failure)
    @Test
    public void testGetProductById_Failure() {
        Long productId = 1L;

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        Optional<Product> retrievedProduct = productService.getProductById(productId);

        assertFalse(retrievedProduct.isPresent());
    }

    
    // Test for deleting a product (Failure)
    @Test
    public void testDeleteProduct_Failure() {
        Long productId = 1L;

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            productService.deleteProduct(productId);
        });

        assertEquals("Product not found with id 1", exception.getMessage());
    }

   

    // Test for getting products by category ID (Failure)
    @Test
    public void testGetProductsByCategoryId_Failure() {
        Long categoryId = 1L;

        when(productRepository.findByCategoryId(categoryId)).thenReturn(new ArrayList<>());

        List<Product> retrievedProducts = productService.getProductsByCategoryId(categoryId);

        assertTrue(retrievedProducts.isEmpty());
    }
}
