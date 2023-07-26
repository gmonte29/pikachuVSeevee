import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        //Pokemon objects created
        pokemon pikachu = new pokemon("Pikachu", 200, 30, 90);
        pokemon eevee = new pokemon("Eevee", 200, 50, 55);

        pikachu.set_move(0,"Light Screen", 0, 50);
        pikachu.set_move(1,"Thunder", 120, 0);
        pikachu.set_move(2,"Agility", 0, 50);
        pikachu.set_move(3,"Thunder Bolt", 95, 0);

        eevee.set_move(0, "Take Down", 90, 0);
        eevee.set_move(1, "Focus Energy", 0, 50);
        eevee.set_move(2, "Bite", 60, 0);
        eevee.set_move(3, "Quick Attack", 40, 0);

        sequence go = new sequence(pikachu, eevee);
        go.run_sequence();

    }
}