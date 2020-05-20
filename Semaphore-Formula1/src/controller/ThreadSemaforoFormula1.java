/* ALUNO - Henrique Souza Lima
 * 
 * --------------------------  ATIVIDADE PÁG38 SEMAPHORE-------------------------------------
 * Você foi contratado para automatizar um treino de fóruma 1. As regras estabelecidas
 * pela direção das provas são simples:
 *		1 - No máximo 5 carros dos 7 times (14 carros no total) presentes
 *			podem entrar na pista simultâneamente, mas apenas um carro de cada equipe. 
 *		2 - O segundo carro deve ficar à espera, caso um companheiro de equipe já esteja 
 *		    na pista.
 *      3 - Cada piloto deve dar três voltas na pista.
 *      4 - O tempo de cada volta deverá ser exibido e a volta mais rápida de cada piloto 
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

	// --------------------- MÉTODO RUN THREADS ------------------------
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

	// --------------------------- MÉTODO LARGADA --------------------------
	public void Largada() {

		if (idCarro <= 14) {
			System.out.println("### PRONTO PARA LARGADA Carro #" + idCarro);
		}

	}

	// ------------------------- MÉTODO CORRIDA ----------------------------
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
					System.out.println("Carro #" + idCarro + " Deu a " + volta + "º volta em " + (tempoVolta/10) + " seg.");

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
