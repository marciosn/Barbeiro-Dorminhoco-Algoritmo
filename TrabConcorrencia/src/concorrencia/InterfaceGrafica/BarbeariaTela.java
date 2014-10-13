package concorrencia.InterfaceGrafica;

import java.awt.Color;

import jplay.GameImage;
import jplay.Scene;
import jplay.Window;

public class BarbeariaTela {
	private Window window;  
    private Scene scene;  
    private GameImage cliente1, cliente2, cliente3, cliente4, cliente5, barbeiro, clienteCortando;

    public BarbeariaTela() {
    	window = new Window(800, 600);  
        
        cliente1 = new GameImage("cliente.png");
        cliente2 = new GameImage("cliente.png");
        cliente3 = new GameImage("cliente.png");
        cliente4 = new GameImage("cliente.png");
        cliente5 = new GameImage("cliente.png");
        clienteCortando = new GameImage("cliente.png");
        barbeiro = new GameImage("barbeiro.png");
        
        scene = new Scene();  
        scene.loadFromFile("scene.scn");  
        scene.setDrawStartPos(0, 1);
        
        scene.draw();
        window.update();
	} 
    public void desenhaCliente(int quantidadeClientes){
    	switch (quantidadeClientes) {
    	
    	case 0:
	        scene = new Scene();
	        scene.loadFromFile("scene.scn");
	        
	        barbeiro.x = 341;
	        barbeiro.y = 251;
	        scene.addOverlay(barbeiro);
	        barbeiro.draw();
	        
	        /*clienteCortando.x = 265;
	        clienteCortando.y = 300;
	        scene.addOverlay(clienteCortando);
	        clienteCortando.draw();*/
	        
	        scene.draw();
	        window.update();			
			break;
    	
		case 1:
			cliente1.x = 431;
	        cliente1.y = 164;
	        scene = new Scene();
	        scene.loadFromFile("scene.scn");
	        scene.addOverlay(cliente1);
	        cliente1.draw();
	        
	        barbeiro.x = 341;
	        barbeiro.y = 251;
	        scene.addOverlay(barbeiro);
	        barbeiro.draw();
	        
	        clienteCortando.x = 265;
	        clienteCortando.y = 300;
	        scene.addOverlay(clienteCortando);
	        clienteCortando.draw();
	        
	        scene.draw();
	        window.update();
			
			break;
		case 2:
			cliente1.x = 431;
	        cliente1.y = 164;
	        cliente2.x = 564;
	        cliente2.y = 181;
	        scene = new Scene();
	        scene.loadFromFile("scene.scn");
	        scene.addOverlay(cliente1);
	        scene.draw();
	        cliente1.draw();
	        scene.addOverlay(cliente2);
	        cliente2.draw();
	        
	        barbeiro.x = 341;
	        barbeiro.y = 251;
	        scene.addOverlay(barbeiro);
	        barbeiro.draw();
	        
	        clienteCortando.x = 265;
	        clienteCortando.y = 300;
	        scene.addOverlay(clienteCortando);
	        clienteCortando.draw();
	        
	        scene.draw();
	        window.update();
			break;
		case 3:
			cliente1.x = 431;
	        cliente1.y = 164;
	        cliente2.x = 564;
	        cliente2.y = 181;
	        cliente3.x = 585;
	        cliente3.y = 281;
	        scene = new Scene();
	        scene.loadFromFile("scene.scn");
	        scene.addOverlay(cliente1);
	        scene.draw();
	        cliente1.draw();
	        scene.addOverlay(cliente2);
	        scene.draw();
	        cliente2.draw();
	        scene.addOverlay(cliente3);
	        cliente3.draw();
	        
	        barbeiro.x = 341;
	        barbeiro.y = 251;
	        scene.addOverlay(barbeiro);
	        barbeiro.draw();
	        
	        clienteCortando.x = 265;
	        clienteCortando.y = 300;
	        scene.addOverlay(clienteCortando);
	        clienteCortando.draw();
	        
	        scene.draw();
	        window.update();
			break;
		case 4:
			cliente1.x = 431;
	        cliente1.y = 164;
	        cliente2.x = 564;
	        cliente2.y = 181;
	        cliente3.x = 585;
	        cliente3.y = 281;
	        cliente4.x = 624;
	        cliente4.y = 376;
	        scene = new Scene();
	        scene.loadFromFile("scene.scn");
	        scene.addOverlay(cliente1);
	        scene.draw();
	        cliente1.draw();
	        scene.addOverlay(cliente2);
	        scene.draw();
	        cliente2.draw();
	        scene.addOverlay(cliente3);
	        scene.draw();
	        cliente3.draw();
	        scene.addOverlay(cliente4);
	        cliente4.draw();
	        
	        barbeiro.x = 341;
	        barbeiro.y = 251;
	        scene.addOverlay(barbeiro);
	        barbeiro.draw();
	        
	        clienteCortando.x = 265;
	        clienteCortando.y = 300;
	        scene.addOverlay(clienteCortando);
	        clienteCortando.draw();
	        
	        scene.draw();
	        window.update();
			break;
		case 5:
			cliente1.x = 431;
	        cliente1.y = 164;
	        cliente2.x = 564;
	        cliente2.y = 181;
	        cliente3.x = 585;
	        cliente3.y = 281;
	        cliente4.x = 624;
	        cliente4.y = 376;
	        cliente5.x = 623;
	        cliente5.y = 470;
	        scene = new Scene();
	        scene.loadFromFile("scene.scn");
	        scene.addOverlay(cliente1);
	        scene.draw();
	        cliente1.draw();
	        scene.addOverlay(cliente2);
	        scene.draw();
	        cliente2.draw();
	        scene.addOverlay(cliente3);
	        scene.draw();
	        cliente3.draw();
	        scene.addOverlay(cliente4);
	        scene.draw();
	        cliente4.draw();
	        scene.addOverlay(cliente5);
	        cliente5.draw();
	        
	        barbeiro.x = 341;
	        barbeiro.y = 251;
	        scene.addOverlay(barbeiro);
	        barbeiro.draw();
	        
	        clienteCortando.x = 265;
	        clienteCortando.y = 300;
	        scene.addOverlay(clienteCortando);
	        clienteCortando.draw();
	        
	        scene.draw();
	        window.update();
			break;
		default:
			break;
		}
    }
    public void imprimeClienteAtendidos(int qtd){
    	int restante = 12 - qtd;
    	window.drawText("Clientes Atendidos: " + qtd , 20, 100, Color.RED);
    	window.drawText("Clientes Aguardando: " + restante , 20, 480, Color.RED);
    }
    public void update(){
    	window.update();
    }
	public GameImage getCliente1() {
		return cliente1;
	}
	public void setCliente1(GameImage cliente1) {
		this.cliente1 = cliente1;
	}
	public GameImage getCliente2() {
		return cliente2;
	}
	public void setCliente2(GameImage cliente2) {
		this.cliente2 = cliente2;
	}
	public GameImage getCliente3() {
		return cliente3;
	}
	public void setCliente3(GameImage cliente3) {
		this.cliente3 = cliente3;
	}
	public GameImage getCliente4() {
		return cliente4;
	}
	public void setCliente4(GameImage cliente4) {
		this.cliente4 = cliente4;
	}
	public GameImage getCliente5() {
		return cliente5;
	}
	public void setCliente5(GameImage cliente5) {
		this.cliente5 = cliente5;
	}
	public GameImage getBarbeiro() {
		return barbeiro;
	}
	public void setBarbeiro(GameImage barbeiro) {
		this.barbeiro = barbeiro;
	}
	public GameImage getClienteCortando() {
		return clienteCortando;
	}
	public void setClienteCortando(GameImage clienteCortando) {
		this.clienteCortando = clienteCortando;
	}

}
