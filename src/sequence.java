import java.util.Scanner;

public class sequence {
    pokemon first;
    pokemon second;
    battle_moves bm;

    public sequence(pokemon user, pokemon other){
        this.first = user;
        this.second = other;
        this.bm = new battle_moves();
    }

    public void run_sequence(){
        // Requests the user to choose a pokemon to use in the battle
        System.out.println("Pokemon selection for battle; Eevee or Pikachu?");
        System.out.println("[1]"+first.pokemonName);
        System.out.println("[2]"+second.pokemonName);

        //section where user determines which pokemon to use and sets the computer to the other choice
        Scanner sc = new Scanner(System.in);
        int userPokemon = sc.nextInt();
        pokemon user;
        pokemon computer;

        if (userPokemon == 1) {
            user = first;
            computer = second;
        } else {
            user = second;
            computer = first;
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
            if(turn == user) bm.attack_selection(user, other, false);
            else bm.attack_selection(other, user, true);

            //method to end battle if other Pokemon's health <= zero
            if(other.pokemonHealth<=0){
                bm.battleEnd(turn, other);
                break;
            }
            //after each attack the status of the receiving Pokemon is shown
            System.out.println(other.pokemonName +" health: "+(int)other.pokemonHealth);
            System.out.println();

            //turn pokemon and other pokemon are switched and attacking sequence redone below
            pokemon temp = turn;
            turn = other;
            other = temp;

            if(turn == user) bm.attack_selection(user,other);
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
