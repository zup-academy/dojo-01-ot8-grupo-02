package br.com.zup.edu.sitedeviagens.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class VooRota {

    @EmbeddedId
    private VooRotaKey id;

    @ManyToOne
    private Voo voo;

    @ManyToOne
    private Rota rota;
}
