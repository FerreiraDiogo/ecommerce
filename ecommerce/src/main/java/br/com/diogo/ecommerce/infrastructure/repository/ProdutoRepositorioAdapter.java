package br.com.diogo.ecommerce.infrastructure.repository;

import br.com.diogo.ecommerce.application.dto.ProdutoDTO;
import br.com.diogo.ecommerce.application.interfaces.repository.ProdutoRepositorioPort;
import br.com.diogo.ecommerce.domain.entity.Categoria;
import br.com.diogo.ecommerce.domain.entity.Produto;
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
    public Page<Produto> findAllPaginated(Pageable pageable) {
        return produtoRepositorio.findAll(pageable);
    }

    @Override
    public Optional<Produto> findById(String id) {
        return produtoRepositorio.findById(id);
    }

    @Override
    public Produto insert(ProdutoDTO produtoDTO) {
        var produto = Produto.builder()
                .preco(produtoDTO.preco())
                .nome(produtoDTO.nome())
                .tags(produtoDTO.tags())
                .categorias(produtoDTO.categorias().stream().map(c -> Categoria.builder().id(c.id()).nome(c.nome()).build()).toList())
                .build();
        return produtoRepositorio.insert(produto);
    }
}
