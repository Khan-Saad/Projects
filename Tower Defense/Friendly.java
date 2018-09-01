import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;
public class Friendly extends Character
{ 
  //4 images
  //2 different models (upgrade/no upgrade)
  //2 attacks for eaech model
  private BufferedImage img = null;
  private BufferedImage img2 = null;
  private BufferedImage img3 = null;
  private BufferedImage img4 = null;
  String pic;
  String picU;
  String picA;
  String picAU;
  
  //stores whether the unit is upgraded or not
  int upgradeLevel=0;
  
  //variables that controls attack animation
  public boolean attackA=false;
  private int animationCount=0;
  
  //contructor
  public Friendly(String str, int a, int b)
  {
    //sets  and y coordinates
    x=a;
    y=b;
    
    //reads the string given
    readType(str);
    
    //initializes range based on string
    if (str == "Mage"){
      range = 70;
    }else if(str == "Archer"){
     range = 100; 
      
    }else if(str == "AxeWielder"){
     range = 40; 
      
    }else if(str == "Swordsman"){
     range = 50; 
      
    }
    else if(str == "Lancer"){
     range = 50;  
    }
    
    //using data from the readType method, initializes 4 different images
    try
    {
      img = ImageIO.read(new File(pic));
      img2= ImageIO.read(new File(picU));
      img3 = ImageIO.read(new File(picA));
      img4= ImageIO.read(new File(picAU));
    } catch (IOException e)
    {
      System.out.println("No Image");
    }
  }
  
  //paint method 
  public void paint(Graphics2D g)
  {
    //changes model depending on upgrade or not
    if(upgradeLevel==0)
    {
      //attack animation based on whether variable was changed to true from TowerDefense class
      if(attackA)
      {
        g.drawImage(img3, x, y, null);
        animationCount++;
      }
      else
      {
      g.drawImage(img, x, y, null);
      }
    }
    else
    {
      if(attackA)
      {
        g.drawImage(img4, x, y, null);
        animationCount++;
      }
      else
      {
      g.drawImage(img2, x, y, null);
      }
    }
    
    // resets model back to normal stance after attack animation
    if(animationCount==30)
    {
      animationCount=0;
      attackA=false;
    }
  }
  
  //returns true if enemy unit a is in attack range of friendly unit b
  public static boolean attack(Enemy a, Friendly b)
  {
      if (a.getX() <= (b.getX()-b.range) + (b.range * 2) + 35 && a.getX() >= b.getX() - b.range && a.getY() >= b.getY() - b.range && a.getY() <= (b.getY() - b.range) + (b.range * 2) + 35){
      return true;
      }
      else
      {
        return false;
      }

  }
  
  //returns x value of unit
  public int getX()
  {
    return x;
  }
  
  //returns y value of unit
  public int getY()
  {
    return y;
  }
  
  
  public void move()
  {
    x=50;
    y=50;
  }
  
  //used in contructor
  //takes the string parameter from constructor and sets up variables for the unit needed
   private void readType(String a)
  {
    if (a=="Mage")
    {
      pic="Mage.png";
      picU= "Sprites\\MageU.png";
      picA= "Sprites\\MageA.png";
      picAU= "Sprites\\MageUA.png";
      attackPower=15;
    }     
    if (a=="Archer")
    {
      pic="Archer.png";
      picU= "Sprites\\ArcherU.png";
      picA= "Sprites\\ArcherA.png";
      picAU= "Sprites\\ArcherUA.png";
      attackPower=30;
    }
        if (a=="Swordsman")
    {
      pic="Swordsman.png";
      picU= "Sprites\\SwordsmanU.png";
      picA= "Sprites\\SwordsmanA.png";
      picAU= "Sprites\\SwordsmanUA.png";
      attackPower=40;
    }
        if (a=="AxeWielder")
    {
      pic="AxeWielder.png";
      picU= "Sprites\\AxeWielderU.png";
      picA= "Sprites\\AxeWielderA.png";
      picAU= "Sprites\\AxeWielderUA.png";
      attackPower=50;
    }
        if (a=="Lancer")
    {
      pic="Lancer.png";
      picU= "Sprites\\LancerU.png";
      picA= "Sprites\\LancerA.png";
      picAU= "Sprites\\LancerUA.png";
      attackPower=40;
    }
    
  }

}
  