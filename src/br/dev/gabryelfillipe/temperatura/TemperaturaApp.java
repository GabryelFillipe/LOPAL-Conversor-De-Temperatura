package br.dev.gabryelfillipe.temperatura;

import br.dev.gabryelfillipe.temperatura.gui.TelaConversor;
import br.dev.gabryelfillipe.temperatura.model.Temperatura;

public class TemperaturaApp {

	public static void main(String[] args) {
		// Chamando a minha tela
		TelaConversor tela = new TelaConversor();
		tela.criarTelaConversor();
	}

}
