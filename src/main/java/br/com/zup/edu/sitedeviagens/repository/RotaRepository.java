package br.com.zup.edu.sitedeviagens.repository;

import br.com.zup.edu.sitedeviagens.modelo.Rota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RotaRepository extends JpaRepository<Rota, Long> {


    List<Rota> findByOrigemIdAndDestinoId(Long ID1, Long id2);
}
