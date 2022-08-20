
package com.Portfolio.JerezEmilio.servicio;

import com.Portfolio.JerezEmilio.modelo.Experiencias;
import com.Portfolio.JerezEmilio.repositorio.ExperienciasRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciasServicio {
    
    @Autowired
    private ExperienciasRepositorio expRepo;
    
    public Experiencias crearExperiencia(Experiencias exp){
        return expRepo.save(exp);
    }
    
    public List<Experiencias> VerTodasExperiencias(){
        return expRepo.findAll();
    }
    
    public Experiencias verExperienciaId(Long id){
        return expRepo.findById(id).orElse(null);
    }
    
    public Experiencias actualizarExperiencia(Experiencias exp){
        
        Experiencias existeExp = verExperienciaId(exp.getId());
        existeExp.setEmpresa(exp.getEmpresa());
        existeExp.setPuesto(exp.getPuesto());
        existeExp.setTarea(exp.getTarea());
        existeExp.setFec_ini(exp.getFec_ini());
        existeExp.setFec_fin(exp.getFec_fin());
        
        return expRepo.save(existeExp);
        
    }
    
    public void borrarExperienciaId(Long id){
        expRepo.deleteById(id);
    }
}
