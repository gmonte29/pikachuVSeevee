import java.util.Scanner;

public class battle_moves {

    //userAttack method, asks for selection than calls attack method with chosen attack
    public void attack_selection(pokemon user, pokemon computer, Boolean computer_turn){
        if (computer_turn){
            int index = (int) (Math.random() * (3 - 0 + 1));
            System.out.println("Opponent " + computer.pokemonName + " used "+computer.move_set[index].attackName);
            attack(user, computer.move_set[index]);
        }
        else{
            System.out.println("Attack Selection");
            System.out.println("[1] "+ user.move_set[0].attackName);
            System.out.println("[2] "+ user.move_set[1].attackName);
            System.out.println("[3] "+ user.move_set[2].attackName);
            System.out.println("[4] "+ user.move_set[3].attackName);

            Scanner move = new Scanner(System.in);
            int selection = move.nextInt();

            if (user.move_set[selection-1]==null){
                throw new IndexOutOfBoundsException("no move in selected slot");
            }

            if(selection ==1) attack(computer, user.move_set[0]);
            if(selection ==2) attack(computer, user.move_set[1]);
            if(selection ==3) attack(computer, user.move_set[2]);
            if(selection ==4) attack(computer, user.move_set[3]);
        }
    }

    //decrease computer pokemon health by chosen attack * random less other defense stat * random
    public void attack(pokemon other, attacks attack){
        //line determines amount of damage done, subtacts receiving pokemon defense from attack power
        // minimum possible attack damage is 10
        other.pokemonHealth -= (Math.max(10,attack.attackPower*Math.random()- other.pokemonDefense*Math.random()));
    }

    public void battleEnd(pokemon p, pokemon other){
        System.out.println(other.pokemonName + " fainted.");
        System.out.println(p.pokemonName + " won.");
    }

    public String getPokemonData(pokemon p){
        return p.pokemonName+" - Health: "+p.pokemonHealth+", Defense: "+p.pokemonDefense;
    }

}