package com.tyss.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	@GetMapping("/fetch")
	public String fetch(@RequestParam (name="pid")int id, @RequestParam(name="pname") String name){
		return "Product id- "+id+ ", Product name- "+name;
	}
	@PostMapping("/save")
	public Product save(@RequestBody Product product) {
		// TODO Auto-generated method stub
		System.out.println(product);
		return product;
	}
	@DeleteMapping("/delete/{id}/name/{pname}")
	private String delete( @PathVariable (name="id")int pid,@PathVariable String pname) {
		// TODO Auto-generated method stub
		return "delete successful: "+pid +" "+pname;
	}
	@PutMapping("/update")
	private String Update(@RequestHeader (name="pbrand")String brand, @RequestHeader (name="ptoken")String token) {
		// TODO Auto-generated method stub
		System.out.println(brand);System.out.println(token);
		//return "BrandName- "+brand+" Token-"+token ;
		
		return "Product Updated: "+brand+" "+token;
	}
	@PatchMapping("/patch")
	private String patch() {
		// TODO Auto-generated method stub
		return "patch open sandy";
	}
}
