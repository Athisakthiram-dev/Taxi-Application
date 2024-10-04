package TaxiApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mainclass {


        public static void main(String[] args) {
            List<Taxi> taxiList=new ArrayList<>();
            for(int i=1;i<=4;i++){
                taxiList.add(new Taxi(i));
            }
            System.out.println("Welcome to taxi Booking application");
            Scanner sc=new Scanner(System.in);
            int customerId=1;
            while(true){
                System.out.println("1.Book a taxi\n2.Display Taxi details\n3.Exit");
                int userChoice=sc.nextInt();
                switch(userChoice){
                    case 1:
                        TaxiBookings bookings=new TaxiBookings(customerId);
                        TaxiBookings.book(taxiList,bookings);
                        customerId++;
                        break;
                    case 2:
                        displayTaxiDetails(taxiList);
                        break;

                }
            }



        }

    private static void displayTaxiDetails(List<Taxi> taxiList) {
            System.out.println("Taxi Details: ");
            for(Taxi taxi:taxiList){
                System.out.println("Taxi " + taxi.getTaxiNo() + ": Current Location = " + taxi.getCurrentLocation() +
                        ", Total Earnings = Rs." + taxi.getTotalEarnings() +
                        ", Available = " + (taxi.isAvailable() ? "Yes" : "No") +
                        ", Free Time = " + taxi.getFreeTime() + "hrs");
            }
    }
}


