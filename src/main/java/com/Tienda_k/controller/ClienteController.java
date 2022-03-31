package com.Tienda_k.controller;

import com.Tienda_k.domain.Cliente;
import com.Tienda_k.service.ClienteService;
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
public class ClienteController {
    
    @Autowired //crea instancias automatico
    private ClienteService clienteService;
    
    @GetMapping("/cliente/listado") //entra a url default
    public String inicio(Model model){
      var clientes = clienteService.getClientes();
      model.addAttribute("clientes", clientes);
          
      return "/cliente/listado";
    }
    
    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente){
        return "/cliente/modifica";
    }
    
    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/cliente/listado"; //redirect retorna a una accion no una página
    }
    
    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        var respuesta = clienteService.getCliente(cliente);
        model.addAttribute("cliente", respuesta);
        return "/cliente/modifica";
    }
    
    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }
}
