public class Ladybug extends Role{
    public Ladybug(){
        super("Ladybug");
    }

    public static void Move(String[][] player,String[][] playerClone, String name){
        int x = Main.TargetSearch(player, name);
        int y = Main.RoleSearch(playerClone, "Ladybug");
        if(x != -1 || y != -1){
            if(!player[x][1].equals("Killed")) player[y][1] = playerClone[y][1];
            else  player[y][1] = player[x][1];
            System.out.println(player[y][0]+" is moved to "+player[x][0]);
        }
    }
}
