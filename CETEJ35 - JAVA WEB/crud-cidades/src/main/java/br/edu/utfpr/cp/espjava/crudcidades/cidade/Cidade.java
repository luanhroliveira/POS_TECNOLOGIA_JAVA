package br.edu.utfpr.cp.espjava.crudcidades.cidade;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Cidade {

    @NotBlank(message = "{app.cidade.blank}")
    @Size(min = 5, max = 60, message = "{app.cidade.size}")
    private String nome;

    @NotBlank(message = "{app.estado.blank}")
    @Size(min = 2, max = 2, message = "{app.estado.size}")
    private String estado;

    public Cidade() {
    }

    public Cidade(String nome, String estado) {
        this.nome = nome;
        this.estado = estado;
    }

    public Cidade clonar(
        final CidadeEntity entity
    ) {
       return new Cidade(entity.getNome(), entity.getEstado());
    }

    public CidadeEntity clonar() {
        CidadeEntity entity = new CidadeEntity();
        entity.setNome(this.getNome());
        entity.setEstado(this.getEstado());

        return entity;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
