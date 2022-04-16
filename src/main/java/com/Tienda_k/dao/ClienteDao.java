package com.Tienda_k.dao;

import com.Tienda_k.domain.Cliente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author calde
 */
public interface ClienteDao extends CrudRepository<Cliente, Long> { //hace CRUD de los datos 
    public List<Cliente> findByCorreo(String correo);
    
    public Cliente findByNombreAndApellidos(String nombre, String apellidos);   
}
