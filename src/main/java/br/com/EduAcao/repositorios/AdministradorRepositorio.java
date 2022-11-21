package br.com.EduAcao.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.EduAcao.model.Administrador;




public interface AdministradorRepositorio extends JpaRepository<Administrador, Long> {

    @EntityGraph(attributePaths = "endereco")
    List<Administrador> findAll();

    Optional<Administrador> findByEmail(String email);
    
}