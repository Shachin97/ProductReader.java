import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ProductTest {
    Product p1, p2, p3, p4;

    @BeforeEach
    void setUp()
    {

        p1 = new Product("12345", "paper", "used to write", 2.45);
        p2 = new Product("54321", "pencil", "piece of tool", 1.99);
        Product.setIDSeed(0);
        p3 = new Product("Wines", "modern drink", 159.00 );
        p4 = new Product("Chicken", "food", 9.00);

    }

    @Test
    void getIDSeed() {
        assertEquals(0, Product.getIDSeed());
    }

    @Test
    void getName() {
        assertEquals("paper", p1.getName());
    }

    @Test
    void setName() {
        p1.setName("pencil");
        assertEquals("pencil", p2.getName());
    }

    @Test
    void getDescription() {
        assertEquals("used to write", p1.getDescription());
    }

    @Test
    void setDescription() {
        p3.setDescription("Modern drink");
        assertEquals("Modern drink", p3.getDescription());
    }

    @Test
    void getID() {
        assertEquals("12345", p1.getIDNum());
    }

    @Test
    void setIDNum() {
        p1.setIDNum("00000B");
        assertEquals("00000B", p1.getIDNum());
    }

    @Test
    void getCost() {
        assertEquals(2.45, p1.getCost());
    }

    @Test
    void setCost() {
        p1.setCost(9.99);
        assertEquals(9.99, p1.getCost());
    }

    @Test
    void Equals() {
        p1.setIDNum("54321");
        p1.setName("pencil");
        p1.setDescription("piece of tool");
        p1.setCost(1.99);
        assertEquals(true, p1.equals(p2));
    }
}
