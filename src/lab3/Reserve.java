package lab3;

import java.time.LocalDate;

public class Reserve {
    private final House house;
    private final Client client;
    private final LocalDate date;

    public Reserve(final House house,final LocalDate date,final Client client) {
        this.house = house;
        this.date = date;
        this.client = client;
    }

    public House getHouse() {
        return house;
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "house=" + house +
                ", client=" + client +
                ", date=" + date +
                '}';
    }
}
