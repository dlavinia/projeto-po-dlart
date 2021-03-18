package ifrn.projetopi.dlart.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.projetopi.dlart.models.Produto;
import ifrn.projetopi.dlart.repositories.ProdutoRepository;

@Controller
public class Produtos {
	
	@Autowired
	private ProdutoRepository pr;
	
	@RequestMapping("/")
	public String index() {
		return "home";
	};
	
	@GetMapping("/novoproduto")
	public String novoProd() {
		return "produto/novoProduto";
	}
	
	@GetMapping("/")
	public ModelAndView listarProdutos() {
		
		List<Produto> produtos = pr.findAll();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("produtos", produtos);
		return mv;
		
	}
	
	@GetMapping("/produto/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView md = new ModelAndView();
		Optional<Produto> opt = pr.findById(id);
		
		if(opt.isEmpty()) {
			md.setViewName("home");
			return md;
		}
		
		md.setViewName("produto/detalhes");
		Produto produto = opt.get();
		md.addObject("produto", produto);
		
		return md;
		
		
		
	}
	
	
	
	@PostMapping("/addproduto")
	public String saveProduto(Produto produto){
		pr.save(produto);
		System.out.print("Salvou o produto");
		return "produto/produtoadd";
	}
}
