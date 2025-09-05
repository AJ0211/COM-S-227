package hw2;

import static api.PlayerPosition.*;
import static api.BallType.*;

public class SimpleTests {

	public static void main(String[] args){
			
		System.out.println("Test 1: ");
		ThreeCushion game = new ThreeCushion(PLAYER_A, 3); 
	    System.out.println(game); 
	     
	    game.lagWinnerChooses(true, WHITE); 
	    
	    System.out.println(); 
	    System.out.println("Test 2:"); 
	    System.out.println("The shot player is " + game.getInningPlayer() + ", expected PLAYER_A"); 
	    System.out.println("The cue ball is " + game.getCueBall() + ", expected WHITE"); 
	    System.out.println("This is the break shot " + game.isBreakShot() + ", expected true"); 
	    System.out.println("Stats:    " + game); 
	    System.out.println("Expected: Player A*: 0, Player B: 0, Inning: 1 not started"); 
	    
	 // Player A takes a shot. 
	    game.cueStickStrike(WHITE); 
	    
	    System.out.println(); 
	    System.out.println("Test 3:"); 
	    System.out.println("The shot has started is " + game.isShotStarted()  + ", expected true"); 
	    System.out.println("Stats:    " + game); 
	    System.out.println("Expected: Player A*: 0, Player B: 0, Inning: 1 started");
	    
	    
	    game.endShot(); 
	    
	    System.out.println(); 
	    System.out.println("Test 4:"); 
	    System.out.println("The shot has started is " + game.isShotStarted() + ", expected false"); 
	    System.out.println("This is the break shot " + game.isBreakShot() + ", expected false"); 
	    System.out.println("The cue ball is " + game.getCueBall() + ", expected YELLOW"); 
	    System.out.println("Stats:    " + game); 
	    System.out.println("Expected: Player A: 0, Player B*: 0, Inning: 2 not started");
	    
	    game.foul(); 
	    
	    System.out.println(); 
	    System.out.println("Test 5:"); 
	    System.out.println("The cue ball is " + game.getCueBall() + ", expected WHITE"); 
	    System.out.println("Stats:    " + game); 
	    System.out.println("Expected: Player A*: 0, Player B: 0, Inning: 3 not started");
	    
	    game.cueStickStrike(YELLOW); 
	    
	    System.out.println(); 
	    System.out.println("Test 6:"); 
	    System.out.println("Stats:    " + game); 
	    System.out.println("Expected: Player A: 0, Player B*: 0, Inning: 4 not started");
	    
	 // All balls stop motion. 
	    game.endShot(); 
	    // Player B strikes the correct cue ball starting the next shot. 
	    game.cueStickStrike(YELLOW); 
	    
	    System.out.println(); 
	    System.out.println("Test 7:"); 
	    System.out.println("Stats:    " + game); 
	    System.out.println("Expected: Player A: 0, Player B*: 0, Inning: 4 started"); 
	    // The shot is valid. 
	    
	    game.cueBallStrike(RED); 
	    
	    game.cueBallImpactCushion(); 
	    game.cueBallImpactCushion(); 
	    game.cueBallImpactCushion(); 
	    game.cueBallStrike(WHITE); 
	    game.endShot(); 
	    
	    System.out.println(); 
	    System.out.println("Test 8:"); 
	    System.out.println("Stats:    " + game); 
	    System.out.println("Expected: Player A: 0, Player B*: 1, Inning: 4 started"); 
	    
	    game.cueStickStrike(YELLOW); 
	    game.cueBallImpactCushion(); 
	    game.cueBallImpactCushion(); 
	    game.cueBallImpactCushion(); 
	    game.cueBallStrike(RED); 
	    game.cueBallImpactCushion(); 
	    game.cueBallStrike(WHITE); 
	    game.endShot(); 
	    
	    System.out.println(); 
	    System.out.println("Test 9:"); 
	    System.out.println( 
	   "This is a bank shot " + game.isBankShot() + ", expected true"); 
	    System.out.println("Stats:    " + game); 
	    System.out.println( 
	   "Expected: Player A: 0, Player B*: 2, Inning: 4 started");
	    
	    game.cueStickStrike(YELLOW); 
	    game.cueBallImpactCushion(); 
	    game.cueBallStrike(WHITE); 
	    game.cueBallImpactCushion(); 
	    game.cueBallImpactCushion(); 
	    game.cueBallStrike(RED); 
	    game.endShot(); 
	    
	    System.out.println(); 
	    System.out.println("Test 10:"); 
	    System.out.println("This is a bank shot " + game.isBankShot() + ", expected false"); 
	    System.out.println("Stats:    " + game); 
	    System.out.println("Expected: Player A: 0, Player B*: 3, Inning: 4 started, game result final"); 
	   
	    ThreeCushion game2 = new ThreeCushion(PLAYER_B, 3); 
	    game2.lagWinnerChooses(true, WHITE); 
	    
	    game2.cueStickStrike(WHITE);
	    game2.endShot();
	    System.out.println("Stats:    " + game2); 
	    
	    //lagWinnerChooses()
	} 
}

