package br.com.poc.service;

import br.com.poc.entity.Produto;
import br.com.poc.enumerator.Erros;
import br.com.poc.exception.CategoriaNotFoundException;
import br.com.poc.repository.CategoriaRepository;
import br.com.poc.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto salvar(final Produto produto) {

        if (categoriaRepository.findById(produto.getCategoria().getId()).isEmpty()) throw new CategoriaNotFoundException((Erros.CATEGORIA_NOT_FOUND.getMensagem()));

        return produtoRepository.save(produto);
    }

}
