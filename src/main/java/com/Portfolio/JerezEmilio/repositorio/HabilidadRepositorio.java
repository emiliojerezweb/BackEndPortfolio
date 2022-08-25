
package com.Portfolio.JerezEmilio.repositorio;

import com.Portfolio.JerezEmilio.modelo.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepositorio  extends JpaRepository <Habilidad, Long>{
    
}
