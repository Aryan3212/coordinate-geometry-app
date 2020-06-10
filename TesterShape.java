import java.util.ArrayList;
import java.util.Scanner;
public class TesterShape{
  static Scanner sc;
  public static void main(String args[]){
    char run = 'y';
    do{
      System.out.println("Number of files and name of the files please:  ");
      sc = new Scanner(System.in);
      int numOfFiles = sc.nextInt();
      String fileName = sc.next();
      ArrayList<String> filenames = new ArrayList<String>();
      ArrayList<Shape> shapes = new ArrayList<Shape>();
      for(int i =1 ; i <= numOfFiles; ++i){
        filenames.add("data//"+fileName+i+".txt");
        shapes.add(new Shape(filenames.get(i-1)));
      }
      String maxPerimeterfile="";
      double maxPerimeterShape = 0;
      try{
        for(int i =0 ; i < numOfFiles; ++i){
        shapes.get(i).showInfo();
        if(shapes.get(i).getPerimeter()> maxPerimeterShape){
          maxPerimeterShape = shapes.get(i).getPerimeter();
          maxPerimeterfile = shapes.get(i).filename;
        }
      }
      System.out.println("File with LARGEST Perimeter is: "+maxPerimeterfile+"\n"
                           +"The Perimeter is: "+ maxPerimeterShape);
      }catch(Exception e){
        System.out.println("No files were loaded Or there was an error I don't know of "+e);
      }
      
      System.out.println("Do you want run the program again? :ENTER y or n");
      run = sc.next().charAt(0);
     
    }while(run == 'y');
  }
}