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

    public Boolean send_attack(pokemon user, pokemon computer, Boolean comp){
        //user or computer attack methods called based on who's turn it is
        if(comp) bm.attack_selection(user, computer, true);
        else bm.attack_selection(user, computer, false);

        //method to end battle if other Pokemon's health <= zero
        if(comp && user.pokemonHealth<=0){
            bm.battleEnd(computer, user);
            return true;
        }

        //method to end battle if other Pokemon's health <= zero
        if(!comp && computer.pokemonHealth<=0){
            bm.battleEnd(user, computer);
            return true;
        }

        //after each attack the status of the receiving Pokemon is shown
        if (comp) {
            System.out.println(user.pokemonName +" health: "+ user.pokemonHealth);
        }
        else System.out.println(computer.pokemonName +" health: "+ computer.pokemonHealth);
        System.out.println("-------------------");
        return false;
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

            if(turn == user) {
                if (send_attack(user, computer, false)) break;
                if (send_attack(user, computer, true)) break;
            }
            else {
                if (send_attack(user, computer, true)) break;
                if (send_attack(user, computer, false)) break;
            }

        }
        battle_on = false;
        sc.close();
    }
}
