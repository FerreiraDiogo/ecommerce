package br.com.diogo.ecommerce.application.interfaces.repository;

import br.com.diogo.ecommerce.application.dto.ProdutoDTO;
import br.com.diogo.ecommerce.infrastructure.entity.ProdutoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProdutoRepositorioPort {
    Page<ProdutoEntity> findAllPaginated(Pageable pageable);
    Optional<ProdutoEntity> findById(String id);
    ProdutoEntity insert(ProdutoDTO produtoDTO);
}
