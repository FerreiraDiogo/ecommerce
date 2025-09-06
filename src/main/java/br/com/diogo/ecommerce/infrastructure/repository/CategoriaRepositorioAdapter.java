package br.com.diogo.ecommerce.infrastructure.repository;

import br.com.diogo.ecommerce.application.dto.CategoriaDTO;
import br.com.diogo.ecommerce.domain.entity.Categoria;
import br.com.diogo.ecommerce.domain.repository.CategoriaRepositorioPort;
import br.com.diogo.ecommerce.infrastructure.mapper.CategoriaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoriaRepositorioAdapter implements CategoriaRepositorioPort {

    private final ICategoriaRepositorio repo;
    private final CategoriaMapper mapper;

    @Override
    public Optional<Categoria> findById(String id) {
        return repo.findById(id).map(mapper::categoriaEntityToCategoraDomainEntity);
    }

    @Override
    public Page<Categoria> findAllPaginated(Pageable pageable) {
        return repo.findAll(pageable).map(mapper::categoriaEntityToCategoraDomainEntity);
    }

    @Override
    public Categoria upsert(CategoriaDTO categoria) {
        var categoriaAtualizada = repo.save(mapper.categoriaDtoToCategoriaEntity(categoria));
        return mapper.categoriaEntityToCategoraDomainEntity(categoriaAtualizada);
    }

    @Override
    public void deleteById(String categoriaId) {
        repo.deleteById(categoriaId);
    }
}
