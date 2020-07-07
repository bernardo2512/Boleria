package entityImp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connection.GetConnection;
import entityDAO.EntityDAO;
import entitys.Order;
import entitys.Schedule;

public class ScheduleImp implements EntityDAO<Schedule> {
	private PreparedStatement stm;
	private ResultSet rs;
	private java.sql.Statement sttm;
	
	@Override
	public void create(Schedule obj) throws Exception {
		try {
			GetConnection connect = new GetConnection();
			Connection conn = connect.getConnection();
			
			stm = conn.prepareStatement("insert into agenda (data_entrega, data_pagamento, pendente, cdcliente) values (?, ?, ?, ?)");
			stm.setString(1, obj.getDeliveryDate());
			stm.setString(2, obj.getPayday());
			stm.setBoolean(3, obj.isPending());
			stm.setInt(4, obj.getCdClient());
			stm.executeUpdate();
			
			sttm = conn.createStatement();
			rs = sttm.executeQuery("select max(cdagenda) from agenda;");
			rs.next();
			
			int cdSchedule = rs.getInt(1);
			obj.setCdSchedule(cdSchedule);
			System.out.println("Pedido adicionado a agenda!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void read(int cd) throws Exception {
		try {
			GetConnection connect = new GetConnection();
			Connection conn = connect.getConnection();
			
			stm = conn.prepareStatement("select cdagenda, data_entrega, data_pagamento, pendente, cdcliente from agenda where cdagenda = ? ");
			stm.setInt(1, cd);
			rs = stm.executeQuery();
			rs.next();
			
			System.out.println("[Codigo do agenda: " + rs.getInt("cdagenda") + " Data da entrega: " + rs.getString("data_entrega") + " Data do pagamento: " + rs.getString("data_pagamento") + " Código do cliente: " + rs.getInt("cdcliente") + "]");
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
			
			stm = conn.prepareStatement("delete from agenda where cdagenda = ?");
			stm.setInt(1, cd);
			stm.executeUpdate();
			System.out.println("Agenda de Codigo [" + cd + "] foi Deletada");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Schedule> list() throws Exception {
		GetConnection connect = new GetConnection();
		Connection conn = connect.getConnection();
		
		stm = conn.prepareStatement("select * from agenda order by cdagenda");
		rs = stm.executeQuery();
		
		ArrayList<Schedule> schedules = new ArrayList<>();
		
		while(rs.next()) {
			String deliveryDate = rs.getString("data_entrega");
			String payDay = rs.getString("data_pagamento");
			boolean pending = rs.getBoolean("pendente");
			int cdClient = rs.getInt("ccliente");
			
			schedules.add(new Schedule(deliveryDate, payDay, pending, cdClient));
		}
		
		int x = 0;
		while(x < schedules.size()) {
			System.out.println("[Data da entrega: " + schedules.get(x).getDeliveryDate() + " Data do pagamento: " + schedules.get(x).getPayday() + " Esta pendente? : " + schedules.get(x).isPending() + " Código do cliente: " + schedules.get(x).getCdClient() + "]");
			x++;
		}
		
		return schedules;
	}

}
