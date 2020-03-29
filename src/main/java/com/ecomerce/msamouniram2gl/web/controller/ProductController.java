package com.ecomerce.msamouniram2gl.web.controller;

import com.ecomerce.msamouniram2gl.model.Product;
import com.ecomerce.msamouniram2gl.dao.ProductDao;
import com.ecomerce.msamouniram2gl.dao.ProductDaoImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Nom: Mounira
 * Prenom: Soilihi Boina
 * Classe: M2GL
 */

@RestController

public class ProductController {


    private ProductDao productDao;


    //Récupération un produit par id
    @GetMapping(value = "/Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        return productDao.findById(id);
    }

    //ajout  d'un produit
    @PostMapping(value = "/Produits")
    public ResponseEntity<Void> ajouterProduit(@RequestBody Product product) {
        Product productAdded = productDao.save(product);
        if (productAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
    //Récupéreration de la liste des produits
    @RequestMapping(value = "/Produits", method = RequestMethod.GET)
    public List<Product> listeProduits() {
        return productDao.findAll();
    }


}
