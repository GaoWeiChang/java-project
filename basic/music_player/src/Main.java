import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // audio accepted .wav, .au, .aiff
        String filePath = "src/music/song1.wav";
        File file = new File(filePath);

        // read audio file (raw file)
        try (Scanner scanner = new Scanner(System.in); // it will auto close in try and except
             AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {

            // set actual audio
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();

            String response = "";
            while(!response.equals("Q")){
                System.out.println("P = play");
                System.out.println("S = stop");
                System.out.println("R = reset");
                System.out.println("Q = quit");
                System.out.print("Enter your choice: ");
                response = scanner.next().toUpperCase();

                switch (response) {
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.close();
                    default -> System.out.println("Invalid choice");
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Could not located file");
        }
        // file not supported
        catch (UnsupportedAudioFileException e){
            System.out.println("Audio file is not supported");
        }
        catch (LineUnavailableException e){
            System.out.println("Unable to access audio resource");
        }
        // have another problem eg. not found, cannot read
        catch (IOException e){
            System.out.println("Something went wrong");
        }
        finally {
            System.out.println("Bye!");
        }
    }
}
