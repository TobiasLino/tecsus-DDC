package com.tecsus.ddc.controller.service;

import com.tecsus.ddc.bills.energy.Product;
import com.tecsus.ddc.bills.energy.enums.ProductDescription;
import com.tecsus.ddc.factory.ProductFactory;
import com.tecsus.ddc.query.ProductQueryFactory;
import com.tecsus.ddc.controller.connector.ConnectionImpl;
import com.tecsus.ddc.controller.connector.Connector;
import com.tecsus.ddc.controller.repository.ProductRepository;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class ProductServiceTest {

    private final ProductRepository productRepository;

    public ProductServiceTest() {
        Connector connector = new Connector().connect();
        ConnectionImpl connection = connector.getConnection();
        this.productRepository = new ProductRepository(connection, new ProductQueryFactory(), new ProductFactory());
    }

    @Test
    public void testFindAll() {
        ProductService service = new ProductService(productRepository);

        List<Product> products = service.findAllById("1");
        products.forEach(product -> {
            System.out.printf("ID: %d -> valor: %s%n", product.getId(), product.getTotalValue().toString());
        });
    }

    @Test
    public void insertedProductIsTheAameAsReturned() {
        Product product = simpleProduct();

        ProductService service = new ProductService(productRepository);
        service.insert(product);

        Optional<Product> productResponse = service.findById("6");

        productResponse.ifPresent(value -> assertEquals(product, value));
    }

    @Test
    public void findAll() {
        ProductService service = new ProductService(productRepository);
        List<Product> products = service.findAll();
        products.forEach(System.out::println);
        assertEquals(5, products.size());
    }

    private Product simpleProduct() {
        return Product.builder()
                .totalValue(new BigDecimal("25.00"))
                .kWhQuantity(new BigDecimal("300"))
                .fornecValue(new BigDecimal("7.58"))
                .description("TUSD - Consumo")
                .billNum(2)
                .build();
    }
}
