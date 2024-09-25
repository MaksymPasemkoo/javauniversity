package lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class House {
    private final List<HouseAmenitie> houseAmenities = new ArrayList<>();
    private final HouseCondition houseCondition;
    private final int houseNumber;
    private int personInHouse = 0;

    public House(final HouseCondition houseCondition,final int houseNumber){
        this.houseCondition = houseCondition;
        this.houseNumber = houseNumber;
        includeAmenities();
    }

    public void addAdditionalAmenities(){
        Scanner scanner = new Scanner(System.in);
        List<HouseAmenitie> listOfHouseAmenities = new ArrayList<>(HouseAmenitie.getListAmenities());

        System.out.println("List of amenities:");
        for (int i = 0; i < listOfHouseAmenities.size(); i++) {
            System.out.println((i + 1) + ":" + listOfHouseAmenities.get(i));
        }
        System.out.println("Enter number from 1 to " + listOfHouseAmenities.size() +  " to add amenitie:");
        String choice = scanner.next();

        HouseAmenitie houseAmenitie = null;
        switch(choice){
            case "1":
                houseAmenitie = HouseAmenitie.WIFI;
                break;
            case "2":
                houseAmenitie = HouseAmenitie.KITCHEN;
                break;
            case "3":
                houseAmenitie = HouseAmenitie.SMART_TV;
                break;
            case "4":
                houseAmenitie = HouseAmenitie.CONDITIONER;
                break;
            case "5":
                houseAmenitie = HouseAmenitie.WASHING_MACHINE;
                break;
            case "6":
                houseAmenitie = HouseAmenitie.SAFE;
                break;
            case "7":
                houseAmenitie = HouseAmenitie.BED;
                personInHouse++;
                break;
            case "8":
                houseAmenitie = HouseAmenitie.CHILD_BED;
                personInHouse++;
                break;
            case "9":
                houseAmenitie = HouseAmenitie.TERRACE;
                break;
            case "10":
                houseAmenitie = HouseAmenitie.JACUZZI;
                break;
            case "11":
                houseAmenitie = HouseAmenitie.MINI_KITCHEN;
                break;
            default:
                System.out.println("There is no choice like " + choice);
                break;
        }
        houseAmenities.add(houseAmenitie);
    }


    private void includeAmenities(){
        switch (houseCondition.getTextCondition()) {
            case "economy" -> {
                houseAmenities.add(HouseAmenitie.WIFI);
                houseAmenities.add(HouseAmenitie.BED);
                houseAmenities.add(HouseAmenitie.MINI_KITCHEN);
                personInHouse++;
            }
            case "standard" -> {
                houseAmenities.add(HouseAmenitie.WIFI);
                houseAmenities.add(HouseAmenitie.BED);
                houseAmenities.add(HouseAmenitie.MINI_KITCHEN);
                houseAmenities.add(HouseAmenitie.CONDITIONER);
                houseAmenities.add(HouseAmenitie.SAFE);
                personInHouse++;
            }
            case "luxury" -> {
                houseAmenities.add(HouseAmenitie.WIFI);
                houseAmenities.add(HouseAmenitie.BED);
                houseAmenities.add(HouseAmenitie.BED);
                houseAmenities.add(HouseAmenitie.KITCHEN);
                houseAmenities.add(HouseAmenitie.CONDITIONER);
                houseAmenities.add(HouseAmenitie.SAFE);
                houseAmenities.add(HouseAmenitie.SMART_TV);
                houseAmenities.add(HouseAmenitie.WASHING_MACHINE);
                personInHouse += 2;
            }
            case "president" -> {
                houseAmenities.add(HouseAmenitie.WIFI);
                houseAmenities.add(HouseAmenitie.BED);
                houseAmenities.add(HouseAmenitie.BED);
                houseAmenities.add(HouseAmenitie.BED);
                houseAmenities.add(HouseAmenitie.KITCHEN);
                houseAmenities.add(HouseAmenitie.CONDITIONER);
                houseAmenities.add(HouseAmenitie.SAFE);
                houseAmenities.add(HouseAmenitie.SMART_TV);
                houseAmenities.add(HouseAmenitie.WASHING_MACHINE);
                houseAmenities.add(HouseAmenitie.TERRACE);
                houseAmenities.add(HouseAmenitie.JACUZZI);
                personInHouse += 3;
            }
        }
    }

    public void getAmenities(){
        System.out.println("House amenities:");
        houseAmenities.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------");
        Hotel.getHotelAmenities();
    }

    public HouseCondition getHouseCondition() {
        return houseCondition;
    }

    public List<HouseAmenitie> getHouseAmenities() {
        return houseAmenities;
    }


    public int getPersonInHouse() {
        return personInHouse;
    }


    @Override
    public String toString() {
        return "House{" +
                "house number=" + houseNumber +
                ", house condition=" + houseCondition +
                ", house amenities=" + houseAmenities +
                ", person in house=" + personInHouse +
                '}';
    }
}
