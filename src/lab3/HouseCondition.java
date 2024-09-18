package lab3;

public enum HouseCondition {
    ECONOMY("economy"),
    STANDARD("standard"),
    LUXURY("luxury"),
    PRESIDENT("president");

   private final String textCondition;

    HouseCondition(final String textCondition) {
        this.textCondition = textCondition;
    }

    public String getTextCondition() {
        return textCondition;
    }


}
