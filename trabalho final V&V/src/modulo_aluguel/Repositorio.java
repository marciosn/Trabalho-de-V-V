package modulo_aluguel;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import modulo_titulos.Copia;

@ManagedBean
@SessionScoped
public class Repositorio {

	List<Aluguel> alugueis = new ArrayList<Aluguel>();
	

	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}
	public String insere(Aluguel a){
		alugueis.add(a);
		return "lista";
	}
}
