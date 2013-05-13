package com.pokeranch.model;

/**
 *
 * @author Rian
 */
public class Monster {
    private String Nama;
    private int Level;
    private int Exp;
    private String Species;
    private String Elemen;
    private int HP;
    private int MP;
    private int Speed;
    private int BonusUang;
    private int BonusExp;
    private int CurrentHP;
    private int CurrentMP;
    private String Status;
    private int Umur;
    
    public Monster(String nm) {
        Nama = nm;
        Level = 0;
        Exp = 0;
        Species = "default";
        Elemen = "default";
        HP = 10;
        MP = 10;
        Speed = 5;
        BonusUang = 0;
        BonusExp = 0;
        CurrentHP = 10;
        CurrentMP = 10;
        Status = "active";
        Umur = 0;
    }
    
    public Monster(String nm,int lvl,int ex,String sp,String el,int mhp,int mmp,int spd,int bu,int be,int chp,int cmp,String st,int um){
        Nama = nm;
        Level = lvl;
        Exp = ex;
        Species = sp;
        Elemen = el;
        HP = mhp;
        MP = mmp;
        Speed = spd;
        BonusUang = bu;
        BonusExp = be;
        CurrentHP = chp;
        CurrentMP = cmp;
        Status = st;
        Umur = um;
    }
    
    public String getNama(){
        return Nama;
    }
    
    public void setNama(String nm){
        Nama = nm;
    }
    
    public int getLevel(){
        return Level;
    }
    
    public void setLevel(int lvl){
        Level = lvl;
    }
    
    public int getExp(){
        return Exp;
    }
    
    public void setExp(int ex){
        Exp = ex;
    }
    
    public String getSpecies(){
        return Species;
    }
    
    public void setSpecies(String sp){
        Species = sp;
    }
    
    public String getElemen(){
        return Elemen;
    }
    
    public void setElemen(String el){
        Elemen = el;
    }
    
    public int getHP(){
        return HP;
    }
    
    public void setHP(int mhp){
        HP = mhp;
    }
    
    public int getMP(){
        return MP;
    }
    
    public void setMP(int mmp){
        MP = mmp;
    }
    
    public int getSpeed(){
        return Speed;
    }
    
    public void setSpeed(int spd){
        Speed = spd;
    }
    
    public int getBonusUang(){
        return BonusUang;
    }
    
    public void setBonusUang(int bu){
        BonusUang = bu;
    }
    
    public int getBonusExp(){
        return BonusExp;
    }
    
    public void setBonusExp(int be) {
    	BonusExp = be;
    }
    
    public int getCurrentHP(){
        return CurrentHP;
    }
    
    public void setCurrentHP(int chp){
        CurrentHP = chp;
    }
    
    public int getCurrentMP(){
        return CurrentMP;
    }
    
    public void setCurrentMP(int cmp){
        CurrentMP = cmp;
    }       
    
    public String getStatus(){
        return Status;
    }
    
    public void setStatus(String st){
        Status = st;
    }
    
    public int getUmur(){
        return Umur;
    }
    
    public void setUmur(int um){
        Umur = um;
    }
    
    public void addExperience(Monster M){
        Exp += M.getExp();
    }
    
    public void addLevel(){
        Level += 1;
    }
    
    public boolean isSekarat(){
        return (CurrentHP < (HP/10));
    }
    
    public void StatusEfek(){
        
    }
    
    public void ChangeSpecies(){
        
    }
    
    public void ShowStatus(){
        System.out.println("Monster "+getNama()+" :\n");
        System.out.println("Level : "+getLevel()+"\n");
        System.out.println("Experience : "+getExp()+"\n");
        System.out.println("Species : "+getSpecies()+"\n");
        System.out.println("Element : "+getElemen()+"\n");
        System.out.println("HP : "+getCurrentHP()+"/"+getHP()+"\n");
        System.out.println("MP : "+getCurrentMP()+"/"+getMP()+"\n");
        System.out.println("Status : "+getStatus());
        System.out.println("Umur : "+getUmur());
    }
}
