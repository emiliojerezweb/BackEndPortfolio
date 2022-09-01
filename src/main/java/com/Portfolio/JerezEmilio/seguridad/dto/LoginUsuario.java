
package com.Portfolio.JerezEmilio.seguridad.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginUsuario {
    
    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String password;
    
}
