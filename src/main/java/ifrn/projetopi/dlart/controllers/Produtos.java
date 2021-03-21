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
	
	
	
	//Listar para gerenciar
		@GetMapping("/gerenciarprodutos")
		public ModelAndView getprodutos() {
			
			List<Produto> produtos = pr.findAll();
			ModelAndView mv = new ModelAndView("produto/gerenciarprodutos");
			mv.addObject("produtos", produtos);
			return mv;
			
		}
		
	
	
	//Listar produtos na home
	@GetMapping("/")
	public ModelAndView listarProdutos() {
		
		List<Produto> produtos = pr.findAll();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("produtos", produtos);
		return mv;
		
	}
	
	//Detalhar produtos
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
	//Salvar produtos
	@PostMapping("/addproduto")
	public String salvarProduto(Produto produto){
		pr.save(produto);
		System.out.print("Salvou o produto");
		return "redirect:gerenciarprodutos";
	}
	
	//Deletar produtos
	@GetMapping("/produto/{id}/remover")
	public String apagarProduto(@PathVariable Long id){
	Optional<Produto> opt = pr.findById(id);

	if(!opt.isEmpty()){
		Produto produto = opt.get();
		pr.delete(produto);
		System.out.print("deletou o produto");
		
	}
	
	return "redirect:/gerenciarprodutos";
	}
}
