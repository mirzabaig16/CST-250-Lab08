package edu.ru.lab08;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
public class MainClass
{
	public static void main(String[] args) {
	    ArrayList<Camera> cameras = new ArrayList();
	    
	    try{
	        File myFile = new File("C:\\Users\\Tayyab\\Lab08\\CST-250-Lab08\\Lab08\\src\\main\\java\\edu\\ru\\lab08\\data.txt");
	        Scanner scanner = new Scanner(myFile);
	        while(scanner.hasNextLine()){
	           String row = scanner.nextLine(); 
	           String[] camProp = row.split(",");
	           cameras.add(new Camera(
	               camProp[0],
	               camProp[1],
	               camProp[2],
	               camProp[3],
	               Double.valueOf(camProp[4]),
	               Double.valueOf(camProp[5])
	               ));
	        }
	      
	    }
	    catch(Exception ex){
	    System.out.println("Error Occured"); 
	    System.out.println("Error Message : "+ex.getMessage());    
	    ex.printStackTrace();
	    }
		
		//Sorting by Year
      Collections.sort(cameras,Camera.year);
      	for (Camera cam : cameras) { 		    
           cam.Display();
      }
      //Near By camera
      int i=0;
      	for (Camera cam : cameras) { 
      	    
      	    double dist =cam.getDistance(41.86040786445197,-87.69867209877323);
      	    if( dist <= 5){ // in circle of 5Km 
      	        i++;
      	        System.out.println("No : "+ i);
      	        System.out.println("Distance : "+ dist+" km");
           cam.Display();
      	    }
      }
		//cameras.get(10).Display();
		//  System.out.println(cameras.get(9).getDistance(41.86040786445197,-87.69867209877323)+ " km");
	      //  System.out.println(cameras.get(9).getAddress());
	}
}
