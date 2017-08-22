package br.com.techgold.tg.modelo;

import java.util.Calendar;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Solicitacao {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String abriuChamado;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar agendado;
	
	@Lob
	private String  andamentoDoChamado;
	
	private String classificacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataAbertura = Calendar.getInstance();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataAndamento;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataFechamento;

	private String descricaoProblema;
	
	private String nivelDeIncidencia;
	
	private String obs;
	
	private String onsiteOffsite;

	private String prioridade;

	private String resolucao;

	private String status;
	
	private String usuario;
	
	@OneToOne(fetch=FetchType.EAGER) //faz com que cliente seja carregado ao carregar solicitacao
	private Cliente cliente;

	@OneToOne(fetch=FetchType.EAGER)
	private Funcionario funcionario;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAbriuChamado() {
		return abriuChamado;
	}

	public void setAbriuChamado(String abriuChamado) {
		this.abriuChamado = abriuChamado;
	}

	public Calendar getAgendado() {
		return agendado;
	}

	public void setAgendado(Calendar agendado) {
		this.agendado = agendado;
	}

	public String getAndamentoDoChamado() {
		return andamentoDoChamado;
	}

	public void setAndamentoDoChamado(String andamentoDoChamado) {
		this.andamentoDoChamado = andamentoDoChamado;
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

	public Calendar getDataAndamento() {
		return dataAndamento;
	}

	public void setDataAndamento(Calendar dataAndamento) {
		this.dataAndamento = dataAndamento;
	}

	public Calendar getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Calendar dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public String getDescricaoProblema() {
		return descricaoProblema;
	}

	public void setDescricaoProblema(String descricaoProblema) {
		this.descricaoProblema = descricaoProblema;
	}

	public String getNivelDeIncidencia() {
		return nivelDeIncidencia;
	}

	public void setNivelDeIncidencia(String nivelDeIncidencia) {
		this.nivelDeIncidencia = nivelDeIncidencia;
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

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	//Adiciona o cliente na solicitação ante de salvar - metodo do link
	public void adicionaCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	//Adiciona o cliente na solicitação ante de salvar - metodo do link
	public void adicionaFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public void addFuncionarioMsg() {
        String msgFuncionario = "Funcionário adicionado";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgFuncionario));
    }
	
	public void addClienteMsg() {
        String msgCliente = "Cliente adicionado";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msgCliente));
    }

}
