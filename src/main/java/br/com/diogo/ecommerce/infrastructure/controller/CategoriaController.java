package br.com.diogo.ecommerce.infrastructure.controller;

import br.com.diogo.ecommerce.application.dto.CategoriaDTO;
import br.com.diogo.ecommerce.application.service.CategoriaService;
import br.com.diogo.ecommerce.infrastructure.controller.dto.CategoriaUpdateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api/v1/categoria"))
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService service;

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO>findById(@PathVariable String id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<CategoriaDTO>> obterPaginado(@PageableDefault Pageable pageable){
        return ResponseEntity.ok(service.findAllPaginated(pageable));
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> insert(@RequestBody CategoriaDTO categoriaDTO){
        return ResponseEntity.ok(service.upsert(categoriaDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO>  update(@RequestBody CategoriaUpdateDTO categoriaUpdateDTO, @PathVariable String id){
        return ResponseEntity.ok(service.upsert(new CategoriaDTO(id, categoriaUpdateDTO.nome())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.accepted().body("Categoria Excluída com Sucesso");
    }

}
