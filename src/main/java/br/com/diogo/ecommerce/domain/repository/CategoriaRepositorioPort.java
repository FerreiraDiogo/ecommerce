package br.com.diogo.ecommerce.domain.repository;

import br.com.diogo.ecommerce.application.dto.CategoriaDTO;
import br.com.diogo.ecommerce.domain.entity.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoriaRepositorioPort {
    Optional<Categoria> findById(String id);
    Page<Categoria>findAllPaginated(Pageable pageable);
    Categoria upsert(CategoriaDTO categoria);
    void deleteById(String categoriaId);
}
