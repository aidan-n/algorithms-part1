
public class FastCollinearPoints
{

  /**
   * finds all line segments containing 4 points
   */
  public FastCollinearPoints(final Point[] points)
  {
    if (points == null)
    {
      throw new NullPointerException();
    }
    for (final Point point: points)
    {
      if (point == null)
      {
        throw new NullPointerException();
      }
    }

  }

  /**
   * the number of line segments
   */
  public int numberOfSegments()
  {
    return 0;
  }

  /**
   * the line segments
   */
  public LineSegment[] segments()
  {
    return new LineSegment[0];
  }

}
