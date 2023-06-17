public class PlayGame {
    private int width;
    private int height;
    private Ball ball;
    private Paddle paddleOne;
    private Paddle paddleTwo;

    public PlayGame(int width, int height) {
        this.width = width;
        this.height = height;
        ball = new Ball(width, height);
    }

    public void startGame() {
        paddleOne = new Paddle(20, 450, width, height);
        paddleTwo = new Paddle(1530, 450, width, height);
        ball = new Ball(width, height);
    }

    public void moveBall() {
        ball.move(paddleOne, paddleTwo);
    }

    public void movePaddleOne(int direction) {
        paddleOne.setDirection(direction);
    }

    public void movePaddleTwo() {
        if (!getBall().getGameOver()) {
            int paddleCenter = paddleTwo.getPaddleY() + paddleTwo.getPaddleHeight() / 2;
            if (ball.getBallY() < paddleCenter && paddleTwo.getPaddleY() > 0) {
                paddleTwo.setDirection(-1);
            } else if (ball.getBallY() > paddleCenter
                    && paddleTwo.getPaddleY() + paddleTwo.getPaddleHeight() < height) {
                paddleTwo.setDirection(1);
            }
        } else {
            paddleTwo.setDirection(0); 
        }
    }

    public void updatePaddles() {
        paddleOne.update();
        paddleTwo.update();
    }

    public Ball getBall() {
        return ball;
    }

    public Paddle getPaddleOne() {
        return paddleOne;
    }

    public Paddle getPaddleTwo() {
        return paddleTwo;
    }
}
