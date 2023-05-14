package br.com.edusync.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.rmi.server.UID;

@Data
public class JwtRequestDto implements Serializable {

    private static final long serialVersionUID = 1l;

    private String username;
    private String password;
}
