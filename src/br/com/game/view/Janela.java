package br.com.game.view;

import javax.swing.JOptionPane;

import br.com.game.model.entities.Clube;

/**
 * Classe com as definições das janelas apresentadas
 * @author Diego Azevedo
 */

public class Janela {
	
	private static String titulo = "Informe";

	static public Integer janelaSimNao(String mensagem) {

		return JOptionPane.showConfirmDialog(null, mensagem, titulo, 
				JOptionPane.YES_NO_OPTION);
	}
	
	static public Integer janelaSimNao(String mensagem, Clube clube) {

		return JOptionPane.showConfirmDialog(null, mensagem + " " + clube + "?", titulo, 
				JOptionPane.YES_NO_OPTION);
	}

	static public void janelaSaida(String mensagem) {

		JOptionPane.showMessageDialog(null, mensagem);
	}
	
	static public String janelaEntrada(String mensagem) {

		return JOptionPane.showInputDialog(null, mensagem);
	}
	

}