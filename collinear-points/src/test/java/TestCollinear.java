import org.junit.Assert;
import org.junit.Test;

public class TestCollinear
{

  @Test
  public void collinear()
  {
    final Point p = new Point(1000, 17000);
    final Point q = new Point(1000, 27000);
    final Point r = new Point(1000, 31000);
    final Point s = new Point(1000, 28000);
    Assert.assertTrue(BruteCollinearPoints.areCollinear(new Point[] {
                                                                      p,
                                                                      q,
                                                                      r,
                                                                      s }));
  }

}
