package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel
{
  // TODO - add instance variables as needed
  private int lastYear;
  private int yearBefore;
  private int population;
  
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel()
  {
    lastYear = 1;
    yearBefore = 0;
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
	  population = lastYear + yearBefore;
	  yearBefore = lastYear;
	  lastYear= population;
  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
	lastYear = 1;
	yearBefore = 0;
    population = 0;
  }
}
