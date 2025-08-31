package br.com.diogo.ecommerce.infrastructure.repository;

import br.com.diogo.ecommerce.application.dto.ProdutoDTO;
import br.com.diogo.ecommerce.domain.repository.ProdutoRepositorioPort;
import br.com.diogo.ecommerce.infrastructure.mapper.CategoriaMapper;
import br.com.diogo.ecommerce.infrastructure.mapper.ProdutoMapper;
import br.com.diogo.ecommerce.domain.entity.Produto;
import br.com.diogo.ecommerce.infrastructure.entity.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProdutoRepositorioAdapter implements ProdutoRepositorioPort {

    private  final IProdutoRepositorio produtoRepositorio;
    private  final ProdutoMapper produtoMapper;
    private  final CategoriaMapper categoriaMapper;

    @Override
    public Page<Produto> findAllPaginated(Pageable pageable) {
        return produtoRepositorio.findAll(pageable)
                .map(produtoMapper::produtoRepositorioEntityToProdutoDomainEntity);
    }

    @Override
    public Optional<Produto> findById(String id) {

        return produtoRepositorio.findById(id).map(produtoMapper::produtoRepositorioEntityToProdutoDomainEntity);
    }

    @Override
    public Produto insert(ProdutoDTO produtoDTO) {
        var produto = ProdutoEntity.builder()
                .preco(produtoDTO.preco())
                .nome(produtoDTO.nome())
                .tags(produtoDTO.tags())
                .categorias(produtoDTO.categorias().stream().map(categoriaMapper::categoriaDtoToCategoriaEntity).toList())
                .build();
        return produtoMapper.
                produtoRepositorioEntityToProdutoDomainEntity(produtoRepositorio.insert(produto));
    }
}
