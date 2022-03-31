package com.Tienda_k.dao;

import com.Tienda_k.domain.Categoria;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author calde
 */
public interface CategoriaDao extends CrudRepository<Categoria, Long> { //hace CRUD de los datos 
    
      //marcar palabra + ctrl H para reemplazar todo las palabras
}
