package com.Tienda_k.service;

import com.Tienda_k.dao.CategoriaDao;
import com.Tienda_k.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author calde
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired //crea instancias automatico
    private CategoriaDao categoriaDao;

    @Override
    @Transactional (readOnly = true) //lectura
    public List<Categoria> getCategorias(boolean activos) {
        var lista = (List<Categoria>) categoriaDao.findAll();
        
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        
        return lista;
    }

    @Override
    @Transactional //Manejo transacciones de escritura y lectura
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);       
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

    @Override
    @Transactional (readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }  
    
}
