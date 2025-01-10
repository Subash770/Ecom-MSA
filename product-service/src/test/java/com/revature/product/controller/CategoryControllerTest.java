package com.revature.product.controller;

import com.revature.product.model.Category;
import com.revature.product.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;

    // Test for a successful scenario (getting a category by ID)
   
    // Test for a failure scenario (category not found)
    @Test
    public void testGetCategoryById_Failure() {
        Long categoryId = 1L;

        when(categoryService.getCategoryById(categoryId)).thenReturn(Optional.empty());

        ResponseEntity<Category> response = categoryController.getCategoryById(categoryId);

        // Assert that the response is 404 Not Found
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

   

    // Test for getting all categories (Failure)
    @Test
    public void testGetAllCategories_Failure() {
        when(categoryService.getAllCategories()).thenReturn(new ArrayList<>());

        List<Category> response = categoryController.getAllCategories();

        // Assert that the list is empty
        assertTrue(response.isEmpty());
    }

   
    // Test for deleting a category (Success)
    @Test
    public void testDeleteCategory_Success() {
        Long categoryId = 1L;
        doNothing().when(categoryService).deleteCategory(categoryId);

        ResponseEntity<Void> response = categoryController.deleteCategory(categoryId);

        // Assert that the category is deleted successfully
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
