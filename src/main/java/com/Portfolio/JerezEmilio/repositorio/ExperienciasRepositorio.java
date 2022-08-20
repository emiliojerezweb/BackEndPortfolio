
package com.Portfolio.JerezEmilio.repositorio;

import com.Portfolio.JerezEmilio.modelo.Experiencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciasRepositorio extends JpaRepository<Experiencias, Long>{
    
}
