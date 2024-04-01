public class Doctor extends Role{
    public Doctor(){
        super("Doctor");
    }

    public static void Protect(String[][] player,String[][] playerClone, String name){
        int x = Main.TargetSearch(player, name);
        if(x != -1){
            player[x][1] = playerClone[x][1];
            System.out.println(player[x][0]+" is Protected");
        }
    }
}