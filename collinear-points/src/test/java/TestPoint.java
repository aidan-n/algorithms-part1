import org.junit.Assert;
import org.junit.Test;

public class TestPoint
{

  @Test
  public void reflexive1()
  {
    Point p = new Point(154, 58);
    Point q = new Point(263, 28);
    Assert.assertEquals(0, p.slopeOrder().compare(q, q));
  }

}
