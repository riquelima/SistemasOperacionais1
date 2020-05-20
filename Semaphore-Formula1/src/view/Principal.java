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
package view;
import java.util.concurrent.Semaphore;

import controller.ThreadSemaforoFormula1;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 5;
		Semaphore controlelargada = new Semaphore(permissoes);
		
		 for (int idCarro = 1; idCarro <= 14 ; idCarro++) {
		
				 Thread tSemaforoFormula1 = new ThreadSemaforoFormula1(idCarro, controlelargada);
		            tSemaforoFormula1.start();
	
		 }

	}
}
