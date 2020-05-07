package controller;
import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread{
	private int idCarro;
	private String sentido;
	private Semaphore semaforo;
	
	public ThreadCruzamento(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
		
		if(this.idCarro == 1) {
			sentido = "Norte";
		} else if(this.idCarro == 2) {
			sentido = "Sul";
		} else if(this.idCarro == 3) {
			sentido = "Leste";
		}else if(this.idCarro == 4) {
			sentido = "Oeste";
		}
	}

		@Override
	public void run() {
		
		try {
			semaforo.acquire();
			atravessa();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	public void atravessa() {
		System.out.println("Carro " + idCarro + " dirigindo " + sentido);
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Carro " + idCarro + " passou");
	}

		
		
	}
	
	

