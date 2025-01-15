import lt.techin.philatelist.Philatelist;
import lt.techin.philatelist.PhilatelistBaseTest;
import philate.MyPhilatelist;

public class PhilatelistTest extends PhilatelistBaseTest {
    @Override
    protected Philatelist getPhilatelist() {
        return new MyPhilatelist();
    }
}
