public class Werewolf extends Role{
    String target;
    
    public Werewolf(){
        super("Werewolf");
    }

    public static void Kill(String[][] player, String name){
        int x = Main.TargetSearch(player, name);
        if(x != -1){
            System.out.println(player[x][0]+" is Killed");
            player[x][1] = "Killed";
        }
    }
}
