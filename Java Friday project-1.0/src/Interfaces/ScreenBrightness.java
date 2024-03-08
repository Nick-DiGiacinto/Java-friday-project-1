package Interfaces;

//Creo queste due interfacce per consentire rispettivamente la regolazione della luminosità
// e del volume nelle classi presenti nel package Entities
public interface ScreenBrightness {
    void screenBrightnessUp();
    void screenBrightnessDown();
    String screenBrightnessLevel();
}
