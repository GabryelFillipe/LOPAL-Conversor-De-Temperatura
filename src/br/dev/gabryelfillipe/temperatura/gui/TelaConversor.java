package br.dev.gabryelfillipe.temperatura.gui;

import java.awt.Color;
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
		Font fonteResultado = new Font("Bold", Font.BOLD, 24);
		Font fonteErro = new Font("Bold", Font.BOLD, 18);
		
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
			if (!(celsius.indexOf(",") == -1)) { // Substituindo virgula por ponto
				celsius = celsius.replace(",", ".");
			}
			if (!(celsius.indexOf(" ") == -1)) { // Removendo espaços em branco
				celsius = celsius.replace(" ", "");
			}
			String mensagemDeErro = "none";
			
			
			
			
			Temperatura temperatura = new Temperatura();
			temperatura.setCelsius(Double.parseDouble(celsius));
			temperatura.converterParaFahrenheit();
			double fahrenheit = temperatura.converterParaFahrenheit();
			String resultado = fahrenheit+"fahrenheit";//transformando o fahrenheit em string

			labelResultado.setText(resultado); // Tornando a temperatura visivel.
			
			
			
			}
		});
		
		buttonKelvin = new JButton();
		buttonKelvin.setText("Kelvin");
		buttonKelvin.setBounds(215, 110, 185, 30);
		
		buttonKelvin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				String celsius = textCelsius.getText();
				if (!(celsius.indexOf(",") == -1)) { // Substituindo virgula por ponto
					celsius = celsius.replace(",", ".");
				}
				if (!(celsius.indexOf(" ") == -1)) { // Removendo espaços em branco
					celsius = celsius.replace(" ", "");
				}
				String mensagemDeErro = "none";
				
				
				
				Temperatura temperatura = new Temperatura();
				temperatura.setCelsius(Double.parseDouble(celsius));
				temperatura.converterParaKelvin();
				double kelvin = temperatura.converterParaKelvin();
				String resultado = kelvin+"kelvin"; //transformando o kelvin em string
				labelResultado.setText(resultado); // Tornando a temperatura visivel.
				
			}
		});
		
		
		// Criando o label resultado.
		labelResultado = new JLabel();

		labelResultado.setBounds(150, 150, 250, 50);
		labelResultado.setFont(fonteResultado);
		
		
		labelMensagemErro = new JLabel();
		labelMensagemErro.setBounds(150, 170, 250, 100);
		labelMensagemErro.setForeground(Color.red);
		labelMensagemErro.setText("teste");
		labelMensagemErro.setFont(fonteErro);
		
		
		// Adicionando os containers.
		container.add(labelCelsius);
		container.add(buttonFahrenheit);
		container.add(buttonKelvin);
		container.add(labelResultado);
		container.add(textCelsius);
		container.add(labelResultado);
		container.add(labelMensagemErro);
		
		
		tela.setVisible(true);
	}
}
