package ifrn.projetopi.dlart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ifrn.projetopi.dlart.models.Produto;
import ifrn.projetopi.dlart.repositories.ProdutoRepository;

@Controller
public class Produtos {
	
	@Autowired
	private ProdutoRepository pr;
	
	@RequestMapping("/")
	public String GetProdutos() {
		return "Home";
	}
	
	@PostMapping("/addproduto")
	public String SaveProduto(Produto produto){
		pr.save(produto);
		System.out.print("Salvou o produto");
		return "produtoadd";
	}
}
