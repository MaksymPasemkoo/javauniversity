package lab3;

import java.util.Arrays;
import java.util.List;

public enum HotelAmenitie {
    FREE_WIFI("free Wi-Fi"),
    BREAKFAST("breakfast"),

    GYM("gym"),
    SWIMMING_POOL("swimming pool"),
    SPA_SERVICES("spa services"),
    RESTAURANT("restaurant"),
    CONCIERGE_SERVICE("concierge service"),
    PARKING("parking");

    private final String textAmenitie;
    HotelAmenitie(final String textAmenitie){
        this.textAmenitie = textAmenitie;
    }

    public String getTextAmenitie() {
        return textAmenitie;
    }

    public static List<HotelAmenitie> getListAmenities(){
        return Arrays.asList(HotelAmenitie.values());
    }
}
