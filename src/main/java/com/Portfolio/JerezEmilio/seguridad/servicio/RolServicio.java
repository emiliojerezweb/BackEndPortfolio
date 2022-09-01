
package com.Portfolio.JerezEmilio.seguridad.servicio;

import com.Portfolio.JerezEmilio.seguridad.enums.RolNombre;
import com.Portfolio.JerezEmilio.seguridad.modelo.Rol;
import com.Portfolio.JerezEmilio.seguridad.repositorio.RolRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolServicio {
    
    @Autowired
    RolRepositorio rolRepositorio;
    
    public Optional<Rol> buscarPorRolNombre(RolNombre rolNombre){
        return rolRepositorio.findByRolNombre(rolNombre);
    }
    
    public void guardar(Rol rol){
        rolRepositorio.save(rol);
    }
}
