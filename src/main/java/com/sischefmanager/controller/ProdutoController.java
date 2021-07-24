package com.sischefmanager.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.sischefmanager.model.Produto;
import com.sischefmanager.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/cadastro-produto")
	public String cadastro() {
		return "produto/cadastroProduto";
	}
	
	@PostMapping("/cadastro-produto")
	public String cadastro(Produto produto) {
		produtoRepository.save(produto);
		return "produto/cadastroProduto";
	}
	
	@GetMapping("/produto")
	public ModelAndView produto() {
		ModelAndView model = new ModelAndView("produto/tabelaProduto");
		Iterable<Produto> produto = produtoRepository.findAll();
		model.addObject("produto", produto);
		return model;
	}
	
	
	@GetMapping("/editar-produto/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView model = new ModelAndView("produto/editarProduto");
		Optional<Produto> produto = produtoRepository.findById(id);
		model.addObject("produto", produto);
		return model;
	}

    @GetMapping("/deletar-produto") 
    public String removerAluno(@RequestParam Long id){
        Produto produto = produtoRepository.getById(id);
        produtoRepository.delete(produto);
        return "redirect:/produto";
    }
    
}
