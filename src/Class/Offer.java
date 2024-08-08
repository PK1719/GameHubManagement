package Class;

public class Offer {
    private String offerCode;
    private String description;
    private int amount;

    public Offer(String offerCode, String description, int amount) {
        this.offerCode = offerCode;
        this.description = description;
        this.amount = amount;
    }

    public String getOfferCode() {
        return this.offerCode;
    }

    public void setOfferCode(String offerCode) {
        this.offerCode = offerCode;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
