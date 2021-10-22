import java.io.*;
import java.util.*;
import java.awt.Point;
import java.lang.*;
/**
 * Map.java - class with a map constructor and loadmap methods,
 * getcharatloc methods, maptostring methods, etc.
 * Contains two instance variables, map (now singleton) and revealed
 */

public class Map{
  private char [][] map;
  private boolean [][] revealed;
  static Map instance;
  /**
	 * Constrcutor for map, creates two [][] one of them with chars and the other with booleans
	 */
  public Map()
  {
    map = new char[5][5]; 
    revealed = new boolean[5][5];
  }
  /**
   *getInstance() - Singelton map instance method
   *@return - a singleton instance of the map
   */
  public static Map getInstance(){
    if(instance == null)
    {
      instance = new Map();
    }
    return instance;
  }
  /**
	 * Reads the file correlating with the mapNum(map1.txt, map2.txt and map3.txt)
	 * Iterate through two for loops in order to get every single point of the 2d array
	 * Use a try and catch block to make sure the mapNum is viable 
   * Also iterates through whole map and sets everything in revealed to false except for the start position
	 * @param mapNum, mapNUm will be used to correlate which map.txt to use
	 */

  public void loadMap(int mapNum){
    try {
      Scanner read = new Scanner(new File("map" + mapNum + ".txt"));
      while (read.hasNextLine()) {
        for (int i = 0; i < map.length; i++) {
          String line = read.nextLine().replace(" ", "");
          for (int j = 0; j < map.length; j++) {
            map[i][j] = line.charAt(j);
          }
        }
      }
      read.close();
    } catch (FileNotFoundException e) {
      System.out.println("File Not Found");
    }

    for(int i = 0; i < 5; i++)
    {
      for(int j = 0; j < 5; j++)
      {
        if(map[i][j] == 's')
        {
          revealed[i][j] = true;
        }
        else 
        {
          revealed[i][j] = false;
        }
      }
    }
  }
  /**
	 * @param Point p, gets the location in which we want the char at
	 * @return the char at the current location of the hero
	 */
  public char getCharAtLoc(Point p)
  {
    return map[p.x][p.y];
  }
  
  /**
	 * Iterates through the whole map and creates a string of the whole map
	 * makes sure to append the correct char in the string
	 * @param Point p
	 * @return the string version of the map
	 */ 
  public String mapToString(Point p)
  {
    StringBuilder sb = new StringBuilder();
    String s = " ";
    int count = 0;

    for (int i = 0; i < 5; i++) { 
      for (int j = 0; j < 5; j++) { 
        count++;
        if(revealed[i][j] == false)
        {
          sb.append('x' + " ");
        }
        else if(i == p.x && j == p.y)
        {
          sb.append('*' + " ");
        }
        else
        {
          if(map[i][j] == 's')
          {
            sb.append('s' + " ");
          }
          else if(map[i][j] == 'f')
          {
            sb.append('f' + " ");
          }
          else if(map[i][j] == 'm')
          {
            sb.append('m' + " ");
          }
          else
          {
            sb.append('n' + " ");
          }
        }
        if(count % 5 == 0)
        {
          sb.append(" \n");
        }
        s = sb.toString();
      }
    }
    if(map[p.x][p.y] == 'f')
    {
      return s;
    }
    return s;
  }


  /**
	 * Iterates through the whole map and finds the start point by finding 's'
   * call reveal() on the point
	 * @return the beginning point of the map
	 */
  public Point findStart()
  {
    Point w = new Point(0,0);
    for (int i = 0; i < 5; i++) 
    { 
      for (int j = 0; j < 5; j++) 
      { 
        if(map[i][j] == 's')
        {
          w = new Point(i,j);
          break;
        }
      } 
    }   
    reveal(w);
    return w;
  }


  /**
	 * Changes the point's boolean at the location to true
	 * @param Point p, the location in which we would like to change
	 */
  public void reveal(Point p)
  {
    revealed[p.x][p.y]= true;
  }

  /**
	 * After we visit the location, change the char to 'n' if it was 'm', 'n' or 'i'
	 * @param Point p, the location of the hero
	 */
  public void removeCharAtLoc(Point p)
  {
    if(map[p.x][p.y] == 'm' || map[p.x][p.y] == 'n' || map[p.x][p.y] == 'i')
    {
      map[p.x][p.y] = 'n';
    }
  }
}
