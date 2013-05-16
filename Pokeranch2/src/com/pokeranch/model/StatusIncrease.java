/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author msmaromi
 */
public class StatusIncrease extends Item {
  private int mpMaxTambah;
  private int hpMaxTambah;
  
  public StatusIncrease(int harga, String nama, int mp, int hp) {
    super(harga, nama);
    mpMaxTambah = mp;
    hpMaxTambah = hp;
  }
  
  public StatusIncrease(StatusIncrease st) {
    super(st);
    mpMaxTambah = st.mpMaxTambah;
    hpMaxTambah = st.hpMaxTambah;            
  }
  
  public int getMPmaxTambah() {
    return mpMaxTambah;
  }
  
  public int getHPmaxTambah() {
    return hpMaxTambah;
  }
  
  public void setMPmaxTambah(int mp) {
    mpMaxTambah = mp;
  }
  
  public void setHPmaxTambah(int hp) {
    hpMaxTambah = hp;
  }
  
  @Override
  public void execute(Monster m) {
    m.setHP(m.getHP()+hpMaxTambah);
    m.setMP(m.getMP()+mpMaxTambah);
  }
}
