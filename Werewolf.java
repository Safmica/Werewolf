public class Werewolf extends Role{
    String target;
    
    public Werewolf(){
        super("Werewolf");
    }

    public static void Kill(String[][] player, String name){
        int x = Main.TargetSearch(player, name);
        player[x][0] = "Death";
        player[x][1] = "Death";
    }
}
