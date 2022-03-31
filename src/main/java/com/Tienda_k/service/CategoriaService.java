package com.Tienda_k.service;

import com.Tienda_k.domain.Categoria;
import java.util.List;
/**
 *
 * @author calde
 */
public interface CategoriaService {
    
    public List<Categoria> getCategorias(boolean activos);
    
    public void save(Categoria categoria);
    
    public void delete(Categoria categoria);
    
    public Categoria getCategoria(Categoria categoria);
    
}
