package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitController {
	@Autowired
	private IProduitRepository produitRepository;
	
	@RequestMapping("/save")
	public Produit saveProduit(Produit p) {
		produitRepository.save(p);
		return p ;
	}

	@RequestMapping("/all")
	public List<Produit> getProduits(){
		return produitRepository.findAll();
	}
	
	@RequestMapping("/produits")
	public Page<Produit> getProduits(int page){
		return produitRepository.findAll(PageRequest.of(page, 5));
	}

	@RequestMapping("/produitsParMC")
	public Page<Produit> getProduits(String mc,int page){
		return produitRepository.produitParMC("%"+mc+"%", PageRequest.of(page, 5));
	}
	
	@RequestMapping("/get")
	public Produit getProduit(Long ref) {
		return produitRepository.getOne(ref);
	}
	
	@RequestMapping("/delete")
	public boolean delete(Long ref) {
		produitRepository.deleteById(ref);
		return true;
	}
	
	@RequestMapping("update")
	public Produit update(Produit p) {
		produitRepository.saveAndFlush(p);
		return p;
	}
	
	
	

}
