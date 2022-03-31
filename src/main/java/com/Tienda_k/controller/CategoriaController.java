package com.Tienda_k.controller;

import com.Tienda_k.domain.Categoria;
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
public class CategoriaController {
    
    @Autowired //crea instancias automatico
    private CategoriaService categoriaService;
    
    @GetMapping("/categoria/listado") //entra a url default
    public String inicio(Model model){
      var categorias = categoriaService.getCategorias(false);
      model.addAttribute("categorias", categorias);
          
      return "/categoria/listado";
    }
    
    @GetMapping("/categoria/nuevo")
    public String nuevoCategoria(Categoria categoria){
        return "/categoria/modifica";
    }
    
    @PostMapping("/categoria/guardar")
    public String guardarCategoria(Categoria categoria){
        categoriaService.save(categoria);
        return "redirect:/categoria/listado"; //redirect retorna a una accion no una página
    }
    
    @GetMapping("/categoria/modificar/{idCategoria}")
    public String modificarCategoria(Categoria categoria, Model model){
        var respuesta = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", respuesta);
        return "/categoria/modifica";
    }
    
    @GetMapping("/categoria/eliminar/{idCategoria}")
    public String eliminarCategoria(Categoria categoria){
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }
}
