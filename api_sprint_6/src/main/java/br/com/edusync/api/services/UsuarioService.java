package br.com.edusync.api.services;

import br.com.edusync.api.models.Usuario;
import br.com.edusync.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByUsername(username);
    }

    public boolean userExists(String username) {
        Usuario usu = usuarioRepository.findByUsername(username);
        return (usu != null);
    }

    public void createAdminUser() {
        Usuario usuAdmin = new Usuario();
        usuAdmin.setUsername("admin");
        usuAdmin.setPassword(passwordEncoder.encode("1234"));
        usuAdmin.setNomeCompleto("Administrador");

        usuarioRepository.save(usuAdmin);
    }
}
