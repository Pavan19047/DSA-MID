import java.util.Scanner;

public class Playlist {

    class Song {
        String song_name;
        Song next;

        Song(String song_name) {
            this.song_name = song_name;
            this.next = null;
        }
    }

    private Song head = null;
    private Song tail = null;

    public void addSong(String song_name) {
        Song newSong = new Song(song_name);

        if (head == null) {
            head = newSong;
            tail = newSong;
            System.out.println(song_name + " inserted to the playlist");
        } else {
            tail.next = newSong;
            tail = newSong;
            System.out.println(song_name + " inserted to the playlist");
        }
    }

    public void deleteSong(int pos) {
        if (head == null) {
            System.out.println("Playlist is empty");
        } else if (pos == 1) {
            System.out.println(head.song_name + " deleted from the playlist");
            head = head.next;
        } else {
            int count = 1;
            Song temp = head;
            Song prev = null;
            while (temp != null && count != pos) {
                count++;
                prev = temp;
                temp = temp.next;
            }

            if (temp == null) {
                System.out.println("Invalid position");
            } else {
                prev.next = temp.next;
                System.out.println(temp.song_name + " deleted from the playlist");
            }
        }
    }

    public void displayPlaylist() {
        Song temp = head;
        while (temp != null) {
            System.out.print(temp.song_name + "--->");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Playlist pl = new Playlist();
        Scanner sc = new Scanner(System.in);

        for (;;) {
            System.out.println("Enter your choice:-\n1.)Add song\n2.)Delete song\n3.)Display playlist\n0.)Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume the newline character
            switch (choice) {
                case 1:
                    System.out.println("Enter the song name:-");
                    String song_name = sc.nextLine();
                    pl.addSong(song_name);
                    break;
                case 2:
                    System.out.println("Enter the position of the song to be deleted:-");
                    int pos = sc.nextInt();
                    pl.deleteSong(pos);
                    break;
                case 3:
                    System.out.println("Playlist:-");
                    pl.displayPlaylist();
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }

        }
    }
}
