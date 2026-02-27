package com.tyss.controller;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
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
//	@GetMapping("/fetch")
//	public String fetch(@RequestParam (name="pid")int id, @RequestParam(name="pname") String name){
//		return "Product id- "+id+ ", Product name- "+name;
//	}
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/all")
	public List<Product> fetch(){
		List<Product > products=productRepository.findAll();
		return products;
	}
	@GetMapping("/byId")
	public Product fetchById(@RequestParam Integer pid) {
		return productRepository
				.findById(pid)
				.orElseThrow(()-> new RuntimeErrorException(null,"Product not found"));
	}
	@PostMapping("/save")
	public Product save(@RequestBody Product product) {
		// TODO Auto-generated method stub
		Product savedProduct=productRepository.save(product);
		return savedProduct;
	}
	
	@PutMapping("/update/pid/{pid}")
	public String update(@PathVariable Integer pid, @RequestBody Product product) {
		
		Optional<Product> opt=productRepository.findById(pid);
		
		if(opt.isPresent()) {
		Product dbproduct = opt.get();
		dbproduct.setPid(product.getPid());
		dbproduct.setPname(product.getPname());
		
		productRepository.save(dbproduct);
		return "Product update successfully";
		}
		return "project not found";
		
		// TODO Auto-generated method stub
//		System.out.println(brand);System.out.println(token);
//		//return "BrandName- "+brand+" Token-"+token ;
//		
//		return "Product Updated: "+brand+" "+token;
	}
	@DeleteMapping("/delete/{id}")
	private String delete( @PathVariable (name="id")int pid,@PathVariable String pname) {
		// TODO Auto-generated method stub
		
		Optional<Product> opt = productRepository.findById(pid);
		if (opt.isPresent()) {
			productRepository.deleteById(pid);
			return "product deleted";
		}
		return "Product not found";
	}
	
	@PatchMapping("/patch")
	private String patch() {
		// TODO Auto-generated method stub
		return "patch open sandy";
	}
}
