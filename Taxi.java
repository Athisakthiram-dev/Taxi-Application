package TaxiApplication;

public class Taxi {
       private int taxiNo;
       private int freeTime;
       private int totalEarnings;
       private char currentLocation;
       private boolean isAvailable;

       Taxi(int taxiNo){
           this.taxiNo=taxiNo;
           this.currentLocation='A';
           this.totalEarnings=0;
           this.isAvailable=true;
           this.freeTime=0;
       }
    public int getTaxiNo() {
        return taxiNo;
    }

    public void setTaxiNo(int taxiNo) {
        this.taxiNo = taxiNo;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(int freeTime) {
        this.freeTime = freeTime;
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(int totalEarnings) {
        this.totalEarnings +=totalEarnings;
    }

    public char getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(char currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
