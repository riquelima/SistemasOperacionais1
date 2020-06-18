package view;

import java.io.IOException;

import javax.imageio.IIOException;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		IArquivosController arqCont = new ArquivosController();
		String arquivo = "arquivo.csv";
		int codigo = 1;
		
		try {
			arqCont.verificaDirTemp();
			arqCont.verificaCadastro(arquivo, codigo);
			arqCont.imprimeCadastro(arquivo, codigo);
			arqCont.insereCadastro(arquivo, 6, "Carla Dias", "carla@uol.com");
		} catch (IIOException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
