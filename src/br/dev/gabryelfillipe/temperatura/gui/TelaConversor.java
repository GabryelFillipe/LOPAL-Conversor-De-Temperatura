package br.dev.gabryelfillipe.temperatura.gui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import br.dev.gabryelfillipe.temperatura.model.Temperatura;

public class TelaConversor {

	private JTextField textCelsius;
	private JLabel labelCelsius;
	private JButton buttonKelvin;
	private JButton buttonFahrenheit;
	private JLabel labelResultado;
	private JLabel labelMensagemErro;
	
	public void criarTelaConversor() {
		// Criando a minha tela.
		JFrame tela = new JFrame();
		tela.setTitle("Conversor De Temperatura");
		tela.setSize(430, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		
		// Obtendo a referecia do painel de conteudo da tela.
		Container container = tela.getContentPane();
		// Obtendo referencia da fonte e tamanho que sera utilizada .
		Font minhaFonte = new Font("Bold", Font.BOLD, 32);
		
		//  Criar o label Celsius.
		labelCelsius = new JLabel();
		labelCelsius.setText("Temperatura em graus Celsius:");
		labelCelsius.setBounds(20, 30, 300, 50);
		
		
		textCelsius = new JTextField();
		textCelsius.setBounds(20, 70, 390, 30);
		
		// Criando os botões.
		buttonFahrenheit = new JButton();
		buttonFahrenheit.setText("Fahrenheit");
		buttonFahrenheit.setBounds(20, 110, 185, 30);
		
		buttonFahrenheit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			String celsius = textCelsius.getText();
			
			double celsiusDouble = Double.parseDouble(celsius);
			
			Temperatura temperatura = new Temperatura();
			temperatura.setCelsius(celsiusDouble);
			
			double temperaturaResult = temperatura.converterParaFahrenheit();
			
			
			}
		});
		
		buttonKelvin = new JButton();
		buttonKelvin.setText("Kelvin");
		buttonKelvin.setBounds(215, 110, 185, 30);
		
		// Criando o label resultado.
		labelResultado = new JLabel();
		labelResultado.setText("Teste!!!");
		labelResultado.setBounds(150, 140, 205, 50);
		labelResultado.setFont(minhaFonte);
		
		// Adicionando os containers.
		container.add(labelCelsius);
		container.add(buttonFahrenheit);
		container.add(buttonKelvin);
		container.add(labelResultado);
		container.add(textCelsius);
		container.add(labelResultado);
		
		
		tela.setVisible(true);
	}
}
