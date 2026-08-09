package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestAtributos {

	public static void main(String[] args) {
		
		Maquina rubia = new Maquina("M001", "Pilsener", "cerveza rubia", 0.02, 10000, 0);
		
		rubia.imprimir();
		
		rubia.setNombreCerveza("Golden Ale");
		rubia.setDescripcion("Cerveza con aroma mas intenso");
		rubia.imprimir();
		
		System.out.println("Codigo de la maquina: " + rubia.getCodigo());
		
	}

}