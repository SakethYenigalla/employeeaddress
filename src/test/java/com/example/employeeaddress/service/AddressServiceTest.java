package com.example.employeeaddress.service;

import com.example.employeeaddress.address.Address;
import com.example.employeeaddress.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class AddressServiceTest {
    @MockBean
    private AddressRepository addressRepository;
    @Autowired
    private AddressService addressService;


    @Test
    void getAllEmployeAddress() {
        List<Address> addressList=Arrays.asList(new Address("Newyork","11111"),new Address("Chicago","22222"));
        Mockito.when(addressRepository.findAll()).thenReturn(addressList);
        List<Address> serviceList=addressService.getAllEmployeAddress();
        assertEquals(addressList,serviceList);
    }

    @Test
    void getByIdAddress() {
        Optional<Address> address= Optional.of(new Address("Chicago","22222"));
        Mockito.when(addressRepository.findById(2)).thenReturn(address);
        String addressName="Chicago";
        Optional<Address> cityName=addressService.getByIdAddress(2);
        assertEquals(addressName,cityName.get().getCity());

    }

    @Test
    void addNewAddress() {
        Address address=new Address("NewYork","11111");
        Mockito.when(addressRepository.save(address)).thenReturn(address);
       addressService.addNewAddress(address);
       Mockito.verify(addressRepository, Mockito.times(1)).save(address);
    }

    @Test
    void deleteAddress() {
        Address address=new Address("NewYork","11111");
        Mockito.doNothing().when(addressRepository).deleteById(1);
        addressService.deleteAddress(1);
        Mockito.verify(addressRepository,Mockito.times(1)).deleteById(1);
    }
}