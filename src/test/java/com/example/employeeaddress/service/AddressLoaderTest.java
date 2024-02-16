package com.example.employeeaddress.service;

import com.example.employeeaddress.repository.AddressRepository;
import com.example.employeeaddress.address.Address;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class AddressLoaderTest {

    @MockBean
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressLoader addressLoader;

    @Test
    void run() throws Exception {
        when(addressRepository.save(any(Address.class))).thenReturn(null);
        verify(addressRepository, times(50)).save(any(Address.class));
    }
}
