import org.junit.Assert;
import org.junit.Test;

public class TestPoint
{

  @Test
  public void antisymmetric1()
  {
    final Point p = new Point(77, 496);
    final Point q = new Point(242, 352);
    final Point r = new Point(145, 245);

    final double qrSlope = q.slopeTo(r);
    final double rqSlope = r.slopeTo(q);

    final int qrSlopeOrder = p.slopeOrder().compare(q, r);
    final int rqSlopeOrder = p.slopeOrder().compare(r, q);

    Assert.assertEquals(-1, qrSlopeOrder);
    Assert.assertEquals(1, rqSlopeOrder);
  }

  @Test
  public void reflexive1()
  {
    final Point p = new Point(154, 58);
    final Point q = new Point(263, 28);
    Assert.assertEquals(0, p.slopeOrder().compare(q, q));
  }

  @Test
  public void reflexive2()
  {
    final Point p = new Point(15887, 739);
    final Point q = new Point(15896, 21373);
    Assert.assertEquals(0, p.slopeOrder().compare(q, q));
  }

}
