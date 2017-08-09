package br.com.techgold.tg.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Solicitacao {
	@Id
	@GeneratedValue
	private Integer id;

	@OneToOne(fetch=FetchType.EAGER) //faz com que cliente seja carregado ao carregar solicitacao
	private Cliente cliente;

	@OneToOne(fetch=FetchType.EAGER)
	private Usuario usuario;

	private String usuarioAfetado;
	private String prioridade;
	private String descricaoProblema;
	private String resolucao;
	private String status;
	private String obs;
	private String onsiteOffsite;
	private String classificacao;

	@Temporal(TemporalType.TIMESTAMP)
	// Grava data ignorando os segundos
	private Calendar dataAbertura = Calendar.getInstance();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getUsuarioAfetado() {
		return usuarioAfetado;
	}

	public void setUsuarioAfetado(String usuarioAfetado) {
		this.usuarioAfetado = usuarioAfetado;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getDescricaoProblema() {
		return descricaoProblema;
	}

	public void setDescricaoProblema(String descricaoProblema) {
		this.descricaoProblema = descricaoProblema;
	}

	public String getResolucao() {
		return resolucao;
	}

	public void setResolucao(String resolucao) {
		this.resolucao = resolucao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getOnsiteOffsite() {
		return onsiteOffsite;
	}

	public void setOnsiteOffsite(String onsiteOffsite) {
		this.onsiteOffsite = onsiteOffsite;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	
	//Adiciona o cliente na solicitação ante de salvar - metodo do link
	public void adicionaCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	//Adiciona o cliente na solicitação ante de salvar - metodo do link
	public void adicionaUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
