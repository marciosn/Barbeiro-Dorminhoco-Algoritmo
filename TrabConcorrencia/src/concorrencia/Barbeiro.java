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
				do{
					sleepTime = ((int) (Math.random() * 10000));
				}while(sleepTime < 7000);
				
				Thread.sleep(sleepTime);
				barbearia.cortarCabelo();
			} catch (Exception e) {
			}

			System.out.println("Quantidade de Clientes: "+ barbearia.getFilaClientes().size());

		}
	}

}
