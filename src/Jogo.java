import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image. BufferedImage;

public class Jogo extends Canvas implements Runnable, KeyListener{
	
	//configurações da tela do jogo
	public static int LARGURA = 160;
	public static int ALTURA = 120;
	public static int ESCALA = 3;
	public BufferedImage TelaDoJogo = new BufferedImage(LARGURA,ALTURA,BufferedImage.TYPE_INT_RGB);
	
	public static RaqueteJogador objetoRaqueteJogador;
	public static Bola objetoBola;
	
	public Jogo(){
	
	
	//Configurar tamanho da tela
		this.setPreferredSize(new Dimension (LARGURA*ESCALA,ALTURA*ESCALA));
		//adicionar manipulador de enventos do teclado (leitura das teclas)
		this.addKeyListener(this);
		//iniciar os objetos raquete e bola
		objetoRaqueteJogador = new RaqueteJogador(100,ALTURA-5);
		objetoBola = new Bola(100,ALTURA/2 -1);
}
	

		public void DesenharJogoNaTela()
		{
			//criar o frontbuffer
			BufferStrategy bs = this.getBufferStrategy();
			if(bs == null) {
				this.createBufferStrategy(3);
				return;
			}
			
			//desenhar os objetos do jogo no backbuffer
			Graphics g = TelaDoJogo.getGraphics();
			g.setColor(Color.black);
			g.fillRect(0,0,LARGURA,ALTURA);
			objetoRaqueteJogador.Desenhar(g);
			objetoBola.Desenhar(g);
			
			//tranferir a imagem do backbuffer para o frontbuffer
			g = bs.getDrawGraphics();
			g.drawImage(TelaDoJogo,0,0,LARGURA*ESCALA,ALTURA*ESCALA,null);
			bs.show(); //mostrar o frontbuffer
		}

	
		public void AtualizarPosicoesObjetos()
		{
			objetoRaqueteJogador.AtualizarPosicao();
			objetoBola.AtualizarPosicao();
		}
	
		@Override
	public void run() {
			while (true) {
				//atualizar as posições de todos os objetos do jogo
				AtualizarPosicoesObjetos();
				// desenhar novamente o jogo
				DesenharJogoNaTela();
				try {
					Thread.sleep(15); //aguardar 15 milesegundo e continuar a execução
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
				
			}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		//verificar se as teclas "->" ou "<-" foram pressionadas
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			objetoRaqueteJogador.direita = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			objetoRaqueteJogador.esquerda = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//verificar se as teclas "->" ou "<-" foram liberadas
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			objetoRaqueteJogador.direita = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			objetoRaqueteJogador.esquerda = false;
		}
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	

}


