package modulo_titulos;


public class Copia {
	private static int ultId = 0;
	
	private String titulo;
	private Estado estado;
	private int id;
	
	
	public Copia(){
		this.id = ultId++;
		//this.estado = "Disponivel";
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado2) {
		this.estado = estado2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
