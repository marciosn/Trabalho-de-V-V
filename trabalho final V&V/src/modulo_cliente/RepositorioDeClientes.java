package modulo_cliente;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class RepositorioDeClientes {
	


	private List<Cliente> listaDeClientes = new ArrayList<Cliente>();
	
	public RepositorioDeClientes(){
		
	}

	public List<Cliente> getListaDeClientes() {
		return listaDeClientes;
	}

	public void setListaDeClientes(List<Cliente> listaDeClientes) {
		this.listaDeClientes = listaDeClientes;
	}
	
	public void inserirCliente(Cliente cliente){
		this.listaDeClientes.add(cliente);
	}
		
}
