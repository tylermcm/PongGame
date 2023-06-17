import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PongGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong Game");
        GamePanel gamePanel = new GamePanel();
        PlayGame playGame = gamePanel.getPlayGame(); 
        Input input = new Input(gamePanel, playGame); 
        gamePanel.addKeyListener(input);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        gamePanel.requestFocusInWindow();

        Timer timer = new Timer(1000 / 60, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                input.updatePaddle();
                playGame.moveBall();
                playGame.movePaddleTwo(); 
                playGame.updatePaddles();
                gamePanel.repaint();
            }
        });
        timer.start();
    }
}
