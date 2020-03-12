import java.io.InputStream;
import java.io.ObjectInputStream;

public class TrataServidor extends Thread{

	private InputStream servidor;
	private MostrarTela tela;

	//Construtor
	public TrataServidor(InputStream servidor, MostrarTela tela) {
		this.servidor = servidor;
		this.tela = tela;
	}
	
	public void run(){
		ObjectInputStream oi;
		while(true) {
			try{
				
				oi = new ObjectInputStream(servidor);
				String mensagem = (String) oi.readObject();
				tela.setTela(mensagem);
					
			}catch(Exception e){
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

}
