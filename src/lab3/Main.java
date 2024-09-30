package lab3;

import java.time.Month;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Dnipro");

        House house1 = new House(HouseCondition.ECONOMY,1,hotel);
        House house2 = new House(HouseCondition.ECONOMY,2, hotel);
        House house3 = new House(HouseCondition.PRESIDENT,3,hotel);

        Client client1 = new Client("Maksym",4719,10000);
        Client client2 = new Client("Vlad",47129,28237);
        Client client3 = new Client("Marta",47129,28237);

        house1.addAdditionalAmenities(HouseAmenitie.BED);
        System.out.println("-------------------------------------------------------------------");

        hotel.reserve(house1,"13-02-2024",client1);
        System.out.println("-------------------------------------------------------------------");
        hotel.reserve(house2,"12-03-2024",client2);
        System.out.println("-------------------------------------------------------------------");

        hotel.calendarOfReservation(Month.MARCH);
        System.out.println("-------------------------------------------------------------------");
        hotel.reserve(house3,"13-03-2024",client3);
        System.out.println("-------------------------------------------------------------------");

        house1.printAmenities();
        System.out.println("-------------------------------------------------------------------");

        hotel.printIncomeAndExpense();
        System.out.println("-------------------------------------------------------------------");

        hotel.printHousesWithAmenities(HouseCondition.ECONOMY);
        System.out.println("-------------------------------------------------------------------");
        hotel.printHousesWithAmenities(HouseAmenitie.KITCHEN);

        System.out.println("-------------------------------------------------------------------");
        hotel.printListOfReservation();

    }
}
