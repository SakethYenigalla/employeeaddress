package com.example.employeeaddress.service;

import com.example.employeeaddress.addressmodel.Address;
import com.example.employeeaddress.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component

public class AddressLoader implements CommandLineRunner {
    @Autowired
    private AddressRepository addressRepository;
    private static final String[] CITIES = {"New York", "Los Angeles", "Chicago", "Houston"};
    private static final String[] ZIP_CODES = {"10001", "90001", "60601", "77001"};
    Random random=new Random();
    String randomCity = CITIES[random.nextInt(CITIES.length)];
    String randomZipCode = ZIP_CODES[random.nextInt(ZIP_CODES.length)];


    @Override
    public void run(String... args) throws Exception {
        int count=50;
        for(int i=1;i<=count;i++){
            Address address=new Address();
            address.setCity(randomCity);
            address.setZipCode(randomZipCode);
            addressRepository.save(address);
        }

    }
}
