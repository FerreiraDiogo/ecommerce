package br.com.diogo.ecommerce.application.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record ProdutoDTO(

        String id,

        @NotNull(message = "O nome do produto é obrigatório")
        @NotBlank(message = "O nome do produto é obrigatório")
        @Size(min = 3, max = 100, message = "O nome do produto deve conter no mínimo três caracteres e no máximo 100 caracteres")
        String nome,

        @NotNull(message = "O preço é obrigatório")
        @DecimalMin(value = "0.1", message = "O preço deve possuir valor positivo")
        BigDecimal preco,

        List<String> tags,

        List<CategoriaDTO> categorias
) {
}
