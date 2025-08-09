package br.com.diogo.ecommerce.application.service;

import br.com.diogo.ecommerce.application.dto.CategoriaDTO;
import br.com.diogo.ecommerce.application.dto.ProdutoDTO;
import br.com.diogo.ecommerce.application.interfaces.repository.ProdutoRepositorioPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepositorioPort produtoRepositorio;

    public Page<ProdutoDTO> findAllPaginated(Pageable pageable){
        var produtos = produtoRepositorio.findAllPaginated(pageable);
        return produtos.map(produto -> new ProdutoDTO(produto.getId(),produto.getNome(), produto.getPreco(),produto.getTags(),
                produto.getCategorias().stream().map(c -> new CategoriaDTO(c.getId(), c.getNome())).toList()
        ));
    }

    public ProdutoDTO insert(ProdutoDTO dto) {
        var p = produtoRepositorio.insert(dto);
        return new ProdutoDTO(p.getId(), p.getNome(), p.getPreco(), p.getTags(),
                p.getCategorias().stream().map(c -> new CategoriaDTO(c.getId(), c.getNome())).toList()
        );
    }
}
