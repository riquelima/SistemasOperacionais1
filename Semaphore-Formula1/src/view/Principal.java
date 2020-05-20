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
