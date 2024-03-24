import java.util.*;
public class Main {
    public static void main(String[] args) {

        CarShowroomContainer kontener = new CarShowroomContainer();


        kontener.addCenter("Salon1", 20);
        kontener.addCenter("Salon2", 30);
        kontener.addCenter("Salon3", 25);


        Vehicle vehicle1 = new Vehicle("Audi", "A4", ItemCondition.NEW, 20000.0, 0.0, 2.0, 2022);
        Vehicle vehicle2 = new Vehicle("Toyota", "Corolla", ItemCondition.USED, 15000.0, 50000.0, 1.6, 2019);
        Vehicle vehicle3 = new Vehicle("Mercedes-Benz", "E220", ItemCondition.DAMAGED, 10000.0, 80000.0, 1.8, 2015);
        Vehicle vehicle4 = new Vehicle("BMW", "e39", ItemCondition.USED, 7000.0,300000.0,3.0,1998);

        kontener.salony.get("Salon1").addProduct(vehicle1);
        kontener.salony.get("Salon1").addProduct(vehicle2);
        kontener.salony.get("Salon2").addProduct(vehicle3);
        kontener.salony.get("Salon3").addProduct(vehicle4);

        kontener.salony.get("Salon3").getProduct(vehicle4);
        kontener.summary();
        vehicle1.print();

        kontener.removeCenter("Salon1");


        List<String> pusteSalony = kontener.findEmpty();
        System.out.println("Puste salony:");
        for (String nazwaSalonu : pusteSalony) {
            System.out.println(nazwaSalonu);
        }
    }
}
