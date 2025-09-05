package hw2;

import api.PlayerPosition;
import api.BallType;
import static api.PlayerPosition.*;
import static api.BallType.*;

/**
 * Class that models the game of three-cushion billiards.
 * 
 * @author Andrew Johnson
 */
public class ThreeCushion {

	private PlayerPosition currentInningPlayer; // tracks the current inning player
	private PlayerPosition lagWinner; // the winner of the lag
	private BallType ObjectBall = RED; //the ball that needs to be hit in order to score
	private BallType currentBall; //which cue ball color is assigned to player a
	private BallType otherBall; //which cue ball color is assigned to player b

	private int playerAScore;
	private int playerBScore;
	private int inningAScore;
	private int inningBScore;
	private int pointsToWin;
	private int inning;
	private int cueBallHits;
	private int objectBallHits;
	private int cushionHits;
	private int bankShotCounter;
	
	private boolean isFoul;
	private boolean isShotStarted;
	private boolean isInningStarted;

	
	
	public ThreeCushion(PlayerPosition lagWinner, int pointsToWin) {
		inning = 1;
		this.lagWinner = lagWinner;
		this.pointsToWin = pointsToWin;
		currentBall = null;
		otherBall = null;
		playerAScore = 0;
		playerBScore = 0;
	}
	
	
	/**
	 * used to show that the ball has hit a cushion
	 * 
	 * @param none
	 * @return nothing
	 */
	public void cueBallImpactCushion() {
		cushionHits++;
		if(bankShotCounter < 3)
			bankShotCounter++;
	}
	
	
	/**
	 * used to show that the cue ball has hit another one
	 * 
	 * @param ball
	 * @return nothing
	 */
	public void cueBallStrike(BallType ball) {
		if(currentInningPlayer == PLAYER_A && !isFoul) {
			if(ball == otherBall) {
				cueBallHits++;
			}
			if(ball == ObjectBall) {
				objectBallHits++;
			}
		}
		
		if(currentInningPlayer == PLAYER_B && !isFoul) {
			if(ball == currentBall) {
				cueBallHits++;
			}
			if(ball == ObjectBall) {
				objectBallHits++;
			}
		}
		if(bankShotCounter >= 3 && bankShotCounter < 5)
			bankShotCounter++;
		
		if(cushionHits == 0 && cueBallHits == 1) {
			foul();
		}
		
		if(cushionHits == 1 && objectBallHits >= 1) {
			foul();
		}
	}
	
	
	/**
	 * shows that the cue stick has hit a ball and checks if its the right ball
	 * 
	 * @param ball
	 * @return nothing
	 */
	public void cueStickStrike(BallType ball) {
		bankShotCounter = 0;
		isShotStarted = true;
		if (currentInningPlayer == PLAYER_A && ball == currentBall || currentInningPlayer == PLAYER_B && ball == otherBall) {
			isInningStarted = true;
			isShotStarted();
			isFoul = false;
		}
		else
			foul();
	}
	
	
	/**
	 * used to show that the balls have stopped their motion
	 * 
	 * @param none
	 * @return none
	 */
	public void endShot() {
		if(currentInningPlayer == PLAYER_A && cueBallHits >= 1 && objectBallHits == 1 && cushionHits >= 3) {
			playerAScore++;
			inningAScore++;
		}
		else if(currentInningPlayer == PLAYER_B && cueBallHits >= 1 && objectBallHits == 1 && cushionHits >= 3) {
			playerBScore++;
			inningBScore++;
		}

		if(currentInningPlayer == PLAYER_A && inningAScore == 0)
			currentInningPlayer = PLAYER_B;
		else if(currentInningPlayer == PLAYER_B && inningBScore == 0)
			currentInningPlayer = PLAYER_A;
		
		if(isShotStarted && inningAScore <= 0 && isShotStarted && inningBScore <= 0) {
			inning++;
			isInningStarted = false;
		}
		
		inningAScore = 0;
		inningBScore = 0;
		objectBallHits = 0;
		cushionHits = 0;
		isShotStarted = false;
	}
	
	
	/**
	 * A foul ends the players inning and starts the inning for the next player
	 * 
	 * @param none
	 * @return none
	 */
	public void foul() {
		isFoul = true;
		isShotStarted = false;
		
		if(currentBall != null || otherBall != null)
			inning++;
		
		if(currentInningPlayer == PLAYER_A && inningAScore == 0) {
			currentInningPlayer = PLAYER_B;
			isInningStarted = false;
		}
		else if(currentInningPlayer == PLAYER_B && inningBScore == 0) {
			currentInningPlayer = PLAYER_A;
			isInningStarted = false;
		}
	}
	
	
	/**
	 * returns the cue ball of the current player
	 * 
	 * @param none
	 * @return the current cue ball
	 */
	public BallType getCueBall() {
		if (currentInningPlayer == PLAYER_A) 
			return currentBall;
			return otherBall;
		
	}
	
	
	/**
	 * gets the inning number
	 * 
	 * @param none
	 * @return int corresponding to the current inning
	 */
	public int getInning() {
		return inning;
	}
	
	
	/**
	 * gets the current player
	 * 
	 * @param none
	 * @return returns the current inning player
	 */
	public PlayerPosition getInningPlayer() {
		return currentInningPlayer;
	}
	
	
	/**
	 * gets the score of player A
	 * 
	 * @param none
	 * @return int corresponding to player A
	 */
	public int getPlayerAScore() {
		return playerAScore;
	}
	
	
	/**
	 * gets the score of player A
	 * 
	 * @param none
	 * @return int corresponding to player A
	 */
	public int getPlayerBScore() {
		return playerBScore;
	}
	
	
	/**
	 * returns true if the shot wasa back shot
	 * 
	 * @param none
	 * @return boolean corresponding to weather or not it was a bank shot
	 */
	public boolean isBankShot() {
		if (bankShotCounter >= 5)
			return true;
			return false;
	}
	
	
	/**
	 * returns true if the shot was the break shot
	 * 
	 * @param none
	 * @return boolean returns true if its the first shot of the first inning	
	 */
	public boolean isBreakShot() {
		if (inning == 1) 
		return true;
		return false;
	}
	
	
	/**
	 * Returns true if either player scored enough points to win
	 * 
	 * @param none
	 * @return boolean returns whether or not either player has enough points to win the game
	 */
	public boolean isGameOver() {
		if (playerAScore >= pointsToWin || playerBScore >= pointsToWin) // owihergowNEOG
			return true;
			return false;
	}
	
	
	/**
	 * returns true if the shooting player has taken their first shot of the inning
	 * 
	 * @param none
	 * @return boolean returns whether or not the first shot of the inning has been played
	 */
	public boolean isInningStarted() {
		return isInningStarted;
	}
	
	
	/**
	 * returns true if a shot has been taken
	 * 
	 * @param none
	 * @return boolean returns whether or not a shot is in progress
	 */
	public boolean isShotStarted() {
		return isShotStarted;
	}
	
	
	/**
	 * Sets whether the player that won the lag chooses to break (
	 * 
	 * @param selfBreak shows who wants to break
	 * @param cueBall shows who owns what cue ball
	 * @return none
	 */
	public void lagWinnerChooses(boolean selfBreak, BallType cueBall) {
		if(lagWinner == PLAYER_A && selfBreak)
			currentInningPlayer = PLAYER_A;
		else if(lagWinner == PLAYER_A && !selfBreak)
			currentInningPlayer = PLAYER_B;
		else if(lagWinner == PLAYER_B && selfBreak)
			currentInningPlayer = PLAYER_B;
		else
			currentInningPlayer = PLAYER_A;
		
		if(lagWinner == PLAYER_A && cueBall == WHITE){
			currentBall = WHITE;
			otherBall = YELLOW;	
		}
		else if(lagWinner == PLAYER_A && cueBall == YELLOW){
			currentBall = YELLOW;
			otherBall = WHITE;
		}
		else if(lagWinner == PLAYER_B && cueBall == WHITE) {
			otherBall = WHITE;
			currentBall = YELLOW;
		}
		else {
			otherBall = YELLOW;
			currentBall = WHITE;
		}
	}
	
	
	
	
	
	
	// The method below is provided for you and you should not modify it.
	// The compile errors will go away after you have written stubs for the
	// rest of the API methods.

	/**
	 * Returns a one-line string representation of the current game state. The
	 * format is:
	 * <p>
	 * <tt>Player A*: X Player B: Y, Inning: Z</tt>
	 * <p>
	 * The asterisks next to the player's name indicates which player is at the
	 * table this inning. The number after the player's name is their score. Z is
	 * the inning number. Other messages will appear at the end of the string.
	 * 
	 * @return one-line string representation of the game state
	 */
	public String toString() {
		String fmt = "Player A%s: %d, Player B%s: %d, Inning: %d %s%s";
		String playerATurn = "";
		String playerBTurn = "";
		String inningStatus = "";
		String gameStatus = "";
		if (getInningPlayer() == PLAYER_A) {
			playerATurn = "*";
		} else if (getInningPlayer() == PLAYER_B) {
			playerBTurn = "*";
		}
		if (isInningStarted()) {
			inningStatus = "started";
		} else {
			inningStatus = "not started";
		}
		if (isGameOver()) {
			gameStatus = ", game result final";
		}
		return String.format(fmt, playerATurn, getPlayerAScore(), playerBTurn, getPlayerBScore(), getInning(),
				inningStatus, gameStatus);
	}
}