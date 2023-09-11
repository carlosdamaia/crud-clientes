package br.com.cliente.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.cliente.factory.ConnectionFactory;
import br.com.cliente.model.Cliente;

public class ClienteDAO {
	
	public void save(Cliente cliente) {
		
		String sql = "INSERT INTO cliente(name, email, comment, cpnj) VALUES (?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySql();		
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cliente.getName());
			pstm.setString(2, cliente.getEmail());
			pstm.setString(3, cliente.getComment());
			pstm.setString(4, cliente.getCnpj());
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
