package concorrencia;

public class Cliente extends Thread {
	private Barbearia barbearia;
	private boolean cortar = true;

	public Cliente(Barbearia barbearia) {
		this.barbearia = barbearia;
	}

	public void run() {
		while (cortar) {
			try {
				int sleepTime;
				do {
					sleepTime = ((int) (Math.random() * 50000));
				} while (sleepTime < 100);

				Thread.sleep(sleepTime);
				barbearia.aguardaVez(this);
			} catch (Exception e) {
			}
		}

	}
}
