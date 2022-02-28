package com.Tienda_k.service;

import com.Tienda_k.domain.Cliente;
import java.util.List;
/**
 *
 * @author calde
 */
public interface ClienteService {
    
    public List<Cliente> getCliente();
    
    public void save(Cliente cliente);
    
    public void delete(Cliente cliente);
    
    public Cliente getCliente(Cliente cliente);
    
}
