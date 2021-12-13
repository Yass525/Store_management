package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Produit;
import com.example.demo.entity.Stock;
import com.example.demo.repositories.ProduitRpository;
import com.example.demo.repositories.StockRepository;

@Service
public class ProduitServiceImpl implements IProduit {
	@Autowired
	private ProduitRpository produitRepository;
	private StockRepository stockRepository;

	@Override
	public List<Produit> retrieveAllProduits() {
		// TODO Auto-generated method stub
		List<Produit> produits = (List<Produit>) produitRepository.findAll();
		return produits;
		
	}

	@Override
	public Produit addProduit(Produit p) {
		// TODO Auto-generated method stub
		produitRepository.save(p);
		return p;
	}

	@Override
	public void deleteProduit(Long id) {
		// TODO Auto-generated method stub
		produitRepository.deleteById(id);
	}

	@Override
	public Produit updateProduit(Produit u) {
		// TODO Auto-generated method stub
		return produitRepository.save(u);
	}

	@Override
	public Produit retrieveProduit(Long id) {
		// TODO Auto-generated method stub
		Produit produit = produitRepository.findById(id).orElse(null);
		return produit;
	}
	@Override
	public String affectProduitToStock(Long idProduit,Long idStock){
		Stock stockEntity=stockRepository.findById(idStock).get();
		Produit produitEntity=produitRepository.findById(idProduit).get();
		produitEntity.setStock(stockEntity);
		
		produitRepository.save(produitEntity);
		return"success";
		
	}
	

}
