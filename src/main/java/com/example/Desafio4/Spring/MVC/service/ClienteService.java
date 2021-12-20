package com.example.Desafio4.Spring.MVC.service;

import com.example.Desafio4.Spring.MVC.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
	List < Cliente > getAllClientes();
    void saveCliente(Cliente cliente);
    Optional<Cliente> getClienteByName(final String name, final String surname1, final String surname2);
}
