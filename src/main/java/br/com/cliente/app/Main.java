package br.com.cliente.app;

import br.com.cliente.dao.ClienteDAO;
import br.com.cliente.model.Cliente;

public class Main {

	public static void main(String[] args) {
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente1 = new Cliente();
		cliente1.setName("Jovem Nerd");
		cliente1.setEmail("jovemnerd@email.com");
		cliente1.setComment("NA");
		cliente1.setCnpj("22.111.121/0001-11");
		cliente1.setId(1);
		
		//clienteDAO.delete(cliente1);
		
		clienteDAO.save(cliente1);
		
		System.out.println(clienteDAO.getClientes());

	}

}
