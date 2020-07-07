package entityImp;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connection.GetConnection;
import entityDAO.EntityDAO;
import entitys.Product;


public class ProductImp implements EntityDAO<Product> {
	private PreparedStatement stm;
	private ResultSet rs;
	private Statement sttm;
	
	@Override
	public void create(Product obj)throws Exception {
		try {
			GetConnection connect = new GetConnection();
			Connection conn = connect.getConnection();
			
			stm = conn.prepareStatement("insert into produto (descr,preco) values (?,?)");
			stm.setString(1,obj.getDescription());
			stm.setDouble(2, obj.getPrice());
			stm.executeUpdate();
			
			sttm = conn.createStatement();
			rs = sttm.executeQuery("select max(cdproduto) from produto;");
			rs.next();
			
			int cdProduct = rs.getInt(1);
			obj.setCdProduct(cdProduct);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void read(int cd) throws Exception {
		try {
			
			GetConnection connect = new GetConnection();
			Connection conn = connect.getConnection();
			
			stm = conn.prepareStatement("select descr,preco from produto where cdproduto = ? ");
			stm.setInt(1, cd);
			rs = stm.executeQuery();
			rs.next();
			System.out.println("[Produto: " + rs.getString("descr") + " - Preco: " + rs.getString("preco")+ "]");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(int cd, String toUpdate) throws Exception {
		try {
			
			GetConnection connect = new GetConnection();
			Connection conn = connect.getConnection();
			
			double updateData = Double.parseDouble(toUpdate);
			
			stm = conn.prepareStatement("update produto set preco = ? where cdproduto = ?");
			stm.setDouble(1,updateData);
			stm.setInt(2, cd);
			stm.executeUpdate();
			System.out.println("Produto de Codigo [" + cd + "] foi atualizado");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int cd) throws Exception {
		try {
			
			GetConnection connect = new GetConnection();
			Connection conn = connect.getConnection();
			
			stm = conn.prepareStatement("delete from produto where cdproduto = ?");
			stm.setInt(1, cd);
			stm.executeUpdate();
			System.out.println("Produto de Codigo [" + cd + "] foi deletado");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Product> list() throws Exception {
		try {
			
		GetConnection connect = new GetConnection();
		Connection conn = connect.getConnection();
		
		stm = conn.prepareStatement("select * from produto order by cdproduto");
		rs = stm.executeQuery();
		
		ArrayList<Product> products = new ArrayList<>();
		
		while(rs.next()) {
			String description = rs.getString("descr");
			Float value = rs.getFloat("preco");
			products.add(new Product(description, value));
		}
		
		int x = 0;
		while(x < products.size()) {
			System.out.println("[Produto: " + products.get(x).getDescription() + " - Preco: " + products.get(x).getPrice() + "]");
			x++;
		}
		
		return products;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
