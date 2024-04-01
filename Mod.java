public class Mod {
    public static void Vote(String[][] player, String name){
        int x = Main.TargetSearch(player, name);
        if(x != -1){
            System.out.println(player[x][0]+" is Voted Out");
            if(player[x][1].equals("Joker")){
                player[x][1] = "Win";
            }
            int dopplegangger = Main.RoleSearch(player, "Dopplegangger");
            if(x != -1){
                if(dopplegangger != -1){
                    player[dopplegangger][1] = player[x][1];
                }
                else{
                    player[x][1] = "Voted";
                }
            }
        }
    }

    public static void Dead(String[][] player){
        for (int i = 0; i < player.length; i++) {
            if (player[i][1].equals("Killed") || player[i][1].equals("Voted")) {
                player[i][1] = "Dead";
            }
        }
    }
}
