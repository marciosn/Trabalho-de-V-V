package modulo_titulos;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

	
@ManagedBean
@SessionScoped

public class Repositorio_Titulos {
	
	List<Titulo> titulos = new ArrayList<Titulo>();
	
	public List<Titulo> getTitulos() {
		return titulos;
	}

	public void setTitulos(List<Titulo> titulos) {
		this.titulos = titulos;
	}
	
	public String insere(Titulo t){
		titulos.add(t);
		return "lista";
	}
}
