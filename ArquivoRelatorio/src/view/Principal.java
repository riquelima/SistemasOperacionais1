/*                     [ HENRIQUE SOUZA LIMA ]
 * 
 * Pegar o arquivo relatório.txt, colocar em um diretório que o permita ser lido, 
 * fazer a leitura e colocar seu conteúdo em um arquivo CSV, para que seja lido pelo Excel.
 * 
 */

package view;

import java.io.IOException;

import javax.imageio.IIOException;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		IArquivosController arqCont = new ArquivosController();
		String dirWin = "C:\\Windows";
		String path = "C:\\TEMP\\RelatorioArquivo";
		String nome = "relatorio.txt";
		
		try {
			arqCont.LerDiretorio(path);
			arqCont.LerArquivo(path, nome);
			arqCont.CopiaArquivo(path, "relatorio.csv");
		} catch (IIOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
