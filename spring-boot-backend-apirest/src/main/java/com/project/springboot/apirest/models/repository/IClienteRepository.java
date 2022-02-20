package com.project.springboot.apirest.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.springboot.apirest.models.entity.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, Long>{

}
