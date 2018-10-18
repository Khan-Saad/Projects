import java.awt.*; 
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;
public class Castle
{
   private BufferedImage img = null;
  static int health=500;
  public Castle()
  {
     try
    {
      img = ImageIO.read(new File("SaveScreen.png"));
    } catch (IOException e)
    {
      System.out.println("No Image");
    }
  }
  public void paint(Graphics2D g2d) 
    //paints the health bar as long as the castle has health
  { if(health>1)
    {
    g2d.setColor(Color.BLACK);
    g2d.fillRect(98, 28, health+4, 14);
    g2d.setColor(Color.RED); 
    g2d.fillRect(100, 30, health, 10);
  }
  //paints gameover screen
    else
    {
    g2d.drawImage(img, 0, 0, null);
    TowerDefense.friendlies.clear();
    TowerDefense.enemies.clear();
    
    }
  
  }
  
  
  
  public void hit(int a)
  {
    health= health -a;
  }
  
}