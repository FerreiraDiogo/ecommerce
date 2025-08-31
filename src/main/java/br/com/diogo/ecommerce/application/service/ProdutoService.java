package br.com.diogo.ecommerce.application.service;

import br.com.diogo.ecommerce.application.dto.ProdutoDTO;
import br.com.diogo.ecommerce.domain.repository.ProdutoRepositorioPort;
import br.com.diogo.ecommerce.infrastructure.mapper.ProdutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepositorioPort produtoRepositorio;
    private final ProdutoMapper produtoMapper;

    public Page<ProdutoDTO> findAllPaginated(Pageable pageable){
        return produtoRepositorio.findAllPaginated(pageable)
            .map(produtoMapper::produtoDomainEntityToProdutoDto);
    }

    public ProdutoDTO insert(ProdutoDTO dto) {
        return produtoMapper.produtoDomainEntityToProdutoDto(produtoRepositorio.insert(dto));
    }
}
