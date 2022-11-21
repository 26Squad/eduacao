package br.com.EduAcao.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.EduAcao.model.Newsletter;





public interface NewsletterRepositorio extends JpaRepository<Newsletter, Long> {
	List<Newsletter> findAll();

}
