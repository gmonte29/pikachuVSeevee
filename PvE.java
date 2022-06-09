import java.util.Scanner;

public class PvE {

    public static void main(String[] args) {

        //Pokemon objects created
        pokemon pikachu = new pokemon("Pikachu", 200, 30, 90);
        pokemon eevee = new pokemon("Eevee", 200, 50, 55);

        //Set up four attacks for each pokemon
        pikachu.oneSet("Light Screen", 0, 50);
        pikachu.twoSet("Thunder", 120, 0);
        pikachu.threeSet("Agility", 0, 50);
        pikachu.fourSet("Thunder Bolt", 95, 0);

        eevee.oneSet("Take Down", 90, 0);
        eevee.twoSet("Focus Energy", 0, 50);
        eevee.threeSet("Bite", 60, 0);
        eevee.fourSet("Quick Attack", 40, 0);

        // Requests the user to choose a pokemon to use in the battle
        System.out.println("Pokemon selection for battle; Eevee or Pikachu?");
        System.out.println("[1] Pikachu");
        System.out.println("[2] Eevee");

        //section where user determines which pokemon to use and sets the computer to the other choice
        Scanner sc = new Scanner(System.in);
        int userPokemon = sc.nextInt();
        pokemon user;
        pokemon computer;

        if (userPokemon == 1) {
            user = pikachu;
            computer = eevee;
        } else {
            user = eevee;
            computer = pikachu;
        }

        //while loop goes through each turn consisting of an attack by both pokemon
        //the pokemon with the first turn determined through speed stat multiplied by random method
        while (user.pokemonHealth > 0 && computer.pokemonHealth > 0) {
            //line where first attacker is determined
            pokemon turn = user.pokemonSpeed*Math.random() > computer.pokemonSpeed*Math.random() ? user : computer;
            pokemon other;
            if(turn == user) other = computer;
            else other = user;

            //user or computer attack methods called based on who's turn it is
            if(turn == user) turn.userAttack(other);
            else turn.computerAttack(other);

            //method to end battle if other Pokemon's health <= zero
            if(other.pokemonHealth<=0){
                turn.battleEnd(other);
                break;
            }
            //after each attack the status of the receiving Pokemon is shown
            System.out.println(other.pokemonName +" health: "+(int)other.pokemonHealth);
            System.out.println();

            //turn pokemon and other pokemon are switched and attacking sequence redone below
            pokemon temp = turn;
            turn = other;
            other = temp;

            if(turn == user) turn.userAttack(other);
            else turn.computerAttack(other);

            if(other.pokemonHealth<=0){
                turn.battleEnd(other);
                break;
            }

            System.out.println(other.pokemonName +" health: "+(int)other.pokemonHealth);
            System.out.println();
        }
        sc.close();
    }
}