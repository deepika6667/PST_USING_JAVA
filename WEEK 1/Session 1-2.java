JAVA COMPARATOR:
  import java.util.*;
import java.util.Comparator;

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        // If scores are equal, sort alphabetically by name (ascending)
        if (a.score == b.score) {
            return a.name.compareTo(b.name);
        }
        
        // Otherwise, sort by score in descending order
        if (a.score < b.score) {
            return 1;
        } else {
            return -1;
        }
    }
}

class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
     
        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}

OUTPUT:
Input (stdin)
5
amy 100
david 100
heraldo 50
aakansha 75
aleksa 150
Your Output (stdout)
aleksa 150
amy 100
david 100
aakansha 75
heraldo 50
Expected Output
aleksa 150
amy 100
david 100
aakansha 75
heraldo 50
