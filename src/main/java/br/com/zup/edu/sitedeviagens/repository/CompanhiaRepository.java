package br.com.zup.edu.sitedeviagens.repository;

import br.com.zup.edu.sitedeviagens.modelo.Companhia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanhiaRepository extends JpaRepository<Companhia, Long> {
}
