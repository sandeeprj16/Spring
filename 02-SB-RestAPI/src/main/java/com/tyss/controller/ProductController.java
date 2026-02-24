package com.tyss.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	@GetMapping("/fetch")
	public String fetch(){
		return "Fetch Data";
	}
	@PostMapping("/save")
	private String save() {
		// TODO Auto-generated method stub
		return "save operations";
	}
	@DeleteMapping("/delete")
	private String delete() {
		// TODO Auto-generated method stub
		return "delete successful";
	}
	@PutMapping("/update")
	private int Update() {
		// TODO Auto-generated method stub
		return 10 ;
	}
	@PatchMapping("/patch")
	private String patch() {
		// TODO Auto-generated method stub
		return "patch oper";
	}
}
