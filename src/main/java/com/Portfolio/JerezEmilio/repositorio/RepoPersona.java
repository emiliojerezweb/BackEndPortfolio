
package com.Portfolio.JerezEmilio.repositorio;

import com.Portfolio.JerezEmilio.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoPersona extends JpaRepository<Persona, Long>{
    
}
