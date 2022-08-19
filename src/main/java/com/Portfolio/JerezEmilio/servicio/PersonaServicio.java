
package com.Portfolio.JerezEmilio.servicio;

import com.Portfolio.JerezEmilio.modelo.Persona;
import com.Portfolio.JerezEmilio.repositorio.RepoPersona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServicio {
    
    @Autowired
    private RepoPersona repoperso;
    
    public Persona guardarPersona(Persona perso){
        return repoperso.save(perso);
       
    }
    
    public List<Persona> verPersona(){
        return repoperso.findAll();
    }        
    
    public Persona buscarPersona(Long id){
        return repoperso.findById(id).orElse(null);
    }
    
    public void borrarPersona(Long id){
        repoperso.deleteById(id);
    }
    
    public Persona actualizarPersona(Persona perso){
        Persona existePersona = repoperso.findById(perso.getId()).orElse(null);
        existePersona.setNombre(perso.getNombre());
        existePersona.setApellido(perso.getApellido());
        existePersona.setDireccion(perso.getDireccion());
        
        return repoperso.save(existePersona);
    }
}
