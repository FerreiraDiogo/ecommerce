package br.com.diogo.ecommerce.application.interfaces.repository;

import br.com.diogo.ecommerce.application.dto.ProdutoDTO;
import br.com.diogo.ecommerce.domain.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProdutoRepositorio {
    Page<Produto> findAllPaginated(Pageable pageable);
    Optional<Produto> findById(String id);
    Produto insert(ProdutoDTO produtoDTO);
}
