package com.Tienda_k.service;

import com.Tienda_k.dao.ClienteDao;
import com.Tienda_k.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author calde
 */
@Service
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired //crea instancias automatico
    private ClienteDao clienteDao;

    @Override
    @Transactional (readOnly = true) //lectura
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional //Manejo transacciones de escritura y lectura
    public void save(Cliente cliente) {
        clienteDao.save(cliente);       
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional (readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdcliente()).orElse(null);
    }  
    
}
