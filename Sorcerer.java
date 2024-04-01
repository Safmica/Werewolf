public class Sorcerer extends Role{
    public Sorcerer(){
        super("Sorcerer");
    }

    public static void IsSeer(String[][] player, String name){
        int x = Main.TargetSearch(player, name);
        if(x != -1){
            if(player[x][1].equals("Seer")){
                System.out.println(player[x][0]+" is Seer");
            }
            else{
                System.out.println(player[x][0]+" isn't Seer");
            }
        }
    }
}

