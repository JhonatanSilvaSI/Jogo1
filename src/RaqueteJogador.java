import java.awt.Color;
import java.awt.Graphics;

public class RaqueteJogador {
	public boolean direita, esquerda;
	public int x,y;
	public int largura_raquete, altura_raquete;

	public RaqueteJogador (int x, int y) {
		this.x = x;
		this.y = y;
		this.largura_raquete = 40;
		this.altura_raquete = 5;
}

	public void AtualizarPosicao ()
	{
		if (direita)//a tecla "->" foi pressionada?
		{

			x++; //mover a posi��o da bola 1 posi��o para a direita
		}
		else if (esquerda) //a tecla "<-" foi pressionada?
		{
			x--; // mover a posi��o da bola 1 posi��o para a esquerda
		}

		if (x+largura_raquete > Jogo.LARGURA) //se a posi��o da raquete ultrapassou o limite da tela (canto direito)
		{
			x = Jogo.LARGURA - largura_raquete; //posicionar o canto da bola no final do lado direito
		}
	
		else if (x < 0)//ultrapassou o canto esquerdo da tela
		{
			x = 0; //posicionar o canto da bola no in�cio do lado esquerdo
		}
	}
	
	public void Desenhar (Graphics g)
	{
		//setar a cor da raquete
		g.setColor (Color.blue);
		//desenhar o retangulo que representa a raquete
		g.fillRect (x, y, largura_raquete, altura_raquete);
	}
}

