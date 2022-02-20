package com.project.springboot.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.apirest.models.entity.Cliente;
import com.project.springboot.apirest.models.services.IClienteService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteRestController {

	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return clienteService.findAll();
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	
	@GetMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Cliente show(@PathVariable Long id) {
		return clienteService.findById(id);
	}
	
	@DeleteMapping("clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		clienteService.delete(id);
	}
	
	@PutMapping("/clientes/{id}")
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente clienteActual = clienteService.findById(id);
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setEmail(cliente.getEmail());
		
		return clienteService.save(clienteActual);
	}
}
