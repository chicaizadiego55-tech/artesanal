package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestRecargarJUnit {
	
	@Test
	public void testRecargaExistosa() {
		
		Maquina rubia = new Maquina("M001", "Pilsener", "cerveza", 0.02, 8000, 0);
		
		boolean resultado = rubia.recargarCerveza(3000);
		
		assertTrue(resultado);
		assertEquals(3000, rubia.getCantidadAcutal(), 0.0001);
	}
	
	@Test
	public void testRecargaFallidaPorDesborde() {
		
		Maquina negra = new Maquina("M002", "Club", "cerveza fria", 0.03, 8000, 0);
		
		negra.recargarCerveza(7000);
		
		boolean resultado = negra.recargarCerveza(1000);
		
		assertFalse(resultado);
		assertEquals(7000, negra.getCantidadAcutal(), 0.0001);
	}
	
}