package com.example.employeeaddress.controller;

import com.example.employeeaddress.address.Address;
import com.example.employeeaddress.service.AddressService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebMvcTest(AddressController.class)
class AddressControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AddressService addressService;

    @BeforeEach
    public void setUp() {
        Address address = new Address("NewYork", "11111");

    }

    @Test
    void getAllAddress() throws Exception {
        Address address = new Address("NewYork", "11111");
        Address address1 = new Address("Chicago", "22222");
        List<Address> addressList = Arrays.asList(address, address1);
        Mockito.when(addressService.getAllEmployeAddress()).thenReturn(addressList);
        mockMvc.perform(MockMvcRequestBuilders.get("/Address/All"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].city", Matchers.is("NewYork")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].zipcode", Matchers.is("11111")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].city", Matchers.is("Chicago")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].zipcode", Matchers.is("22222")));
    }

    @Test
    void getById() throws Exception {
        Address address = new Address("NewYork", "11111");
        Mockito.when(addressService.getByIdAddress(address.getId())).thenReturn(Optional.of(address));
        mockMvc.perform(MockMvcRequestBuilders.get("/Address/{id}",address.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.city").value("NewYork"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.zipcode").value("11111"));

    }

    @Test
    void saveAddress() throws Exception {
        //Address address = new Address("NewYork", "11111");
        mockMvc.perform(MockMvcRequestBuilders.post("/Employed/Data")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":\"1\",\"city\":\"Chicago\",\"zipcode\":\"11111\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteById() throws Exception {
        Address address=new Address("Chicago","22222");
        Mockito.doNothing().when(addressService).deleteAddress(address.getId());
        mockMvc.perform(MockMvcRequestBuilders.delete("/Address/{id}",address.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(addressService, Mockito.times(1)).deleteAddress(address.getId());
    }
}