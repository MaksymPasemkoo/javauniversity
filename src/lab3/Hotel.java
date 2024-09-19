package lab3;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private final String hotelName;
    private final static List<HotelAmenitie> hotelAmenities = new ArrayList<>(HotelAmenitie.getListAmenities());
    private final List<Reserve> listOfReservation;
    private final List<House> listOfReservedHouses;
    private final List<LocalDate> localDateList;
    private LocalDate localDate;
    private static double totalIncomeOfResidence = 0;
    private static double totalExpenseOfResidence = 0;
    private final double discount = 0.2;
    public Hotel(final String hotelName){
        this.hotelName = hotelName;
        listOfReservation = new ArrayList<>();
        listOfReservedHouses = new ArrayList<>();
        localDateList = new ArrayList<>();
        localDate = LocalDate.now();
    }
    public static void getHotelAmenities() {
        System.out.println("Hotel amenities:");
        hotelAmenities.forEach(elem -> System.out.println(elem.getTextAmenitie()));
    }

    public void reserve(final House house,final String date,final Client client){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
             localDate = LocalDate.parse(date, dateTimeFormatter);
        }catch (DateTimeParseException e){
            throw new BookingException("Format must be 'dd-MM-yyyy'");
        }

        if(!localDateList.contains(localDate) && !listOfReservedHouses.contains(house)) {
            Reserve reserve = new Reserve(house,localDate,client);
            listOfReservation.add(reserve);
            localDateList.add(localDate);
            listOfReservedHouses.add(house);

            double priceForHouse = priceOfHouse(house);
            if(localDate.getMonth() == Month.NOVEMBER || localDate.getMonth() == Month.MARCH) {
                totalIncomeOfResidence += priceForHouse * discount;
                totalExpenseOfResidence += priceForHouse * discount;

                System.out.println(localDate.getMonth().name().toLowerCase() + " discount 20%");
                System.out.println("Cost of payment in hrn:" + priceForHouse);
            }else{
                totalIncomeOfResidence += priceOfHouse(house) ;
                totalExpenseOfResidence += expenseOfHouse(house);
                System.out.println("Cost of payment in hrn:" + priceForHouse);
            }

            System.out.println("Balance:" + client.getBalance());
            if(client.getBalance() >= priceForHouse) {
                client.decrementBalance(priceForHouse);
                System.out.println("Balance after payment:" + client.getBalance());
            }else{
                throw new BookingException("Not enough money to pay.");
            }
            System.out.println("House was successfully reserved.");

        }
        else if(localDateList.contains(localDate)){
            throw new BookingException("The house is already reserved one this date.");
        }
        else{
            throw new BookingException("The house is already reserved.");
        }
    }

    public void calendarOfReservation(){
        if(localDate != null) {
            System.out.println("You can book the house on the following days in " + localDate.getMonth().name().toLowerCase());
            for (int i = 1; i <= localDate.lengthOfMonth(); i++) {
                LocalDate currentDay = localDate.withDayOfMonth(i);
                if (localDateList.contains(currentDay)){
                    continue;
                }
                System.out.print(i + "|");
            }
        }
        else{
            System.out.println("All houses are reserved.");
        }
        System.out.println();
    }


    private double priceOfHouse(final House house){
        double price = 0;
        switch (house.getHouseCondition().getTextCondition()) {
            case "economy" -> price = HouseAmenitie.WIFI.getPrice()
                    + HouseAmenitie.BED.getPrice()
                    + HouseAmenitie.MINI_KITCHEN.getPrice();
            case "standard" -> price = HouseAmenitie.WIFI.getPrice()
                    + HouseAmenitie.BED.getPrice()
                    + HouseAmenitie.MINI_KITCHEN.getPrice()
                    + HouseAmenitie.CONDITIONER.getPrice()
                    + HouseAmenitie.SAFE.getPrice();
            case "luxury" -> price = HouseAmenitie.WIFI.getPrice()
                    + HouseAmenitie.BED.getPrice() * 2
                    + HouseAmenitie.KITCHEN.getPrice()
                    + HouseAmenitie.CONDITIONER.getPrice()
                    + HouseAmenitie.SAFE.getPrice()
                    + HouseAmenitie.SMART_TV.getPrice()
                    + HouseAmenitie.WASHING_MACHINE.getPrice();
            case "president" -> price = HouseAmenitie.WIFI.getPrice()
                    + HouseAmenitie.BED.getPrice() * 2
                    + HouseAmenitie.KITCHEN.getPrice()
                    + HouseAmenitie.CONDITIONER.getPrice()
                    + HouseAmenitie.SAFE.getPrice()
                    + HouseAmenitie.SMART_TV.getPrice()
                    + HouseAmenitie.WASHING_MACHINE.getPrice()
                    + HouseAmenitie.TERRACE.getPrice()
                    + HouseAmenitie.JACUZZI.getPrice();
        }
        return price;
    }

    private double expenseOfHouse(final House house){
        double expense = 0;
        switch (house.getHouseCondition().getTextCondition()) {
            case "economy" -> expense = HouseAmenitie.WIFI.getExpense()
                    + HouseAmenitie.BED.getExpense()
                    + HouseAmenitie.MINI_KITCHEN.getExpense();
            case "standard" -> expense = HouseAmenitie.WIFI.getExpense()
                    + HouseAmenitie.BED.getExpense()
                    + HouseAmenitie.MINI_KITCHEN.getExpense()
                    + HouseAmenitie.CONDITIONER.getExpense()
                    + HouseAmenitie.SAFE.getExpense();
            case "luxury" -> expense = HouseAmenitie.WIFI.getExpense()
                    + HouseAmenitie.BED.getExpense() * 2
                    + HouseAmenitie.KITCHEN.getExpense()
                    + HouseAmenitie.CONDITIONER.getExpense()
                    + HouseAmenitie.SAFE.getExpense()
                    + HouseAmenitie.SMART_TV.getExpense()
                    + HouseAmenitie.WASHING_MACHINE.getExpense();
            case "president" -> expense = HouseAmenitie.WIFI.getExpense()
                    + HouseAmenitie.BED.getExpense() * 2
                    + HouseAmenitie.KITCHEN.getExpense()
                    + HouseAmenitie.CONDITIONER.getExpense()
                    + HouseAmenitie.SAFE.getExpense()
                    + HouseAmenitie.SMART_TV.getExpense()
                    + HouseAmenitie.WASHING_MACHINE.getExpense()
                    + HouseAmenitie.TERRACE.getExpense()
                    + HouseAmenitie.JACUZZI.getExpense();
        }
        return expense;
    }

    public static void addTotalExpenseOfResidence(double totalExpenseOfResidence) {
        Hotel.totalExpenseOfResidence += totalExpenseOfResidence;
    }

    public static void addTotalIncomeOfResidence(double totalIncomeOfResidence) {
        Hotel.totalIncomeOfResidence += totalIncomeOfResidence;
    }

    public static void getIncomesAndExpense(){
        System.out.println("Total income:" + totalIncomeOfResidence);
        System.out.println("Total expense:" + totalExpenseOfResidence);
    }


    public void getHousesWithAmenities(final HouseCondition houseCondition){
        List<House> houseList = new ArrayList<>();
        for(House house : House.getListOfHouses()) {
            if(house.getHouseCondition().getTextCondition().equals(houseCondition.getTextCondition())){
                houseList.add(house);
            }
        }
        System.out.println("Houses with " + houseCondition.getTextCondition() + " condition:");
        houseList.forEach(System.out::println);
    }

    public void getHousesWithAmenities(final HouseAmenitie houseAmenitie){
        List<House> houseList = new ArrayList<>();
        for(House house : House.getListOfHouses()){
            if(house.getHouseAmenities().contains(houseAmenitie)){
                houseList.add(house);
            }
        }
        System.out.println("Houses that contains " + houseAmenitie.getAmenitiesText() + ":");
        houseList.forEach(System.out::println);
    }

    public String getHotelName() {
        return hotelName;
    }

    public List<Reserve> getListOfReservation() {
        return listOfReservation;
    }
}
