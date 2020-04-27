
package com.example.controller;
import java.util.List;

import com.example.exceptions.IdNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Employee;
import com.example.service.ServiceClass;

@RestController
@RequestMapping("/ticket")
@CrossOrigin("http://localhost:4200")
public class ControllerClass {
	@Autowired
	ServiceClass serviceobj;

	// generate ticket
	@PostMapping("/ticket")
	public ResponseEntity<String> TicketCreation(@RequestBody Ticket t) {
		Ticket t = serviceobj.EmployeeCreation(emp);
		if (t == null) {
			throw new IdNotFoundException("Enter Valid Id");
		} else {
			return new ResponseEntity<String>("Employee created successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Get Particular Ticket Data
	@GetMapping("/GetTicket/{id}")
	private ResponseEntity<Ticket> getEmployee(@PathVariable("id") int id) {
		Ticket t = serviceobj.getTicketById(id);
		if (t == null) {
			throw new IdNotFoundException("Id does not exist,so we couldn't fetch details");
		} else {
			return new ResponseEntity<Employee>(e, new HttpHeaders(), HttpStatus.OK);
		}
	}

	// Get All tickets Data
	@GetMapping("/GetAllTickets")
	private ResponseEntity<List<Ticket>> getAllTicket() {
		List<Ticket> emplist = serviceobj.getAllTicket();
		return new ResponseEntity<List<Ticket>>(emplist, new HttpHeaders(), HttpStatus.OK);

	}

	