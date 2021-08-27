package br.com.zup.edu.sitedeviagens.repository;

import br.com.zup.edu.sitedeviagens.modelo.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
}
