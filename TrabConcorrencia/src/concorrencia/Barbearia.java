package concorrencia;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import concorrencia.InterfaceGrafica.BarbeariaTela;

public class Barbearia {
	private int qtdeCadeiras = 5;
	private boolean dormindo = true;
	private LinkedBlockingQueue<Cliente> clientesNaFila = new LinkedBlockingQueue<>();
	private int qtdeClienteAtendidos = 0;
	private List<Cliente> clientesJaAtendidos = new ArrayList<>();
	boolean cortando = false;
	
	public synchronized void cortarCabelo() {
		try {
			while (clientesNaFila.size() == 0) {
				System.out.println("Não tem nenhum cliente esperando, o barbeiro resolveu dormir");
				wait();
				System.out.println("Barbeiro continua seu trabalho");
			}
			
			if (clientesNaFila.size() > 0){
				clientesNaFila.poll();
				cortando = true;
			}
			
			System.out.println("Cortando o cabelo do cliente.....");
			int tempoCorte = ((int) (Math.random() * 5000));
			Thread.sleep(tempoCorte);
			System.out.println("Tempo de atendimento: " + tempoCorte);
			qtdeClienteAtendidos++;
			System.out.println("Foram atendidos " + qtdeClienteAtendidos+ " clientes");
			notifyAll();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public synchronized void aguardaVez(Cliente cliente) {
		try {
			if (!clientesJaAtendidos.contains(cliente)) {
				if (clientesNaFila.size() < qtdeCadeiras) {
					clientesJaAtendidos.add(cliente);
					clientesNaFila.offer(cliente);
					System.out.println("Quantidade clientes esperando para cortar = "+ clientesNaFila.size());
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
			notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public LinkedBlockingQueue<Cliente> getFilaClientes() {
		return clientesNaFila;
	}

	public boolean isCortando() {
		return cortando;
	}

	public boolean isDormindo() {
		return dormindo;
	}

}
