package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.energy.Product;
import com.tecsus.ddc.query.ProductQueryFactory;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.controller.repository.ProductRepository;
import org.junit.Test;

import java.util.List;

public class ProductServiceTest {

    private final ProductRepository productRepository;

    public ProductServiceTest() {
        Connector connector = new Connector().connect();
        ConnectionImpl connection = connector.getConnection();
        this.productRepository = new ProductRepository(connection, new ProductQueryFactory());
    }

    @Test
    public void testFindAll() {
        ProductService service = new ProductService(productRepository);

        List<Product> products = service.findAllById("1");
        products.forEach(product -> {
            System.out.println(String.format("ID: %d -> valor: %s", product.getId(), product.getTotalValue().toString()));
        });
    }
}
