import java.util.HashMap;

public class IOU {

    HashMap<String, Double> debts;

    public void setSum(String toWhom, double amount){
        debts.put(toWhom,amount);
    }

    public double howMuchDoIOweTo(String toWhom){
        return debts.get(toWhom);
    }
}
