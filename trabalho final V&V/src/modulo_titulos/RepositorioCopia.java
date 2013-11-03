package modulo_titulos;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class RepositorioCopia {

	List<Copia> copias = new ArrayList<Copia>();
	
	List<Copia> aux = new ArrayList<Copia>();
	
	public List<Copia> getAux() {
		return aux;
	}

	public void setAux(List<Copia> aux) {
		this.aux = aux;
	}

	public List<Copia> getCopias() {
		return copias;
	}

	public void setCopias(List<Copia> copias) {
		this.copias = copias;
	}
	public String insere(Copia c){
		copias.add(c);
		return "listar";
	}
	
}
