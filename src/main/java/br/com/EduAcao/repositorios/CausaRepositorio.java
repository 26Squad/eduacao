package br.com.EduAcao.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.EduAcao.model.Causa;


public interface CausaRepositorio extends JpaRepository<Causa, Long> {

    @EntityGraph(attributePaths = "endereco")
    List<Causa> findAll();

    Optional<Causa> findByEmail(String email);
    
}
