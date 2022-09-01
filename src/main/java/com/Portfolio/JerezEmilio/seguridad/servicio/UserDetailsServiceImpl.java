
package com.Portfolio.JerezEmilio.seguridad.servicio;

import com.Portfolio.JerezEmilio.seguridad.modelo.Usuario;
import com.Portfolio.JerezEmilio.seguridad.modelo.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    UsuarioServicio usuarioServicio;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        
        Usuario usuario = usuarioServicio.buscarPorUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }
    
    
}
