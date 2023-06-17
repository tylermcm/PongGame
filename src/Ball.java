import java.util.Random;

public class Ball {
    private int width;
    private int height;
    private int ballX = 800;
    private int ballY = randomBallY();
    private int ballXSpeed = 10;
    private int ballYSpeed = 15;
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    public boolean gameIsOver = false;
    private String winner = "";

    public Ball(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void move(Paddle paddleOne, Paddle paddleTwo) {
        if (!gameIsOver) {
            if (ballX + ballXSpeed <= 0) {
                playerTwoScore++;
                ballX = 800;
                ballY = randomBallY();
                randomizeBallSpeed();
            } else if (ballX + ballXSpeed >= width - 50) {
                playerOneScore++;
                ballX = 800;
                ballY = randomBallY();
                randomizeBallSpeed();
            } else {
                if (ballY + ballYSpeed <= 0 || ballY + ballYSpeed >= height - 50)
                    ballYSpeed *= -1;

                if ((ballX + ballXSpeed <= paddleOne.getPaddleX() + paddleOne.getPaddleWidth())
                        && (ballY + ballYSpeed >= paddleOne.getPaddleY())
                        && (ballY + ballYSpeed <= paddleOne.getPaddleY() + paddleOne.getPaddleHeight())) {
                    ballXSpeed *= -1;
                    ballX = paddleOne.getPaddleX() + paddleOne.getPaddleWidth();
                    randomizeBallSpeed();
                } else if ((ballX + ballXSpeed >= paddleTwo.getPaddleX() - 50)
                        && (ballY + ballYSpeed >= paddleTwo.getPaddleY())
                        && (ballY + ballYSpeed <= paddleTwo.getPaddleY() + paddleTwo.getPaddleHeight())) {
                    ballXSpeed *= -1;
                    ballX = paddleTwo.getPaddleX() - 50;
                    randomizeBallSpeed();
                }
            }

            if (playerOneScore == 5) {
                gameIsOver = true;
                winner = "Player one wins!";
            } else if (playerTwoScore == 5) {
                gameIsOver = true;
                winner = "Player two wins!";
            }

            if (gameIsOver) {
                ballXSpeed *= 0;
                ballYSpeed *= 0;
                playerOneScore = 0;
                playerTwoScore = 0;
            }

            ballX += ballXSpeed;
            ballY += ballYSpeed;
        }
    }

    private void randomizeBallSpeed() {
        Random rand = new Random();
        ballXSpeed = rand.nextInt(6) + 10; 
        ballYSpeed = rand.nextInt(6) + 10; 

        if (rand.nextBoolean()) {
            ballXSpeed *= -1;
        }
        if (rand.nextBoolean()) { 
            ballYSpeed *= -1;
        }
    }

    private int randomBallY() {
        Random rand = new Random();
        int min = 50; 
        int max = 550; 
        return rand.nextInt((max - min) + 1) + min;
    }
    public int getBallX() {
        return ballX;
    }
    public int getBallY() {
        return ballY;
    }
    public int getPlayerOneScore() {
        return playerOneScore;
    }
    public int getPlayerTwoScore() {
        return playerTwoScore;
    }
    public boolean getGameOver() {
        return gameIsOver;
    }
    public String getWinner() {
        return winner;
    }
}
