import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {
    pokemon first;
    pokemon second;
    battle_moves bm;


    @Test
    public void test_attack_impact(){
        second = new pokemon("test",100, 100,100 );
        double original_health = second.pokemonHealth;
        bm = new battle_moves();
        bm.attack(second, new attacks("test", 50, 0));

        assertEquals(50, second.pokemonHealth);
    }


}
