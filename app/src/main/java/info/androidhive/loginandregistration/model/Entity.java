package info.androidhive.loginandregistration.model;

import java.io.Serializable;

/**
 * Created by Anis on 07/05/2017.
 */

public class Entity implements Serializable{
    String nom_ecole,image,info;

    public Entity() {
    }

    public Entity(String nom_ecole, String image, String info) {
        this.nom_ecole = nom_ecole;
        this.image = image;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "nom_ecole='" + nom_ecole + '\'' +
                ", image='" + image + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public String getNom_ecole() {
        return nom_ecole;
    }

    public void setNom_ecole(String nom_ecole) {
        this.nom_ecole = nom_ecole;
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
}
