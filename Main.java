import java.util.*;

public class Main{
    static Scanner scr = new Scanner(System.in);
    static Random ran = new Random();
    public static void main(String[] args) {
        boolean status = true;
        boolean play = true;
        while(status){
            String role[] = {"Villager","Villager","Villager","Werewolf","Werewolf","Sorcerer","Seer","Doctor","Ladybug","Bomberman","Traitor","Dopplegangger","Joker"};
            String player[][] = new String[13][2];
            String playerClone[][] = new String[13][2];

            ShuffleArray(role);
            InputPlayer(role, player);
            Clone(player, playerClone);
            System.out.println();
            System.out.println("ROLE WEREWOLF");
            System.out.println();
            ShowArray(player);
            play = true;
            while (play) {
                play = Menu(player,playerClone,play);
                ShowArray(player);
            }
            System.out.println();
            System.out.println( "WEREWOLF GAME");
            System.out.println("================");
        }
        scr.close();
    }

    static void Clone(String player[][], String playerClone[][]){
        for(int i = 0;i<player.length;i++){
            for(int j = 0;j<player[i].length;j++){
                playerClone[i][j] = player[i][j];
            }
        }
    }


    static void InputPlayer(String role[], String player[][]){
        for(int i = 0;i<role.length;i++){
            int a = 0;
            int b = 1;
            System.out.print("Player "+(i+1)+" = ");
            player[i][a] = scr.nextLine();
            player[i][b] = role[i];
        }
    }

    static void ShuffleArray(String[] array) {
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);

            String temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    static void ShowArray(String player[][]){
        for(int i = 0;i<player.length;i++){
            System.out.print((i+1)+". ");
            System.out.print(player[i][0]);
            System.out.print("(");
            System.out.print(player[i][1]);
            System.out.print(")");
            System.out.println();
        }
    }

    static boolean Menu(String player[][],String[][] playerClone,boolean play){
        String target;

        System.out.println();
        System.out.println("NIGHT IS COMING");
        System.out.print("1. Werewolf target = ");
        target = scr.nextLine();
        Werewolf.Kill(player, target);
        System.out.println();

        System.out.print("2. Sorcerer target = ");
        target = scr.nextLine();
        Sorcerer.IsSeer(player, target);
        System.out.println();

        System.out.print("3. Seer target = ");
        target = scr.nextLine();
        Seer.ShowRole(player, target);
        System.out.println();

        System.out.print("4. Doctor target = ");
        target = scr.nextLine();
        Doctor.Protect(player,playerClone,target);
        System.out.println();
        
        System.out.print("5. Ladybug target = ");
        target = scr.nextLine();
        Ladybug.Move(player,playerClone,target);
        System.out.println();

        System.out.print("7. Vote = ");
        target = scr.nextLine();
        Mod.Vote(player, target);
        System.out.println();

        Bomberman.Bom(player, playerClone);
        System.out.println();


        boolean value = Winner(player, play);
        Mod.Dead(player);
        System.out.println();
        //check werewolf and traitor status
        return value;
    }

    static int RoleSearch(String[][] array, String target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][1].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    static int TargetSearch(String[][] array, String target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i][0].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    static int Count(String[][] array, String target){
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i][1].equals(target)){
                count+=1;
            }
        }
        return count;
    }

    static boolean Winner(String[][] player, boolean play){
        int ww = RoleSearch(player, "Werewolf");
        int sorcerer = RoleSearch(player, "Sorcerer");
        int traitor = RoleSearch(player, "Traitor");
        if(ww == -1 && sorcerer == -1){
            if(traitor != -1){
                System.out.println("====|Congratulations "+player[traitor][0]+", Traitor WIN|====");
                play = false;
                return play;
            }
            else{
                System.out.println("====|Congratulations Villagers WIN|====");
                play = false;
                return play;
            }
        }
        else if(ww != -1 || sorcerer != -1){
            int bad = 0;
            int good = 0;
            for(int i = 0; i <player.length; i++){
                if(player[i][1].equals("Win")) {
                    System.out.println("====|Congratulations "+player[i][0]+",Joker WIN|====");
                    play = false;
                    return play;
                }
                if(player[i][1].equals("Werewolf") || player[i][1].equals("Sorcerer")) bad += 1;
                if(!player[i][1].equals("Werewolf") && !player[i][1].equals("Sorcerer") && !player[i][1].equals("Death")) good += 1;
            }
            if(good == bad){
                System.out.println("====|Werewolf and Sorcerer WIN|====");
                play = false;
                return play;
            }
            System.out.println("====|"+Count(player, "Werewolf")+" Werewolf left and "+Count(player, "Sorcerer")+" Sorcerer left"+"|====");
        }
        else{
            System.out.println("====|"+Count(player, "Werewolf")+" Werewolf left and "+Count(player, "Sorcerer")+" Sorcerer left"+"|====");
        }
        return play;
    }
}