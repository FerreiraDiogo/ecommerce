package br.com.diogo.ecommerce.infrastructure.mapper;

import br.com.diogo.ecommerce.application.dto.CategoriaDTO;
import br.com.diogo.ecommerce.domain.entity.Categoria;
import br.com.diogo.ecommerce.infrastructure.entity.CategoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    Categoria categoriaEntityToCategoraDomainEntity(CategoriaEntity categoria);
    CategoriaDTO categoriaDomainEntityToCategoriaDto(Categoria categoria);
    CategoriaEntity categoriaDtoToCategoriaEntity(CategoriaDTO categoria);
}
