package Entities;

import Interfaces.ScreenBrightness;
import Interfaces.Volume;
public class Video extends Multimedia implements Volume, ScreenBrightness {
    private int volume;
    private int brightness;
    private final int seconds;


    public Video(String title, MediaType format, int seconds) {
        super(title, format);
        this.brightness = 4;
        this.volume = 4;
        this.seconds = seconds;
    }

// Effettuo gli override per la regolazione di luminosità e volume adoperando i metodi implementati nelle interfacce

    @Override
    public void screenBrightnessDown() {
        if (brightness > 1) {
            brightness--;
        }
    }

    @Override
    public void screenBrightnessUp() {
        if (brightness < 10) {
            brightness++;
        }
    }

    @Override
    public String screenBrightnessLevel() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < brightness; i++) str.append("*");
        return "Brightness: (" + str + ")";
    }

    @Override
    public void play() {
        for (int i = seconds; i > 0 ; i--) {
            System.out.println(this.getFileName() + " is now playing. The remaining time is: " + i + " seconds; " + this.volumeIntensity() + "; " + this.screenBrightnessLevel());
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
