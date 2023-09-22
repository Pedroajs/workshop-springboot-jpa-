package com.example.demo.config;

import com.example.demo.entities.*;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;
    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Eletrônico");
        Category category2 = new Category(null, "Livros");
        Category category3 = new Category(null, "Videojogos");
        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));

        Product product1 = new Product(null, "Zeldinha", "jogo zelda", 190.0, "url/...");
        Product product2 = new Product(null, "Bom da Guerra", "jogo do Kratos", 199.90, "url/...");
        product1.getCategories().add(category3);
        product2.getCategories().add(category3);
        product2.getCategories().add(category1);
        productRepository.saveAll(Arrays.asList(product1, product2));


        User user1 = new User(null, "pedro", "pedroajs@gmail", "21998536", "93810++001");
        User user2 = new User(null, "maria", "mariadb@gmail", "218966387", "810++001");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVERED, user1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.PENDING, user2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.PAID, user1);
        Order o4 = new Order(null, Instant.now(),OrderStatus.SHIPPED, user2);

        userRepository.saveAll(Arrays.asList(user1,user2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));

    }
}
