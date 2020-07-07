package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entityImp.AddressImp;
import entityImp.ClientImp;
import entityImp.PhoneImp;
import entitys.Address;
import entitys.Client;
import entitys.Phone;
import interfaceView.InterfaceView;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class CadastroClienteView extends JPanel implements InterfaceView{

	private JTextField textNameSurname;
	private JTextField textDDD;
	private JTextField textNumberPhone;
	private JTextField textAdress;
	private JTextField textNumberAdress;
	private JTextField textCepAdress;
	private JTextField textNeighborhoods;
	private JButton btnCadastrar;
	private JComboBox<String> comboTypePhone;
	
	public CadastroClienteView() {
		setSettingsView();
		setBtnListeners();
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void setSettingsView() {
		setLayout(null);
		
		
		JLabel lblNomeESobrenome = new JLabel("Nome e Sobrenome:");
		lblNomeESobrenome.setBounds(211, 136, 156, 16);
		this.add(lblNomeESobrenome);
		
		textNameSurname = new JTextField();
		textNameSurname.setBounds(370, 131, 124, 28);
		this.add(textNameSurname);
		textNameSurname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("DDD:");
		lblNewLabel.setBounds(186, 219, 55, 16);
		this.add(lblNewLabel);
		
		textDDD = new JTextField();
		textDDD.setBounds(244, 213, 55, 28);
		this.add(textDDD);
		textDDD.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("N\u00FAmero:");
		lblNewLabel_1.setBounds(310, 219, 73, 16);
		this.add(lblNewLabel_1);
		
		textNumberPhone = new JTextField();
		textNumberPhone.setBounds(372, 213, 122, 28);
		this.add(textNumberPhone);
		textNumberPhone.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo do contato:");
		lblNewLabel_2.setBounds(498, 219, 116, 16);
		this.add(lblNewLabel_2);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(383, 412, 111, 28);
		this.add(btnCadastrar);
		
		
		comboTypePhone = new JComboBox();
		comboTypePhone.setModel(new DefaultComboBoxModel(new String[] {"RES", "PES", "COM"}));
		comboTypePhone.setBounds(604, 214, 60, 26);
		this.add(comboTypePhone);
		
		JLabel lblNewLabel_3 = new JLabel("CADASTRO DE CLIENTE");
		lblNewLabel_3.setBounds(357, 35, 156, 16);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Rua:");
		lblNewLabel_4.setBounds(115, 296, 55, 16);
		add(lblNewLabel_4);
		
		textAdress = new JTextField();
		textAdress.setColumns(10);
		textAdress.setBounds(153, 291, 191, 28);
		add(textAdress);
		
		JLabel lblN = new JLabel("N\u00B0:");
		lblN.setBounds(357, 296, 30, 16);
		add(lblN);
		
		textNumberAdress = new JTextField();
		textNumberAdress.setColumns(10);
		textNumberAdress.setBounds(378, 291, 55, 28);
		add(textNumberAdress);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(436, 297, 43, 16);
		add(lblCep);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(591, 296, 64, 16);
		add(lblBairro);
		
		textCepAdress = new JTextField();
		textCepAdress.setColumns(10);
		textCepAdress.setBounds(475, 291, 98, 28);
		add(textCepAdress);
		
		textNeighborhoods = new JTextField();
		textNeighborhoods.setColumns(10);
		textNeighborhoods.setBounds(654, 291, 98, 28);
		add(textNeighborhoods);
		
	}


	@Override
	public void setBtnListeners() {
		btnCadastrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ClientImp clientImp = new ClientImp();
				PhoneImp phoneImp = new PhoneImp();
				AddressImp adressImp = new AddressImp();
				
				
				try {
					clientImp.create(new Client(textNameSurname.getText()));
					phoneImp.create(new Phone(comboTypePhone.getSelectedItem().toString(),textDDD.getText(),textNumberPhone.getText(),clientImp.getLestIdClientCreated()));
					adressImp.create(new Address(textAdress.getText(),textNumberAdress.getText(),textCepAdress.getText(),textNeighborhoods.getText(),clientImp.getLestIdClientCreated()));
					JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!");
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}finally {
					clearTextField();
				}
				
				
				
				
				
			}
		});
		
	}


	@Override
	public void setTable() {
		// TODO Auto-generated method stub
		
	}
	public void clearTextField() {
		textNameSurname.setText("");
		textDDD.setText("");
		textNumberPhone.setText("");
		textAdress.setText("");
		textNumberAdress.setText("");
		textCepAdress.setText("");
		textNeighborhoods.setText("");
		
		
	}
}
