package modulo_titulos;

public enum Estado {
	DISPONIVEL("Disponivel"), ALUGADO("Alugado"), RESERVADO("Reservado");

	private String nome;
	
	private Estado(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}

}
