package concorrencia;

public class Cliente extends Thread {
	private Barbearia barbearia;
	private boolean cortar = true;
	private String nome;

	public Cliente(Barbearia barbearia, String nome) {
		this.barbearia = barbearia;
		this.nome = nome;
	}

	public void run() {
		while (cortar) {
			try {
				int sleepTime;
				do{
					sleepTime = ((int) (Math.random() * 10000));
				}while(sleepTime < 100);
				
				Thread.sleep(sleepTime);
				barbearia.aguardaVez(this);
			} catch (Exception e) {
			}
			System.out.println("Quantidade de Clientes: "+ barbearia.getFilaClientes().size());
		}

	}

	public String getNome() {
		return nome;
	}
}
