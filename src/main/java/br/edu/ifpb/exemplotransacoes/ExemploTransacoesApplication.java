package br.edu.ifpb.exemplotransacoes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class ExemploTransacoesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExemploTransacoesApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(EstoqueService estoqueService){
        List<Produto> produtos = List.of(
                new Produto("Teclado mecânico", "Teclado 65%", BigDecimal.valueOf(550)),
                new Produto("Mouse", "Mouse", BigDecimal.valueOf(350)),
                new Produto("Monitor", "Monitor 29'", BigDecimal.valueOf(1550)),
                new Produto("Notebook", "16GB de RAM, Core i9", BigDecimal.valueOf(5550))
        );

        return args -> {
            try {
                estoqueService.addProdutos(produtos);
            } catch (ProdutoInvalidoException e) {}
        };
    }

}
