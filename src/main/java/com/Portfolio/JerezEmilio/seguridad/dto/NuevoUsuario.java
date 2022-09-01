
package com.Portfolio.JerezEmilio.seguridad.dto;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NuevoUsuario {
    
   @NotBlank
   private String nombre;
   @NotBlank
   private String nombreUsuario;
   @Email
   private String email;
   @NotBlank
   private String password;
   
   //crea usuario por defecto
   private Set<String> roles = new HashSet<>();
   
   
    
}
