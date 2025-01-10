package com.revature.product.service;

import com.revature.product.model.Category;
import com.revature.product.repository.CategoryRepository;
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
public class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

  
    // Test for getting a category by ID (Failure)
    @Test
    public void testGetCategoryById_Failure() {
        Long categoryId = 1L;

        when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());

        Optional<Category> retrievedCategory = categoryService.getCategoryById(categoryId);

        assertFalse(retrievedCategory.isPresent());
    }

    

  

    

    // Test for deleting a category (Failure)
    @Test
    public void testDeleteCategory_Failure() {
        Long categoryId = 1L;

        when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            categoryService.deleteCategory(categoryId);
        });

        assertEquals("Category not found with id 1", exception.getMessage());
    }
}
