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
		tela.setSize(430, 400);
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
			try {

				labelMensagemErro.setVisible(false);
				String celsius = textCelsius.getText();
				String celsius1 = celsius.replace(",", ".");
				double celsiusDouble = Double.parseDouble(celsius1);
				
				
				if(celsiusDouble >= -271.5) {
					
					Temperatura temperatura = new Temperatura();
					temperatura.setCelsius(Double.parseDouble(celsius));
					temperatura.converterParaFahrenheit();
					double fahrenheit = temperatura.converterParaFahrenheit();
					String resultado = fahrenheit+" Fahrenheit";//transformando o fahrenheit em string

					labelResultado.setText(resultado); // Tornando a temperatura visivel.
					
				}else {
					labelResultado.setVisible(false);
					// Deixando o resultado invisível
					labelMensagemErro.setBounds(50, 140, 370, 60);
					// Definindo localização da mensagem de erro
					labelMensagemErro.setText("DIGITE UM VALOR CELSIUS VALIDO");
					// Definindo mensagem de erro
					labelMensagemErro.setVisible(true);
				}
			
			}catch(NumberFormatException erro) {
				labelResultado.setVisible(false);
				// Quando ocorrer um erro o resultado anterior ficará invisível
				labelMensagemErro.setBounds(50, 160, 370, 90);
				// Definindo localização da mensagem de erro
				labelMensagemErro.setText("<html><body style='width: 250px'>FORMATO DIGITADO INVALIDO, O VALOR DE CELSIUS DEVE SER UM NUMERO");
				// Verificando se celsius é valido para realizar a conversão se não exibir uma
				// mensagem de erro
			
				labelMensagemErro.setVisible(true);
				// Quando os comandos no try não poderem ser executados o labelMensagemErro será
				// visivel

			}
			}
		});
		
		buttonKelvin = new JButton();
		buttonKelvin.setText("Kelvin");
		buttonKelvin.setBounds(215, 110, 185, 30);
		
		buttonKelvin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					labelMensagemErro.setVisible(false);
					String celsius = textCelsius.getText();
					String celsius1 = celsius.replace(",", ".");
					double celsiusDouble = Double.parseDouble(celsius1);
					
					
					if(celsiusDouble >= -271.5) {
						Temperatura temperatura = new Temperatura();
						temperatura.setCelsius(Double.parseDouble(celsius1));
						temperatura.converterParaKelvin();
						double kelvin = temperatura.converterParaKelvin();
						String resultado = kelvin+" Kelvin"; //transformando o kelvin em string
						labelResultado.setText(resultado); // Tornando a temperatura visivel.
						labelResultado.setVisible(true);
					}else {
						labelResultado.setVisible(false);
						// Deixando o resultado invisível
						labelMensagemErro.setBounds(50, 140, 370, 60);
						// Definindo localização da mensagem de erro
						labelMensagemErro.setText("DIGITE UM VALOR CELSIUS VALIDO");
						// Definindo mensagem de erro
						labelMensagemErro.setVisible(true);
					}
					
					textCelsius.requestFocus();
				}catch (NumberFormatException erro) {
					labelResultado.setVisible(false);
					// Quando ocorrer um erro o resultado anterior ficará invisível
					labelMensagemErro.setBounds(50, 160, 370, 90);
					// Definindo localização da mensagem de erro
					labelMensagemErro.setText("<html><body style='width: 250px'>FORMATO DIGITADO INVALIDO, O VALOR DE CELSIUS DEVE SER UM NUMERO");
					// Verificando se celsius é valido para realizar a conversão se não exibir uma
					// mensagem de erro
					
					labelMensagemErro.setVisible(true);
					// Quando os comandos no try não poderem ser executados o labelMensagemErro será
					// visivel

				}
				
				
				
			
				
			}
		});
		
		
		// Criando o label resultado.
		labelResultado = new JLabel();

		labelResultado.setBounds(100, 150, 250, 50);
		labelResultado.setFont(fonteResultado);
		
		
		labelMensagemErro = new JLabel();
		labelMensagemErro.setForeground(Color.red);
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
