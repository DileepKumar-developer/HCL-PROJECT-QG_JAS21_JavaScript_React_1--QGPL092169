package com.online.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping.entity.Address;
import com.online.shopping.entity.Product;
import com.online.shopping.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("")
	public List<Address> findAll(){
		return addressService.viewAllAddress();
	}
	
	@GetMapping("/{id}")
	public Address getOne(@PathVariable("id") Integer addressId) {
		return addressService.viewAddress(addressId);
	}
	
	@PostMapping(value = "/create",
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Address> createNew(@RequestBody Address address ) {
		addressService.addAddress(address);
		return ResponseEntity.ok(address);
	}
	@PutMapping("/{id}/update")
    public ResponseEntity edit(@PathVariable("id") Integer addressId,
                               @RequestBody Address address) {
		address.setAddressId(addressId);
		addressService.updateAddress(address);
        return ResponseEntity.ok(address);
    }
	@DeleteMapping("/{id}/delete")
    public ResponseEntity delete(@PathVariable("id") Integer addressId) {
        addressService.removeAddress(addressId);
        return ResponseEntity.ok().build();
    }
}
