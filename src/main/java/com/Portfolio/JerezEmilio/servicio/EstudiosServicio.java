
package com.Portfolio.JerezEmilio.servicio;

import com.Portfolio.JerezEmilio.modelo.Estudios;
import com.Portfolio.JerezEmilio.repositorio.EstudiosRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudiosServicio {
    
    @Autowired
    private EstudiosRepositorio estuRepo;
    
    public Estudios crearEstudio(Estudios estudio){
        return estuRepo.save(estudio);
    }
    
    public List<Estudios> VerTodosEstudios(){
        return estuRepo.findAll();
    }
    
    public Estudios verEstudioId(Long id){
        return estuRepo.findById(id).orElse(null);
    }
    
    public Estudios actualizarEstudio(Estudios estudio){
        
        return estuRepo.save(estudio);
    }
    
    public void borrarEstudioId(Long id){
        estuRepo.deleteById(id);
    }
}
