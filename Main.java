import java.util.*;

public class Main{
    static Scanner scr = new Scanner(System.in);
    static Random ran = new Random();
    public static void main(String[] args) {
        boolean status = true;
        while(status){
            String role[] = {"Villager","Villager","Villager","Werewolf","Werewolf","Sorcerer","Seer","Doctor","Ladybug","Bomberman","Traitor","Dopplegangger","Joker"};
            String player[][] = new String[13][2];

            shuffleArray(role);
            inputPlayer(role, player);
            showRole(player);
        }
        scr.close();
    }

    static void inputPlayer(String role[], String player[][]){
        for(int i = 0;i<role.length;i++){
            int a = 0;
            int b = 1;
            System.out.print("Player "+(i+1)+" = ");
            player[i][a] = scr.nextLine();
            player[i][b] = role[i];
        }
    }

    static void shuffleArray(String[] array) {
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);

            String temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    static void showRole(String player[][]){
        for(int i = 0;i<player.length;i++){
            System.out.print((i+1)+". ");
            System.out.print(player[i][0]);
            System.out.print("(");
            System.out.print(player[i][1]);
            System.out.print(")");
            System.out.println();
        }
    }
}