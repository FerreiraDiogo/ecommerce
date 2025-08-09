package br.com.diogo.ecommerce.application.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record ProdutoDTO(

        String id,

        @NotNull(message = "O nome do produto é obrigatório")
        @NotBlank(message = "O nome do produto é obrigatório")
        @Min(value = 3L, message = "O nome do produto deve conter no mínimo três caracteres")
        @Max(value = 100L, message = "O nome do produto deve conter no máximo 100 caracteres")
        String nome,

        @NotNull(message = "O preço é obrigatório")
        @Min(value = 0L, message = "O preço deve possuir valor positivo")
        BigDecimal preco,

        List<String> tags,

        List<CategoriaDTO> categorias
) {
}
