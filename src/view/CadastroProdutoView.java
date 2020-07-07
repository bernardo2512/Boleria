package view;

import javax.swing.JPanel;

import interfaceView.InterfaceView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entityImp.ProductImp;
import entitys.Product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class CadastroProdutoView extends JPanel implements InterfaceView{
	private JTextField textPreco;
	private JTextField textDescr;
	private JButton buttonSend;

	/**
	 * Create the panel.
	 */
	public CadastroProdutoView() {
		setSettingsView();
		setBtnListeners();
	}

	@Override
	public void setSettingsView() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO DE PRODUTO");
		lblNewLabel.setBounds(383, 67, 180, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Descri\u00E7\u00E3o:");
		lblNewLabel_1.setBounds(220, 179, 95, 14);
		add(lblNewLabel_1);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(437, 179, 50, 14);
		add(lblPreo);
		
		textPreco = new JTextField();
		textPreco.setBounds(489, 175, 86, 24);
		add(textPreco);
		textPreco.setColumns(10);
		
		textDescr = new JTextField();
		textDescr.setColumns(10);
		textDescr.setBounds(304, 175, 115, 24);
		add(textDescr);
		
		buttonSend = new JButton("Cadastrar");
		buttonSend.setBounds(401, 343, 105, 28);
		add(buttonSend);
		
		
	}

	@Override
	public void setBtnListeners() {
		buttonSend.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProductImp productImp = new ProductImp();
				try {
					productImp.create(new Product(textDescr.getText(),Double.parseDouble(textPreco.getText())));
					JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
				} catch (Exception e1){
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar o produto");
				}finally{
					clearTextField();
				}
				
			}
		});
		
	}

	@Override
	public void setTable() {
		
	}
	public void clearTextField() {
		textDescr.setText("");
		textPreco.setText("");
		
	}
}
