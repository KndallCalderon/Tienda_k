package com.Tienda_k.dao;

import com.Tienda_k.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author calde
 */
public interface ClienteDao extends CrudRepository<Cliente, Long> { //hace CRUD de los datos 
    
      
}
