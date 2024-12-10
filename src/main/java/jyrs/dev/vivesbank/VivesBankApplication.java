package jyrs.dev.vivesbank;

import com.fasterxml.jackson.databind.ObjectMapper;
import jyrs.dev.vivesbank.products.base.models.Product;
import jyrs.dev.vivesbank.products.base.repositories.ProductRepository;
import jyrs.dev.vivesbank.products.base.services.ProductServices;
import jyrs.dev.vivesbank.products.base.services.ProductServicesImpl;
import jyrs.dev.vivesbank.products.storage.ProductStorage;
import jyrs.dev.vivesbank.products.storage.ProductStorageImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.io.File;

@SpringBootApplication
@EnableCaching
@EnableJpaAuditing
@Slf4j
public class VivesBankApplication implements CommandLineRunner {

    //@Value("${spring.profiles.active}")
    //private String perfil;

    //@Value("${server.port}")
    //private String port;
    ProductStorage storage = new ProductStorageImpl(new ObjectMapper());

    public static void main(String[] args) {
        SpringApplication.run(VivesBankApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("🟢 Servidor escuchando en puerto: " + 1 + " y perfil: " + 1);
        ClassPathResource resource = new ClassPathResource("products.csv");
        File file = resource.getFile();
        storage.loadCsv(file);
    }
}
