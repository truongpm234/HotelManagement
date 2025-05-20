/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author phamm
 */
public class Hotel {
    private int Available;
    private int Rating;
    private String Phone;
    private String Id;
    private String Name;
    private String Address;
    
    public Hotel(String Id, String Name, int Available, String Address, String Phone, int Rating ){
        this.Id = Id;
        this.Name = Name;
        this.Available = Available;
        this.Address = Address;
        this.Phone = Phone;
        this.Rating = Rating;
    }
    public void setId(String Id){
        this.Id = Id;
    }
    public void setAvailable(int Available){
        this.Available = Available;
    }
    public void setPhone(String Phone){
        this.Phone = Phone;
    }
    public void setRating(int Rating){
        this.Rating = Rating;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public void setAddress(String Address){
        this.Address = Address;
    }
    public String getId(){
        return Id;
    } 
    public int getAvailable(){
        return Available;
    }
    public String getPhone(){
        return Phone;
    }
    public int getRating(){
        return Rating;
    }
    public String getName(){
        return Name;
    }
    public String getAddress(){
        return Address;
    }
    
    @Override
    public String toString(){
        return  Id + "\t" + Name + "\t" + Available + "\t" + Address + "\t" + Phone + "\t" + Rating;  
    }
}
