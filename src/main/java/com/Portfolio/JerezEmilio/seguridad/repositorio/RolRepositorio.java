
package com.Portfolio.JerezEmilio.seguridad.repositorio;

import com.Portfolio.JerezEmilio.seguridad.enums.RolNombre;
import com.Portfolio.JerezEmilio.seguridad.modelo.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositorio extends JpaRepository <Rol, Integer> {
    
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
    
}
