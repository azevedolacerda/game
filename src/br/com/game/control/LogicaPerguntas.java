package br.com.game.control;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.game.model.FactoryClube;
import br.com.game.model.entities.Clube;
import br.com.game.model.entities.Jogo;
import br.com.game.view.Janela;

/**
 * Classe com as lógicas e métodos das perguntas dividas em 3 fases:
 * Pergunta inicial, define a nacionalidade e adivinha ou obtém um time
 * @author Diego Azevedo
 */

public class LogicaPerguntas {
	
	/* 
	 * Pergunta incial se gosta ou não de futebol
	 */
	public static void getPerguntaInicial() {
		Integer respostaInicial = null;
		
		respostaInicial = Janela.janelaSimNao("Você gosta de futebol?");

		//Mantém o jogo equanto o usuário desejar
		while (respostaInicial < 1) {
			if (!LogicaPerguntas.getPerguntaNacionalidade(0)) {
				break;
			}
		}

		//Sai do jogo
		if (respostaInicial == 1) {
			Janela.janelaSaida("Que pena");
		}
	}
	
	/* 
	 * Pergunta se o time é estrageiro e chama o outro método referente
	 */
	private static Boolean getPerguntaNacionalidade(Integer indice) {
		Integer resposta = null;
		
		if (Janela.janelaSimNao("Pense em um time qualquer de futebol.") == 1) {
			return false;
		}

		resposta = Janela.janelaSimNao("Este clube é estrangeiro?");

		//Chama o próximo método referente a resposta dada
		if (resposta == 0) {
			return getPerguntaTime(indice, Jogo.listaEstrangeiros);
		} else {
			return getPerguntaTime(indice, Jogo.listaNacionais);
		}

	}

	/* 
	 * Define o time ou adiciona um novo a lista
	 */
	private static Boolean getPerguntaTime(Integer indice, List<Clube> lista) {
		Integer resposta = null;
		
		resposta = Janela.janelaSimNao("Este clube é o", lista.get(indice));

		//Volta a tela inicial ou insere um novo time
		if (resposta == 0) {
			Janela.janelaSaida("Adivinhei o time!");
			return true;
		} else {

			resposta = Janela.janelaSimNao("Seu clube pensado é melhor que o", lista.get(indice));
			
			//Caso esteja no final da lista adicionará o time melhor informado
			if(resposta == 1) {
				String novoClube = Janela.janelaEntrada("Em qual clube você pensou?");
				lista.add(indice, FactoryClube.getClube(novoClube));
				return true;
			}
			
			//Percorrerá recursivamente a lista seguindo para o próximo melhor time
			if (lista.size() > ++indice) {
				getPerguntaTime(indice, lista);
			} 
			else {

				String novoClube = Janela.janelaEntrada("Em qual clube você pensou?");
				
				 /* Se o time pensado for melhor: é adicionado abaixo da posição atual, 
				    senão é adicionado na posição atual */
				if (resposta == 0) {
					lista.add(indice, FactoryClube.getClube(novoClube));
				}else {
					lista.add(indice-1, FactoryClube.getClube(novoClube));
				}
				
			}
			
		//Volta ao início do jogo
		return true;
		}
	}

}