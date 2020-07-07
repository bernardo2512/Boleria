package entityImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connection.GetConnection;
import entityDAO.EntityDAO;
import entitys.Address;
import entitys.Product;

public class AddressImp implements EntityDAO<Address> {
	private PreparedStatement stm;
	private ResultSet rs;
	private java.sql.Statement sttm;
	@Override
	public void create(Address obj) throws Exception {
		try {
			GetConnection connect = new GetConnection();
			Connection conn = connect.getConnection();
			
			stm = conn.prepareStatement("insert into endereco (rua, numero, cep, bairro, cdcliente) values (?, ?, ?, ?, ?)");
			stm.setString(1,obj.getStreet());
			stm.setString(2, obj.getNumber());
			stm.setString(3, obj.getZipCode());
			stm.setString(4, obj.getNeighborhood());
			stm.setInt(5, obj.getCdClient());
			stm.executeUpdate();
			
			sttm = conn.createStatement();
			rs = sttm.executeQuery("select max(cdproduto) from produto;");
			rs.next();
			
			int cdAddress = rs.getInt(1);
			obj.setCdAddress(cdAddress);
			System.out.println("Endereco adicionado com sucesso!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void read(int cd) throws Exception {
		try {
			GetConnection connect = new GetConnection();
			Connection conn = connect.getConnection();
			
			stm = conn.prepareStatement("select rua, numero, cep, bairro, cdcliente from endereco where cdendereco = ? ");
			stm.setInt(1, cd);
			rs = stm.executeQuery();
			rs.next();
			
			System.out.println("[Rua: " + rs.getString("rua") + " - Numero: " + rs.getString("numero") + " - CEP: " + rs.getString("cep") + " - Bairro: " + rs.getString("bairro") + " - Codigo do cliente: " + rs.getInt("cdcliente") + "]");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void update(int cd, String toUpdate) throws Exception {
		Address address;
		
		try {
			GetConnection connect = new GetConnection();
			Connection conn = connect.getConnection();
			
			stm = conn.prepareStatement("select rua, numero, cep, bairro, cdcliente from endereco where cdendereco = ? ");
			stm.setInt(1, cd);
			rs = stm.executeQuery();
			rs.next();
			
			address = new Address(rs.getString("rua"), rs.getString("numero"), rs.getString("cep"), rs.getString("bairro"), rs.getInt("cdcliente"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
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
			
			stm = conn.prepareStatement("delete from endereco where cdendereco = ?");
			stm.setInt(1, cd);
			stm.executeUpdate();
			System.out.println("Endereco de Codigo [" + cd + "] foi Deletado");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<Address> list() throws Exception {
		GetConnection connect = new GetConnection();
		Connection conn = connect.getConnection();
		
		stm = conn.prepareStatement("select * from endereco order by cdendereco");
		rs = stm.executeQuery();
		
		ArrayList<Address> addresses = new ArrayList<>();
		
		while(rs.next()) {
			String street = rs.getString("rua");
			String number = rs.getString("numero");
			String zipCode = rs.getString("cep");
			String neighborhood = rs.getString("bairro");
			int cdClient = rs.getInt("cdcliente");
			addresses.add(new Address(street, number, zipCode, neighborhood, cdClient));
		}
		
		int x = 0;
		while(x < addresses.size()) {
			System.out.println("[Rua: " + addresses.get(x).getStreet() + " - Numero: " + addresses.get(x).getNumber() + " - CEP: " + addresses.get(x).getZipCode() + " - Bairro: " + addresses.get(x).getNeighborhood() + " - Codigo do cliente: " + addresses.get(x).getCdClient() + "]");
			x++;
		}
		
		return addresses;
	}
	
}
