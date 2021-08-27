package br.com.zup.edu.sitedeviagens.repository;

import br.com.zup.edu.sitedeviagens.modelo.Aeroporto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeroportoRepository extends JpaRepository<Aeroporto, Long> {
}
