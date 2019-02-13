package mx.charlhyemartinez.challenge.model;

import java.io.Serializable;

public class ResultItem implements Serializable {
    private String title, discipline, venue, price, description, date, address, url, img;

    public ResultItem(String title, String discipline, String venue, String price, String description, String date, String address, String url, String img) {
        this.title = title;
        this.discipline = discipline;
        this.venue = venue;
        this.price = price;
        this.description = description;
        this.date = date;
        this.address = address;
        this.url = url;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return this.title + ", " + this.venue + ", " + this.price;
    }
}
