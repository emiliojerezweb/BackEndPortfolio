
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
        
        Estudios existeEstudio = verEstudioId(estudio.getId());
        existeEstudio.setTitulo(estudio.getTitulo());
        existeEstudio.setLugar(estudio.getLugar());
        existeEstudio.setIni_est(estudio.getIni_est());
        existeEstudio.setFin_est(estudio.getFin_est());
        existeEstudio.setImagen(estudio.getImagen());
        
        return estuRepo.save(existeEstudio);
        
    }
    
    public void borrarEstudioId(Long id){
        estuRepo.deleteById(id);
    }
}
