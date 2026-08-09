package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestServirCervezaIA {

	private static final double TOLERANCIA = 0.0001;

	@Test
	public void testServirCervezaCuandoHayCantidadSuficiente() {

		Maquina maquina = new Maquina(
				"M001",
				"Rubia",
				"Cerveza artesanal rubia",
				0.05,
				10000,
				5000
		);

		double valorAPagar = maquina.servirCerveza(1000);

		assertEquals(50, valorAPagar, TOLERANCIA);
		assertEquals(4000, maquina.getCantidadAcutal(), TOLERANCIA);
	}

	@Test
	public void testServirCervezaCuandoCantidadEsExactamenteIgualALaDisponible() {

		Maquina maquina = new Maquina(
				"M002",
				"Negra",
				"Cerveza artesanal negra",
				0.08,
				10000,
				2000
		);

		double valorAPagar = maquina.servirCerveza(2000);

		assertEquals(160, valorAPagar, TOLERANCIA);
		assertEquals(0, maquina.getCantidadAcutal(), TOLERANCIA);
	}

	@Test
	public void testServirCervezaCuandoNoHayCantidadSuficiente() {

		Maquina maquina = new Maquina(
				"M003",
				"Roja",
				"Cerveza artesanal roja",
				0.06,
				10000,
				500
		);

		double valorAPagar = maquina.servirCerveza(1000);

		assertEquals(0, valorAPagar, TOLERANCIA);
		assertEquals(500, maquina.getCantidadAcutal(), TOLERANCIA);
	}

	@Test
	public void testServirCervezaUsandoConstructorConCuatroParametros() {

		Maquina maquina = new Maquina(
				"M004",
				"IPA",
				"Cerveza artesanal IPA",
				0.10
		);

		boolean recargaExitosa = maquina.recargarCerveza(3000);

		double valorAPagar = maquina.servirCerveza(1500);

		assertTrue(recargaExitosa);
		assertEquals(150, valorAPagar, TOLERANCIA);
		assertEquals(1500, maquina.getCantidadAcutal(), TOLERANCIA);
	}

	@Test
	public void testServirCervezaConConstructorCuatroParametrosSinRecargar() {

		Maquina maquina = new Maquina(
				"M005",
				"Stout",
				"Cerveza artesanal stout",
				0.12
		);

		double valorAPagar = maquina.servirCerveza(500);

		assertEquals(0, valorAPagar, TOLERANCIA);
		assertEquals(0, maquina.getCantidadAcutal(), TOLERANCIA);
	}

	@Test
	public void testServirCervezaConCantidadCero() {

		Maquina maquina = new Maquina(
				"M006",
				"Porter",
				"Cerveza artesanal porter",
				0.07,
				10000,
				2500
		);

		double valorAPagar = maquina.servirCerveza(0);

		assertEquals(0, valorAPagar, TOLERANCIA);
		assertEquals(2500, maquina.getCantidadAcutal(), TOLERANCIA);
	}
}