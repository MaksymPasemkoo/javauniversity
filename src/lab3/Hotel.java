//package lab3;
//
//import java.time.LocalDate;
//import java.time.Month;
//import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Hotel {
//    private final String hotelName;
//    private final static List<HotelAmenitie> hotelAmenities = new ArrayList<>(HotelAmenitie.getListAmenities());
//    private final List<Reserve> listOfReservation = new ArrayList<>();
//    private final List<House> houses = new ArrayList<>();
//
//    public Hotel(final String hotelName){
//        this.hotelName = hotelName;
//    }
//
//    public void reserve(final House house,final String date,final Client client){
//        //to DateUtil
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        try {
//             localDate = LocalDate.parse(date, dateTimeFormatter);
//        }catch (DateTimeParseException e){
//            throw new BookingException("Format must be 'dd-MM-yyyy'");
//        }
//        //////////
//
//
//
//        if(!localDateList.contains(localDate) && !listOfReservedHouses.contains(house)) {
//            Reserve reserve = new Reserve(house,localDate,client);
//            listOfReservation.add(reserve);
//            localDateList.add(localDate);
//            listOfReservedHouses.add(house);
//
//            double priceForHouse = priceOfHouse(house);
//            if(LocalDate.now().getMonth() == Month.NOVEMBER || LocalDate.now().getMonth() == Month.MARCH) {
//                double discount = 0.2;
//                totalIncomeOfResidence += priceForHouse * discount;
//                totalExpenseOfResidence += priceForHouse * discount;
//
//                System.out.println(localDate.getMonth().name().toLowerCase() + " discount 20%");
//                System.out.println("Cost of payment in hrn:" + priceForHouse);
//            }else{
//                totalIncomeOfResidence += priceOfHouse(house) ;
//                totalExpenseOfResidence += expenseOfHouse(house);
//                System.out.println("Cost of payment in hrn:" + priceForHouse);
//            }
//
//            System.out.println("Balance:" + client.getBalance());
//            if(client.getBalance() >= priceForHouse) {
//                client.decrementBalance(priceForHouse);
//                System.out.println("Balance after payment:" + client.getBalance());
//            }else{
//                throw new BookingException("Not enough money to pay.");
//            }
//            System.out.println("House was successfully reserved.");
//
//        }
//        else if(localDateList.contains(localDate)){
//            throw new BookingException("The house is already reserved one this date.");
//        }
//        else{
//            throw new BookingException("The house is already reserved.");
//        }
//    }
//
//    public void calendarOfReservation(){
//        if(localDate != null) {
//            System.out.println("You can book the house on the following days in " + localDate.getMonth().name().toLowerCase());
//            for (int i = 1; i <= localDate.lengthOfMonth(); i++) {
//                LocalDate currentDay = localDate.withDayOfMonth(i);
//                if (localDateList.contains(currentDay)){
//                    continue;
//                }
//                System.out.print(i + "|");
//            }
//        }
//        else{
//            System.out.println("All houses are reserved.");
//        }
//        System.out.println();
//    }
//
//
//    private double priceOfHouse(final House house){
//        return house.getHouseAmenities().stream()
//                .mapToDouble(HouseAmenitie::getPrice)
//                .sum();
//    }
//
//    private double expenseOfHouse(final House house){
//        return house.getHouseAmenities().stream()
//                .mapToDouble(HouseAmenitie::getExpense)
//                .sum();
//    }
//
//
//
//    public static void getIncomesAndExpense(){
//        System.out.println("Total income:" + totalIncomeOfResidence);
//        System.out.println("Total expense:" + totalExpenseOfResidence);
//    }
//
//    public static void getHotelAmenities() {
//        System.out.println("Hotel amenities:");
//        hotelAmenities.forEach(elem -> System.out.println(elem.getTextAmenitie()));
//    }
//
//    public void getHousesWithAmenities(final HouseCondition houseCondition){
//        List<House> houseList = House.getListOfHouses().stream()
//                .filter(house -> house.getHouseCondition().getTextCondition().equals(houseCondition.getTextCondition()))
//                .toList();
//        System.out.println("Houses with " + houseCondition.getTextCondition() + " condition:");
//        houseList.forEach(System.out::println);
//    }
//
//
//    public void getHousesWithAmenities(final HouseAmenitie houseAmenitie){
//        List<House> houseList = House.getListOfHouses().stream()
//                        .filter(house -> house.getHouseAmenities().contains(houseAmenitie))
//                                .toList();
//        System.out.println("Houses that contains " + houseAmenitie.getAmenitiesText() + ":");
//        houseList.forEach(System.out::println);
//    }
//
//    public void getListOfReservation() {
//        System.out.println("List of reservation:");
//        listOfReservation.forEach(System.out::println);
//    }
//
//    public String getHotelName() {
//        return hotelName;
//    }
//
//}
