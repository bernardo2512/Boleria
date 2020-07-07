package view;

import javax.swing.*;

import interfaceView.InterfaceView;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SystemView extends JFrame implements InterfaceView{

	private static final long serialVersionUID = 1L;
	private static JLayeredPane layeredPane = new JLayeredPane();
	private JMenuBar menuBar = new JMenuBar();
	
	private CadastroClienteView clientView = new CadastroClienteView();
	private CadastroProdutoView produtoView = new CadastroProdutoView();
//
//	private RegisterProductView registerProductView = new RegisterProductView();
//	private static RegisterPersonView personView = new RegisterPersonView();
//	private RegisterFuncView funcView = new RegisterFuncView();
//	private FuncionarioControlView funcControllView = new FuncionarioControlView();
	
	private JMenuItem mntmCliente = new JMenuItem("Cliente");
	private JMenuItem mntmProduto = new JMenuItem("Produto");
	private JMenuItem mntmVendaDeProdutos = new JMenuItem("Venda de Produtos");
	private JMenuItem mntmEstoque = new JMenuItem("Relatorios");


	private JMenu mnCadastro = new JMenu("Cadastro");
	private JMenu mnVendas = new JMenu("Venda");
	private JMenu mnConsulta = new JMenu("Relatorios");
	private JMenu mnAgenda = new JMenu("Agenda");

	
	public SystemView() {
		setSettingsView();
		setBtnListeners();
	}
	
	@Override
	public void setTable() {
		
	}
	
	@Override
	public void setSettingsView () {
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(960, 600);
		
		menuBar.setBounds(0, 0, 960, 21);
		contentPane.add(menuBar);
		
		menuBar.add(mnCadastro);
		menuBar.add(mnAgenda);
		
		mnCadastro.add(mntmCliente);
		mnCadastro.add(mntmProduto);
		
		menuBar.add(mnVendas);
		
		mnVendas.add(mntmVendaDeProdutos);
		
		menuBar.add(mnConsulta);
		
		mnConsulta.add(mntmEstoque);

		
		layeredPane.setBounds(10, 32, 940, 560);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
				
		layeredPane.add(clientView, "clienteView");
		layeredPane.add(produtoView, "produtoView");
//		layeredPane.add(registerProductView, "registerView");
//		layeredPane.add(stockView, "stockView");	
//		layeredPane.add(funcView, "funcView");
		
		getContentPane().add(contentPane);
	}
	
	@Override
	public void setBtnListeners () {
		mntmCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(clientView);
				
			}
		});		
		
		mntmProduto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switchPanels(produtoView);				
			}
		});
//		
//		mntmEstoque.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				switchPanels(stockView);				
//			}
//		});
//		
//		mntmPessoa.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				switchPanels(personView);				
//			}
//		});
//		
//		mntmFuncionrio.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				switchPanels(funcView);				
//			}
//		});
//		
//		mntmFuncionario.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				switchPanels(funcControllView);				
//			}
//		});
	}
	
//	public static void pessoaClick() {
//		switchPanels(personView);			
//	}
//	
	public static void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();		
	}		
}