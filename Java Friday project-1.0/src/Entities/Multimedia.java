package Entities;

public abstract class Multimedia {

    private final String title;
    private final MediaType format;

    // Creo qui il costruttore del Multimedia che ci servirà per le altre classi presenti nel package Entities
    public Multimedia(String title, MediaType format) {
        this.title = title;
        this.format = format;
    }

    // GETTERS & SETTERS
    public String getFileName() {
        return this.title + "." + this.format.toString().toLowerCase();
    }
}
