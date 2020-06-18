package controller;
import java.io.IOException;
import javax.imageio.IIOException; 

public interface IArquivosController {

	    public void verificaDirTemp() throws IOException;
		public boolean verificaCadastro(String arquivo, int codigo) throws IOException;
		public void imprimeCadastro(String arquivo, int codigo) throws IOException;
		public void insereCadastro(String arquivo, int codigo, String nome, String email) throws IOException;
		
	}

	
	

