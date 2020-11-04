package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.energy.Product;
import com.tecsus.ddc.controller.repository.ProductRepository;
import com.tecsus.ddc.controller.repository.Repository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

/**
 * @author TOBIASDASILVALINO
 */
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;



    public void insertAll(final Iterable<Product> products) {
        productRepository.saveAll(products);
    }

    public void insert(final Product product) {
        productRepository.save(product);
    }

    public Optional<Product> findById(final String idProduct) {
        return productRepository.findById(idProduct);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAllById(final String id) {
        return productRepository.findAllById(id);
    }
}
