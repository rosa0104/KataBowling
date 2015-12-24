import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class KataBowlingTest {

    @Test
    public void testThat20OnesReturn20() {
        assertEquals(20, KataBowling.calc("11111111111111111111"));
    }

    @Test
    public void testThat20TwosReturn40() {
        assertEquals(40, KataBowling.calc("22222222222222222222"));
    }

    @Test
    public void testThat19OnesAndZeroReturn19() {
        assertEquals(19, KataBowling.calc("-1111111111111111111"));
    }

    @Test
    public void testThat20ZerosReturn0() {
        assertEquals(0, KataBowling.calc("--------------------"));
    }

    @Test
    public void testThat20LowRollsReturn40() {
        assertEquals(40, KataBowling.calc("4321-4321-4321-4321-"));
    }

    @Test
    public void testThat90909090909090909090Return90() {
        assertEquals(90, KataBowling.calc("9-9-9-9-9-9-9-9-9-9-"));
    }

    @Test
    public void testThat20FivesReturn150() {
        assertEquals(150, KataBowling.calc("5/5/5/5/5/5/5/5/5/5/5"));
    }

    @Test
    public void testThatRandomRollsWithSparesReturn50() {
        assertEquals(50, KataBowling.calc("1/4-3452----------/8"));
    }
    @Test
    public void testThatOneSPareReturn10() {
        assertEquals(10, KataBowling.calc("-/------------------"));
    }

    @Test
    public void testThat12XReturn300() {
        assertEquals(300, KataBowling.calc("XXXXXXXXXXXX"));
    }
}