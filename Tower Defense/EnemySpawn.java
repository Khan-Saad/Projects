import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;
import java.util.*;
public class EnemySpawn
{
  //round  variable controls whether enemies are going to spawn
  boolean round= false;
  String pic;
  String type;
  
  //initial coordinates of friendlies before they are spawned
  private int a =150;
  private int b=150;
  private int gold;
  
  //sets range of units
  private int range=0; 
  
  //brings up the selection menu
  public boolean place= false;
  
  //lets user move and place unit
  public boolean spawn= false;
  
  //hold image for the unit preview before it is spawned
  private BufferedImage img = null;
  
  //list that holds all locations currently taken up by friendly units
  private ArrayList<Integer> xValue = new ArrayList<Integer>();
  private ArrayList<Integer> yValue = new ArrayList<Integer>();
  
  //hold which unit has been clicked on by using x and y coordinates
  int xUp, yUp;
  
  //allows units to snap to an invisible grid system and not anywhere on the map
  int xOffset,yOffset;
  
  public EnemySpawn()
  {
    
  }
  
  public void paint(Graphics2D g)
  {
    
    
      
    //displays range of unit being spawned
    if(place)
    {
      g.setColor(Color.RED);
      g.drawImage(img, a, b, null);
      g.drawRect(a-range, b-range,(range*2) + 35,(range*2) + 35);
      
    }
  }
  
  public void mouseReleased(MouseEvent e) 
  {
  }
  
  //changes pic according to what unit is spawning
  public void changePic()
  {
    try
    {
      img = ImageIO.read(new File(pic));
    } catch (IOException e)
    {
      System.out.println("No Image");
    }
  }
  
  public void mousePressed(MouseEvent e) 
  {
    //if the mage button is clicked
    if(e.getX() > 645 && e.getX() < 795 && e.getY() < 216 && e.getY() > 147)
    {
      //if it is before round 5 you cannot buy the mage
      if (gold < 50||TowerDefense.roundGame<5)
      {
        
      }
      
      //else biing up mage menu
      else
      {
        TowerDefense.characterMage = true;
        type = "Mage";
        pic = "Mage.png";
        range=70;
      }
    }
    
    //if new round button is clicked
    if(e.getX() >720 && e.getY()>532&&TowerDefense.fakeRound%2==0&&TowerDefense.enemies.isEmpty())
    {
      TowerDefense.fakeRound+=1;
      TowerDefense.roundGame+=1;
    }
    
    if(e.getX() > 645 && e.getX() < 795 && e.getY() < 297 && e.getY() > 225)
    {
      if (gold < 30)
      {
      }
      else
      {
        
        TowerDefense.characterArcher = true;
        type= "Archer";
        range=100;
        pic="Archer.png";
      }
    }
    if(e.getX() > 645 && e.getX() < 795 && e.getY() < 374 && e.getY() > 302)
    {
      if (gold < 60)
      {
      }
      else
      {
        
        TowerDefense.characterAxeWielder = true;
        type= "AxeWielder";
        range=30;
        pic="AxeWielder.png";
        changePic();
      }
    }
    if(e.getX() > 645 && e.getX() < 795 && e.getY() < 449 && e.getY() > 381)
    {
      if (gold <60)
      {
      }
      else
      {
        
        TowerDefense.characterSwordsman = true;
        type= "Swordsman";
        range=50;
        pic="Swordsman.png";
        changePic();
      }
    }
    if(e.getX() > 645 && e.getX() < 795 && e.getY() < 531 && e.getY() > 456)
    {
      if (gold < 60)
      {
      }
      else
      {
        
        TowerDefense.characterLance = true;
        type= "Lancer";
        range=50;
        pic="Lancer.png";
        changePic();
      }
    }
    
    //while place is true, you can move and place the units
    if(place)
    {
      
      
      if(e.getButton()==MouseEvent.BUTTON3)
      {
        //moves x and y vales of the click left till the nearest loaction a unit can be spawned
        for(int x=0; x<50;x++)
        {
          if((e.getX()-x)%40==0)
          {
            xOffset = e.getX()-x;
            x=50;
          }
          
        }
        
        for(int x=0; x<50;x++)
        {
          if((e.getY()-x)%40==0)
          {
            yOffset = e.getY()-x; 
            x=50;
          }
          
        }
        
        //if the location given by the code above is not on another unit or on the track, the unit preview moves there and a unit can be spawned there
        if(checkSpot(xOffset,yOffset)&&trackCheck(xOffset,yOffset))
        {
          a=xOffset;
          b=yOffset;
        }
        
      }
      
      //if while placing the unit you press left click, the unit is sent to be spawned and its coordinates are added the a list for future reference
      if (e.getButton() == MouseEvent.BUTTON1)
      {
        xValue.add(new Integer(a));
        yValue.add(new Integer(b));
        spawn=true;
      }
    }
    
    if(e.getX() > 225 && e.getX() < 325 && e.getY() < 451 && e.getY() > 400)
    { 
      if (e.getButton() == MouseEvent.BUTTON1)
      {
        if(TowerDefense.characterMage || TowerDefense.characterArcher||TowerDefense.characterAxeWielder || TowerDefense.characterSwordsman ||TowerDefense.characterLance){
          TowerDefense.characterMage = false;
          TowerDefense.characterArcher = false;
          TowerDefense.characterSwordsman = false;
          TowerDefense.characterAxeWielder = false;
          TowerDefense.characterLance=false;
          place=true;
          changePic();
        }
        
        else{
          TowerDefense.characterMage = false;
          TowerDefense.characterArcher = false;
        }
      }
    }
    
    //if exit button is pressed on unit selection screen it will cancel the operation
    if(e.getX() > 423 && e.getX() < 479 && e.getY() < 479 && e.getY() > 455)
         { 
      if(TowerDefense.characterMage || TowerDefense.characterArcher||TowerDefense.characterAxeWielder || TowerDefense.characterSwordsman||TowerDefense.characterLance){
        TowerDefense.characterMage = false;
        TowerDefense.characterArcher = false;
        TowerDefense.characterSwordsman = false;
        TowerDefense.characterAxeWielder = false;
        TowerDefense.characterLance= false;
      }
    }
       
       
       
       //if upgrade is true, if the upgrade button is pressed a unit is upgraded
    if(TowerDefense.upgrade)
    {
      if(e.getX() > 639 && e.getX() <717 &&e.getY() > 532)
      {
        //only happens if user has enough gold, and unit has not already been upgraded
        if(TowerDefense.gold>=100&&TowerDefense.friendlies.get(exactSpot(xUp,yUp)).upgradeLevel<1)
        {
        TowerDefense.friendlies.get(exactSpot(xUp,yUp)).attackPower+=15;
        TowerDefense.friendlies.get(exactSpot(xUp,yUp)).upgradeLevel++;
        TowerDefense.upgrade=false;
        TowerDefense.gold=TowerDefense.gold-100;
        }
        else
        {
          TowerDefense.upgrade=false;
        }
      }
      else
      {
        TowerDefense.upgrade=false;
      }
      }
    
    //while not placing a unit, anytime you click anywhere, this checks if you clicked on a unit
    if(!place)
    {
      for(int x=0; x<50;x++)
      {
        if((e.getX()-x)%40==0)
        {
          xUp = e.getX()-x;
          break;
        }
        
      }
      for(int x=0; x<50;x++)
      {
        if((e.getY()-x)%40==0)
        {
          yUp = e.getY()-x; 
          x=50;
        }
        
      }
      
      //if a unit was clicked the option to upgrade is available
      if(!checkSpot(xUp, yUp))
      { 
        if(TowerDefense.friendlies.get(exactSpot(xUp,yUp)).upgradeLevel<1)
        {
        TowerDefense.upgrade=true;
        }
        else
        {
        }
      }
      
    }
  }
    
    

  
  //accessors
  public boolean getS()
  {
    return spawn;
  }
  public void setS()
  {
    spawn=false;
    place=false;
  }
  public int getA()
  {
    return a;
  }
  public int getB()
  {
    return b;
  }
  public void getAB(){
    
    a = 150;
    b = 150;
    
  }
  
  public String getType()
  {
    return type;
  }
  public boolean getRound()
  {
    return round;
  }
  
  //allows TowerDefense to end the round once spawn limit has been reached
  public void setRound()
  {
    round=false;
  }
  
  ///gets gold from TOwerDefense to check if there is enough to spawn units
  public void getGold(int gold)
  {
    this.gold = gold;
  }
  
  //finds what unit is in the given x and y values
  // the int is the number in the list
  public int exactSpot(int x, int y)
  { 
    int spot=-1;
    for (int j=0; j<xValue.size(); j++)
    {
      if(x==xValue.get(j)&& y==yValue.get(j))
      {
        spot = j;
      }
      else
      {
        
      }
    }
    
    return spot;
  }
  
  //just checks if the spot with given x and y is taken
  public boolean checkSpot(int x, int y)
  { 
    boolean flag= true;
    if(yValue.size()==0)
    {
      flag=true;
    }
    else
    {
      for (int j=0; j<xValue.size(); j++)
      {
        if(x==xValue.get(j)&& y==yValue.get(j))
        {
          flag= false;
        }
        else
        {
          
        }
      }
    }
    return flag;
  }
  
  //if the given x and y values are on the track, returns false
  public boolean trackCheck(int x, int y)
  {
    if( (x>=560&&y>=320&&x<600) || (x<560&&x>=280&&y>=320&&y<360) || (x<320 &&x>=280&&y>=320&&y<560)|| (x<320 &&x>=40&&y>=520&&y<560) || (x<80 &&x>=40&&y>=240&&y<560) || (x<280 &&x>=40&&y>=240&&y<280) || (x<360 &&x>=280&&y>=280&&y<280) || y<200||x>=640)
    {
      return false;
    }
    else
    {
      return true;
    }
  }
  
  
}