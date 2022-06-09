import java.util.*;

public class pokemon {

    String pokemonName;
    double pokemonHealth;
    int pokemonDefense;
    int pokemonSpeed;
    Attacks one;
    Attacks two;
    Attacks three;
    Attacks four;

    //constructor to create pokemon object
    public pokemon (String name, double health, int defense, int speed){
        pokemonName = name;
        pokemonHealth = health;
        pokemonDefense = defense;
        pokemonSpeed = speed;

        one = new Attacks("",0,0);
        two = new Attacks("",0,0);
        three = new Attacks("",0,0);
        four = new Attacks("",0,0);
    }

    //userAttack method, asks for selection than calls attack method with chosen attack
    public void userAttack(pokemon other){
        System.out.println("Attack Selection");
        System.out.println("[1] "+ one.attackName);
        System.out.println("[2] "+ two.attackName);
        System.out.println("[3] "+ three.attackName);
        System.out.println("[4] "+ four.attackName);
        Scanner move = new Scanner(System.in);
        int selection = move.nextInt();
        if(selection ==1) attack(other, one);
        if(selection ==2) attack(other, two);
        if(selection ==3) attack(other, three);
        if(selection ==4) attack(other, four);
    }

    //decrease computer pokemon health by chosen attack * random less other defense stat * random
    public void attack(pokemon other, Attacks attack){
        other.pokemonHealth -= (attack.attackPower*Math.random()- other.pokemonDefense*Math.random());
    }

    //computer attack method, makes selection using random
    public void computerAttack(pokemon other){
        double [] attackList = new double [4];
        attackList[0] = one.attackPower*Math.random();
        attackList[1] = two.attackPower*Math.random();
        attackList[2] = three.attackPower*Math.random();
        attackList[3] = four.attackPower*Math.random();
        double max = Double.MIN_VALUE;
        int attack = Integer.MIN_VALUE;
        Attacks used = one;

        for(int i = 0; i < attackList.length; i++){
            if(attackList[i] > max){
                max = attackList[i];
                attack = i;
            }
        }

        if(attack == 0) used = one;
        if(attack == 1) used = two;
        if(attack == 2) used = three;
        if(attack == 3) used = four;

        other.pokemonHealth -= (max-other.pokemonDefense*Math.random());
        System.out.println(pokemonName+" used "+ used.attackName);
    }

    public void battleEnd(pokemon other){
        System.out.println(other.pokemonName + " has fainted.");
        System.out.println(pokemonName + " has won.");
    }

    public String getPokemonData(){
        return pokemonName+" - Health: "+pokemonHealth+", Defense: "+pokemonDefense;
    }

    public void oneSet(String name, int power, int status){
        one.attackName=name;
        one.attackPower=power;
        one.attackStatus=status;
    }

    public void twoSet(String name, int power, int status){
        two.attackName=name;
        two.attackPower=power;
        two.attackStatus=status;
    }

    public void threeSet(String name, int power, int status){
        three.attackName=name;
        three.attackPower=power;
        three.attackStatus=status;
    }

    public void fourSet(String name, int power, int status){
        four.attackName=name;
        four.attackPower=power;
        four.attackStatus=status;
    }
}
