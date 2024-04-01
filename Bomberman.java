import java.util.Scanner;

public class Bomberman extends Role{
    static Scanner  scr = new Scanner(System.in);

    public Bomberman (){
        super("Bomberman");
    }

    public static void Bom(String player[][], String[][] playerClone){
        int x = Main.RoleSearch(playerClone, "Bomberman");
        if(x != -1){
            if(player[x][1].equals("Killed") || player[x][1].equals("Voted")){
                System.out.print("Bomberman target = ");
                String target = scr.nextLine();
                int y = Main.TargetSearch(player, target);
                if(x != -1){
                    System.out.println(player[y][0]+" is Bombed");
                    player[y][1] = "Dead";
                    System.out.println();
                }
            }
        }
    }
}
