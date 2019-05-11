package br.com.game.model;

import br.com.game.model.entities.Clube;

/**
 * Classe para instanciar qualquer objeto clube
 * @author Diego Azevedo
 */

public class FactoryClube {

	public static Clube getClube(String nome) {

		return new Clube(nome);

	}
}