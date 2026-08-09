package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestCodigoJUnit {

	@Test
	public void testCodigoMaquina() {
		
		Maquina rubia = new Maquina("M001", "Pilsener", "cerveza", 0.02, 8000, 0);
		
		assertEquals("M001", rubia.getCodigo());
		
	}
	
}
