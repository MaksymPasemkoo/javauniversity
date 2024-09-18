package lab3;

public class Main {
    public static void main(String[] args) {
        House house = new House(HouseCondition.ECONOMY);
        Hotel hotel = new Hotel("Dnipro");
        Client client1 = new Client("Maksym",4719,10000);
        Client client2 = new Client("Vlad",47129,28237);
        hotel.reserve(house,"13-03-2024",client1);
        hotel.reserve(house,"12-02-2024",client2);

    }
}
