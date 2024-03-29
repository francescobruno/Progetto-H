/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import exceptions.ProductNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Francesco
 */
public class Comanda extends Observable{

    private ArrayList<Product> ordersList = new ArrayList<Product>();
    private Client client;
    private Calendar deliveryTime = new GregorianCalendar();

    public Comanda(){
    }

    public void addProduct(Product p) {
        this.ordersList.add(p);
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "CLIENT >> " + this.client.toString() + "\t"
                + "\n\nOra di Consegna " + getTime() + "\n"
                + "\nOrdini : \n" + this.getOrderedProducts() + "\n "
                + "\nTotal : " + this.calculateTotalPrice();
    }

    public String getOrderedProducts() {
        int index = 0;
        String s = "";
        for (Product p : ordersList) {
            index++;
            s += index + ".\t" + p.toString() + "\n";
        }
        return s;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product p : ordersList) {
            totalPrice += p.getPrice();

        }
        return totalPrice;
    }

    public Calendar getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Calendar data) {
        this.deliveryTime = data;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void removeProduct(String nomeProdcut) throws ProductNotFoundException {
        Product prodottoTrovato = this.searchProdcutByName(nomeProdcut);
        this.ordersList.remove(prodottoTrovato);
        setChanged();
        notifyObservers();
    }

    private Product searchProdcutByName(String nameProduct) throws ProductNotFoundException {
        Product p = null;
        for (Product ord : ordersList) {
            if (ord.getName().equals(nameProduct)) {
                p = ord;
                break; //fa schifo

            }
        }
        if (p == null) {
            throw new ProductNotFoundException("\t NESSUN PRODOTTO TROVATO INERENTE A : \t" + nameProduct);
        }
        return p;
    }
    
    private String getTime(){
        return deliveryTime.getTime().toString();
    }

    public ArrayList<Product> getOrdersList() {
        return ordersList;
    }
    
    
}

