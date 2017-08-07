package br.com.techgold.tg.bean;

import javax.faces.bean.ManagedBean;

import br.com.techgold.tg.dao.DAO;
import br.com.techgold.tg.modelo.Cliente;

@ManagedBean
public class ClienteBean {

	private Cliente cliente = new Cliente();

	public Cliente getCliente() {
		return cliente;
	}

	public void gravar() {
		System.out.println("Gravando usuario " + this.cliente.nome);

		if (cliente.getNome().isEmpty()) {
			throw new RuntimeException("Usuario deve ter pelomenos nome");
		}

		new DAO<Cliente>(Cliente.class).adiciona(this.cliente);

		this.cliente = new Cliente();

	}
}
