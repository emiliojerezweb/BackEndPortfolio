
package com.Portfolio.JerezEmilio.controlador;

import com.Portfolio.JerezEmilio.modelo.Experiencias;
import com.Portfolio.JerezEmilio.servicio.ExperienciasServicio;
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
public class ExperienciasControlador {
    
    @Autowired
    private ExperienciasServicio expServ;
    
    @PostMapping("/exp/crear")
    public Experiencias crearExperiencia(@RequestBody Experiencias experiencia){
        return expServ.crearExperiencia(experiencia);
    }
    
    @GetMapping("/exp/ver/todas")
    public List<Experiencias> TodasExperiencias(){
        return expServ.VerTodasExperiencias();
    }
    
    @GetMapping("/exp/ver/{id}")
    public Experiencias verExperienciaId(@PathVariable Long id){
        return expServ.verExperienciaId(id);
    }
    
    @PutMapping("exp/editar")
    public Experiencias editarExperiencia(@RequestBody Experiencias experiencia){
        return expServ.actualizarExperiencia(experiencia);
    }
    
    @DeleteMapping("exp/borrar/{id}")
    public void borrarExperiencia(@PathVariable Long id){
        expServ.borrarExperienciaId(id);
    }
}
