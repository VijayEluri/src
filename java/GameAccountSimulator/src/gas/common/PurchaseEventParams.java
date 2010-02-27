package gas.common;

public class PurchaseEventParams {

    public PurchaseEventParams(Land land) {
        this.land = land;
    }

    /*
     * Returns land that has been actually purchased.
     * The problems is that when we realised that we have had enough resources to
     * afford this land, we had this land already purchased, hence with quantity
     * increased. Therefore we are returning a new land with decreased quantity
     * that represents the actual land that has been bought.
     */
    public Land getPurchasedLand() {
        return new Land(land.getLandType(), land.getName(), land.getStartingPrice(), land.getQuantity() - 1, land.getIncome());
    }

    Land land;
}
