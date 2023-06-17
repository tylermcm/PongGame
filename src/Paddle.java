public class Paddle {
    private int height;
    private int paddleWidth = 50;
    private int paddleHeight = 300;
    private int paddleX;
    private int paddleY;
    private int paddleSpeed = 10;
    private int direction;

    public Paddle(int x, int y, int width, int height) {
        paddleX = x;
        paddleY = y;
        this.height = height;
        direction = 0;
    }

    public void update() {
        if ((direction == -1 && paddleY >= 0) || (direction == 1 && paddleY + paddleHeight <= height)) {
            paddleY += paddleSpeed * direction;
        }
    }

    public int getPaddleX() {
        return paddleX;
    }
    public int getPaddleY() {
        return paddleY;
    }
    public int getPaddleWidth() {
        return paddleWidth;
    }
    public int getPaddleHeight() {
        return paddleHeight;
    }

    public void setDirection(int newDirection) {
        direction = newDirection;
    }
}
