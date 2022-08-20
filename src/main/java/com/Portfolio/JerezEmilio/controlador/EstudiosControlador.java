
package com.Portfolio.JerezEmilio.controlador;

import com.Portfolio.JerezEmilio.modelo.Estudios;
import com.Portfolio.JerezEmilio.servicio.EstudiosServicio;
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
public class EstudiosControlador {
    
    @Autowired
    private EstudiosServicio estuServ;
    
    @PostMapping("/estudio/crear")
    public Estudios agregarEstudio(@RequestBody Estudios estudio){
        return estuServ.crearEstudio(estudio);
    }
    
    @GetMapping("/estudio/ver/todos")
    public List<Estudios> todosEstudios(){
        return estuServ.VerTodosEstudios();
    }
    
    @GetMapping("/estudio/ver/{id}")
    public Estudios verEstudioId(@PathVariable Long id){
        return estuServ.verEstudioId(id);
    }
    
    @PutMapping("/estudio/editar")
    public Estudios editarEstudio(@RequestBody Estudios estudio){
        return estuServ.actualizarEstudio(estudio);
    }
    
    @DeleteMapping("/estudio/borrar/{id}")
    public void borrarEstudio(@PathVariable Long id){
        estuServ.borrarEstudioId(id);
    }
}
