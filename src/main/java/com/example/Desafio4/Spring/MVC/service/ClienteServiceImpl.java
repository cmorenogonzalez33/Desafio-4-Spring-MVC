package com.example.Desafio4.Spring.MVC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Desafio4.Spring.MVC.model.Cliente;
import com.example.Desafio4.Spring.MVC.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> getAllClientes() {
		
		return clienteRepository.findAll();
	}

	@Override
	public void saveCliente(Cliente cliente) {
		this.clienteRepository.save(cliente);
		
	}

	@Override
	public Optional<Cliente> getClienteByName(String name, String surname1, String surname2) {
		Optional < Cliente > optional = clienteRepository.findByNameAndSurName1AndSurName2(name, surname1, surname2);
        
		Cliente cliente = null;
        if (optional.isPresent()) {
            cliente = optional.get();
        } else {
            throw new RuntimeException(" Cliente not found for name :: " + name + " " + surname1 + " " + surname2);
        }
        
        
		return optional;
	}
	
}
