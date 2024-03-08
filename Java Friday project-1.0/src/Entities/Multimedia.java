package Entities;

public abstract class Multimedia {
    private final MediaType format;
    private final String title;
    // Creo qui il costruttore del Multimedia che ci servirà per le altre classi presenti nel package Entities
    public Multimedia(String title, MediaType format) {
        this.title = title;
        this.format = format;
    }

    public String getFileName() {
        return this.title + "." + this.format.toString().toLowerCase();
    }
}
