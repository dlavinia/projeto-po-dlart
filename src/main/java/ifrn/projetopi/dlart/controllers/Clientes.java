package ifrn.projetopi.dlart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ifrn.projetopi.dlart.models.Cliente;
import ifrn.projetopi.dlart.repositories.ClienteRepository;

@Controller
public class Clientes {
	
	@Autowired
	private ClienteRepository cr;
	
	@GetMapping("/cadastrar/cliente")
	public String formcliente() {
		return "cliente/novoCliente";
	};
	
	@GetMapping("/cliente/login")
	public String formlogin() {
		return "cliente/login";
	};
	
	//Salvar produtos
		@PostMapping("/cadastrar/cliente")
		public String salvarCliente(Cliente cliente){
			cr.save(cliente);
			System.out.print("Salvou o cliente");
			return "cliente/favs";
		}
		

}
