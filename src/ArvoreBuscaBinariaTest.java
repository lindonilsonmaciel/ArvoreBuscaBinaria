import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class ArvoreBuscaBinariaTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @Test
    public void isBalanced(){
        //Arrange
        Random random = new Random();
        ArvoreBuscaBinaria tree = new ArvoreBuscaBinaria();
        for (int i = 0; i < 10; i++){
            tree.insert(random.nextInt(40));
        }
        //Act
        int balanced = tree.balanced();
        boolean test = (balanced == 1) ? true : false;
        //Assert
        assertEquals(test, tree.isBalanced());
    }
}