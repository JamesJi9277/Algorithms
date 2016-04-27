import java.io.*;
import java.util.*;

/*
1. levels, default number of levels
2. 
*/

class Person{
  
    private String personID;
    private ParkingSpot parkS;
  
    public Person(){
      
    }
  
    public boolean park(ParkingLot pl){
     
        if( pl.getAvailableLevel() == null ){
            return false;
        }
        ParkingSpot ps = pl.getAvailableLevel().getParkingSpot();
        parkS = ps.getSpotID();
        return true;   
    }
  
  
    public boolean unpark(ParkingLot pl){
        // 根据ticketID, 找到parkingSpot
        // parkingSpot set tate is not occupied
        parkS.setState(false);
        
        pl.getLevel( parkS.getLevelID() ).putParkingSpot();
        
    }
  
}

class Level{
  private static final int spotCapacity = 100;
  private int levelID;
  /*
  private boolean[] C1currentAvailableLevel;
  private boolean[] C2currentAvailableSpotInCueerntLevel;
  */
  private ParkingSpot[] parkSpots;
  
  private int currentAvailable;
  private int currentNotAvailable;
  
  public Level(int id){
    
    // initialization parking spots
    this.levelID = id;
    ParkingSpot[] parkSpots = new ParkingSpot[spotCapacity];
    for(int i = 0; i < spotCapacity; i++){
       ParkingSpot ps = new ParkingSpot( levelID * 1000 + i );
       parkSpots[i] = ps;
    }
    currentAvailable = spotCapacity;
    currentNotAvailable = 0;
  }
  
  // return minimal spotID as available parking spot
  public ParkingSpot getParkingSpot(){
      for(int i = 0; i < parkSpots.length; i++){
          if( parkSpots[i].getState() == true ){
              parkSpots[i].setState(true);
              return parkSpots[i];
          }
      }
      return null;
  }
  
  public void putParkingSpot(){
      currentAvailable++;
      currentNotAvailable--;
  }
  
  
  public int getCurrentAvailable(){
      return this.currentAvailable;
  }
  
}

class ParkingLot{
  
  private static final int levelCapacity = 5;
  private Level[] levels;
  private static ParkingLot parkingLot = null;

  public ParkingLot(){
  	//check if it has been initialize before
     if(parkingLot == null) {
     	parkingLot = new parkingLot();
     }  

     levels = new Level[levelCapacity];
    
     for(int i = 0; i < levelCapacity; i++){
        Level level = new Level(i+1);
        levels[i] = level;
     }
    
  }
  
  public Level getAvailableLevel(){
      for( int i = 0; i < levels.length; i++){
          if( levels[i].getCurrentAvailable() > 0 ){
              return levels[i];
          }
      }
      return null;
  }
  
  // getter methods
  // setter methods
}


abstract class ParkingSpot{
    private int spotID;
    private boolean isAvailable;
    private int levelID;  
  
  
    public ParkingSpot(int id, int levelID){
      this.spotID = id;
      this.levelID = levelID;
      isAvailable = true;
    }
}

class bigParkingSpot extends ParkingSpot{
	private int spotID;
    private boolean isAvailable;
    private int levelID;  
  
  
    public ParkingSpot(int id, int levelID){
      this.spotID = id;
      this.levelID = levelID;
      isAvailable = true;
    }
    // getter method
    public int getSpotID(){
        return spotID;
    }
    public int getLevelID(){
        return levelID;
    }

    public void setState(boolean occupied){
        isAvailable = !occupied;
    }
    public boolean getState(){
        return isAvailable;
    }
}

class smallParkingSpot extends ParkingSpot {
    private int spotID;
    private boolean isAvailable;
    private int levelID;  
  
  
    public ParkingSpot(int id, int levelID){
      this.spotID = id;
      this.levelID = levelID;
      isAvailable = true;
    }
    // getter method
    public int getSpotID(){
        return spotID;
    }
    public int getLevelID(){
        return levelID;
    }

    public void setState(boolean occupied){
        isAvailable = !occupied;
    }
    public boolean getState(){
        return isAvailable;
    }
}




class Solution {
  public static void main(String[] args) {
    
      ParkingLot parkLot = new ParkingLot();
      Person p1 = new Person("sdadad");
  }
}
