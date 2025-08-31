package br.com.diogo.ecommerce.infrastructure.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "produto")
@Data
@Builder
public class ProdutoEntity {

    @Id
    private String id;


    private String nome;


    private BigDecimal preco;

    @DocumentReference
    private List<CategoriaEntity> categorias;

    private List<String> tags;

}
