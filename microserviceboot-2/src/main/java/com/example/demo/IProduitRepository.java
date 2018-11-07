package com.example.demo;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;


public interface IProduitRepository extends MongoRepository<Produit,Long>{
	//@Query("select p from Produit p where p.designation like :x")
	public Page<Produit> produitParMC(@Param("x")String mc,Pageable p);
	public List<Produit> findByDesignation(String des);
	public Page<Produit> findByDesignation(String des, Pageable p);
	public Produit getOne(Long ref);
	public void saveAndFlush(Produit p);

}
