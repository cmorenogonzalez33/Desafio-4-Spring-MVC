package com.example.Desafio4.Spring.MVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Desafio4.Spring.MVC.model.Cliente;
import com.example.Desafio4.Spring.MVC.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("/")
	public String inicio() {
		return "index";
	}
	
	@GetMapping("/lista")
	public String viewHomePage(Model model) {
        model.addAttribute("listClientes", clienteService.getAllClientes());
        return "lista";
    }
	
	@GetMapping("/nuevo")
    public String showNewClienteForm(Model model) {
        // create model attribute to bind form data
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "nuevo";
    }
	
	@PostMapping("/saveCliente")
    public String saveCilente(@ModelAttribute("cliente") Cliente cliente) {
        // save employee to database
        clienteService.saveCliente(cliente);
        return "redirect:/";
    }
	
	// Busca por nombre introducido
		@RequestMapping(value="/nombreP", method=RequestMethod.GET, params= {"np", "np1", "np2"})
		public @ResponseBody String nombreP(@RequestParam("np") String np, @RequestParam("np1") String np1, @RequestParam("np2") String np2) {
			clienteService.getClienteByName(np, np1, np2);
			return "encontrados";
		}
		
}
