package br.com.poc;

import br.com.poc.controller.ProdutoController;
import br.com.poc.entity.Categoria;
import br.com.poc.entity.Produto;
import br.com.poc.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class PadraoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PadraoApplication.class, args);
	}

	@Autowired
	private ProdutoController controller;

	@Override
	public void run(String... args) throws Exception {

		Categoria categoria = new Categoria();
		categoria.setDescricao("Categoria não cadastrada em banco");
		categoria.setId(1000L);

		Produto produto = new Produto();
		produto.setCategoria(categoria);
		produto.setValor(new BigDecimal("49.90"));
		produto.setTitulo("Carregador de celular");
		produto.setDescricao("Carregador tipo USB-C com carregamento rápido");

		controller.cadastrar(produto);
	}
}
