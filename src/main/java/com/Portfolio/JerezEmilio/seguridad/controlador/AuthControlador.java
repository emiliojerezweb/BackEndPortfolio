
package com.Portfolio.JerezEmilio.seguridad.controlador;

import com.Portfolio.JerezEmilio.seguridad.dto.JwtDto;
import com.Portfolio.JerezEmilio.seguridad.dto.LoginUsuario;
import com.Portfolio.JerezEmilio.seguridad.dto.NuevoUsuario;
import com.Portfolio.JerezEmilio.seguridad.enums.RolNombre;
import com.Portfolio.JerezEmilio.seguridad.jwt.JwtProvider;
import com.Portfolio.JerezEmilio.seguridad.modelo.Rol;
import com.Portfolio.JerezEmilio.seguridad.modelo.Usuario;
import com.Portfolio.JerezEmilio.seguridad.servicio.RolServicio;
import com.Portfolio.JerezEmilio.seguridad.servicio.UsuarioServicio;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthControlador {
    
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioServicio usuarioServicio;
    @Autowired
    RolServicio rolServicio;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevoUsuario(@Valid @RequestBody NuevoUsuario nuevoUsuario,
            BindingResult bindingResult){
        
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(new Mensaje("Campos mal o email invalido"), 
                    HttpStatus.BAD_REQUEST);
        }
        if(usuarioServicio.existeUsuario(nuevoUsuario.getNombreUsuario())){
            return new ResponseEntity<>(new Mensaje ("Ese nombre existe"),
                    HttpStatus.BAD_REQUEST);
        }
        if(usuarioServicio.existeEmail(nuevoUsuario.getEmail())){
            return new  ResponseEntity<>(new Mensaje("Ese email existe"),
                    HttpStatus.BAD_REQUEST);
        }
        
        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(),
                                nuevoUsuario.getEmail(),
                            passwordEncoder.encode(nuevoUsuario.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolServicio.buscarPorRolNombre(RolNombre.ROLE_USER).get());
        
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolServicio.buscarPorRolNombre(RolNombre.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        
        usuarioServicio.guardarUsuario(usuario);
        
        return new ResponseEntity<>(new Mensaje("Usuario creado"),
                              HttpStatus.CREATED);
        
    }    
        @PostMapping("/login")
        public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario,
                                    BindingResult bindingResult){
            if(bindingResult.hasErrors())
                return new ResponseEntity(new Mensaje("Campos mal"),
                        HttpStatus.BAD_REQUEST);
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),
                            loginUsuario.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtProvider.generateToken(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), 
                    userDetails.getAuthorities());
            return new ResponseEntity(jwtDto, HttpStatus.OK);
        }
}
