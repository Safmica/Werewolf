public class Seer extends Role{
    public Seer(){
        super("Seer");
    }

    public static void ShowRole(String[][] player, String name){
        int x = Main.TargetSearch(player, name);
        if(x != -1){
            if(player[x][1].equals("Werewolf") || player[x][1].equals("Sorcerer")){
                System.out.println(player[x][0]+" is Bad");
            }
            else if(player[x][1].equals("Dopplegangger") || player[x][1].equals("Joker") || player[x][1].equals("Traitor")){
                System.out.println(player[x][0]+" is Neutral");
            }
            else{
                System.out.println(player[x][0]+" is Good");
            }
        }
    }
}

