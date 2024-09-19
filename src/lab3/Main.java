package lab3;


public class Main {
    public static void main(String[] args) {
        House house1 = new House(HouseCondition.ECONOMY,1);
        House house2 = new House(HouseCondition.ECONOMY,2);
        House house3 = new House(HouseCondition.PRESIDENT,3);
        Hotel hotel = new Hotel("Dnipro");

        Client client1 = new Client("Maksym",4719,10000);
        Client client2 = new Client("Vlad",47129,28237);
        Client client3 = new Client("Marta",47129,28237);

        house1.addAdditionalAmenities();
        System.out.println("-------------------------------------------------------------------");

        hotel.reserve(house1,"13-02-2024",client1);
        System.out.println("-------------------------------------------------------------------");
        hotel.reserve(house2,"12-03-2024",client2);
        System.out.println("-------------------------------------------------------------------");

        hotel.calendarOfReservation();
        System.out.println("-------------------------------------------------------------------");
        hotel.reserve(house3,"16-03-2024",client3);
        System.out.println("-------------------------------------------------------------------");

        house1.getAmenities();
        System.out.println("-------------------------------------------------------------------");

        Hotel.getIncomesAndExpense();
        System.out.println("-------------------------------------------------------------------");

        hotel.getHousesWithAmenities(HouseCondition.ECONOMY);
        System.out.println("-------------------------------------------------------------------");
        hotel.getHousesWithAmenities(HouseAmenitie.KITCHEN);

    }
}
