package Entities;
import Interfaces.Volume;

public class AudioRecording extends Multimedia implements Volume{

    private final int seconds;
    private int volume;
    public AudioRecordings(String title, MediaType format, int seconds) {
        super(title, format);
        this.volume = 4;
        this.seconds = seconds;
    }

    // METHODS
    @Override
    public void play() {
        for (int i = seconds; i > 0 ; i--) {
            System.out.println(this.getFileName() + " is now playing. The remaining time is: " + i + " seconds; " + this.volumeIntensity());
            if (i == 1) System.out.println(this.getFileName() + " terminated reproduction.");
        }
    }


    @Override
    public void volumeDown() {
        if (volume > 0) {
            volume--;
        }
    }
    @Override
    public void volumeUp() {
        if (volume < 10) {
            volume++;
        }
    }

    @Override
    public String volumeIntensity() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < volume; i++) str.append("!");
        return "Volume: (" + str + ")";
    }
}
