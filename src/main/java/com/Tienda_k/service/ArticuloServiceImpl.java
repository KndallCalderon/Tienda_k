package com.Tienda_k.service;

import com.Tienda_k.dao.ArticuloDao;
import com.Tienda_k.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author calde
 */
@Service
public class ArticuloServiceImpl implements ArticuloService {
    
    @Autowired //crea instancias automatico
    private ArticuloDao articuloDao;

    @Override
    @Transactional (readOnly = true) //lectura
    public List<Articulo> getArticulos(boolean activos) {
        var lista = (List<Articulo>) articuloDao.findAll();
        
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        
        return lista;
    }

    @Override
    @Transactional //Manejo transacciones de escritura y lectura
    public void save(Articulo articulo) {
        articuloDao.save(articulo);       
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.delete(articulo);
    }

    @Override
    @Transactional (readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }  
    
}
