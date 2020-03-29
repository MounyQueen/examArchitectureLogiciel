package com.ecomerce.msamouniram2gl.dao;

import com.ecomerce.msamouniram2gl.model.Product;

import java.util.List;

/**
 * Nom: Mounira
 * Prenom :Soilihi Boina
 * Classe: M2GL
 */
public interface ProductDao {
    Product findById(int id);
    Product save(Product product);
    List<Product> findAll();

}
