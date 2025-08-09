package br.com.diogo.ecommerce.infrastructure.controller;

import br.com.diogo.ecommerce.application.dto.ProdutoDTO;
import br.com.diogo.ecommerce.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;


@RestController
@RequestMapping("/v1/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> getPaginated(@PageableDefault Pageable pageable){
        return ResponseEntity.ok().body(produtoService.findAllPaginated(pageable));
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> post(@RequestBody ProdutoDTO dto){

        return ResponseEntity.created(URI.create("")).body(produtoService.insert(dto));
    }
}
