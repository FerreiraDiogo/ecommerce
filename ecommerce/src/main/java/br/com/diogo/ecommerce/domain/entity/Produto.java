package br.com.diogo.ecommerce.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.math.BigDecimal;
import java.util.List;

@Document(collection = "produto")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Produto {

    @Id
    private String id;


    private String nome;


    private BigDecimal preco;

    @DocumentReference
    private List<Categoria> categorias;

    private List<String> tags;

}
