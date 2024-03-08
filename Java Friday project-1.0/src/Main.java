import Entities.*;
import Interfaces.Volume;
import Interfaces.ScreenBrightness;
import java.util.Scanner;
import java.util.Objects;

// Ho provato a creare uno scanner il più efficiente possibile, cercando di rispettare la traccia
//con le 5 diverse possibilità da selezionare per l'utente. Non nego che essendo stata questa la mia prima
//settimana di Java ho provato a fare al meglio l'intera consegna, ma negli ultimi minuti a disposizione non ho
//potuto eliminare tutti gli errori che mi venivano segnalati. Di questo mi scuso sentitamente, ma ho cercato di
//fare del mio meglio nel tempo che avevo a disposizione. Ho avuto molteplici problemi con gli upload di github che hanno purtroppo
// rallentato le ultime ore del mio lavoro (l'upload dei comment ha richiesto una quantità di tempo anomalo ed ho dovuto riavviare il computer più volte).
//Chiedo ancora scusa, cercherò di vedere accuratamente i miei setting attuali di github, dato che in precedenza ero abituato agli upload
//mediante visual studio code.
public class Main {
    public static void main(String[] args) {
        System.out.println();
        final Scanner sc = new Scanner(System.in);

        System.out.println("Insert 5 multimedia types");
        System.out.println();
        System.out.println("Insert an image...");
        Video video1 = createVideo(sc);
        System.out.println("Insert a video...");
        Video video2 = createVideo(sc);
        System.out.println("Insert a video...");
        AudioRecording audio1 = createAudio(sc);
        System.out.println("Insert an audio...");
        AudioRecording audio2 = createAudio(sc);
        System.out.println("Insert an audio...");
        Image image = createImage(sc);

        MediaType[] media = {image, video1, video2, audio1, audio2,};
        player(sc, media);
    }

    public static Image createImage(Scanner sc) {
        System.out.println("Define a title:");
        final String title = sc.nextLine();
        System.out.println("Title: " + title);
        System.out.println("Recap - Title: " + title + "; Format: JPEG");
        System.out.println();
        return new Image(title, MediaType.JPEG);
    }

    public static AudioRecording createAudio(Scanner sc) {
        System.out.println("Define a title:");
        final String title = sc.nextLine();
        System.out.println("Title: " + title);
        format = MediaType.MP3;
        System.out.println("Define duration (seconds):");
        final int duration = Integer.parseInt(sc.nextLine());
        System.out.println("Duration: " + duration + " seconds");
        System.out.println("Recap - Title: " + title + "; Format: " + format + "; Duration: " + duration + " seconds");
        System.out.println();
        return new AudioRecording(title, format, duration);
    }
    public static Video createVideo(Scanner sc) {
        System.out.println("Define a title:");
        final String title = sc.nextLine();
        System.out.println("Title: " + title);
        System.out.println("Define format (MP4, AVI):");
        final String formatValue = sc.nextLine().toLowerCase();
        MediaType format;
        if (Objects.equals(formatValue, "mp4")) {
            format = MediaType.MP4;
            System.out.println("Format: " + format);
        } else if (Objects.equals(formatValue, "avi")) {
            format = MediaType.AVI;
            System.out.println("Format: " + format);
        } else {
            format = MediaType.MP4;
            System.out.println("Invalid input, default format selected: MP4");
        }
        System.out.println("Define duration (seconds):");
        final int duration = Integer.parseInt(sc.nextLine());
        System.out.println("Duration: " + duration + " seconds");
        System.out.println("Recap - Title: " + title + "; Format: " + format + "; Duration: " + duration + " seconds");
        System.out.println();
        return new Video(title, format, duration);
    }
    public static void manageVolume(Scanner sc, Multimedia el) {
        System.out.println();
        System.out.println("SET THE VOLUME OF " + el.getFileName());
        System.out.println("Current volume: " + ((Volume) el).getVolume()  + " (min: 0 - max: 10)");
        System.out.println("Instructions:");
        System.out.println("- Type \"up\" and press Enter to set up the volume (+1)");
        System.out.println("- Type \"down\" and press Enter to set down the volume (-1)");
        System.out.println("- Press Enter to go next");
        String value = sc.nextLine();
        if (Objects.equals(value, "up")) {
            ((Volume) el).volumeUp();
            manageVolume(sc, el);
        } else if (Objects.equals(value, "down")) {
            ((Volume) el).volumeDown();
            manageVolume(sc, el);
        }
    }

    public static void manageBrightness(Scanner sc, Multimedia el) {
        System.out.println();
        System.out.println("SET THE BRIGHTNESS OF " + el.getFileName());
        System.out.println("Current brightness: " + ((ScreenBrightness) el).getBrightness()  + " (min: 1 - max: 10)");
        System.out.println("Instructions:");
        System.out.println("- Type \"up\" and press Enter to set up the brightness (+1)");
        System.out.println("- Type \"down\" and press Enter to set down the brightness (-1)");
        System.out.println("- Press Enter to go next");
        String value = sc.nextLine();
        if (Objects.equals(value, "up")) {
            ((ScreenBrightness) el).screenBrightnessUp();
            manageBrightness(sc, el);
        } else if (Objects.equals(value, "down")) {
            ((ScreenBrightness) el).screenBrightnessDown();
            manageBrightness(sc, el);
        }
    }

    public static void imageHandler(Scanner sc, Multimedia el) {
        System.out.println();
        ((Image) el).show();
        System.out.println("Press Enter to exit");
        sc.nextLine();
        ((Image) el).close();
    }

    //Ho pensato di realizzare uno switch per gestire le 5 scelte dell'utente, mettendo in più 0 come
    //possibilità èper l'utente di uscire dalla scelta.
    public static void player(Scanner sc, Multimedia[] arr) {
        System.out.println("Select a media (digit the corresponding number):");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 + " - " + arr[i].getFileName());
        }
        System.out.println("0 - Exit the program");
        String value = sc.nextLine();
        switch (value) {
            case "0" -> sc.close();
            case "1" -> {
                if (arr[0] instanceof Volume) manageVolume(sc, arr[0]);
                if (arr[0] instanceof ScreenBrightness) manageBrightness(sc, arr[0]);
                if (arr[0] instanceof Volume) ((Volume) arr[0]).play();
                if (arr[0] instanceof Image) imageHandler(sc, arr[0]);
                System.out.println();
                player(sc, arr);
            }
            case "2" -> {
                if (arr[1] instanceof Volume) manageVolume(sc, arr[1]);
                if (arr[1] instanceof ScreenBrightness) manageBrightness(sc, arr[1]);
                if (arr[1] instanceof Volume) ((Volume) arr[1]).play();
                if (arr[1] instanceof Image) imageHandler(sc, arr[1]);
                System.out.println();
                player(sc, arr);
            }
            case "3" -> {
                if (arr[2] instanceof Volume) manageVolume(sc, arr[2]);
                if (arr[2] instanceof ScreenBrightness) manageBrightness(sc, arr[2]);
                if (arr[2] instanceof Volume) ((Volume) arr[2]).play();
                if (arr[2] instanceof Image) imageHandler(sc, arr[2]);
                System.out.println();
                player(sc, arr);
            }
            case "4" -> {
                if (arr[3] instanceof Volume) manageVolume(sc, arr[3]);
                if (arr[3] instanceof ScreenBrightness) manageBrightness(sc, arr[3]);
                if (arr[3] instanceof Volume) ((Volume) arr[3]).play();
                if (arr[3] instanceof Image) imageHandler(sc, arr[3]);
                System.out.println();
                player(sc, arr);
            }
            case "5" -> {
                if (arr[4] instanceof Volume) manageVolume(sc, arr[4]);
                if (arr[4] instanceof ScreenBrightness) manageBrightness(sc, arr[4]);
                if (arr[4] instanceof Volume) ((Volume) arr[4]).play();
                if (arr[4] instanceof Image) imageHandler(sc, arr[4]);
                System.out.println();
                player(sc, arr);
            }
            default -> {
                System.out.println("Invalid input. Try again.");
                System.out.println();
                player(sc, arr);
            }
        }
    }
}
