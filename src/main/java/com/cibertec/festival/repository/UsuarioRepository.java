package com.cibertec.festival.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cibertec.festival.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    Optional<Usuario> findByUsername(String username);

}