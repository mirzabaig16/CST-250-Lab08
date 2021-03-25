package edu.ru.lab08;

import java.util.Comparator;
public class Camera{
    
    private String address;
    private String firstApproach;
    private String secondApproach;
    private String goLiveDate;
    private double latitude;
    private double longitude;
    
    public Camera(String address, String firstApproach, String secondApproach, String goLiveDate, double latitude, double longitude){
        this.address = address;
        this.firstApproach = firstApproach;
        this.secondApproach =secondApproach;
        this.goLiveDate = goLiveDate;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
     public String getFirstApproach(){
        return this.firstApproach;
    }
    public void setFirstApproach(String firstApproach){
        this.firstApproach = firstApproach;
    }
     public String getSecondApproach(){
        return this.secondApproach;
    }
    public void setSecondApproach(String secondApproach){
        this.secondApproach = secondApproach;
    }
     public String getGoLiveDate(){
        return this.goLiveDate;
    }
    public void setGoLiveDate(String goLiveDate){
        this.goLiveDate = goLiveDate;
    }
     public double getLatitude(){
        return this.latitude;
    }
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }
    public double getLongitude(){
        return this.longitude;
    }
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }
    
    
    public void Display(){
        
        
        System.out.println("Camera Located At: " + this.address);
        System.out.println("Camera Installed On: " + this.goLiveDate);
        System.out.println("Camera latitude - longitude: " + this.latitude+ " - "+this.longitude);
        System.out.println("------------------------------------");
        
    }
    
    public double getDistance( double latitude,double longitude){
        double distance = distance(this.latitude,latitude,this.longitude,longitude,"K");
        //K for kilometer and M for miles
     return distance;
    }
    
   private double distance(double lat1, double lat2, double lon1, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		}
		else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if (unit.equals("K")) {
				dist = dist * 1.609344;
			} 
			return (dist);
		}
   }
    public static Comparator<Camera> year = new Comparator<Camera>() {

	public int compare(Camera c1, Camera c2) {

	   int year1 = Integer.parseInt(c1.getGoLiveDate().split("/")[2]);
	   int year2 = Integer.parseInt(c2.getGoLiveDate().split("/")[2]);

	   /*For ascending order*/
	   return year1-year2;

	   /*For descending order*/
	   //rollno2-rollno1;
   }};
}