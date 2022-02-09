package Janelas;
import Ouvintes.*;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public abstract class JanelaMae extends JFrame {
	
	//Atributos
	private String titulo;
	
	//Construtor
	public JanelaMae(String titulo) {
		this.titulo = titulo;
		setTitle("Salão Center");
		setSize(900,640);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(Util.COR_PADRAO_FUNDO);
		setUndecorated(true);
		DragListener.add(this);
		adicionarTitulo();
		adicionarBFechar();
		adicionarBMinimizar();
		adicionarBVoltar();
	}
	
	//Metodos de adição de elementos de layout
	private void adicionarBFechar() {
		JButton fechar = new JButton("X");
		fechar.setForeground(Color.WHITE);
		fechar.setBackground(Util.COR_PADRAO_BFECHAR);
		fechar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN,13));
		OuvinteBotaoFecharClassMae ouvinte = new OuvinteBotaoFecharClassMae(this);
		fechar.addActionListener(ouvinte);
		this.add(fechar);
		fechar.setBounds(850, 17, 36, 36);
	}
	private void adicionarBMinimizar() {
		JButton mini = new JButton("_");
		mini.setForeground(Color.WHITE);
		mini.setBackground(Util.COR_PADRAO_BMINI);
		mini.setFont(new Font("Arial Rounded MT Bold", Font.BOLD,13));
		OuvinteBotaoMinimizarClassMae ouvinte = new OuvinteBotaoMinimizarClassMae(this);
		mini.addActionListener(ouvinte);
		this.add(mini);
		mini.setBounds(810, 17, 36, 36);
	}
	private void adicionarTitulo() {
		JLabel texto = new JLabel(titulo);
		this.add(texto);
		texto.setBounds(0, 35, 900, 80);
		texto.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN,52));
		texto.setForeground(Util.COR_PADRAO_FONTE);
		texto.setHorizontalAlignment(SwingConstants.CENTER);
	}
	protected void adicionarBVoltar() {
		JButton voltar = new JButton(Util.ICONE_VOLTAR);
		voltar.setForeground(Color.WHITE);
		voltar.setBackground(Util.COR_PADRAO_BMINI);
		OuvinteBotaoVoltarJanelasCentral ouvinte = new OuvinteBotaoVoltarJanelasCentral(this);
		voltar.addActionListener(ouvinte);
		this.add(voltar);
		voltar.setBounds(14, 17, 36, 36);
	}
	public void adicionarJLabel(String nome, int xPosicao, int yPosicao, int xLargura) {
		JLabel texto = new JLabel(nome);
		this.add(texto);
		texto.setBounds(xPosicao, yPosicao, xLargura, 30);
		texto.setForeground(Util.COR_PADRAO_FONTE);
	}
}
