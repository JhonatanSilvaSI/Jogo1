import javax.swing.JFrame;

public class Principal extends JFrame{

	public static void main(String[] args) {
		
		//criar uma instancia do jogo
		Jogo game = new Jogo();
		
		//criar a janela do jogo
		JFrame janelaprincipal = new JFrame("Ping Pong");
		
		//adicionar o jogo na tela
		janelaprincipal.add(game);
		//permitir alterar dimensões na tela de acordo com o jogo
		janelaprincipal.pack();
		//limpar as comfigurações de posicionamento da tela
		janelaprincipal.setLocationRelativeTo(null);
		//encerrar o programa quando clicar no x da janela
		janelaprincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//não deixar o usuario alterar o tamanho da janela
		janelaprincipal.setResizable(false);
		//mostrar a janela
		janelaprincipal.setVisible(true);
		
		//iniciar a thread do jogo
		new  Thread(game).start();
	}

}


//desenvolvido por Jhonatan Silva