/* ALUNO - Henrique Souza Lima
 * 
 * --------------------------  ATIVIDADE P�G38 SEMAPHORE-------------------------------------
 * Voc� foi contratado para automatizar um treino de f�ruma 1. As regras estabelecidas
 * pela dire��o das provas s�o simples:
 *		1 - No m�ximo 5 carros dos 7 times (14 carros no total) presentes
 *			podem entrar na pista simult�neamente, mas apenas um carro de cada equipe. 
 *		2 - O segundo carro deve ficar � espera, caso um companheiro de equipe j� esteja 
 *		    na pista.
 *      3 - Cada piloto deve dar tr�s voltas na pista.
 *      4 - O tempo de cada volta dever� ser exibido e a volta mais r�pida de cada piloto 
 *      	deve ser armazenada para, no final, exibir o grid de largada, ordenado do menor
 *      	tempo para o maior.	
*/

package controller;

import java.util.concurrent.Semaphore;
import java.util.Random;
import java.math.*;

public class ThreadSemaforoFormula1 extends Thread {
	private int idCarro;
	private Semaphore controlelargada;
	private double tempoVolta = 0;
	private double tempoCorrida = 0;

	// ------------------ CONSTRUTOR -----------------------------
	public ThreadSemaforoFormula1(int idCarro, Semaphore controlelargada) {
		this.idCarro = idCarro;
		this.controlelargada = controlelargada;
	}

	// --------------------- M�TODO RUN THREADS ------------------------
	public void run() {
		Largada();
		try {
			controlelargada.acquire();
			CarroAndando();
		} catch (InterruptedException e) {

			e.printStackTrace();
		} finally {
			controlelargada.release();
			Libera();
		}
	}

	// --------------------------- M�TODO LARGADA --------------------------
	public void Largada() {

		if (idCarro <= 14) {
			System.out.println("### PRONTO PARA LARGADA Carro #" + idCarro);
		}

	}

	// ------------------------- M�TODO CORRIDA ----------------------------
	public void CarroAndando() {

		int distanciaPista = 1000;
		int distanciaPercorrida = 0;
		int deslocamento = 250;
		int tempo = 10;

		for (int volta = 1; volta <= 3; volta++) {
			while (distanciaPercorrida < distanciaPista) {
				distanciaPercorrida = distanciaPercorrida + deslocamento;
				try {
					sleep(tempo);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				tempoVolta = tempoVolta + (double) 1 + (Math.random() * 1);

				System.out.println("Carro #" + idCarro + " andou: " + distanciaPercorrida + " metros.");
				if (distanciaPercorrida == 1000) {
					tempoVolta = Math.round(tempoVolta * 100);
					System.out.println("Carro #" + idCarro + " Deu a " + volta + "� volta em " + (tempoVolta/10) + " seg.");

				}

			}
			distanciaPercorrida = 0;
			tempoCorrida = tempoCorrida + tempoVolta;
			tempoVolta = 0;

		}
		System.out.println(" ==== CARRO #"+idCarro+ " TERMINOU A CORRIDA EM "+ tempoCorrida+ "min. ====");

	}

	public void Libera() {

	}
}
