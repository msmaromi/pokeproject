/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.menugan;

/**
 *
 * @author msmaromi
 */
public class Potion extends Item {
  private int mpTambah;
  private int hpTambah;
  
  public Potion(int harga, String nama, int mp, int hp) {
    super(harga, nama);
    mpTambah = mp;
    hpTambah = hp;
  }
  
  public Potion(){
	  super(100,"Potion");
	  mpTambah = 100;
	  hpTambah = 100;
  }
  
  public Potion(Potion p) {
    super(p.harga, p.nama);
    mpTambah = p.mpTambah;
    hpTambah = p.hpTambah;
  }
  
  public int getMPTambah() {
    return mpTambah;
  }
  
  public int getHPTambah() {
    return hpTambah;    
  }
  
  public void setMPTambah(int mp) {
    mpTambah = mp;
  }
  
  public void setHPTambah(int hp) {
    hpTambah = hp;
  }
  
  @Override
  public void execute(Monster m) {
//    m.setCurrentHP(m.getCurrentHP()+hpTambah);
//    m.setCurrentMP(m.getCurrentMP()+mpTambah);
    
  }
  
}
