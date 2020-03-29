package com.ecomerce.msamouniram2gl.dao;

import com.ecomerce.msamouniram2gl.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Nom : Mounira
 * Prenom: Soilihi Boina
 * Classe: M2GL
 */
@Repository
public class ProductDaoImpl implements ProductDao {
    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, new String("Ordinateur"), 150000));
        products.add(new Product(2, new String("Imprimante"), 20000));
        products.add(new Product(3, new String("chaise roulante"), 15000));
    }


    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

}
