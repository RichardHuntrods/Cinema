package com.qa.springfilms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springfilms.domain.Films;
import com.qa.springfilms.service.FilmsService;

@RestController
@RequestMapping
public class FilmsController {

	private FilmsService service;

	@Autowired
	private FilmsController(FilmsService service) {
this.service = service;
	}


@Getmapping()
public String test() {
	return "Testing Films";
}

@PostMapping("/create")
public ResponseEntity<Films> create(@RequestBody Films fm){
	return new ResponseEntity<Films>(this.service.create(fm), HttpStatus.CREATED);
}

@GetMapping("/read")
public ResponseEntity<List<Films>>read(){
return new ResponseEntity<List<Films>>(this.service.read(),HttpStatus.OK);
}
@PutMapping("/replace/{id}")
public ResponseEntity<Films>update(@PathVariable Long id, @RequestBody Films fm){
return new ResponseEntity<Films>(this.service.update(id, fm), HttpStatus.ACCEPTED);
}

@PatchMapping("/update/{id}")
public ResponseEntity<Films>update1(@PathVariable Long id, @RequestBody Films fm){
return new ResponseEntity<Films>(this.service.update(id, fm), HttpStatus.ACCEPTED);
}
@DeleteMapping("/delete/{id}")
public ResponseEntity<Boolean>delete(@PathVariable Long id){
return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
}
}