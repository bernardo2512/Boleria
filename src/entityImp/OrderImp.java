package entityImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connection.GetConnection;
import entityDAO.EntityDAO;
import entitys.Order;

public class OrderImp implements EntityDAO<Order> {
	private PreparedStatement stm;
	private ResultSet rs;
	private java.sql.Statement sttm;
	
	@Override
	public void create(Order obj) throws Exception {
		try {
			GetConnection connect = new GetConnection();
			Connection conn = connect.getConnection();
			
			stm = conn.prepareStatement("insert into pedido (cdproduto, quantidade, valor_venda, cdagenda) values (?, ?, ?, ?)");
			stm.setInt(1,obj.getCdProduct());
			stm.setInt(2, obj.getAmount());
			stm.setDouble(3, obj.getSalePrice());
			stm.setInt(4, obj.getCdSchedule());
			stm.executeUpdate();
			
			sttm = conn.createStatement();
			rs = sttm.executeQuery("select max(cdpedido) from pedido;");
			rs.next();
			
			int cdOrder = rs.getInt(1);
			obj.setCdOrder(cdOrder);
			System.out.println("Pedido criado com sucesso!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void read(int cd) throws Exception {
		try {
			GetConnection connect = new GetConnection();
			Connection conn = connect.getConnection();
			
			stm = conn.prepareStatement("select cdproduto, quantidade, valor_venda, cdagenda from pedido where cdpedido = ? ");
			stm.setInt(1, cd);
			rs = stm.executeQuery();
			rs.next();
			
			System.out.println("[Codigo do produto: " + rs.getInt("cdproduto") + " - Quantidade: " + rs.getInt("quantidade") + " Valor da venda: " + rs.getDouble("valor_venda") + " Código da agenda: " + rs.getInt("cdagenda") + "]");
		} catch(Exception e) {
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
			
			stm = conn.prepareStatement("delete from pedido where cdpedido = ?");
			stm.setInt(1, cd);
			stm.executeUpdate();
			System.out.println("Pedido de Codigo [" + cd + "] foi Deletado");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Order> list() throws Exception {
		GetConnection connect = new GetConnection();
		Connection conn = connect.getConnection();
		
		stm = conn.prepareStatement("select * from pedido order by cdpedido");
		rs = stm.executeQuery();
		
		ArrayList<Order> orders = new ArrayList<>();
		
		while(rs.next()) {
			int cdProduct = rs.getInt("cdproduto");
			int amount = rs.getInt("quantidade");
			double salePrice = rs.getDouble("valor_venda");
			int cdSchedule = rs.getInt("cdagenda");
			
			orders.add(new Order(cdProduct, cdSchedule, amount, salePrice));
		}
		
		int x = 0;
		while(x < orders.size()) {
			System.out.println("[Codigo do produto: " + orders.get(x).getCdProduct() + " - Quantidade: " + orders.get(x).getAmount() + " Valor da venda: " + orders.get(x).getSalePrice() + " Código da agenda: " + orders.get(x).getCdSchedule() + "]");
			x++;
		}
		
		return orders;
	}

}
