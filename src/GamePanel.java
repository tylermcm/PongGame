import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private PlayGame playGame;
    public static int width = 1600;
    public static int height = 1200;
    private int x;
    private int stringWidth;

    public GamePanel() {
        this.setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        playGame = new PlayGame(width, height);
        playGame.startGame();
        Input input = new Input(this, playGame);
        this.addKeyListener(input);
        this.setFocusable(true);
    }

    public int getStringWidth(Graphics g, String string) {
        FontMetrics fm = g.getFontMetrics();
        int stringWidth = fm.stringWidth(string);
        return stringWidth;
    }

    public void paintMessage(Graphics g, int y, String string) {
        g.setColor(Color.black);
        g.setFont(new Font("Arial", Font.PLAIN, 80));
        stringWidth = getStringWidth(g, string);
        x = (getWidth() - stringWidth) / 2;
        g.drawString(string, x, y);
    }

    protected void paintNet(Graphics g) {
        g.setFont(new Font("Arial", Font.PLAIN, 40));
        String net = ("■");
        int lineHeight = g.getFontMetrics().getHeight();
        for (int i = 0; i < 30; i++) {
            g.drawString(net, 788, i * lineHeight);
        }
    }

    protected void paintScore(Graphics g) {
        String score = String.format("%d            %d", playGame.getBall().getPlayerOneScore(),
                playGame.getBall().getPlayerTwoScore());
        g.setFont(new Font("Arial", Font.PLAIN, 80));
        FontMetrics fm = g.getFontMetrics();
        int stringWidth = fm.stringWidth(score);
        int x = (width - stringWidth) / 2;
        g.drawString(score, x, 70);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillOval((int) playGame.getBall().getBallX(), (int) playGame.getBall().getBallY(), 50, 50);
        g.fillRect(playGame.getPaddleOne().getPaddleX(), playGame.getPaddleOne().getPaddleY(),
                playGame.getPaddleOne().getPaddleWidth(),
                playGame.getPaddleOne().getPaddleHeight());
        g.fillRect(playGame.getPaddleTwo().getPaddleX(), playGame.getPaddleTwo().getPaddleY(),
                playGame.getPaddleTwo().getPaddleWidth(),
                playGame.getPaddleTwo().getPaddleHeight());
        paintScore(g);
        paintNet(g);
        if (playGame.getBall().getGameOver()) {
            g.setColor(Color.WHITE);
            g.fillRect(350, 450, 900, 300);
            paintMessage(g, 525, "Game Over!");
            paintMessage(g, 625, playGame.getBall().getWinner());
            paintMessage(g, 725, "Press enter to play again");
        }
    }

    public PlayGame getPlayGame() {
        return playGame;
    }
}
