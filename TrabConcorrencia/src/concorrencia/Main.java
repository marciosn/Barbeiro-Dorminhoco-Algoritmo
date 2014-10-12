package concorrencia;

import concorrencia.InterfaceGrafica.BarbeariaTela;

public class Main {
	
	 public static void main(String[] args) {  
			BarbeariaTela bt = new BarbeariaTela();
	        Barbearia barbearia = new Barbearia();  
	          
	        Barbeiro barb = new Barbeiro(barbearia);  
	          
	     
	        Cliente cli1 = new Cliente(barbearia);  
	        Cliente cli2 = new Cliente(barbearia);  
	        Cliente cli3 = new Cliente(barbearia);  
	        Cliente cli4 = new Cliente(barbearia);  
	        Cliente cli5 = new Cliente(barbearia);  
	        Cliente cli6 = new Cliente(barbearia);  
	        Cliente cli7 = new Cliente(barbearia);  
	        Cliente cli8 = new Cliente(barbearia);  
	        Cliente cli9 = new Cliente(barbearia);  
	        Cliente cli10 = new Cliente(barbearia);  
	        Cliente cli11 = new Cliente(barbearia);  
	        Cliente cli12 = new Cliente(barbearia);  
	          
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
	        
	        while(true){
	        	int qtd = barbearia.getFilaClientes().size();
	        	bt.desenhaCliente(qtd);
	        	bt.update();
	        }
	    }

}
