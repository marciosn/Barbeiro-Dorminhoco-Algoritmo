package concorrencia;

import concorrencia.InterfaceGrafica.BarbeariaTela;

public class Main {

	public static void main(String[] args) {
		BarbeariaTela bt = new BarbeariaTela();
		Barbearia barbearia = new Barbearia();

		Barbeiro barb = new Barbeiro(barbearia);

		Cliente cli1 = new Cliente(barbearia, "[ Cliente 01 ]");
		Cliente cli2 = new Cliente(barbearia, "[ Cliente 02 ]");
		Cliente cli3 = new Cliente(barbearia, "[ Cliente 03 ]");
		Cliente cli4 = new Cliente(barbearia, "[ Cliente 04 ]");
		Cliente cli5 = new Cliente(barbearia, "[ Cliente 05 ]");
		Cliente cli6 = new Cliente(barbearia, "[ Cliente 06 ]");
		Cliente cli7 = new Cliente(barbearia, "[ Cliente 07 ]");
		Cliente cli8 = new Cliente(barbearia, "[ Cliente 08 ]");
		Cliente cli9 = new Cliente(barbearia, "[ Cliente 09 ]");
		Cliente cli10 = new Cliente(barbearia, "[ Cliente 10 ]");
		Cliente cli11 = new Cliente(barbearia, "[ Cliente 11 ]");
		Cliente cli12 = new Cliente(barbearia, "[ Cliente 12 ]");

		barb.start();
		cli1.start();
		cli2.start();
		cli3.start();
		cli4.start();
		cli5.start();
		cli6.start();
		cli7.start();
		cli8.start();
		cli9.start();
		cli10.start();
		cli11.start();
		cli12.start();

		while (true) {
			int qtd = barbearia.getFilaClientes().size();
			int atendidos = barbearia.getAtendidos();
			boolean dormindo = barbearia.isDormindo();

			if (dormindo)
				bt.getBarbeiro().loadImage("dormindo.png");
			else
				bt.getBarbeiro().loadImage("barbeiro.png");
			
			if(atendidos == 12)
				bt.getBarbeiro().loadImage("dormindo.png");
			
			bt.desenhaCliente(qtd);
			bt.update();
		}
	}

}
