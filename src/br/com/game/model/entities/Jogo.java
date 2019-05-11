package br.com.game.model.entities;

import java.util.ArrayList;
import java.util.List;

import br.com.game.control.LogicaPerguntas;
import br.com.game.model.FactoryClube;

/**
 * Classe com os atributos e parâmentros inciais 
 * necessários para um jogo
 * @author Diego Azevedo
 */

public class Jogo {
	
	public static List<Clube> listaNacionais = new ArrayList<>();
	public static List<Clube> listaEstrangeiros = new ArrayList<>();

	public static void iniciar() {
		LogicaPerguntas.getPerguntaInicial();
	}
	
	public static void setTimeInicial(String nacional, String estrangeiro) {
		listaEstrangeiros.add(FactoryClube.getClube(estrangeiro));
		listaNacionais.add(FactoryClube.getClube(nacional));
	}
}
