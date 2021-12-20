package com.example.Desafio4.Spring.MVC.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Desafio4.Spring.MVC.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	public Optional<Cliente> findByNameAndSurName1AndSurName2(final String name, final String surname1, final String surname2);
}
