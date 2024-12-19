//file5
package java.lang;
import java.util.Arrays;
public class ShipDemo {
    public static void main(String[] args) {
        /**
         * create an array that can store  insatnce sof the class Ship (3)
         * Remember, an instance of a subclass is considered as an instance of a superclass, so this is considered
         * as a valid element for the array
         * Below is exercise f, where we intialize the array mentioned earlier.
         * Then, create a for loop and execute the toString() method
         */
        Ship[] arraylist = new Ship[3];

        CruiseShip obj1 = new CruiseShip(567);
        CargoShip obj2 = new CargoShip(1000);
        TankerShip obj3 = new TankerShip("C02", 10000.789);

        arraylist[0] = obj1;
        arraylist[1] = obj2;
        arraylist[2] = obj3;

        for(int i = 0; i<3; i++){
            System.out.println(arraylist[i].toString());
            System.out.println("---------------------------");
        }

        System.out.println();

        //Now we will do exercise g.
        //Create three objects of CruiseShip class and store them in an array
        CruiseShip o1 = new CruiseShip(988);
        CruiseShip o2 = new CruiseShip(989);
        CruiseShip o3 = new CruiseShip(900);
        CruiseShip[] array = new CruiseShip[3];
        array[0] = o1;
        array[1] = o2;
        array[2] = o3;

        //print all CruiseShip Instances before you sort them
        System.out.println("Before sorting three objects of CruiseShip");
        for(int j = 0; j<3; j++){
            System.out.println("[" + j + "]");
            System.out.println(array[j].toString());
            System.out.println();
        }

        System.out.println("After sorting three objects of CruiseShip");
        Arrays.sort(array); //method from chapter 7. We are able to sort instances of class using this built in method due to compareTo method
        for(int m = 0; m<3; m++){
            System.out.println("[" + m + "]");
            System.out.println(array[m].toString());
            System.out.println();
        }
    }
}

interface  Comparable<E>{
    public int compareTo(E o);

}

//file1 - exercise a
class Ship
{
    //data fileds
    private String ShipName;
    private String ShipYear;

    //no arg constructor
    public Ship(){
        ShipName = "TTS";
        ShipYear = "1995";
    }

    //arg constructor
    public Ship(String ShipName, String ShipYear){
        this.ShipName = ShipName;
        this.ShipYear = ShipYear;
    }

    //mutatorsS
    public void setShipName(String ShipName){
        this.ShipName = ShipName;
    }

    public void setShipYear(String ShipYear){
        this.ShipYear = ShipYear;
    }

    //accessors
    public String getShipName(){
        return ShipName;
    }

    public String getShipYear(){
        return ShipYear;
    }

    //toString
    @Override
    public String toString(){
        return "Ships name: " + ShipName + " " + "Year it was built: " + ShipYear;
    }
}

//file2 - exercise b
class CruiseShip extends Ship implements Comparable<CruiseShip>
{

    //data field
    private int MaxPassengers;

    //no arg constructor
    public CruiseShip(){
        MaxPassengers = 999;
    }

    //arg constructor
    public CruiseShip(int MaxPassengers){
        super("Mario","1997");
        this.MaxPassengers = MaxPassengers;
    }

    //mutator
    public void setMaxPassengers(int MaxPassengers){
        this.MaxPassengers = MaxPassengers;
    }

    //accessor
    public int getMaxPassengers(){
        return MaxPassengers;
    }

    //toString method
    @Override
    public String toString(){
       return super.toString() + "\n" + "Maximum number of passengers: " + MaxPassengers;
    }

    @Override
    public int compareTo(CruiseShip o) {
        if(this.MaxPassengers > o.MaxPassengers){
            return 1;
        }
        else if(this.MaxPassengers == o.MaxPassengers){
            return 0;
        }
        else{
            return -1;
        }
    }
}

//file3 - exercise c
class CargoShip extends Ship implements Comparable<CargoShip>
{
    private int capacity;

    //no arg constructor
    public CargoShip(){
        capacity = 50000;
    }

    //arg constructor
    public CargoShip(int capacity){
        super("Luigi", "1998");
        this.capacity = capacity;
    }

    //mutator
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    //accessor
    public int getCapacity(){
        return capacity;
    }

    //toString method
    @Override
    public String toString(){
        return super.toString() + "\n" + "Ships capacity: " + capacity;
    }

    //compareTo method
    @Override
    public int compareTo(CargoShip o) {
       if(this.capacity > o.capacity){
           return 1;
       }
       else if(this.capacity == o.capacity){
           return 0;
       }
       else{
           return -1;
       }
    }
}

//file4 - exercise d
class TankerShip extends Ship implements Comparable<TankerShip>
{
    //data fields
    private String GasBulk;
    private Double capacity;

    //no arg constructor
    public TankerShip(){
        GasBulk = "Methane";
        capacity = 99999.999;
    }

    //arg constructor
    public TankerShip(String GasBulk, Double capacity){
        super("Waldo", "2001");
        this.GasBulk = GasBulk;
        this.capacity = capacity;
    }

    //mutator
    public void setGasBulk(String GasBulk){
        this.GasBulk = GasBulk;
    }

    public void setCapacity(Double capacity){
        this.capacity = capacity;
    }

    //accessor
    public String getGasBulk(){
        return GasBulk;
    }

    public Double getCapacity(){
        return capacity;
    }

    @Override
    public String toString(){
        return super.toString() + "\n" + "Type of gas: " + GasBulk + "\n" + "Capacity: " + capacity;
    }


    @Override
    public int compareTo(TankerShip o) {
        //
    }
}