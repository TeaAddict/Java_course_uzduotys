import java.util.HashMap;

public class IOU {

    private HashMap<String, Double> debts = new HashMap<>();

    public void setSum(String toWhom, double amount){
        debts.put(toWhom,amount);
    }

    public double howMuchDoIOweTo(String toWhom){
        return debts.getOrDefault(toWhom, 0.0);
    }
}
