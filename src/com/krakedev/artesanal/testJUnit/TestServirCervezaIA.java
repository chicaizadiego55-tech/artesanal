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
		// Valida que si la cantidad solicitada es igual a la cantidad disponible:
		// 1. La maquina sirve correctamente.
		// 2. La cantidad actual queda en cero.
		// 3. Retorna el valor correcto a pagar.

		Maquina maquina = new Maquina(
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
		// Valida que si la maquina no tiene suficiente cerveza:
		// 1. No sirve nada.
		// 2. Retorna 0.
		// 3. No modifica la cantidad actual.

		Maquina maquina = new Maquina(
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
	public void testServirCervezaUsandoConstructorConTresParametros() {
		// Valida el metodo servirCerveza usando el segundo constructor.
		// Este constructor inicia la cantidad actual en 0.
		// Luego se recarga cerveza usando un metodo disponible de la clase.
		// Finalmente se valida que pueda servir correctamente.

		Maquina maquina = new Maquina(
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
	public void testServirCervezaConConstructorTresParametrosSinRecargar() {
		// Valida que usando el constructor de tres parametros,
		// la maquina inicia sin cerveza disponible.
		// Si se intenta servir, debe retornar 0 y no modificar la cantidad actual.

		Maquina maquina = new Maquina(
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
		// Valida que si el cliente solicita 0 ml:
		// 1. No se cobra nada.
		// 2. La cantidad actual no cambia.

		Maquina maquina = new Maquina(
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