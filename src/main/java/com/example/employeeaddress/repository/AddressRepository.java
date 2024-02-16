package com.example.employeeaddress.repository;

import com.example.employeeaddress.addressmodel.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
