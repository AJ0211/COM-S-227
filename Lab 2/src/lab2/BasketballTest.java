package lab2;

/**
 * Try out the Basketball class.
 */
public class BasketballTest
{
  /**
   * Entry point.
   */
  public static void main(String[] args)
  {
    // Construct an instance and examine its attributes
    Basketball b = new Basketball(4.0);
    System.out.println(b.getDiameter());
    System.out.println(b.isDribbleable());
    
    // Construct another instance with a diameter of 6
    Basketball b2 = new Basketball(6.0);
    Basketball b3 = new Basketball(2.0);
    // Inflate the first one
    b.inflate();
    b3.inflate();
    b3.deflate();
    
    // First one is now dribbleable
    System.out.println("First basketball: " + b.isDribbleable());
    
    // Second one is unchanged
    System.out.println("Second basketball: " + b2.isDribbleable());
    
    System.out.println("Third basketball: " + b3.isDribbleable());
    
  }
}