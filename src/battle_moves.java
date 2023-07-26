import java.util.Scanner;

public class battle_moves {

    //userAttack method, asks for selection than calls attack method with chosen attack
    public void attack_selection(pokemon sender, pokemon receiver, Boolean computer_turn){
        if (computer_turn){
            int index = (int) (Math.random() * (3 - 0 + 1));
            attack(receiver, sender.move_set[index]);
        }
        else{
            System.out.println("Attack Selection");
            System.out.println("[1] "+ sender.move_set[0].attackName);
            System.out.println("[2] "+ sender.move_set[1].attackName);
            System.out.println("[3] "+ sender.move_set[2].attackName);
            System.out.println("[4] "+ sender.move_set[3].attackName);

            Scanner move = new Scanner(System.in);
            int selection = move.nextInt();
            if(selection ==1) attack(receiver, sender.move_set[0]);
            if(selection ==2) attack(receiver, sender.move_set[1]);
            if(selection ==3) attack(receiver, sender.move_set[2]);
            if(selection ==4) attack(receiver, sender.move_set[3]);
        }
    }

    //decrease computer pokemon health by chosen attack * random less other defense stat * random
    public void attack(pokemon other, attacks attack){
        other.pokemonHealth -= (attack.attackPower*Math.random()- other.pokemonDefense*Math.random());
    }

    public void battleEnd(pokemon p, pokemon other){
        System.out.println(other.pokemonName + " has fainted.");
        System.out.println(p.pokemonName + " has won.");
    }

    public String getPokemonData(pokemon p){
        return p.pokemonName+" - Health: "+p.pokemonHealth+", Defense: "+p.pokemonDefense;
    }

}