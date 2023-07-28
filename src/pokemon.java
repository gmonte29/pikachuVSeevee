
public class pokemon {
    String pokemonName;
    int pokemonHealth;
    int pokemonDefense;
    int pokemonSpeed;
    attacks [] move_set;

    //constructor to create Pokemon object
    public pokemon (String name, int health, int defense, int speed){
        if (health < 1 || defense < 0 || speed < 0){
            throw new IllegalArgumentException();
        }
        pokemonName = name;
        pokemonHealth = health;
        pokemonDefense = defense;
        pokemonSpeed = speed;
        move_set = new attacks[4];
    }

    public void set_move(int index, String name, int power, int status){
        if (index >= 4 || index < 0) {
            throw new IllegalArgumentException("Incorrect Index");
        }
        move_set[index] = new attacks(name, power, status);
    }

}
