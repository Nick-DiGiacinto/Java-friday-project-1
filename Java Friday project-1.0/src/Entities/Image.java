package Entities;
import Interfaces.ScreenBrightness;
public class Image extends Multimedia implements ScreenBrightness{
    private int brightness;

    // Setto un valore di partenza di brightness ed effettuo degli override dei metodi presenti
    // nell'interfaccia ScreenBrightness, che ho creato precedentemente nel package Interfaces
    // per consentire la regolazione della luminosità
    public Image(String title, MediaType format) {
        super(title, format);
        this.brightness = 4;
    }

    // METHODS
    public void show() {
        System.out.println(this.getFileName() + " showing...; " + this.screenBrightnessLevel());
    }

    public void close() {
        System.out.println(this.getFileName() + " closed.");
    }

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
}
