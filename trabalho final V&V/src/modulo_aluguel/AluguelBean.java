package modulo_aluguel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import modulo_cliente.Cliente;
import modulo_cliente.RepositorioDeClientes;
import modulo_titulos.Copia;
import modulo_titulos.Estado;
import modulo_titulos.RepositorioCopia;
import modulo_titulos.Repositorio_Titulos;
import modulo_titulos.Titulo;

@ManagedBean

public class AluguelBean {

	private Aluguel aluguel;
	private Aluguel aluguel2;
	private Aluguel aluguel3;
	private Cliente cliente2;
	private Cliente cliente;
	private Titulo titulo3;
	private Copia copia;
	private Copia copia2;
	
	public Copia getCopia() {
		return copia;
	}

	public void setCopia(Copia copia) {
		this.copia = copia;
	}

	public Copia getCopia2() {
		return copia2;
	}

	public void setCopia2(Copia copia2) {
		this.copia2 = copia2;
	}

	private int cpf;
	private int idc;
	private String nome;
	private String nome2;
	
	private int idt;
	private String tit;
	
	private int idcopia;
	private int idcliente;
	
	private int indice;
	private String busca;
	@ManagedProperty(value="#{repositorio}")
	private Repositorio repositorio;
	
	@ManagedProperty(value="#{repositorioDeClientes}")
	private RepositorioDeClientes repositorioDeClientes;
	
	@ManagedProperty(value="#{repositorio_Titulos}")
	private Repositorio_Titulos repositorioT;
	
	@ManagedProperty(value="#{repositorioCopia}")
	private RepositorioCopia repCopia;
	
	public  AluguelBean(){
		this.aluguel = new Aluguel();
		this.aluguel2 = new Aluguel();
		this.cliente = new Cliente();
		this.cliente2 = new Cliente();
		this.titulo3 = new Titulo();
		this.copia = new Copia();
		this.copia2 = new Copia();
	}
	
	public String alugar(){
			
		repositorio.getAlugueis().add(this.aluguel);
		for(int i=0; i < repCopia.getCopias().size();i++){
			if (repCopia.getCopias().get(i).getId() == aluguel.getIdCopia()){
				repCopia.getCopias().get(i).setEstado(Estado.ALUGADO);
				
			}
			
		}
		
		return "/pagina/listarAlugueis?faces-redirect=true";
	}
	public String reservar(){
		System.out.println("entrou no metodo reservar");
		System.out.println(indice);
		
		for(int i=0; i < repCopia.getCopias().size();i++){
			System.out.println(repCopia.getCopias().get(i).getId());
			if(indice == repCopia.getCopias().get(i).getId()){
				System.out.println("passou pelo if");
				repCopia.getCopias().get(i).setEstado(Estado.RESERVADO);
			}
			
		}
			
		return "/pagina/listar_copia?faces-redirect=true";
	}
	public String devolver(){
		for(int i=0; i < repositorio.alugueis.size();i++){
			for(int j=0; j < repCopia.getCopias().size();j++){
				if(repCopia.getCopias().get(j).getId() == aluguel2.getIdCopia()){
				
				repCopia.getCopias().get(j).setEstado(Estado.DISPONIVEL);
					if((repositorio.alugueis.get(i).getIdAluguel()) == indice){
						repositorio.alugueis.remove(i);
					}
				
				}
			}
		}
		return "/pagina/listarAlugueis?faces-redirect=true";
	}
	public String buscarCliente(){
		for(int i=0;i<repositorioDeClientes.getListaDeClientes().size();i++){
			if(repositorioDeClientes.getListaDeClientes().get(i).getNome().equals(busca)){
				
				cliente.setNome(repositorioDeClientes.getListaDeClientes().get(i).getNome());
				cliente.setCpf(repositorioDeClientes.getListaDeClientes().get(i).getCpf());
				cliente.setEmail(repositorioDeClientes.getListaDeClientes().get(i).getEmail());
				cliente.setEndereco(repositorioDeClientes.getListaDeClientes().get(i).getEndereco());
				cliente.setTelefone(repositorioDeClientes.getListaDeClientes().get(i).getTelefone());
				
				System.out.println(cliente.getNome());
			}
		}
		return "/pagina/buscarCliente?faces-redirect=true";
	}
	
	public String exclui(){
		for(int i=0; i < repositorio.alugueis.size();i++){
			if((repositorio.alugueis.get(i).getIdAluguel()) == indice){
				repositorio.alugueis.remove(i);
			}
			
		}
		return "/pagina/listarAlugueis?faces-redirect=true";
	}
	
	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public Aluguel getAluguel2() {
		return aluguel2;
	}

	public void setAluguel2(Aluguel aluguel2) {
		this.aluguel2 = aluguel2;
	}

	public Aluguel getAluguel3() {
		return aluguel3;
	}

	public void setAluguel3(Aluguel aluguel3) {
		this.aluguel3 = aluguel3;
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public Cliente getCliente2() {
		return cliente2;
	}

	public void setCliente2(Cliente cliente2) {
		this.cliente2 = cliente2;
	}

	public Titulo getTitulo3() {
		return titulo3;
	}

	public void setTitulo3(Titulo titulo3) {
		this.titulo3 = titulo3;
	}

	public Repositorio getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(Repositorio repositorio) {
		this.repositorio = repositorio;
	}

	public RepositorioDeClientes getRepositorioDeClientes() {
		return repositorioDeClientes;
	}

	public void setRepositorioDeClientes(RepositorioDeClientes repositorioDeClientes) {
		this.repositorioDeClientes = repositorioDeClientes;
	}

	public Repositorio_Titulos getRepositorioT() {
		return repositorioT;
	}

	public void setRepositorioT(Repositorio_Titulos repositorioT) {
		this.repositorioT = repositorioT;
	}

	public RepositorioCopia getRepCopia() {
		return repCopia;
	}

	public void setRepCopia(RepositorioCopia repCopia) {
		this.repCopia = repCopia;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public int getIdc() {
		return idc;
	}

	public void setIdc(int idc) {
		this.idc = idc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdt() {
		return idt;
	}

	public void setIdt(int idt) {
		this.idt = idt;
	}

	public String getTit() {
		return tit;
	}

	public void setTit(String tit) {
		this.tit = tit;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNome2() {
		return nome2;
	}

	public void setNome2(String nome2) {
		this.nome2 = nome2;
	}

	public int getIdcopia() {
		return idcopia;
	}

	public void setIdcopia(int idcopia) {
		this.idcopia = idcopia;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	
	
}
