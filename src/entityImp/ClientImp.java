package entityImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connection.GetConnection;
import entityDAO.EntityDAO;
import entitys.Client;

public class ClientImp implements EntityDAO<Client> {
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;

	@Override
	public void create(Client obj) throws Exception {
		try {
			GetConnection connect = new GetConnection();
			Connection conn = connect.getConnection();
			
			stm = conn.prepareStatement("insert into cliente(nomeSobrenome) values (?)");
			stm.setString(1,obj.getNameAndSurname());
			stm.executeUpdate();
			
			sttm = conn.createStatement();
			rs = sttm.executeQuery("select max(cdcliente) from cliente;");
			rs.next();
			
			int cdClient = rs.getInt(1);
			obj.setCdclient(cdClient);
			
			System.out.println("Cliente criado com sucesso!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void read(int cd) throws Exception {
		try {
			
			GetConnection conexao = new GetConnection();
			Connection conn = conexao.getConnection();
			
			stm = conn.prepareStatement("select * from cliente where cdcliente = ?");
			stm.setInt(1, cd);
			rs = stm.executeQuery();
			rs.next();
			System.out.println("[Nome do cliente: " + rs.getString("nomeSobrenome")+ "]");
			}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(int cd, String toUpdate) throws Exception {
		try {
			GetConnection conexao = new GetConnection();
			Connection conn = conexao.getConnection();
			
			stm = conn.prepareStatement("update cliente set nomeSobrenome = ? where cdcliente = ?");
			stm.setString(1, toUpdate);
			stm.setInt(2, cd);
			stm.executeUpdate();
			System.out.println("Cliente de Codigo [" + cd + "] foi atualizado");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int cd) throws Exception {
		try {
			GetConnection conexao = new GetConnection();
			Connection conn = conexao.getConnection();
			
			stm = conn.prepareStatement("delete from cliente where cdcliente = ?");
			stm.setInt(1, cd);
			stm.executeUpdate();
			System.out.println("Cliente de Codigo [" + cd + "] foi Deletado");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Client> list() throws Exception {
		try {
			GetConnection conexao = new GetConnection();
			Connection conn = conexao.getConnection();
			
			stm = conn.prepareStatement("select * from cliente order by cdcliente");
			rs = stm.executeQuery();
			
			ArrayList<Client> clients = new ArrayList<>();
			
			while(rs.next()) {
				String nameAndSurename = rs.getString("nomeSobrenome");
				clients.add(new Client(nameAndSurename));
			}
			
			int x = 0;
			while(x < clients.size()) {
				System.out.println("[Cliente: " + clients.get(x).getNameAndSurname()+ "]");
				x++;
			}
			
			return clients;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public int getLestIdClientCreated() throws Exception {
		GetConnection conexao = new GetConnection();
		Connection conn = conexao.getConnection();
		
		sttm = conn.createStatement();
		rs = sttm.executeQuery("select max(cdcliente) from cliente;");
		rs.next();
	
		int cdClient = rs.getInt(1);
		return cdClient;
	}

}