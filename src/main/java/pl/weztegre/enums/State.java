package pl.weztegre.enums;

/**
* Enum opisuje stan obiektu
**/
public enum State {
    New, UsedBad, UsedAverage, UsedGood;

	/**
	* Metoda toString zwraca opis powiązany z enumem
	* @return string z opisem
	**/
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