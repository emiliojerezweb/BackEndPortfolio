
package com.Portfolio.JerezEmilio.seguridad.jwt;

import com.Portfolio.JerezEmilio.seguridad.servicio.UserDetailsServiceImpl;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

/*
    Comprueba validez del token
    Usa provider para validar
*/
public class JwtTokenFilter extends OncePerRequestFilter {
    
    private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);
    
    @Autowired
    JwtProvider jwtProvider;
    
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    /*
    Token: cabecera -> Authorizacion: Bearer token.
    Comprobaciones que se hace en cada peticion al servidor
    */
    @Override
    protected void doFilterInternal(HttpServletRequest request, 
            HttpServletResponse response, 
            FilterChain filterChain) throws ServletException, IOException {
        
        try{
            String token = getToken(request);
            
            if(token != null && jwtProvider.validateToken(token)){
                
                String nombreUsuario = jwtProvider.buscarNombreUsuarioToken(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth =
                     new UsernamePasswordAuthenticationToken(userDetails,
                     null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }catch (Exception e){
            logger.error("Fallo en doFilter");
        }
        
        filterChain.doFilter(request, response);
       
    }
    
//Obtiene el token sin Bearer + el espacio
    private String getToken(HttpServletRequest request) {
    
        String header = request.getHeader("Autorization");
        if(header != null && header.startsWith("Bearer"))
            
            return header.replace("Bearer","");
        
        return null;
    
    }
}
