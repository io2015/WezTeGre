package pl.weztegre.enums;

public enum State {
    New, UsedBad, UsedAverage, UsedGood;

    @Override
    public String toString() {
        switch(this) {
            case New:
                return "Nowy";

            case UsedBad:
                return "Używany - kiepski";

            case UsedAverage:
                return "Używany - średni";

            case UsedGood:
                return "Używany - dobry";

            default:
                return super.toString();
        }
    }
}