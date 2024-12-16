import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Checker implements Comparator<Player> {
    public int compare(Player p1, Player p2) {
        int scoreComparator = Integer.compare(p2.score, p1.score);
        if (scoreComparator != 0) {
            return scoreComparator;
        } else {
            return p1.name.compareTo(p2.name);
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

class Comp {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("namesScore.txt"));
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