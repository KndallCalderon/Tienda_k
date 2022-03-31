package com.Tienda_k.dao;

import com.Tienda_k.domain.Credito;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author calde
 */
public interface CreditoDao extends CrudRepository<Credito, Long> { //hace CRUD de los datos 
    
      //marcar palabra + ctrl H para reemplazar todo las palabras
}
