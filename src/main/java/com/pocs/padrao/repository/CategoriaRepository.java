package com.pocs.padrao.repository;

import com.pocs.padrao.entity.Categoria;
import com.pocs.padrao.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
