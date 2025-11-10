package com.example.orderprocessingsystem.service;
import com.example.orderprocessingsystem.model.Customer;
import com.example.orderprocessingsystem.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
    private CustomerRepository repository;

    @InjectMocks
    private CustomerService service;

    @Test
    void testAddCustomer() {
        Customer c = new Customer(0, "siri", "siri@gmail.com");
        Customer saved = new Customer(1, "", "siri@gmail.com");
        when(repository.save(c)).thenReturn(saved);
        Customer result = service.addCustomer(c);
        assertNotNull(result);
        assertEquals(1, result.getId());
        verify(repository, times(1)).save(c);
    }

    @Test
    void testGetAllCustomers() {
        List<Customer> list = Arrays.asList(
                new Customer(1, "john", "john@gmail.com"),
                new Customer(2, "siri", "siri@gmail.com")
        );
        when(repository.findAll()).thenReturn(list);
        List<Customer> result = service.getAllCustomers();
        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }
}

