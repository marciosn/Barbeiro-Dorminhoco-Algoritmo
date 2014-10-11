package concorrencia;

public class Main {
	
	 public static void main(String[] args) {  
         
	        Barbearia barbearia = new Barbearia();  
	          
	        Barbeiro barb = new Barbeiro(barbearia);  
	          
	     
	        Cliente cli1 = new Cliente(barbearia, "joao");  
	        Cliente cli2 = new Cliente(barbearia, "jose");  
	        Cliente cli3 = new Cliente(barbearia, "flavio");  
	        Cliente cli4 = new Cliente(barbearia, "pedro");  
	        Cliente cli5 = new Cliente(barbearia, "marcio");  
	        Cliente cli6 = new Cliente(barbearia, "souza");  
	        Cliente cli7 = new Cliente(barbearia, "edu");  
	        Cliente cli8 = new Cliente(barbearia, "carlos");  
	        Cliente cli9 = new Cliente(barbearia, "ze");  
	        Cliente cli10 = new Cliente(barbearia, "maria");  
	        Cliente cli11 = new Cliente(barbearia, "joana");  
	        Cliente cli12 = new Cliente(barbearia, "lucia");  
	          
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
	    }

}
