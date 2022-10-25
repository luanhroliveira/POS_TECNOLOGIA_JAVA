package br.com.luanhroliveira.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDFuncPK")
    private Long idFuncPk;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Sexo")
    private String sexo;

    @Column(name = "Telefone")
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "IDCargoFK")
    private Cargo cargo;

    public Funcionario() {
    }

    public Funcionario( String nome, String sexo, String telefone, Cargo cargo) {
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
        this.cargo = cargo;
    }

    public Long getIdFuncPk() {
        return idFuncPk;
    }

    public void setIdFuncPk(Long idFuncPk) {
        this.idFuncPk = idFuncPk;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
