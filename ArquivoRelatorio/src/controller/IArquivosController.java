package controller;
import java.io.IOException;
import javax.imageio.IIOException; 

public interface IArquivosController {
	public void LerDiretorio (String path) throws IIOException, IOException; 
	public void LerArquivo(String path, String nome) throws IOException;
	public void CopiaArquivo(String path, String nome) throws IOException;
	

}
