package br.com.zup.edu.sitedeviagens.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Voo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numeroDeLugares;

    @OneToMany(mappedBy = "voo")
    private List<VooRota> rotas;

}
