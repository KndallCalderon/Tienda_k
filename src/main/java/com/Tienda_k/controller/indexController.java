package com.Tienda_k.controller;

import com.Tienda_k.dao.ClienteDao;
import com.Tienda_k.domain.Cliente;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author calde
 */

@Controller //indica que es controlador
@Slf4j //para poder usar un log de login
public class indexController {
    
    @Autowired //crea instancias automatico
    private ClienteDao clienteDao;
    
    @GetMapping("/") //entra a url default
    public String inicio(Model model){
      log.info("Estamos usando una arquitectura MVC: Modelo Vista Controlador");
      Cliente cliente = new Cliente("Kendall","Calderón","kcalderon@gmail.com","87904888");
      
      Cliente cliente2 = new Cliente("Yuliana","Solano","ysolano@gmail.com","--------");
      var clientes=Arrays.asList(cliente,cliente2);      
      model.addAttribute("clientes",clientes);
      
      var clientesDB = clienteDao.findAll(); //trae todos los registros
      model.addAttribute("clientesDB",clientesDB);
      
      return "index"; //va a buscar siempre a la carpeta de templates
    }
    
    
}
