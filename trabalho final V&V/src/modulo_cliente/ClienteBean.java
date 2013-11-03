package modulo_cliente;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

@ManagedBean
public class ClienteBean {

	private Cliente cliente;
	private Cliente cliente2;
	
	@ManagedProperty(value="#{repositorioDeClientes}")
	private RepositorioDeClientes repositorioDeClientes;

	public ClienteBean(){
		this.cliente = new Cliente();
		this.cliente2 = new Cliente();
	}
	
	public String adicionarCliente(){
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		this.repositorioDeClientes.getListaDeClientes().add(this.cliente);
		flash.setKeepMessages(true);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
				(FacesMessage.SEVERITY_INFO, "CLIENTE INSERIDO COM SUCESSO!!!!", null));
		return "/pagina/listarCliente?faces-redirect=true";
	}
	
	public String editarCliente(){
		
		System.out.println("O ID A SER EDITADO É: " + cliente2.getIdCliente());
		
		for(int i=0;i<repositorioDeClientes.getListaDeClientes().size();i++){
			int comp1 = repositorioDeClientes.getListaDeClientes().get(i).getIdCliente();
			int comp2 = cliente2.getIdCliente();
			if(comp2 == comp1){
				System.out.println("O ID DA POSICAO I É: " + repositorioDeClientes.getListaDeClientes().get(i).getIdCliente());
				
				repositorioDeClientes.getListaDeClientes().get(i).setNome(cliente2.getNome());
				repositorioDeClientes.getListaDeClientes().get(i).setEmail(cliente2.getEmail());
				repositorioDeClientes.getListaDeClientes().get(i).setTelefone(cliente2.getTelefone());
				repositorioDeClientes.getListaDeClientes().get(i).setEndereco(cliente2.getEndereco());
				
				Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
				flash.setKeepMessages(true);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
						(FacesMessage.SEVERITY_INFO, "CONTADO EDITADO COM SUCESSO!!!!", null));
			}
		}	
		
		return "/pagina/listarCliente?faces-redirect=true";
	}
	
	public String exclui(){
		System.out.println("ENTROU NO MÉTODO EXCLUIR");
		for(int i= 0; i < repositorioDeClientes.getListaDeClientes().size(); i++){
			if((cliente2.getIdCliente()) == (repositorioDeClientes.getListaDeClientes().get(i).getIdCliente())){
				
				repositorioDeClientes.getListaDeClientes().remove(i);
				System.out.println("Cliente EXCLUIDO");
				
				return "/pagina/listarCliente?faces-redirect=true";
			}
			
		}
		System.out.println("cliente NÃO EXCLUIDO");
		return "/pagina/listarCliente?faces-redirect=true";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente2() {
		return cliente2;
	}

	public void setCliente2(Cliente cliente2) {
		this.cliente2 = cliente2;
	}

	public RepositorioDeClientes getRepositorioDeClientes() {
		return repositorioDeClientes;
	}

	public void setRepositorioDeClientes(RepositorioDeClientes repositorioDeClientes) {
		this.repositorioDeClientes = repositorioDeClientes;
	}
	
}
