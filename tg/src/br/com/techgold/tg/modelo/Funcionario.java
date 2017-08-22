package br.com.techgold.tg.modelo;

import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue
	public Integer id;
	public Calendar dataAtualizacao;
	public String email;
	public String nome;
	public String senha;
	public String usuario;
	public String funcao;
	public String ultimoLogin;
	public boolean status;

	public Funcionario() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Calendar dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getUltimoLogin() {
		return ultimoLogin;
	}

	public void setUltimoLogin(String ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void addMessage() {
        String msg = status ? "Ativado" : "Desativado";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
    }

}