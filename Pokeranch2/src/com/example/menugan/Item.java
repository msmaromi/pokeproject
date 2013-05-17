/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.menugan;

/**
 *
 * @author msmaromi
 */
public class Item {
  protected int harga;
  protected String nama;
  
  public Item(int _harga, String _nama) {
    harga = _harga;
    nama = _nama;
  }
  
  public Item(Item _item) {
    harga = _item.harga;
    nama = _item.nama;
  }
  
  public int getHarga() {
    return harga;
  }
  
  public String getNama() {
    return nama;
  }
  
  public void setHarga(int newHarga) {
    harga = newHarga;
  }
  
  public void setNama(String newNama) {
    nama = newNama;
  }
  
  public void execute() {
    
  }
  
  public void execute(Monster m) {
    
  }
  
  public void execute(Player p) {
	    
  }
  
}
