package com.example.orderprocessingsystem.controller;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.example.orderprocessingsystem.model.Customer;
import com.example.orderprocessingsystem.service.CustomerService;
import com.example.orderprocessingsystem.controller.CustomerController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    private CustomerService service;

    @InjectMocks
    private CustomerController controller;

    @Test
    void testAddCustomer() {
        Customer customer = new Customer(1, "John", "john@gmail.com");
        when(service.addCustomer(customer)).thenReturn(customer);
        Customer result = controller.addCustomer(customer).getBody();
        assertNotNull(result);
        assertEquals("John", result.getName());
        verify(service, times(1)).addCustomer(customer);
    }

    @Test
    void testGetCustomers() {
        List<Customer> customers = Arrays.asList(
                new Customer(1, "John", "john@gmail.com"),
                new Customer(2, "siri", "siri@gmail.com")
        );
        when(service.getAllCustomers()).thenReturn(customers);
        List<Customer> result = controller.getCustomers();
        assertEquals(2, result.size());
        verify(service, times(1)).getAllCustomers();
    }
}

