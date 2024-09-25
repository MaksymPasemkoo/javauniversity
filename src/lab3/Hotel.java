package lab3;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private final String hotelName;
    private final static List<HotelAmenitie> hotelAmenities = new ArrayList<>(HotelAmenitie.getListAmenities());
    private final List<Reserve> listOfReservation = new ArrayList<>();
    private final List<Client> listOfClients = new ArrayList<>();
    private final List<House> houses = new ArrayList<>();

    public Hotel(final String hotelName){
        this.hotelName = hotelName;
    }

    public void reserve(final House house,final String date,final Client client){
        LocalDate localDate = DateUtil.dateFormatter(date);

        if(!listOfClients.contains(client) && !houses.contains(house)) {
            Reserve reserve = new Reserve(house,localDate,client);
            listOfReservation.add(reserve);
            listOfClients.add(client);
            houses.add(house);

            double priceForHouse = priceOfHouse(house);
            if(localDate.getMonth() == Month.NOVEMBER || localDate.getMonth() == Month.MARCH) {
                final double discountInPercentage = 20;
                final double discount = discountInPercentage / 100;
                final double totalPriceForHouseWithDiscount = priceForHouse + priceForHouse * discount;
//                totalIncomeOfResidence += priceForHouse * discount;
//                totalExpenseOfResidence += priceForHouse * discount;

                System.out.println(localDate.getMonth().name().toLowerCase() + " discount "
                        + discountInPercentage + "%");
                System.out.println("Cost of payment in hrn:" + totalPriceForHouseWithDiscount);
            }else{
//                totalIncomeOfResidence += priceOfHouse(house) ;
//                totalExpenseOfResidence += expenseOfHouse(house);
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
        else if(listOfClients.contains(client)){
            throw new BookingException(client.getName() + " has already reserved house.");
        }
        else{
            throw new BookingException("The house is already reserved.");
        }
    }

    public void calendarOfReservation(final Month month){
            System.out.println("You can book the house on the following days in "
                    + month.name().toLowerCase());

            int year = LocalDate.now().getYear();
            LocalDate firstDayOfMonth = LocalDate.of(year,month,1);

            int monthLength =  month.length(firstDayOfMonth.isLeapYear());
            for (int i = 1; i <= monthLength; i++) {
                LocalDate currentDay = firstDayOfMonth.withDayOfMonth(i);

                boolean isReserved = listOfReservation.stream()
                                .anyMatch(reserve -> reserve.getDate().equals(currentDay));
                if(!isReserved) {
                    System.out.print(i + "|");
                }
            }
            System.out.println();
    }


    private double priceOfHouse(final House house){
        return house.getHouseAmenities().stream()
                .mapToDouble(HouseAmenitie::getPrice)
                .sum();
    }

    private double expenseOfHouse(final House house){
        return house.getHouseAmenities().stream()
                .mapToDouble(HouseAmenitie::getExpense)
                .sum();
    }


    public static void getIncome(){
        
    }

    public static void getHotelAmenities() {
        System.out.println("Hotel amenities:");
        hotelAmenities.forEach(elem -> System.out.println(elem.getTextAmenitie()));
    }

    public void getHousesWithAmenities(final HouseCondition houseCondition){
        List<House> houseList = houses.stream()
                .filter(house -> house.getHouseCondition().getTextCondition().equals(houseCondition.getTextCondition()))
                .toList();
        System.out.println("Houses with " + houseCondition.getTextCondition() + " condition:");
        houseList.forEach(System.out::println);
    }


    public void getHousesWithAmenities(final HouseAmenitie houseAmenitie){
        List<House> houseList = houses.stream()
                        .filter(house -> house.getHouseAmenities().contains(houseAmenitie))
                                .toList();
        System.out.println("Houses that contains " + houseAmenitie.getAmenitiesText() + ":");
        houseList.forEach(System.out::println);
    }

    public void getListOfReservation() {
        System.out.println("List of reservation:");
        listOfReservation.forEach(System.out::println);
    }

    public String getHotelName() {
        return hotelName;
    }

}
