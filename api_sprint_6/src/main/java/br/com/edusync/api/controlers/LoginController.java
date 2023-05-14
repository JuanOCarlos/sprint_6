package br.com.edusync.api.controlers;

import br.com.edusync.api.dto.JwtRequestDto;
import br.com.edusync.api.dto.JwtResponseDto;
import br.com.edusync.api.services.JwtTokenService;
import br.com.edusync.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity createAuthenticationToken(@RequestBody JwtRequestDto authenticationRequest) throws Exception {
        if (!usuarioService.userExists("admin")) {
            usuarioService.createAdminUser();
        }
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = usuarioService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenService.generateToken(userDetails);
        return new ResponseEntity(new JwtResponseDto(token), HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException e){
            throw new Exception("USER_DISABLED", e);
        }catch (BadCredentialsException e){
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
