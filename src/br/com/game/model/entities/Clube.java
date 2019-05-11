package br.com.game.model.entities;

/**
 * Classe de objetos do tipo Clube
 * @author Diego Azevedo
 */

public class Clube {
	String nome;

	public Clube(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}
	
}