package info.androidhive.loginandregistration.model;

/**
 * Created by Anis on 07/05/2017.
 */

public class Entity {
    String title,image,info;

    public Entity(String title, String image, String info) {
        this.title = title;
        this.image = image;
        this.info = info;
    }

    public Entity() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
