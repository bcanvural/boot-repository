package dev.bcv.bootrepository;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class BootRepositoryApplication {

    @Bean
    public Session getSession(BootRepository repository) throws RepositoryException {
        return repository.login("admin", "admin".toCharArray());
    }

    @Bean
    public BootRepository getHippoRepository() throws RepositoryException {
        return RepoFactory.getHippoEnterpriseRepository();
    }

    public static void main(String[] args) {
        SpringApplication.run(BootRepositoryApplication.class, args);
    }
}
