package lab3;

import java.util.ArrayList;
import java.util.List;

public class House {
    private final List<HouseAmenitie> houseAmenities = new ArrayList<>();
    private final HouseCondition houseCondition;
    private final int houseNumber;
    private int personInHouse = 0;
    private final Hotel hotel;

    public House(final HouseCondition houseCondition, final int houseNumber, Hotel hotel){
        this.houseCondition = houseCondition;
        this.houseNumber = houseNumber;
        this.hotel = hotel;
        includeAmenities();
    }

    public void addAdditionalAmenities(HouseAmenitie choice){
        HouseAmenitie houseAmenitie = null;
        switch (choice) {
            case WIFI -> houseAmenitie = HouseAmenitie.WIFI;
            case KITCHEN -> houseAmenitie = HouseAmenitie.KITCHEN;
            case SMART_TV -> houseAmenitie = HouseAmenitie.SMART_TV;
            case CONDITIONER -> houseAmenitie = HouseAmenitie.CONDITIONER;
            case WASHING_MACHINE -> houseAmenitie = HouseAmenitie.WASHING_MACHINE;
            case SAFE -> houseAmenitie = HouseAmenitie.SAFE;
            case BED -> {
                houseAmenitie = HouseAmenitie.BED;
                personInHouse++;
            }
            case CHILD_BED -> {
                houseAmenitie = HouseAmenitie.CHILD_BED;
                personInHouse++;
            }
            case TERRACE -> houseAmenitie = HouseAmenitie.TERRACE;
            case JACUZZI -> houseAmenitie = HouseAmenitie.JACUZZI;
            case MINI_KITCHEN -> houseAmenitie = HouseAmenitie.MINI_KITCHEN;
            default -> System.out.println("There is no choice like " + choice.getAmenitiesText());
        }
        if(!houseAmenities.isEmpty()) {
            System.out.println(houseAmenitie.getAmenitiesText() + " was successfully added.");
            houseAmenities.add(houseAmenitie);
        }
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

    public void printAmenities(){
        System.out.println("House amenities:");
        houseAmenities.forEach(System.out::println);
        System.out.println("-------------------------------------------------------------------");
        hotel.printHotelAmenities();
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
