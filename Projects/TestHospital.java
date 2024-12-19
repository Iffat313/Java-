import javax.print.Doc;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
//file6 - exercise g
public class TestHospital {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in); //this Scanner object is used for while loop conditon
        Scanner str = new Scanner(System.in); //this Scanner object is used for string input
        Scanner numeric = new Scanner(System.in); //this Scanner object is used for double input
        //data fields used to read from user
        String patientID;
        String FirstName;
        String LastName;
        String DocFirstName;
        String DocLastName;
        String DocSpecialty;
        String AdmitDate;
        String DischargedDate;
        int day;
        int month;
        int year;
        double PharmacyCharge;
        double RoomRent;
        double DocFee;


        char Userinput = 'y';
        while(Userinput!='n'){
            System.out.println();
            System.out.print("Enter patient's ID: ");
            patientID = str.next();
            System.out.print("Enter patients first name: ");
            FirstName = str.next();
            System.out.print("Enter patients last name: ");
            LastName = str.next();
            System.out.println();

            System.out.print("Enter doctor's first name: ");
            DocFirstName = str.next();
            System.out.print("Enter doctor's last name: ");
            DocLastName = str.next();
            System.out.print("Enter doctor's specialty: ");
            DocSpecialty = str.next();
            Doctor doctor = new Doctor(DocSpecialty, DocFirstName, DocLastName);
            System.out.println();

            System.out.print("Enter Admit Date (day/month/year): ");
            AdmitDate = str.next();
            day = AdmitDate.charAt(0) - '0';
            String temp = AdmitDate.substring(2,4);
            month = Integer.parseInt(temp);
            String temp2 = AdmitDate.substring(5);
            year = Integer.parseInt(temp2);
            Date Admit = new Date(day, month, year);

            System.out.print("Enter Discharged Date (day/month/year): ");
            DischargedDate = str.next();
            day = DischargedDate.charAt(0) - '0';
            temp = DischargedDate.substring(2,4);
            month = Integer.parseInt(temp);
            temp2 = DischargedDate.substring(5);
            year = Integer.parseInt(temp2);
            Date Discharged = new Date(day, month, year);

            System.out.print("Enter pharmacy Charges, room Rent, and docter fee: ");
            PharmacyCharge = numeric.nextDouble();
            RoomRent = numeric.nextDouble();
            DocFee = numeric.nextDouble();
            Bill bills = new Bill(patientID, PharmacyCharge, DocFee, RoomRent);

            Patient patient = new Patient(patientID, Admit, Discharged, doctor, FirstName, LastName);
            System.out.println(patient.toString());
            System.out.println(bills.toString());

            String filename = FirstName+LastName+".txt";
            File file = new File(filename);
            if(file.exists()){
                System.out.println("File already exsists");
            }

            PrintWriter output = new PrintWriter(filename);
            output.println(patient.toString());
            output.println(bills.toString());


            System.out.println("Would you like to continue?: y (Yes) or n (No)");
            Userinput = in.nextLine().charAt(0);
        }

    }
}
/**typical operations include consrtructors )no arg- and paramterized
 * mutator/acessor (for each of the private data fields)
 * If you plan on having the the parameter of the mutator to have the same
 * name as the data member your intialziing, make sure you use the this keyword to
 * distinguish the difference
 * Override the toString() from java.lang.objects
 **/

//base class - Superclass - file 1 - exercise a
class Person{
    //private data fields
    private String First_Name;
    private String Last_Name;

    //no arg constructor
    public Person(){
        First_Name = "Boruto";
        Last_Name = "Uzumaki";
    }

    //arg constructor
    public Person(String First_Name, String Last_Name){
        this.First_Name = First_Name;
        this.Last_Name = Last_Name;
    }

    //mutator
    public void setFirst_Name(String First_Name){
        this.Last_Name = First_Name;
    }

    public void setLast_Name(String Last){
        this.Last_Name = Last_Name;
    }

    //accessor
    public String getFirst_Name(){
        return First_Name;
    }

    public String getLast_Name(){
        return Last_Name;
    }

    //toString
    @Override
    public String toString(){
        return First_Name + " " + Last_Name;
    }


}

//first subclass of the superclass Person
//file2 - exercise -b
class Doctor extends Person{
    //data filed
    private String Specialty;

    //no arg constructor
    public Doctor(){
        super("John", "Wayne");
        Specialty = "Pediatrician";
    }

    //arg constructor
    public Doctor(String Specialty, String FirstName, String LastName){
        super(FirstName,LastName);
        this.Specialty = Specialty;
    }

    //mutator
    public void setSpecialty(String Specialty){
        this.Specialty = Specialty;
    }

    //accessor
    public String getSpecialty(){
        return Specialty;
    }

    //toString method
    @Override
    public String toString(){
        return super.toString() +  " " + Specialty;
    }
}

//file4 - exercise d
class Date{
    //private data fields
    private int month;
    private int day;
    private int year;


    //no arg constructor
    public Date(){
        month = 5;
        day = 5;
        year = 2024;

    }

    //arg constructor
    public Date(int month, int day, int year){
        this.month = month;
        this.day = day;
        this.year = year;
    }

    //mutators
    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day){
        this.day = day;
    }

    public void setYear(int year){
        this.year = year;
    }

    //accessors
    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public int getYear(){
        return year;
    }

    //toString() method
    @Override
    public String toString(){
        return day + "-" + month + "-" + year;
    }

}

//file 5 - exercise e
//constructors, setters and getters for each of the data fields
class Patient extends Person{
    //data filelds of the class Person
    //data field of type string
    private String Patient_ID;
    //data field of type Date meaning instances of the class Date
    Date DOB = new Date();
    Date admitted = new Date();
    Date Discharged = new Date();
    //data field of type docter (instance of the class doctor
    Doctor Physcian_Name = new Doctor();

    //No arg constructor and then arg constructor
    public Patient(){
        super("John", "smith");
        Patient_ID = "12345678";
        this.DOB = new Date(5,6,2024);
        this.admitted = new Date(4,6,2024);
        this.Discharged = new Date(4, 8, 2024);
        this.Physcian_Name = new Doctor("cardiology", "Bruce", "Wayne");
    }
    public Patient(String Patient_ID, Date admitted, Date Discharged, Doctor Physican_Name, String FirstName, String LastName){
        super(FirstName, LastName);
        this.Patient_ID = Patient_ID;
        //this.DOB = DOB;
        this.admitted = admitted;
        this.Discharged = Discharged;
        this.Physcian_Name = Physican_Name;
    }

    //setters/mutators
    public void setPatient_ID(String Patient_ID){
        this.Patient_ID = Patient_ID;
    }

    public void setDOB(Date DOB){
        this.DOB = DOB;
    }

    public void setAdmitted(Date admitted){
        this.admitted = admitted;
    }

    public void setDischarged(Date Discharged){
        this.Discharged = Discharged;
    }

    public void setPhyscian_Name(Doctor Phsycain_Name){
        this.Physcian_Name = Phsycain_Name;
    }

    //getter/accessor
    public String getPatient_ID(){
        return Patient_ID;
    }

    public Date getAdmitted(){
        return admitted;
    }

    public Date getDischarged(){
        return Discharged;
    }

    public Doctor getPhyscian_Name(){
        return Physcian_Name;
    }

    //toString method
    @Override
    public String toString(){
        return "Patient: " + super.toString() + "\n" + "ID: " +  Patient_ID + "\n" + "Attending Physican: " +  Physcian_Name.getFirst_Name() + " "  + Physcian_Name.getLast_Name() + "\n" + "Admit Date: " + admitted.toString() + "\n" + "Discharge Date: " + Discharged.toString();
    }

}

//file3 - exercise c
//no relationship to any class!
class Bill{
    //data fields
    private String StorePatientID;
    private double medicinefee;
    private double doctorsfee;
    private double roomfee;


    //no arg constructor
    public Bill(){
        StorePatientID = "12345678";
        medicinefee = 200.00;
        doctorsfee = 2005.25;
        roomfee = 2500.75;
    }

    //constructor with argument
    public Bill(String StorePatientID, double medicinefee, double doctorsfee, double roomfee){
        this.StorePatientID = StorePatientID;
        this.medicinefee = medicinefee;
        this.doctorsfee = doctorsfee;
        this.roomfee = roomfee;
    }

    //mutator/setter
    public void setStorePatientID(String StorePatientID){
        this.StorePatientID = StorePatientID;
    }

    public void setMedicinefee(double medicinefee){
        this.medicinefee = medicinefee;
    }

    public void setDoctorsfee(double doctorsfee){
        this.doctorsfee = doctorsfee;
    }

    public void setRoomfee(double roomfee){
        this.roomfee = roomfee;
    }

    //accessor/getter
    public String getStorePatientID(){
        return StorePatientID;
    }

    public double getMedicineFee(){
        return medicinefee;
    }

    public double getDoctorsfee(){
        return doctorsfee;
    }

    public double getRoomfee(){
        return roomfee;
    }

    public double total(){
        return medicinefee + roomfee + doctorsfee;
    }

    //toString() method
    @Override
    public String toString(){
        return "Pharmacy Charges: $" + medicinefee + "\n" + "Room Charges: $" + roomfee + "\n" + "Doctor's Fees: $" + doctorsfee + "\n" + "--------------"  + "\n" + "Total Charges: $" + total();
    }

}





