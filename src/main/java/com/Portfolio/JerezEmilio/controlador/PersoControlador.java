
package com.Portfolio.JerezEmilio.controlador;

import com.Portfolio.JerezEmilio.modelo.Persona;
import com.Portfolio.JerezEmilio.servicio.PersonaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersoControlador {
    
    @Autowired
    private PersonaServicio persoServ;
    
    @PostMapping("/sumarpersona")
    public Persona agregarPersona(@RequestBody Persona persona){
        return persoServ.guardarPersona(persona);
    }
    
    @GetMapping("/verpersona/{id}")
    public Persona verPersona(@PathVariable Long id){
        return persoServ.buscarPersona(id);
    }
    
    @DeleteMapping("/borrarpersona/{id}")
    public void borrarPersona(@PathVariable Long id){
        persoServ.borrarPersona(id);
    }
    
    @PutMapping("/editarpersona")
    public Persona editarPersona(Persona perso){
        return persoServ.actualizarPersona(perso);
    }
}
