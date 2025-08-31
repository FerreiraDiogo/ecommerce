package br.com.diogo.ecommerce.domain.entity;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Produto {

    private String id;

    @NotNull(message = "O nome do produto é obrigatório")
    @NotBlank(message = "O nome do produto é obrigatório")
    @Min(value = 3L, message = "O nome do produto deve conter no mínimo três caracteres")
    @Max(value = 100L, message = "O nome do produto deve conter no máximo 100 caracteres")
    private String nome;

    @NotNull(message = "O preço é obrigatório")
    @Min(value = 0L, message = "O preço deve possuir valor positivo")
    private BigDecimal preco;

    private List<Categoria> categorias;

    private List<String> tags;

}
