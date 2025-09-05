package br.com.diogo.ecommerce.infrastructure.controller;

import br.com.diogo.ecommerce.application.dto.ProdutoDTO;
import br.com.diogo.ecommerce.application.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;


@RestController
@RequestMapping("/api/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Page<ProdutoDTO>> obterPaginado(@PageableDefault Pageable pageable){
        return ResponseEntity.ok().body(produtoService.findAllPaginated(pageable));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProdutoDTO> obterPorId(@PathVariable String productId){
        return ResponseEntity.ok().body(produtoService.obterPorId(productId));
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastrar(@RequestBody @Valid ProdutoDTO dto){
        var produto = produtoService.insert(dto);
        return ResponseEntity.created(URI.create("/"+produto.id())).body(produto);
    }
}
