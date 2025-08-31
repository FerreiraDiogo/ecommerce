package br.com.diogo.ecommerce.infrastructure.repository;

import br.com.diogo.ecommerce.infrastructure.entity.ProdutoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProdutoRepositorio  extends MongoRepository<ProdutoEntity, String> {
}
