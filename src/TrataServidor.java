import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TrataServidor extends Thread{

	private InputStream servidor;

	//Construtor
	public TrataServidor(InputStream servidor) {
		this.servidor = servidor;
	}
	
	public void run(){
		ObjectInputStream oi;
		while(true) {
			try{
				
				oi = new ObjectInputStream(servidor);
				String mensagem = (String) oi.readObject();
					
			}catch(Exception e){
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

}
