package Source;

public  final class InsuranceCalculationResults {
    private final String id;
    private final String type;
    private final int cost;

    public InsuranceCalculationResults(String id, int cost, String type) {
        this.id = id;
        this.cost = cost;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }
}
