import org.junit.Before;
import org.junit.Test;

/**
 * Created by zaclee on 10/1/16.
 */
public class SlotMachineTest {

    SlotMachine slotMachine;
    Player player;

    @Before
    public void setUpTest() {
        slotMachine = new SlotMachine();
        player = new Player();
    }

    @Test
    public void setNumbersTest() {
        slotMachine.setNumbers();
        System.out.println(slotMachine.num1+ " " + slotMachine.num2 + " " + slotMachine.num3);
    }


}
