package com.example.employeeaddress.service;

import com.example.employeeaddress.addressmodel.Address;
import com.example.employeeaddress.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service

public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    public AddressService(AddressRepository addressRepository){
        this.addressRepository=addressRepository;
    }
    public List<Address> getAllData(){
        return (List<Address>) addressRepository.findAll();
    }
    public Optional<Address> getById(int id){
        Optional<Address> optional=addressRepository.findById(id);
        return optional;
    }
    public Address saveData(Address address){
        return addressRepository.save(address);
    }
    public void deleteAddress(int id){
        addressRepository.deleteById(id);
    }
}
