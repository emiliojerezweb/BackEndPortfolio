
package com.Portfolio.JerezEmilio.seguridad.jwt;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/*
    Comprueba si existe un token si no duvuelve
    un 401 no autorizado
*/
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    //logger para ver cual metodo da error
    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    /**
     *
     * @param request
     * @param response
     * @param authException
     * @throws IOException
     * @throws ServletException
     */
    
    @Override
    public void commence(HttpServletRequest request, 
            HttpServletResponse response, 
            AuthenticationException authException) throws IOException, ServletException {
        
        logger.error("Fallo commence");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado");
    }
   
}
