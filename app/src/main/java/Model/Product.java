package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {

    private int id;
    private String name;
    private int size;
    private String color;
    private Date created_at;
    private Date updated_at;

    public Product(int id, String name, int size, String color,
            Date create_at, Date updated_at) {

        this.id = id;
        this.name = name;
        this.size = size;
        this.color = color;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Product() {
        this.updated_at = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", size=" + size
                + ", color=" + color + ", created_at=" + created_at
                + ", updated_at=" + updated_at + '}';
    }

}
