package concorrencia;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Barbearia {
	private int qtdeCadeiras = 5;
	private boolean dormindo = true;
	private LinkedBlockingQueue<Cliente> clientesNaFila = new LinkedBlockingQueue<>();
	private int qtdeClienteAtendidos = 0;
	private List<Cliente> clientesJaAtendidos = new ArrayList<Cliente>();
	boolean cortando = false;

	public synchronized void cortarCabelo() {
		try {
			while (clientesNaFila.size() == 0) {
				System.out.println("Não tem nenhum cliente esperando, o barbeiro resolveu dormir");
				wait();
				System.out.println("Barbeiro continua seu trabalho..........");
			}
			
			String nameCli = clientesNaFila.peek().nomeCliente();
			if (clientesNaFila.size() > 0) {
					clientesNaFila.poll();
					cortando = true;
					System.out.println("Aguarde enquando o " + nameCli + " é atendido......");
					Thread.sleep((int) (Math.random() * 5000));
					qtdeClienteAtendidos++;
					System.out.println("Foram atendidos " + qtdeClienteAtendidos + " clientes");
			}
			notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void aguardaVez(Cliente cliente) {
		try {
			if (!clientesJaAtendidos.contains(cliente)) {
				if (clientesNaFila.size() < qtdeCadeiras) {
					clientesNaFila.offer(cliente);
					clientesJaAtendidos.add(cliente);
					System.out.println("Quantidade clientes esperando para cortar = "+ clientesNaFila.size());
				} else {
					System.out.println("Um Cliente chegou mas não existem cadeiras vazias, ele voltará em breve.");
					Thread.sleep((int) (Math.random() * 3000));
				}
			}
			
			while (clientesNaFila.size() < qtdeCadeiras) {
				if (dormindo) {
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
	public int getAtendidos(){
		return qtdeClienteAtendidos;
	}

}
