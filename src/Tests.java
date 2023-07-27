import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.*;
import java.io.*;


public class Tests {
    pokemon temp_pokemon;
    pokemon temp_pokemon_1;
    battle_moves bm;
    sequence temp_sequence;


    @Test
    public void test_attack_damage(){
        temp_pokemon = new pokemon("test",100, 100,100 );
        int original_health = temp_pokemon.pokemonHealth;
        bm = new battle_moves();
        bm.attack(temp_pokemon, new attacks("test", 50, 0));

        assertTrue(temp_pokemon.pokemonHealth < original_health);
    }

    @Test
    public void test_constructor_invalid_arguments() {
        assertThrows(IllegalArgumentException.class, () -> {
            new pokemon("", 0, -1, -1);
        });
    }

    @Test
    public void test_battle_ends() {
        temp_pokemon = new pokemon("test",5, 0,0);
        temp_pokemon_1 = new pokemon("test",5, 0,50);
        temp_pokemon_1.move_set[0] = new attacks("", 50, 0);

        temp_sequence = new sequence(temp_pokemon, temp_pokemon_1);

        List<Integer> stream = Arrays.asList(2, 0);
        Iterator<Integer> input = stream.iterator();


        Scanner sc = new Scanner(input.);


    }

}
