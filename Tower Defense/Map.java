import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;
import java.awt.*;
public class Map
{
  private BufferedImage img = null;
  
   public Map()
  {
     try
    {
      img = ImageIO.read(new File("Map.jpg"));
    } catch (IOException e)
    {
      System.out.println("No Image");
    }
    
  }
  
   //paints map
 public void paint(Graphics2D g)
  {
    g.drawImage(img, 0, 0, null);
  }
  }