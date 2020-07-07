package entityImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connection.GetConnection;
import entityDAO.EntityDAO;
import entitys.Client;
import entitys.Phone;

public class PhoneImp implements EntityDAO<Phone> {
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;
	
	@Override
	public void create(Phone obj) throws Exception {
		try {
			GetConnection connect = new GetConnection();
			Connection conn = connect.getConnection();
			
			stm = conn.prepareStatement("insert into telefone(tipo_telefone, ddd, numero, cdcliente) values (?, ?, ?, ?)");
			stm.setString(1,obj.getPhoneType());
			stm.setString(2, obj.getDdd());
			stm.setString(3, obj.getNumber());
			stm.setInt(4, obj.getCdClient());
			stm.executeUpdate();
			
			sttm = conn.createStatement();
			rs = sttm.executeQuery("select max(cdtelefone) from telefone;");
			rs.next();
			
			int cdPhone = rs.getInt(1);
			obj.setCdPhone(cdPhone);
			
			System.out.println("Telefone criado com sucesso!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void read(int cd) throws Exception {
		try {
			
			GetConnection conexao = new GetConnection();
			Connection conn = conexao.getConnection();
			
			stm = conn.prepareStatement("select * from telefone where cdtelefone = ?");
			stm.setInt(1, cd);
			rs = stm.executeQuery();
			rs.next();
			System.out.println("[Tipo: " + rs.getString("tipo_telefone") + " DDD: " + rs.getString("ddd") + " Numero: " + rs.getString("numero") + " Codigo do cliente: " + rs.getInt("cdcliente") + "]");
			}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(int cd, String toUpdate) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int cd) throws Exception {
		try {
			GetConnection conexao = new GetConnection();
			Connection conn = conexao.getConnection();
			
			stm = conn.prepareStatement("delete from telefone where cdtelefone = ?");
			stm.setInt(1, cd);
			stm.executeUpdate();
			System.out.println("Telefone de Codigo [" + cd + "] foi Deletado");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Phone> list() throws Exception {
		try {
			GetConnection conexao = new GetConnection();
			Connection conn = conexao.getConnection();
			
			stm = conn.prepareStatement("select * from telefone order by cdtelefone");
			
			rs = stm.executeQuery();
			
			ArrayList<Phone> phones = new ArrayList<>();
			
			while(rs.next()) {
				String phoneType = rs.getString("tipo_telefone");
				String ddd = rs.getString("ddd");
				String salePrice = rs.getString("numero");
				int cdClient = rs.getInt("cdcliente");
				phones.add(new Phone(phoneType, ddd, salePrice, cdClient));
			}
			
			int x = 0;
			while(x < phones.size()) {
				System.out.println("[Tipo: " + phones.get(x).getPhoneType() + " DDD: " + phones.get(x).getDdd() + " Numero: " + phones.get(x).getNumber() + " Codigo do cliente: " + phones.get(x).getCdClient() + "]");
				x++;
			}
			
			return phones;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
