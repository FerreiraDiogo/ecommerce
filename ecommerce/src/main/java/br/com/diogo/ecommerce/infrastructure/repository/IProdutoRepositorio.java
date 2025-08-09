package br.com.diogo.ecommerce.infrastructure.repository;

import br.com.diogo.ecommerce.domain.entity.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProdutoRepositorio  extends MongoRepository<Produto, String> {
}
