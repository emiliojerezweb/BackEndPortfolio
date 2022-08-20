
package com.Portfolio.JerezEmilio.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Estudios {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column
    private String titulo;
    private String lugar;
    private String ini_est;
    private String fin_est;
    private String imagen;
 
    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="id_persona")
    private Persona persona;

    public Estudios() {
    }

    public Estudios(Long id, String titulo, String lugar, String ini_est, String fin_est, String imagen, Persona persona) {
        this.id = id;
        this.titulo = titulo;
        this.lugar = lugar;
        this.ini_est = ini_est;
        this.fin_est = fin_est;
        this.imagen = imagen;
        this.persona = persona;
    }

   

   
    
    
}
