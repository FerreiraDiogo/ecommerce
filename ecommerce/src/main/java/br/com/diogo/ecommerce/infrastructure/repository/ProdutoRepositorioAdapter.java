package br.com.diogo.ecommerce.infrastructure.repository;

import br.com.diogo.ecommerce.application.dto.ProdutoDTO;
import br.com.diogo.ecommerce.application.interfaces.repository.ProdutoRepositorioPort;
import br.com.diogo.ecommerce.domain.entity.Categoria;
import br.com.diogo.ecommerce.infrastructure.entity.ProdutoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProdutoRepositorioAdapter implements ProdutoRepositorioPort {

    private final IProdutoRepositorio produtoRepositorio;

    @Override
    public Page<ProdutoEntity> findAllPaginated(Pageable pageable) {
        return produtoRepositorio.findAll(pageable);
    }

    @Override
    public Optional<ProdutoEntity> findById(String id) {
        return produtoRepositorio.findById(id);
    }

    @Override
    public ProdutoEntity insert(ProdutoDTO produtoDTO) {
        var produto = ProdutoEntity.builder()
                .preco(produtoDTO.preco())
                .nome(produtoDTO.nome())
                .tags(produtoDTO.tags())
                .categorias(produtoDTO.categorias().stream().map(c -> Categoria.builder().id(c.id()).nome(c.nome()).build()).toList())
                .build();
        return produtoRepositorio.insert(produto);
    }
}
