package com.Tienda_k.domain;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name="credito")
public class Credito implements Serializable {
    
    private static final long serialVersionUIL = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //simula que es un autoincremental
    @Column(name="id_credito")
    private Long idCredito;   
    private double limite; 

    public Credito() {
    }

    public Credito(double limite) {
        this.limite = limite;
    }
   
}
