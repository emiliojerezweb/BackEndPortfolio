
package com.Portfolio.JerezEmilio.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Experiencias {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column
    private String empresa;
    private String puesto;
    private String tarea;
    private String fec_ini;
    private String fec_fin;
    private String imagen;
    
    public Experiencias() {
    }

    public Experiencias(Long id, String empresa, String puesto, String tarea, String fec_ini, String fec_fin, String imagen) {
        this.id = id;
        this.empresa = empresa;
        this.puesto = puesto;
        this.tarea = tarea;
        this.fec_ini = fec_ini;
        this.fec_fin = fec_fin;
        this.imagen = imagen;
    }



    
  

    

    
    
    
}
