package modulo_titulos;

import java.util.ArrayList;
import java.util.List;


public class Titulo {

	private static int ultimoId = 0;
	private static int qInicial = 0;
	
	private String titulo;
	private String genero;
	private int quantidade;
	private int id;
	
	List<Copia> copias = new ArrayList<Copia>();
	
	public Titulo(){
		this.id = ultimoId++;
		this.quantidade = qInicial;
	}
	
	public List<Copia> getCopias() {
		return copias;
	}

	public void setCopias(List<Copia> copias) {
		this.copias = copias;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public int setQuantidade(int quantidade) {
		return this.quantidade = quantidade;
	}
	public String insere(Copia c){
		copias.add(c);
		return "listar";
	}
	
}
