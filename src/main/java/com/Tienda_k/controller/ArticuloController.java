package com.Tienda_k.controller;

import com.Tienda_k.domain.Articulo;
import com.Tienda_k.service.ArticuloService;
import com.Tienda_k.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author calde
 */

@Controller //indica que es controlador
@Slf4j //para poder usar un log de login
public class ArticuloController {
    
    @Autowired //crea instancias automatico
    private ArticuloService articuloService;
    
    @Autowired //crea instancias automatico
    private CategoriaService categoriaService;
    
    @GetMapping("/articulo/listado") //entra a url default
    public String inicio(Model model){
      var articulos = articuloService.getArticulos(false);
      model.addAttribute("articulos", articulos);
          
      return "/articulo/listado";
    }
    
    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo, Model model){
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        
        return "/articulo/modifica";
    }
    
    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Articulo articulo){
        articuloService.save(articulo);
        return "redirect:/articulo/listado"; //redirect retorna a una accion no una página
    }
    
    @GetMapping("/articulo/modificar/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model){  
        var respuesta = articuloService.getArticulo(articulo);
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("articulo", respuesta);       
        model.addAttribute("categorias", categorias);
        
        return "/articulo/modifica";
    }
    
    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo){
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";
    }
}
