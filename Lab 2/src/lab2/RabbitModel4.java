package lab2;
import java.util.Random; 

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel4
{
  // TODO - add instance variables as needed
  private int year;
  private int population;
  private int increase;
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel4()
  {
    year = 0;
    population = 0;
  }  
 
  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation()
  {
    // TODO - returns a dummy value so code will compile
    return population;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {
	  year++;
	  Random rand = new Random();
	  increase = rand.nextInt(10);
	  population += increase;
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
	year = 0;
    population = 2;
  }
}
