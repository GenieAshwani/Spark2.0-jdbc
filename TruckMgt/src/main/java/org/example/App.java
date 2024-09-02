package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

/**
 * Hello world!
 *
 */

public class App 
{

    public static void main( String[] args )
    {
        TruckService truckService=new TruckService();

        Truck tata=new Truck("TATA","2019",1000,"rajesh");
        Truck volvo=new Truck("VOLVO","2023",1000,"Akash");
        Truck eicher=new Truck("Eicher","2022",1000,"Harshit");

        //adding data into database
        System.out.println("Adding data......");
        truckService.addTruck(tata);
        truckService.addTruck(volvo);
        truckService.addTruck(eicher);

        //fetch
        System.out.println("Fetching data by id : ......"+1);
        Truck truck = truckService.getTruckById(1);
        System.out.println("Truck data : "+truck);

        //updating truck data
        System.out.println("Updated  data......");
        truck.setDriverName("Ramesh");
        truckService.updateTruck(truck);
        System.out.println("Updated truck data : "+truckService.getTruckById(1));

        //get all truck data
        System.out.println("fetching all data......");
        List<Truck> allTrucks = truckService.getAllTrucks();
        System.out.println("All trucks in DB :");
        for (Truck truck1 : allTrucks)
        {
            System.out.println(truck1);
        }

        //delete truck data
        System.out.println("Deleting data by id......"+2);
        truckService.deleteTruck(2);
        System.out.println("Data deleted by id : "+2);

        System.out.println("get all data......");
        allTrucks=truckService.getAllTrucks();
        System.out.println("All trucks after all operations :");
        System.out.println(allTrucks);

    }
}
