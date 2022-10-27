
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
public class Persona {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nombre;
    private String apellido;
    private String direccion;
    private String email;
    private String descripcion;
    private String imagen;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String direccion, String email, String descripcion, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.email = email;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    
}


