package br.com.cliente.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.cliente.factory.ConnectionFactory;
import br.com.cliente.model.Cliente;

public class ClienteDAO {
	
	public void save(Cliente cliente) {
		
		String sql = "INSERT INTO cliente(name, email, comment, cnpj) VALUES (?, ?, ?, ?)";
		
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
	
	public void update(Cliente cliente) {
		
		String sql = "UPDATE cliente SET name = ?, email = ?, comment = ?, cnpj = ?" +"WHERE id=?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySql();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cliente.getName());
			pstm.setString(2, cliente.getEmail());
			pstm.setString(3, cliente.getComment());
			pstm.setString(4, cliente.getCnpj());
			pstm.setInt(5, cliente.getId());
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	
	public void delete(Cliente cliente) {
		String sql = "DELETE FROM cliente WHERE id=?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySql();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, cliente.getId());
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Cliente> getClientes(){
		String sql = "SELECT * FROM cliente";
		
		Connection conn = null;	
		PreparedStatement pstm = null;
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySql();
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				int id = rset.getInt("id");
				String name = rset.getString("name");
				String email = rset.getString("email");
				String comment = rset.getString("comment");
				String cnpj = rset.getString("cnpj");
				
				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("E-mail: " + email);
				System.out.println("Comment: " + comment);
				System.out.println("CNPJ: " + cnpj);
				System.out.println("---------------------------------------");
			}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rset!=null) {
						rset.close();
					}
					if(conn!=null) {
						conn.close();
					}
					if(pstm!=null) {
						pstm.close();
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return clientes;
		}
}

