package com.project.springboot.apirest.models.services;

import java.util.List;

import com.project.springboot.apirest.models.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();
}
