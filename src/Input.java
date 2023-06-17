import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class Input implements KeyListener {
    private PlayGame playGame;
    private boolean[] keys;

    public Input(GamePanel gamePanel, PlayGame playGame) {
        this.playGame = playGame;
        this.keys = new boolean[256];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        if (playGame.getBall().getGameOver() && keys[KeyEvent.VK_ENTER]) {
            playGame.startGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void updatePaddle() {
        if (keys[KeyEvent.VK_UP]) {
            playGame.movePaddleOne(-1);
        }
        if (keys[KeyEvent.VK_DOWN]) {
            playGame.movePaddleOne(1);
        }
        if (!keys[KeyEvent.VK_UP] && !keys[KeyEvent.VK_DOWN]) {
            playGame.movePaddleOne(0);
        }
    }
}
