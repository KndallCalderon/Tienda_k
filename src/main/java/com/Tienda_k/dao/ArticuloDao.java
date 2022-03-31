package com.Tienda_k.dao;

import com.Tienda_k.domain.Articulo;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author calde
 */
public interface ArticuloDao extends CrudRepository<Articulo, Long> { //hace CRUD de los datos 
    
      //marcar palabra + ctrl H para reemplazar todo las palabras
}
