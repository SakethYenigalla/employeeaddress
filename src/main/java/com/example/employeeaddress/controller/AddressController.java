package com.example.employeeaddress.controller;

import com.example.employeeaddress.addressmodel.Address;
import com.example.employeeaddress.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Address")

public class AddressController {
    @Autowired
    private AddressService addressService;
    public AddressController(AddressService addressService){
        this.addressService=addressService;
    }
    @GetMapping("/All")
    public List<Address> getAllAddress(){
        return (List<Address>) addressService.getAllData();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable int id){
        Optional<Address> optional=addressService.getById(id);
        return optional.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<String> saveEmployee(@RequestBody Address address){
        addressService.saveData(address);
        return ResponseEntity.status(HttpStatus.OK).body("Employee Saved..!!");

    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id){
        addressService.deleteAddress(id);
    }
}
