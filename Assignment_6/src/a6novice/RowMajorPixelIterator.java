package a6novice;

import java.util.*;

public class RowMajorPixelIterator
  implements Iterator<Pixel>
{
  private Picture source;
  private int x;
  private int y;
  
  public RowMajorPixelIterator(Picture source)
  {
    this.source = source;
    this.x = 0;
    this.y = 0;
  }
  
  public boolean hasNext()
  {
    return (y < source.getHeight());
  }
  
  public Pixel next()
  {
    if (hasNext() != true) {
      throw new NoSuchElementException("No more pixels");
    }
    Pixel p = source.getPixel(x,y);
    if (x == source.getWidth() - 1)
    {
      x = 0;
      y += 1;
    }
    else
    {
      x += 1;
    }
    return p;
  }
}
