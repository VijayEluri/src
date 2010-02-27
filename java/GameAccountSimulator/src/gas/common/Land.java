package gas.common;

public class Land implements Cloneable {

    public Land() {
        quantity = 0;
        startingPrice = 0;
    }

    public Land(LandType landType, String name, double startingPrice, int quantity, double income) {
        this.name = name;
        this.startingPrice = startingPrice;
        this.quantity = quantity;
        this.income = income;
    }

    public double getCurrentPrice() {
        double addition = startingPrice * 0.1 * quantity;
        return startingPrice + addition;
    }

    public double getIncomePerPrice() {
        return (getCurrentPrice() / income);
    }

    public double getTotalIncome() {
        return (income * quantity);
    }

    public double getIncome() {
        return income;
    }

    public void incQuantity() {
        quantity++;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public LandType getLandType() {
        return landType;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    @Override
    public String toString() {
        return String.format("%-17s  %3d  %9.2f", getName(), getQuantity(), getIncomePerPrice());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Land other = (Land) obj;
        if (this.landType != other.landType && (this.landType == null || !this.landType.equals(other.landType))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.landType != null ? this.landType.hashCode() : 0);
        return hash;
    }

    private double startingPrice;
    private int quantity;
    private double income;
    private String name;
    private LandType landType;
}