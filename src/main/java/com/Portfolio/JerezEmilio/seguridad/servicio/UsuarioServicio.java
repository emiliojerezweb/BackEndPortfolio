
package com.Portfolio.JerezEmilio.seguridad.servicio;

import com.Portfolio.JerezEmilio.seguridad.modelo.Usuario;
import com.Portfolio.JerezEmilio.seguridad.repositorio.UsuarioRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioServicio {
    
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    
    public Optional<Usuario> buscarPorUsuario(String nombreUsuario){
        return usuarioRepositorio.findByNombreUsuario(nombreUsuario);
    }
    
    public Boolean existeUsuario(String nombreUsuario){
        return usuarioRepositorio.existsByNombreUsuario(nombreUsuario);
    }
    
    public Boolean existeEmail(String email){
        return usuarioRepositorio.existsByEmail(email);
    }
    
    public void guardarUsuario(Usuario usuario){
        usuarioRepositorio.save(usuario);    }
    
    
}
