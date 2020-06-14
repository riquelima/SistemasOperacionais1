package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.imageio.IIOException;
import javax.swing.JOptionPane;

public class ArquivosController implements IArquivosController {
	public String texto = " ";
	private int id;

	public ArquivosController() {
		super();
	}

	// ----------------- LENDO DIRET�RIO ---------------------
	@Override
	public void LerDiretorio(String path) throws IIOException, IOException {
		File diretorio = new File(path); // indica o caminho que o diret�rio est�
		if (diretorio.exists() && diretorio.isDirectory()) { // verifica se diret�rio existe e � um dirett�rio
			System.out.println(" ----- Diretorio Lido ------ "); // caso exista, escreve 'diret�rio lido'
			System.out.println("Caminho do diret�rio: " + path); // escreve caminho do diret�rio
			System.out.println(" -----------------------------\n");
		} else {
			throw new IOException("Diret�rio Inv�lido"); // caso diret�rio n�o exista, escreve 'diret�rio inv�lido'
		}
		// dir.exists() = identifica se o diret�rio existe e retorna true or false
		// dir.isDirectory() = identifica se o diret�rio � uma pasta ou um arquivo
	}

	// ----------------- LENDO ARQUIVO ---------------------
	@Override
	public void LerArquivo(String path, String nome) throws IOException {
		File arquivo = new File(path, "relatorio.txt");
		if (arquivo.exists() && arquivo.isFile()) {
			System.out.println(" --------- Lendo Arquivo --------- ");
			FileInputStream fluxo = new FileInputStream(arquivo);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) { // procurando End of File
				texto = linha;
				System.out.println(linha);
				linha = buffer.readLine();
			}
			System.out.println(texto);
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo Inv�lido");
		}

	}

	// ----------------- CRIAR ARQUIVO ---------------------
	@Override
	public void CopiaArquivo(String path, String nome) throws IOException {
		File dir = new File(path);
		File arq = new File(path, "arquivo.csv");

		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String conteudo = texto;
			FileWriter fileWriter = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(conteudo); // escreve o conteudo
			print.flush(); // Finaliza a escrita do conte�do
			print.close();
			fileWriter.close(); // Fecha o arquivo
		} else {
			throw new IOException("Diret�rio inv�lido");
		}

	}

	/*private String geraTxt() {
		StringBuffer buffer = new StringBuffer();
		System.out.println(" --------------- NOVO ARQUIVO CRIADO ----------------");

		return buffer.toString();
	
	}
		*/
	
}
