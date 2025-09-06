package br.com.diogo.ecommerce.infrastructure.repository;

import br.com.diogo.ecommerce.infrastructure.entity.CategoriaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICategoriaRepositorio  extends MongoRepository<CategoriaEntity, String> {
}
