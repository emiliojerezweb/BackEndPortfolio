
package com.Portfolio.JerezEmilio.controlador;

import com.Portfolio.JerezEmilio.modelo.Habilidad;
import com.Portfolio.JerezEmilio.servicio.HabilidadServicio;
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
public class HabilidadesControlador {
    
       
    @Autowired
    private HabilidadServicio habilServ;
    
    @PostMapping("/habilidad/crear")
    public Habilidad agregarHabilidad(@RequestBody Habilidad habil){
        return habilServ.guardarHabilidad(habil);
    }
    
    @GetMapping("/habilidad/ver/todas")
    public List<Habilidad> VerHabilidades(){
        return habilServ.verTodaHabilidades();
    }
    
    @GetMapping("/habilidad/ver/{id}")
    public Habilidad verHabilidadId(@PathVariable Long id){
        return habilServ.buscarHabilidad(id);
    }
    
    @PutMapping("/habilidad/editar")
    public Habilidad editarEstudio(@RequestBody Habilidad habil){
        habil.setId(habil.getId());
        return habilServ.actualizarHabilidad(habil);
    }
    
    @DeleteMapping("/habilidad/borrar/{id}")
    public void borrarHabilidad(@PathVariable Long id){
        habilServ.borrarHabilidad(id);
    }
}
