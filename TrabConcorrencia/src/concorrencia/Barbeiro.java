package concorrencia;

public class Barbeiro extends Thread {
	private Barbearia barbearia;
	private boolean cortar = true;

	public Barbeiro(Barbearia barbearia) {
		this.barbearia = barbearia;
	}

	public void run() {
		while (cortar) {
			try {
				int sleepTime;
				do {
					sleepTime = ((int) (Math.random() * 5000));
				} while (sleepTime < 1000);
				Thread.sleep(sleepTime);
				barbearia.cortarCabelo();
			} catch (Exception e) {
			}
		}
	}

}
