package com.example.employeeaddress.repository;

import com.example.employeeaddress.address.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManagerAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest

class AddressRepositoryTest {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private TestEntityManager entityManager;
    @BeforeEach
    void setup(){
        Address address=new Address("Chicago","11111");
        entityManager.persist(address);
    }
    @Test
    public void testById(){
        Address address1= addressRepository.getById(1);
        assertEquals("Chicago", address1.getCity());
    }
    @Test
    public void testSaveEmployee(){
        Address address = addressRepository.save(new Address("NewYork","22222"));
        addressRepository.save(address);
        assertEquals("NewYork", address.getCity());
    }
    @Test
    public void testAllEmployeeData(){
        List<Address> addresses = Arrays.asList(new Address("saketh","saketh1"), new Address("ravi","ravi2"));
        addressRepository.findAll();
        assertEquals(2, addresses.size());
    }

}