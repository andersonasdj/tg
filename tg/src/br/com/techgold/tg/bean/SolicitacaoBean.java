package br.com.techgold.tg.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.techgold.tg.dao.DAO;
import br.com.techgold.tg.modelo.Cliente;
import br.com.techgold.tg.modelo.Solicitacao;

@ManagedBean
@ViewScoped
public class SolicitacaoBean {

	private Solicitacao solicitacao = new Solicitacao();

	private Integer clienteId;

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public List<Cliente> getClientes() {
		return new DAO<Cliente>(Cliente.class).listaTodos();
	}

	public void gravarCliente() {
		Cliente cliente = new DAO<Cliente>(Cliente.class)
				.buscaPorId(this.clienteId);
		this.solicitacao.adicionaCliente(cliente);
		System.out.println("Cliente a gravar é " + cliente.getNome());
	}

	public void gravar() {
		System.out.println("Gravando Solicitação ");

		if (solicitacao.equals("null")) {
			throw new RuntimeException("Usuario deve ter pelomenos nome");
		}

		new DAO<Solicitacao>(Solicitacao.class).adiciona(this.solicitacao);

		this.solicitacao = new Solicitacao();

	}
}
