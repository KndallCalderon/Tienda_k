package com.Tienda_k.service;

import com.Tienda_k.domain.Articulo;
import java.util.List;
/**
 *
 * @author calde
 */
public interface ArticuloService {
    
    public List<Articulo> getArticulos(boolean activos);
    
    public void save(Articulo articulo);
    
    public void delete(Articulo articulo);
    
    public Articulo getArticulo(Articulo articulo);
    
}
