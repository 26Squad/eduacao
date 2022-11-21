package br.com.EduAcao.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Administrador extends Pessoa {

    @Column(nullable = false)
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

  

    
}
