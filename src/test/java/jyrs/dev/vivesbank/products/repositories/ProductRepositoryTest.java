package jyrs.dev.vivesbank.products.repositories;

import jyrs.dev.vivesbank.products.models.Product;
import jyrs.dev.vivesbank.products.models.type.ProductType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository ProductRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Product productTest = Product.builder()
            .id(1L)
            .type(ProductType.BANK_ACCOUNT)
            .specification("test_account")
            .tae(0.2)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();

    @Test
    void findAllByType() {

        entityManager.merge(productTest);
        entityManager.flush();
        // Arrange
        Pageable pageable = PageRequest.of(0, 10);

        // Act
        Page<Product> result = ProductRepository.findAllByType(productTest.getType(), pageable);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getTotalElements());

    }

    @Test
    void findAllByTypeNotFound() {

        // Arrange
        Pageable pageable = PageRequest.of(0, 10);

        // Act
        Page<Product> result = ProductRepository.findAllByType(productTest.getType(), pageable);

        // Assert
        assertNotNull(result);
        assertEquals(0, result.getTotalElements());

    }

    @Test
    void findBySpecificationContainingIgnoreCase(){

        entityManager.merge(productTest);
        entityManager.flush();

        Optional<Product> result = ProductRepository.findBySpecificationContainingIgnoreCase("test_account");

        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(productTest.getId(), result.get().getId())
        );

    }

    @Test
    void findBySpecificationContainingIgnoreCaseNotFound(){
        Optional<Product> result = ProductRepository.findBySpecificationContainingIgnoreCase("test");

        assertNotNull(result);
    }
}