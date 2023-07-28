import java.util.Scanner;

public class sequence {
    pokemon first;
    pokemon second;
    battle_moves bm;
    Boolean battle_on;

    public sequence(pokemon first, pokemon second){
        this.first = first;
        this.second = second;
        this.bm = new battle_moves();
        battle_on = true;
    }

    public void user_select(){
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

        run_sequence(user, computer);

    }

    public void run_sequence(pokemon user, pokemon computer){

        //while loop goes through each turn consisting of an attack by both pokemon
        //the pokemon with the first turn determined through speed stat multiplied by random method
        while (user.pokemonHealth > 0 && computer.pokemonHealth > 0) {
            //line where first attacker is determined
            double user_speed = user.pokemonSpeed + user.pokemonSpeed*.1*(Math.random()*2-1);
            double computer_speed = computer.pokemonSpeed + computer.pokemonSpeed*.1*(Math.random()*2-1);

            pokemon turn = user_speed > computer_speed ? user : computer;

            if(turn == user) {
                if (bm.attack_selection(user, computer, false)) break;
                if (bm.attack_selection(user, computer, true)) break;
            }
            else {
                if (bm.attack_selection(user, computer, true)) break;
                if (bm.attack_selection(user, computer, false)) break;
            }
        }
        battle_on = false;
    }
}
