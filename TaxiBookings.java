package TaxiApplication;

import java.util.List;
import java.util.Scanner;

public class TaxiBookings {

    private int customerId;
    private char pickupPoint;
    private char dropPoint;
    private int pickupTime;

    TaxiBookings(int customerId){
        this.customerId=customerId;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your pickup point: ");
        pickupPoint=sc.next().charAt(0);
        System.out.println("Enter your drop point: ");
        dropPoint=sc.next().charAt(0);
        System.out.println("Enter your Pickup Time: ");
        pickupTime=sc.nextInt();
    }
    public static void book(List<Taxi> taxiList,TaxiBookings bookings){
        Taxi allocatedTaxi=findNearestTaxi(bookings.pickupPoint,taxiList,bookings.pickupTime);
        if(allocatedTaxi!=null){
            int fare=calculateFare(bookings.pickupPoint,bookings.dropPoint);
            System.out.println("Taxi NO: "+allocatedTaxi.getTaxiNo()+ "is booked successfully");
            allocatedTaxi.setTotalEarnings(fare);
            allocatedTaxi.setCurrentLocation(bookings.dropPoint);
            allocatedTaxi.setAvailable(false);
            allocatedTaxi.setFreeTime(bookings.pickupTime+calculateTime(bookings.pickupPoint,bookings.dropPoint));
            System.out.println("Fare for this trip:"+ fare);
        }else{
            System.out.println("No taxis are free try again later");
        }


    }

    private static int calculateTime(char pickupPoint, char dropPoint) {
        return Math.abs(pickupPoint-dropPoint)*1;
    }

    private static int calculateFare(char pickupPoint, char dropPoint) {
        int distance=Math.abs(pickupPoint-dropPoint);
        int fare=((distance*15)-5)*10+100;
        return fare;
    }

    private static Taxi findNearestTaxi(char pickupPoint, List<Taxi> taxiList, int pickupTime) {
    Taxi nearestTaxi=null;
    int minDistance=Integer.MAX_VALUE;
    for(Taxi taxi:taxiList){
        if(taxi.isAvailable() || taxi.getFreeTime()<=pickupTime){
            int distance=Math.abs(taxi.getCurrentLocation()-pickupPoint);
            if(distance< minDistance || (distance==minDistance && taxi.getTotalEarnings() < (nearestTaxi!=null ? nearestTaxi.getTotalEarnings():Integer.MAX_VALUE))){
                nearestTaxi=taxi;
                minDistance=distance;
            }
        }
    }return nearestTaxi;
    }


}
