package br.com.techgold.tg.bean;

import javax.faces.bean.ManagedBean;

import br.com.techgold.tg.dao.DAO;
import br.com.techgold.tg.modelo.Funcionario;

@ManagedBean
public class FuncionarioBean {

	private Funcionario funcionario = new Funcionario();
	
	public Funcionario getFuncionario(){
		return funcionario;
	}

	public void gravar() {
		System.out.println("Gravando funcionario " + this.funcionario.nome);
		
		if (funcionario.getNome().isEmpty()) {
			throw new RuntimeException("Usuario deve ter pelomenos nome");
		}

		new DAO<Funcionario>(Funcionario.class).adiciona(this.funcionario);
		
		this.funcionario = new Funcionario();
		
	}
}
