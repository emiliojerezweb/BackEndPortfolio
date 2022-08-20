
package com.Portfolio.JerezEmilio.repositorio;

import com.Portfolio.JerezEmilio.modelo.Estudios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudiosRepositorio extends JpaRepository<Estudios, Long> {
    
}
