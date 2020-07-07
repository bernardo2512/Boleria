package main;

import java.awt.EventQueue;
import java.sql.Connection;

import connection.GetConnection;
import entityImp.ProductImp;
import entitys.Product;
import view.CadastroClienteView;
import view.SystemView;

public class Main {
	public static void main(String[] args) {
		 try {
			 	GetConnection connect = new GetConnection();
				Connection conn = connect.getConnection();
				
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
	        	System.err.println(ex);
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemView frame = new SystemView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}