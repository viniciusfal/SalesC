package Model;

import java.util.Date;

public class Transaction {

    private int id;
    private String name;
    private int productId;
    private int quantity;
    private String typeOfTransaction;
    private float value;
    private Date created_at;

    public Transaction(int id, String name, int productId, int quantity,
            String typeOfTransaction, float value, Date created_at) {

        this.id = id;
        this.name = name;
        this.productId = productId;
        this.quantity = quantity;
        this.typeOfTransaction = typeOfTransaction;
        this.value = value;
        this.created_at = created_at;
        
    }
    public Transaction(){
        this.created_at = new Date();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public float getValue() {
        return value;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTypeOfTransaction(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    
    @Override
    public String toString(){
        return "transaction{" + "id=" + id + ", name=" + name + ", productId=" 
                + productId + ", quantity=" + quantity + ", typeOfTransaction=" 
                + typeOfTransaction + ", value=" + value + ", crated_at=" + created_at + '}';
    }

}
