package br.com.techgold.tg.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.techgold.tg.dao.DAO;
import br.com.techgold.tg.modelo.Cliente;
import br.com.techgold.tg.modelo.Solicitacao;
import br.com.techgold.tg.modelo.Funcionario;

@ManagedBean
@ViewScoped
public class SolicitacaoBean {

	private Solicitacao solicitacao = new Solicitacao();

	private Integer clienteId;

	private Integer funcionarioId;

	private List<Solicitacao> solicitacoes;

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public Integer getFuncionarioId() {
		return funcionarioId;
	}
	
	public void setFuncionarioId(Integer funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}
	
	//Retorna lista de cliente para seleção
	public List<Cliente> getClientes() {
		return new DAO<Cliente>(Cliente.class).listaTodos();
	}
	
	//Retorna lista de usuários para seleção
	public List<Funcionario> getFuncionarios(){
		return new DAO<Funcionario>(Funcionario.class).listaTodos();
	}

	//Metodo do link que grava o cliente antes de salvar a solicitacao
	public void gravarCliente() {
		Cliente cliente = new DAO<Cliente>(Cliente.class)
				.buscaPorId(this.clienteId);
		this.solicitacao.adicionaCliente(cliente);
		System.out.println("Cliente a gravar é " + cliente.getNome());
	}
	
	//Metodo do link que grava o usuário antes de salvar a solicitacao
	public void gravarFuncionario() {
		Funcionario funcionario = new DAO<Funcionario>(Funcionario.class)
				.buscaPorId(this.funcionarioId);
		this.solicitacao.adicionaFuncionario(funcionario);
		System.out.println("Funcionario a gravar é " + funcionario.getNome());
	}

	//grava uma nova solicitacao e edita caso ID seja diferente de null
	public String gravar() {
		System.out.println("Gravando Solicitação ");

		if (solicitacao.equals("null")) {
			throw new RuntimeException("Usuario deve ter pelomenos nome");
		}

		if (this.solicitacao.getId() == null) {
			new DAO<Solicitacao>(Solicitacao.class).adiciona(this.solicitacao);
		} else {
			new DAO<Solicitacao>(Solicitacao.class).atualiza(this.solicitacao);
		}

		this.solicitacao = new Solicitacao();
		return "solicitacoes?faces-redirect=true";

	}

	@SuppressWarnings("unused")
	private static Calendar parseData(String data) {
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}

	//retorna todas as solicitações
	public List<Solicitacao> getSolicitacoes() {
		DAO<Solicitacao> dao = new DAO<Solicitacao>(Solicitacao.class);
		
		//realiza um cache caso ja tenha realizado o dao
		if(this.solicitacoes == null){
			this.solicitacoes = dao.listaTodos();
		}
		
		return solicitacoes;
	}
	
	//remove uma solicitacao do banco
	public void remover(Solicitacao solicitacao) {
		System.out.println("Removendo livro");
		DAO<Solicitacao> dao = new DAO<Solicitacao>(Solicitacao.class);
		dao.remove(solicitacao);
		//recarrega a pagina devido ao cache
		this.solicitacoes = dao.listaTodos();

	}
	
	//carrega na view a solicitação a ser editada
	public void editar(Solicitacao solicitacao) {
		System.out.println("Editando livro"
				+ solicitacao.getDescricaoProblema());

		this.solicitacao = solicitacao;
	}
	
	
}
