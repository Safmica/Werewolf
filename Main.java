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

            ShuffleArray(role);
            InputPlayer(role, player);
            System.out.println();
            System.out.println("ROLE WEREWOLF");
            System.out.println();
            ShowArray(player);
            play = true;
            while (play) {
                play = Menu(player,play);
                ShowArray(player);
            }
            System.out.println();
            System.out.println( "WEREWOLF GAME");
            System.out.println("================");
        }
        scr.close();
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

    static boolean Menu(String player[][],boolean play){
        System.out.println();
        System.out.println("Moderator Menu");
        System.out.println("1. Werewolf");
        System.out.println("2. Seer");
        System.out.println("3. Doctor");
        System.out.println("4. Sorcerer");
        System.out.println("5. Ladybug");
        System.out.println("6. Bomberman");
        System.out.println("7. Dopplegangger (vote 1)");
        System.out.println("8. Vote");
        System.out.println();
        System.out.print("Input = ");
        int input = scr.nextInt();
        scr.nextLine();
        String target;

        switch (input) {
            case 1:
                System.out.print("Target = ");
                target = scr.nextLine();
                Werewolf.Kill(player, target);
                System.out.println();
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            case 6:
                
                break;
            case 7:
                
                break;
            default:
                break;
        }
        
        //check werewolf and traitor status
        int ww = SequentialSearch(player, "Werewolf");
        int sorcerer = SequentialSearch(player, "Sorcerer");
        int traitor = SequentialSearch(player, "Traitor");
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

    static int SequentialSearch(String[][] array, String target) {
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
}