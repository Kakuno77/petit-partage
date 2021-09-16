import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void testBidon() {
        // GIVEN
        int a = 2;
        int b = 3;

        // WHEN
        int c = a + b;

        // THEN
        Assertions.assertEquals(6, c);
    }
}
