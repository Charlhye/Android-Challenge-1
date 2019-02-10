package mx.charlhyemartinez.challenge.model;

import java.io.Serializable;

public class ResultItem implements Serializable {
    private String title, discipline, venue, price;

    public ResultItem(String title, String discipline, String venue, String price) {
        this.title = title;
        this.discipline = discipline;
        this.venue = venue;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
