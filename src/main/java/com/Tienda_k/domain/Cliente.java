package com.Tienda_k.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author calde
 */
@Data //permite crear automatico settter y getter
@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
    
    private static final long serialVersionUIL = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //simula que es un autoincremental
    private Long idcliente;   
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono; 

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    
}
