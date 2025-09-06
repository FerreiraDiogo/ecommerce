package br.com.diogo.ecommerce.application.service;

import br.com.diogo.ecommerce.application.dto.CategoriaDTO;
import br.com.diogo.ecommerce.application.exception.CategoriaNaoEncontradaException;
import br.com.diogo.ecommerce.domain.repository.CategoriaRepositorioPort;
import br.com.diogo.ecommerce.infrastructure.mapper.CategoriaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepositorioPort repo;
    private final CategoriaMapper categoriaMapper;

    public CategoriaDTO findById(String id){

        return categoriaMapper.categoriaDomainEntityToCategoriaDto(
                repo.findById(id).orElseThrow(() -> new CategoriaNaoEncontradaException("Não foi localizada uma categoria com o produto informado"))
        );
    }

    public Page<CategoriaDTO> findAllPaginated(Pageable pageable){
        return repo.findAllPaginated(pageable).map(categoriaMapper::categoriaDomainEntityToCategoriaDto);
    }

    public CategoriaDTO upsert(CategoriaDTO categoriaDTO){
        return categoriaMapper.categoriaDomainEntityToCategoriaDto(repo.upsert(categoriaDTO));
    }

    public void delete(String id){
        repo.deleteById(id);
    }
}
