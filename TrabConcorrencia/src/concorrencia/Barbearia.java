package concorrencia;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Barbearia {
	private int qtdeCadeiras = 5;
	private boolean dormindo = true;
	private LinkedBlockingQueue<Cliente> clientesNaFila = new LinkedBlockingQueue<>();
	private int qtdeClienteAtendidos = 0;
	private List<Cliente> clientesJaAtendidos = new ArrayList<>();

	public void sentarClienteNaCadeira(Cliente cliente) {
		clientesNaFila.offer(cliente);
	}

	public synchronized void cortarCabelo() {

		System.out.println("quantidade clientes esperando para cortar = "+ clientesNaFila.size());
		try {
			while (clientesNaFila.size() == 0) {
				System.out.println("Não tem nenhum cliente esperando, o barbeiri resolveu dormir");
				wait();

				System.out.println("Barbeiro continua seu trabalho...");
			}
			System.out.println("Cabelo Cortado...");
			int tempoCorte = ((int) (Math.random() * 7000));
			Thread.sleep(tempoCorte);
			System.out.println("Tempo de atendimento: " + tempoCorte);
			qtdeClienteAtendidos++;
			System.out.println("Foram atendidos " + qtdeClienteAtendidos+ " clientes");
			notifyAll();

			if (clientesNaFila.size() > 0)
				clientesNaFila.poll();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public synchronized void aguardaVez(Cliente cliente) {

		try {
			if (!clientesJaAtendidos.contains(cliente)) {
				if (clientesNaFila.size() < qtdeCadeiras) {
					clientesJaAtendidos.add(cliente);
					sentarClienteNaCadeira(cliente);
				} else {
					System.out.println("Não existem cadeiras disponiveis, o cliente resolveu esperar um pouco");
					Cliente.sleep((int) (Math.random() * 3000));
				}
			}else
				System.out.println("O cliente ja foi atendido e nao voltara para a fila");

			while (clientesNaFila.size() < qtdeCadeiras) {
				if (dormindo == true) {
					System.out.println("Acordando o barbeiro...");
					notify();
					dormindo = false;
				}
				wait();
			}
			System.out.println("Existem " + clientesNaFila.size()+ " clientes Aguardando...");
			notifyAll();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public LinkedBlockingQueue<Cliente> getFilaClientes() {
		return clientesNaFila;
	}
}
