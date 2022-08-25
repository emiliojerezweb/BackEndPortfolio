
package com.Portfolio.JerezEmilio.controlador;

import com.Portfolio.JerezEmilio.modelo.Persona;
import com.Portfolio.JerezEmilio.servicio.PersonaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class PersonaControlador {
    
    @Autowired
    private PersonaServicio persoServ;
    
    @PostMapping("/persona/sumar")
    public Persona agregarPersona(@RequestBody Persona persona){
        return persoServ.guardarPersona(persona);
    }
    
    @GetMapping("/persona/ver/{id}")
    public Persona verPersona(@PathVariable Long id){
        return persoServ.buscarPersona(id);
    }
    
    @GetMapping("/persona/todas")
    public List<Persona> verTodasPersonas(){
        return persoServ.verPersona();
    }
    
    
    
    @DeleteMapping("/persona/borrar/{id}")
    public void borrarPersona(@PathVariable Long id){
        persoServ.borrarPersona(id);
    }
    
    @PutMapping("/persona/editar")
    public Persona editarPersona(@RequestBody Persona perso){
        perso.setId(perso.getId());
        return persoServ.actualizarPersona(perso);
    }
}
