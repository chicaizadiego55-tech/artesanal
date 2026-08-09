package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestRecargarJUnit {
	
	@Test
	public void testRecargaExistosa() {
		
		Maquina rubia = new Maquina("Pilsener", "cerveza", 0.02, 8000, 0);
		
		boolean resultado = rubia.recargarCerveza(3000);
		
		assertTrue(resultado);
		assertEquals(3000, rubia.getCantidadAcutal(), 0.0001);
	}
	
	@Test
	public void testRecargaFallidaPorDesborde() {
		
		Maquina negra = new Maquina("Club", "cerveza fria", 0.03, 8000, 0);
		
		negra.recargarCerveza(7000);
		
		boolean resultado = negra.recargarCerveza(1000);
		
		assertTrue(resultado);
		assertEquals(3000, negra.getCantidadAcutal(), 0.0001);
	}
	
}