import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
class Shape{
  ArrayList<Point> points;
  static Scanner sc;
  String filename;
  Shape(String p){
    try{
      filename = p;
      File file = new File(p);
      sc = new Scanner(file);
      points = new ArrayList<Point>();
      while(sc.hasNextLine()){
        String[] tokens = sc.nextLine().split(","); 
        double x = Double.parseDouble(tokens[0]);
        double y = Double.parseDouble(tokens[1]);
       // System.out.println("file: "+p+"\nTOKEN 1== "+ x + " TOKEN 2== "+ y);
        points.add(new Point(x,y));
      }
    }
    catch(FileNotFoundException e){
      System.out.println("I'm sorry file in the path "+p+" Does NOT EXIST!");
    }catch(Exception e){
    System.out.println("I'm sorry there has been an input mismatch!"+e);
    }
  }
  
  double getPerimeter(){
    double sum=0;
    int i;
    for(i =1; i < points.size();++i){
      sum+= points.get(i).getDistance(points.get(i-1));
    }
    sum+= points.get(i-1).getDistance(points.get(0));
    return sum;
  }
  
  double getAverageLength(){
    return getPerimeter()/points.size();
  }
  
  double getLongestSide(){
    double result = 0;
    double length;
    int i;
    for( i =1; i < points.size();++i){
      length= points.get(i).getDistance(points.get(i-1));
      if(result<length){
        result = length;
      }
    }
    length = points.get(i-1).getDistance(points.get(0));
    if(result<length){
        result = length;
      }
    return result;
  }
  
  void showInfo(){
    System.out.println("For "+filename+" : \n"
                      +"Perimeter of Shape: "+getPerimeter()
                      +"\nAverage Length: "+getAverageLength()
                      +"\nLongest Side: "+getLongestSide());
  }
  
}