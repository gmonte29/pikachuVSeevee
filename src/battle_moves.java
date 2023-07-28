import java.util.Scanner;


public class battle_moves {

    //userAttack method, asks for selection than calls attack method with chosen attack
    public boolean attack_selection(pokemon user, pokemon computer, Boolean computer_turn){
        if (computer_turn){
            int index = (int) (Math.random() * (3 - 0 + 1));
            System.out.println("Opponent " + computer.pokemonName + " used "+computer.move_set[index].attackName);
            attack(user, computer.move_set[index]);

            if(user.pokemonHealth<=0){
                battleEnd(computer, user);
                return true;
            }

            System.out.println(user.pokemonName +" health: "+ user.pokemonHealth);
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

            if(computer.pokemonHealth<=0){
                battleEnd(user, computer);
                return true;
            }

            System.out.println(computer.pokemonName +" health: "+ computer.pokemonHealth);

        }
        System.out.println("--------------------");
        return false;
    }

    //decrease computer pokemon health by chosen attack * random less other defense stat * random
    public void attack(pokemon other, attacks attack){
        //line determines amount of damage done, subtacts receiving pokemon defense from attack power
        //attack power and pokemon defense are adjusted with 10% of value times value between 1 and -1
        int attack_power = (int)(attack.attackPower + attack.attackPower*.1*(Math.random()*2-1));
        int pokemon_defense = (int)(other.pokemonDefense + other.pokemonDefense*.1*(Math.random()*2-1));

        //sets minimum of 10 attack damage if attack is damage inducing but the defense is greater than the attack power
        if (attack_power > 0 && pokemon_defense > attack_power) other.pokemonHealth-=10;
        else other.pokemonHealth -= attack_power - Math.min(pokemon_defense, attack_power);
    }

    public void battleEnd(pokemon p, pokemon other){
        System.out.println(other.pokemonName + " fainted.");
        System.out.println(p.pokemonName + " won.");
    }

    public String getPokemonData(pokemon p){
        return p.pokemonName+" - Health: "+p.pokemonHealth+", Defense: "+p.pokemonDefense;
    }

}