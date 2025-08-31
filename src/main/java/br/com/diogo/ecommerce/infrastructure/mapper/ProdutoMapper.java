package br.com.diogo.ecommerce.infrastructure.mapper;

import br.com.diogo.ecommerce.application.dto.ProdutoDTO;
import br.com.diogo.ecommerce.domain.entity.Produto;
import br.com.diogo.ecommerce.infrastructure.entity.ProdutoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    @Mappings(value = {
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "nome", source = "nome"),
            @Mapping(target = "preco", source = "preco"),
            @Mapping(target = "categorias", source = "categorias"),
            @Mapping(target = "tags", source = "tags")
    })
    Produto produtoRepositorioEntityToProdutoDomainEntity(ProdutoEntity entity);

    @Mappings(value = {
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "nome", source = "nome"),
            @Mapping(target = "preco", source = "preco"),
            @Mapping(target = "categorias", source = "categorias"),
            @Mapping(target = "tags", source = "tags")
    })
    ProdutoDTO produtoDomainEntityToProdutoDto(Produto produto);
}
