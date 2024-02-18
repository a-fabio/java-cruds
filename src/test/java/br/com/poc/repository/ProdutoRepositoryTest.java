package br.com.poc.repository;

import br.com.poc.entity.Categoria;
import br.com.poc.entity.Produto;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@ActiveProfiles("test")
@DataJpaTest
class ProdutoRepositoryTest {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Deveria encontrar com sucesso um produto no banco")
    void findAllByValorLessThanCase1() {
        this.criarProduto(new Produto(0L, "Notebook", "8GB RAM, i3 3590", new BigDecimal(999), new Categoria()));
        List<Produto> result = this.produtoRepository.findAllByValorLessThan(new BigDecimal(1000));

        assertThat(!result.isEmpty());
    }

    @Test
    @DisplayName("Não deveria encontrar um produto no banco")
    void findAllByValorLessThanCase2() {
        this.criarProduto(new Produto(0L, "Notebook", "8GB RAM, i3 3590", new BigDecimal(999), new Categoria()));
        List<Produto> result = this.produtoRepository.findAllByValorLessThan(new BigDecimal(10000));

        assertThat(result.isEmpty());
    }

    private Produto criarProduto(Produto produto) {
        entityManager.persist(produto);
        return produto;
    }
}