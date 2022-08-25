
package com.Portfolio.JerezEmilio.servicio;

import com.Portfolio.JerezEmilio.modelo.Habilidad;
import com.Portfolio.JerezEmilio.repositorio.HabilidadRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadServicio {
    
    @Autowired
    private HabilidadRepositorio habilRepo;
    
    public Habilidad guardarHabilidad(Habilidad habil){
        return habilRepo.save(habil);
       
    }
    
    public List<Habilidad> verTodaHabilidades(){
        return habilRepo.findAll();
    }        
    
    public Habilidad buscarHabilidad(Long id){
        return habilRepo.findById(id).orElse(null);
    }
    
    public void borrarHabilidad(Long id){
        habilRepo.deleteById(id);
    }
    
    public Habilidad actualizarHabilidad(Habilidad habil){
        
        return habilRepo.save(habil);
    }
}
