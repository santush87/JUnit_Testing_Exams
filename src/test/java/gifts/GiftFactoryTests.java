package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;

public class GiftFactoryTests {

    private GiftFactory factory;
    private Gift gift;
    private Gift secGift;

    @Before
    public void setup(){
        factory = new GiftFactory();
        gift = new Gift("Flying", 50);
        secGift = new Gift("Teleport", 70);
    }

    @Test
    public void testCreateGiftAndGetCount(){
        Assert.assertEquals(0, factory.getCount());
        factory.createGift(gift);
        Assert.assertEquals(1, factory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGiftThrow(){
        Gift gift1 = new Gift("Flying", 50);
        factory.createGift(gift);
        factory.createGift(gift1);
    }

    @Test
    public void testRemoveGift(){
        factory.createGift(gift);
        factory.createGift(secGift);
        Assert.assertEquals(2, factory.getCount());
        factory.removeGift("Flying");
        Assert.assertEquals(1, factory.getCount());
        Assert.assertTrue(factory.removeGift("Teleport"));
        Assert.assertEquals(0, factory.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveGiftThrow(){
        factory.createGift(gift);
        factory.createGift(secGift);
        factory.removeGift("");
    }

    @Test
    public void testGetPresentWithLeastMagic(){
        factory.createGift(gift);
        factory.createGift(secGift);
        Gift testGift = factory.getPresentWithLeastMagic();
        Assert.assertEquals("Flying", testGift.getType());
    }

    @Test
    public void testGetPresent(){
        factory.createGift(gift);
        factory.createGift(secGift);
        Gift testGift = factory.getPresent("Flying");
        Assert.assertEquals("Flying", testGift.getType());
    }

    @Test
    public void testGetPresents(){
        factory.createGift(gift);
        factory.createGift(secGift);
        Collection<Gift> testCollection = new ArrayList<>();
        testCollection = factory.getPresents();
        Assert.assertEquals(factory.getCount(), testCollection.size());
    }
}
