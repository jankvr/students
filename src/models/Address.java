/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author User
 */
public class Address {
    private int idAddress;
    private String street;
    private int number;
    private String city;
    private int zipCode;

    public Address(int id) {
        idAddress = id;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idAddress;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (this.idAddress != other.idAddress) {
            return false;
        }
        return true;
    }
    
    
}
