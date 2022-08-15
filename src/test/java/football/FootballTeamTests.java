package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {

    private Footballer ronaldo;
    private Footballer messi;
    private FootballTeam levski;

    @Before
    public void setup() {
        ronaldo = new Footballer("Ronaldo");
        messi = new Footballer("Messi");
        levski = new FootballTeam("Levski", 3);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Levski", levski.getName());
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(0, levski.getCount());
        levski.addFootballer(ronaldo);
        Assert.assertEquals(1, levski.getCount());
    }

    @Test
    public void testGetVacantPositions(){
        Assert.assertEquals(3, levski.getVacantPositions());
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameThrow() {
        FootballTeam footballTeam = new FootballTeam(" ", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetVacationPositionThrow() {
        FootballTeam footballTeam = new FootballTeam("asd", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddPlayerThrow() {
        levski.addFootballer(ronaldo);
        levski.addFootballer(messi);
        Footballer gosho = new Footballer("Gosho");
        Footballer misho = new Footballer("Misho");
        levski.addFootballer(gosho);
        levski.addFootballer(misho);
    }

    @Test
    public void testRemoveFootballer() {
        levski.addFootballer(ronaldo);
        levski.addFootballer(messi);
        Assert.assertEquals(2, levski.getCount());
        levski.removeFootballer("Messi");
        Assert.assertEquals(1, levski.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerThrow() {
        levski.removeFootballer("dgfg");
    }

    @Test
    public void testGetStatistics() {
        levski.addFootballer(messi);
        String expected = "The footballer Messi is in the team Levski.";
        String real = levski.getStatistics();
        Assert.assertEquals(expected, real);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleThrow(){
        levski.footballerForSale("aads");
    }

    @Test
    public void testFootballerForSaleSetActiveToFalse(){
        levski.addFootballer(messi);
        Footballer footballer = levski.footballerForSale("Messi");
        boolean isActive = footballer.isActive();
        Assert.assertFalse(isActive);
    }
}
