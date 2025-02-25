package com.revature.user.controller;

import com.revature.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ViewControllerTest {

    @InjectMocks
    private ViewController viewController;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private HttpSession session;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

   

   
    // Test for logout
    @Test
    public void testLogout() {
        // Call the method
        ModelAndView result = viewController.logout(session);

        // Verify and assert
        verify(session, times(1)).invalidate();
        assertEquals("redirect:http://localhost:8080/", result.getViewName());
    }

    // Test for home page
    @Test
    public void testHome() {
        // Call the method
        String result = viewController.home();

        // Assert the correct view is returned
        assertEquals("home", result);
    }

    // Test for login page
    @Test
    public void testLoginPage() {
        // Call the method
        String result = viewController.loginPage();

        // Assert the correct view is returned
        assertEquals("login", result);
    }

    // Test for registration page
    @Test
    public void testRegistrationPage() {
        // Call the method
        String result = viewController.registrationPage();

        // Assert the correct view is returned
        assertEquals("registration", result);
    }

    // Test for admin page
   

    // Test for seller page
    @Test
    public void testSellerPage() {
        // Call the method
        String result = viewController.sellerPage();

        // Assert the correct view is returned
        assertEquals("sellerPage", result);
    }
}
