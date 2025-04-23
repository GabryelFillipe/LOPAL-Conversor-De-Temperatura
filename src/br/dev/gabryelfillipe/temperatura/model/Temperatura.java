package br.dev.gabryelfillipe.temperatura.model;

public class Temperatura {
	
	private double celsius;
	
	
	
	public double getCelsius() {
		return celsius;
	}
	
	public void setCelsius(double celsius) {
		this.celsius = celsius;
	}
	// Criando o conversor para Kelvin somando 273.15 ao celsius.
	public double converterParaKelvin() {
		double kelvin = celsius + 273.15;
		return kelvin;
	}
	//Criando o conversor para Fahrenheit multiplicando o celsius por 9/5 e somando 32 após.
	public double converterParaFahrenheit() {
		double fahrenheit = (celsius * 9/5) +32;
		return  fahrenheit;
	}
}

