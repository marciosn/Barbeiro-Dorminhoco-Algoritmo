package concorrencia;

public class Cliente extends Thread {
	private Barbearia barbearia;
	private boolean cortar = true;
	private String nomeCliente;

	public Cliente(Barbearia barbearia, String nome) {
		this.barbearia = barbearia;
		this.nomeCliente = nome;
	}

	public void run() {
		while (cortar) {
			try {
				int sleepTime;
				do {
					sleepTime = ((int) (Math.random() * 5000));
				} while (sleepTime < 1000);

				Thread.sleep(sleepTime);
				barbearia.aguardaVez(this);
			} catch (Exception e) {
			}
		}

	}
	public String nomeCliente(){
		return nomeCliente;
	}
}
