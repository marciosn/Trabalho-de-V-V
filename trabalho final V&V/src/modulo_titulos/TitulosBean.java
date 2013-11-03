package modulo_titulos;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import modulo_aluguel.Repositorio;



@ManagedBean
public class TitulosBean{

	private Titulo titulo;
	private Titulo titulo2;
	private Copia copia;
	private Copia copia2;
	private String estadoSelecionado;
	
	private String busca;
	private int indice;
	private String tituloCopia;
	
	List<Copia> encontrados = new ArrayList<Copia>();
	//HashSet encontrados = new HashSet();
	
	
	@ManagedProperty(value="#{repositorio_Titulos}")
	private Repositorio_Titulos repositorio_t;

	@ManagedProperty(value="#{repositorio}")
	private Repositorio repositorio;
	
	@ManagedProperty(value="#{repositorioCopia}")
	private RepositorioCopia repCopia;
	
	public TitulosBean(){
		this.titulo = new Titulo();
		this.titulo2 = new Titulo();
		this.copia = new Copia();
		this.copia2 = new Copia();
	}
	
	public String insere(){
		System.out.println("ENTROU NO MÉTODO INSERE");
		repositorio_t.getTitulos().add(this.titulo);
		
		System.out.println("TITULO INSERIDO");
		return "/pagina/listar?faces-redirect=true";
	}
	
	public String insereCopia(){
		
		System.out.println("ENTROU NO MÉTODO INSERE CÓPIA");
		//titulo.getCopias().add(this.copia);
		 
		for(int i=0; i < repositorio_t.titulos.size();i++){
			if(repositorio_t.titulos.get(i).getTitulo().equals(copia.getTitulo())){
				
				System.out.println("PASSOU PELO IF");
				
				repositorio_t.titulos.get(i).getCopias().add(this.copia);
				this.copia.setEstado(Estado.valueOf(estadoSelecionado));
				
				int q = repositorio_t.titulos.get(i).getQuantidade();
				//System.out.println(q);
				repositorio_t.titulos.get(i).setQuantidade(q+1);
				System.out.println("COPIA INSERIDA");
				
				
				return "/pagina/listar_copia?faces-redirect=true";
			}
		}
		System.out.println("COPIA NAO INSERIDA");
		return "/pagina/listar?faces-redirect=true";
	}
public String insereCopia2(){
		
		System.out.println("ENTROU NO MÉTODO INSERE CÓPIA2");
		//titulo.getCopias().add(this.copia);
		 
		for(int i=0; i < repositorio_t.titulos.size();i++){
			if(repositorio_t.titulos.get(i).getTitulo().equals(copia.getTitulo())){
				
				System.out.println("PASSOU PELO IF");
				
				//repositorio_t.titulos.get(i).getCopias().add(this.copia);
				repCopia.copias.add(this.copia);
				this.copia.setEstado(Estado.valueOf(estadoSelecionado));
				
				int q = repositorio_t.titulos.get(i).getQuantidade();
				//System.out.println(q);
				repositorio_t.titulos.get(i).setQuantidade(q+1);
				System.out.println("COPIA INSERIDA");
				
				
				return "/pagina/listar_copia?faces-redirect=true";
			}
		}
		System.out.println("COPIA NAO INSERIDA");
		return "/pagina/listar?faces-redirect=true";
	}
	
	public String atualiza(){

		for(int i=0; i < repositorio_t.titulos.size(); i++){
			if((titulo2.getId()) == (repositorio_t.titulos.get(i).getId())){
				repositorio_t.titulos.get(i).setTitulo(titulo2.getTitulo());
				repositorio_t.titulos.get(i).setGenero(titulo2.getGenero());
				System.out.println("TITULO EDITADO");
				return "/pagina/listar?faces-redirect=true";
			}
		}
		System.out.println("TITULO NÃO EDITADO");
		return "/pagina/listar?faces-redirect=true";
	}
	
	public String atualizaCopia(){
		for(int i=0; i < repCopia.copias.size(); i++){
			if((indice) == (repCopia.copias.get(i).getId())){
				//repCopia.copias.get(i).setEstado(copia2.getEstado());
				repCopia.copias.get(i).setTitulo(copia2.getTitulo());
				repCopia.copias.get(i).setEstado(Estado.valueOf(estadoSelecionado));
				
				System.out.println("COPIA EDITADA");
				return "/pagina/listar?faces-redirect=true";
			}
		}
		System.out.println("COPIA NÃO EDITADA");
		return "/pagina/listar?faces-redirect=true";
	}
	
	public String exclui(){
		System.out.println("ENTROU NO MÉTODO EXCLUIR");
		for(int i= 0; i < repositorio_t.titulos.size(); i++){
			if((titulo2.getId()) == (repositorio_t.titulos.get(i).getId())){
				
				repositorio_t.titulos.remove(i);
				System.out.println("TITULO EXCLUIDO");
				
				return "/pagina/listar?faces-redirect=true";
			}
			
		}
		System.out.println("TITULO NÃO EXCLUIDO");
		return "/pagina/listar?faces-redirect=true";
	}
	
	public String excluiCopia(){
		System.out.println("ENTROU NO METODO EXCLUI COPIA");
		for(int i = 0 ; i < repCopia.copias.size();i++){
			if((repCopia.copias.get(i).getId()) == indice){
				
				int q = repositorio_t.titulos.get(i).getQuantidade();
				repositorio_t.titulos.get(i).setQuantidade(q-1);
				repCopia.copias.remove(i);
				System.out.println("COPIA EXCLUIDA");
			}
		}
		return "/pagina/listar_copia?faces-redirect=true";
	}
	
	public String buscar(){
		
		for(int i=0 ;i < repositorio_t.titulos.size();i++){
			if(titulo2.getTitulo().equals(repositorio_t.titulos.get(i).getTitulo())){
				repositorio_t.titulos.get(i).getTitulo();
				repositorio_t.titulos.get(i).getGenero();
				repositorio_t.titulos.get(i).getId();
				
			}
		}
		return "/pagina/listar?faces-redirect=true";
	}
	
	public String buscarCopia(){
		System.out.println("ENTROU NO METODO BUSCAR COPIA");
	
		return "/pagina/listar?faces-redirect=true";
	}

	
	public String pegaLista(){
		
		//List<Copia> encontrados = new ArrayList<Copia>();
		
		System.out.println("ENTROU NO METODO PEGARLISTA");
		System.out.println(">>>>>>> "+titulo2.getTitulo()+" <<<<<<<");
		
		for(int i = 0 ; i < repositorio_t.titulos.size(); i++){
			if((repositorio_t.titulos.get(i).getId()) == indice && (repositorio_t.titulos.get(i).getQuantidade()) > 0){
				System.out.println("PASSOU PELO PRIMEIRO IF");
				//if(repositorio_t.titulos.get(i).getTitulo().equals(repCopia.copias.get(i).getTitulo())){
				if(titulo2.getTitulo().equals(repCopia.copias.get(i).getTitulo())){
					
					
						for(int j = 1; j < repCopia.copias.size();j++){
							
								
						System.out.println("PASSOU PELO IF");
							repCopia.aux.add(this.copia2);
							repCopia.aux.get(j).setId(repCopia.copias.get(j).getId());
						System.out.println("O ID DA COPIA É " + repCopia.copias.get(j).getId());
							repCopia.aux.get(j).setEstado(repCopia.copias.get(j).getEstado());
						System.out.println(" O ESTADO DA COPIA É " + repCopia.copias.get(j).getEstado());
							repCopia.aux.get(j).setTitulo(repCopia.copias.get(j).getTitulo());
						System.out.println("O TITULO DA COPIA É " + repCopia.copias.get(j).getTitulo());
					
					
				}
			}
				
		}
			
	}
		
		System.out.println("SAIU DO METODO ");
		return "/pagina/listaAux?faces-redirect=true";
	}
	
	public String pegaLista2(){
		
		System.out.println("ENTROU NO METODO PEGARLISTA 2");
		System.out.println(">>>>>>> "+titulo2.getTitulo()+" <<<<<<<");
		
		for(int i = 0 ; i < repositorio_t.titulos.size(); i++){
			if((repositorio_t.titulos.get(i).getId()) == indice && (repositorio_t.titulos.get(i).getQuantidade()) > 0){
				//System.out.println("PASSOU PELO PRIMEIRO IF");
				for(int j = 0; j < repCopia.copias.size();j++){
					
					if(repCopia.copias.get(j).getTitulo().equals(titulo2.getTitulo()))
						
						encontrados.add(repCopia.copias.get(j));
					
				}
							for(int k=0; k < encontrados.size();k++){
						
							repCopia.aux.add(this.copia2);
							repCopia.aux.get(k).setId(encontrados.get(k).getId());
							repCopia.aux.get(k).setEstado(encontrados.get(k).getEstado());
							repCopia.aux.get(k).setTitulo(encontrados.get(k).getTitulo());
					
						System.out.println(">>>>>>>> O ID DA COPIA É " + repCopia.aux.get(k).getId());
			}
				
		}
			
	}
		
		System.out.println("SAIU DO METODO ");
		return "/pagina/listaAux?faces-redirect=true";
	}
		
	public String LimpaAux(){
		
		System.out.println("ENTROU NO METODO LIMPA ARRAY");
	
			for(int i=0 ; i < repCopia.aux.size();i++){
			repCopia.aux.remove(i);
			
			if(repCopia.aux.size() > 0)
				LimpaAux();
			System.out.println("ENTROU NO WHILE E LIMPOU O ARRAY AUX");
			
			for(int j=0;j< encontrados.size();j++)
				encontrados.remove(i);
			
			if(encontrados.size() > 0)
				LimpaAux();
			
			System.out.println("ENTROU NO WHILE E LIMPOU O ARRAY ENCONTRADOS");
		}
			
		return "/pagina/listar?faces-redirect=true";
	}
	public Copia getCopia2() {
		return copia2;
	}

	public void setCopia2(Copia copia2) {
		this.copia2 = copia2;
	}

	public Copia getCopia() {
		return copia;
	}

	public void setCopia(Copia copia) {
		this.copia = copia;
	}
	public Titulo getTitulo2() {
		return titulo2;
	}

	public void setTitulo2(Titulo titulo2) {
		this.titulo2 = titulo2;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public Repositorio_Titulos getRepositorio_t() {
		return repositorio_t;
	}

	public void setRepositorio_t(Repositorio_Titulos repositorio_t) {
		this.repositorio_t = repositorio_t;
	}

	public String getEstadoSelecionado() {
		return estadoSelecionado;
	}

	public void setEstadoSelecionado(String estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
	}
	
	public RepositorioCopia getRepCopia() {
		return repCopia;
	}

	public void setRepCopia(RepositorioCopia repCopia) {
		this.repCopia = repCopia;
	}

	public Estado[] getEstados(){
		return Estado.values();
	}

	public String getBusca() {
		return busca;
	}

	public void setBusca(String busca) {
		this.busca = busca;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public Repositorio getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(Repositorio repositorio) {
		this.repositorio = repositorio;
	}

	public String getTituloCopia() {
		return tituloCopia;
	}

	public void setTituloCopia(String tituloCopia) {
		this.tituloCopia = tituloCopia;
	}

	public List<Copia> getEncontrados() {
		return encontrados;
	}

	public void setEncontrados(List<Copia> encontrados) {
		this.encontrados = encontrados;
	}
	
}
