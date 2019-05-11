/*
* Data de criação: 09/05/2019
* Jogo de adivinhação no qual são armazenado nomes
* de clubes de futebol em uma lista ordernada do pior
* time para o melhor.
*
*/

package br.com.game;

import br.com.game.model.entities.Jogo;

/**
 * Classe principal para iniciar o jogo
 * @author Diego Azevedo
 */

public class Programa {

	public static void main(String[] args) {
		
		Jogo.setTimeInicial("Flamengo", "Barcelona");
		Jogo.iniciar();
		
	}
}