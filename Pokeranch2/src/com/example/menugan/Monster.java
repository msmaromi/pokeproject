
package com.example.menugan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

import android.os.Environment;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
    private int CurrentSpeed;
    private String Status;
    private int Umur;
    public SkillMonster Skill[];
    private int noSkill=0;
    
    public Monster(){
        Nama = "xxxx";
        Level = 0;
        Exp = 0;
        Species = "xxxx";
        Elemen = "xxxx";
        HP = 0;
        MP = 0;
        Speed = 0;
        BonusUang = 0;
        BonusExp = 0;
        CurrentHP = HP;
        CurrentMP = MP;
        CurrentSpeed = Speed;
        Status = "xxxx";
        Umur = 0;
    }
    
    public Monster(String nm){
        Nama = nm;
        Level = 0;
        Exp = 0;
        Species = "xxxx";
        Elemen = "xxxx";
        HP = 0;
        MP = 0;
        Speed = 0;
        BonusUang = 0;
        BonusExp = 0;
        CurrentHP = HP;
        CurrentMP = MP;
        CurrentSpeed = Speed;
        Status = "xxxx";
        Umur = 0;
    }
    
    public Monster(String nm,int lvl,int ex,String sp,String el,int mhp,int mmp,int spd,int be,int bu,String st,int um){
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
        CurrentHP = HP;
        CurrentMP = MP;
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
    
    public void setBonusExp(int be){
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
    
    public int getCurrentSpeed(){
        return CurrentSpeed;
    }
    
    public void setCurrentSpeed(int cspd){
        CurrentSpeed = cspd;
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
        this.Exp += M.getBonusExp();
    }

    public boolean isLevelUp(){
        return (Exp > 200);
    }
    

    public void addLevel(){
        if (this.isLevelUp()) {
            Level += 1;
            if (Elemen.equals("Api")){
                HP += 15;
                MP += 7;
                Speed += 2;
            } else if (Elemen.equals("Air")){
                HP += 10;
                MP += 18;
                Speed += 4;
            } else if (Elemen.equals("Angin")){
                HP += 12;
                MP += 11;
                Speed += 6;
            } else if (Elemen.equals("Tanah")){
                HP += 18;
                 MP += 9;
                Speed += 1;
            }
            this.Exp = 0;
/*            switch (Elemen) {
                case "Api":
                    HP += 15;
                    MP += 7;
                    Speed += 2;
                    break;
                case "Air":
                    HP += 10;
                    MP += 18;
                    Speed += 4;
                    break;
                case "Angin":
                    HP += 12;
                    MP += 11;
                    Speed += 6;
                    break;
                case "Tanah":
                    HP += 18;
                    MP += 9;
                    Speed += 1;
                    break;
            }*/
        }
    }
    
    
    public boolean isSekarat(){
        return (CurrentHP < (HP/10));
    }
    public void StatusEfek(){
        if (Status.equals("Burning")){
            CurrentHP -= (HP/20);
        } else if (Status.equals("Frozen")){
            CurrentSpeed -= (Speed/10);
        }
/*        switch (Status) {
            case "Burning":
                CurrentHP -= (HP/20);
                break;
            case "Frozen":
                CurrentSpeed -= (Speed/10);
                break;
        }*/
    }
    
    public void ChangeSpecies(){
        if (this.isChangeSpecies()){
            if (Elemen.equals("Api")){
                if (Species.equals("Yi")){
                    this.Species = "Er";
                } else if (Species.equals("Er")){
                    this.Species = "San";
                } else if (Species.equals("San")){
                    this.Species = "Shi";
                } else if (Species.equals("Shi")){
                    this.Species = "Wu";
                } else if (Species.equals("Wu")){
                    this.Species = "Liu";
                }
            } else if (Elemen.equals("Air")){
                if (Species.equals("One")){
                    this.Species = "Two";
                } else if (Species.equals("Two")){
                    this.Species = "Three";
                } else if (Species.equals("Three")){
                    this.Species = "Four";
                } else if (Species.equals("Four")){
                    this.Species = "Five";
                } else if (Species.equals("Five")){
                    this.Species = "Six";
                }
            } else if (Elemen.equals("Angin")){
                if (Species.equals("Uno")){
                    this.Species = "Dos";
                } else if (Species.equals("Dos")){
                    this.Species = "Tres";
                } else if (Species.equals("Tres")){
                    this.Species = "Cuatro";
                } else if (Species.equals("Cuatro")){
                    this.Species = "Cinco";
                } else if (Species.equals("Cinco")){
                    this.Species = "Seis";
                }
            } else if (Elemen.equals("Tanah")){
                if (Species.equals("Een")){
                    this.Species = "Twee";
                } else if (Species.equals("Twee")){
                    this.Species = "Drie";
                } else if (Species.equals("Drie")){
                    this.Species = "Vier";
                } else if (Species.equals("Vier")){
                    this.Species = "Vyf";
                } else if (Species.equals("Vyf")){
                    this.Species = "Ses";
                }
            }
        }
/*        switch (Elemen) {
            case ("Api") :
                switch (Species) {
                    case ("Yi") :
                        this.Species = "Er";
                        break;
                    case ("Er") :
                        this.Species = "San";
                        break;
                    case ("San") :
                        this.Species = "Shi";
                        break;
                    case ("Shi") :
                        this.Species = "Wu";
                        break;
                    case ("Wu") :
                        this.Species = "Liu";
                        break;
                    }
                break;
             case ("Air") :
                 switch (Species) {
                     case ("One") :
                         this.Species = "Two";
                         break;
                     case ("Two") :
                         this.Species = "Three";
                         break;
                     case ("Three") : 
                         this.Species = "Four";
                         break;
                     case ("Four") :
                         this.Species = "Five";
                         break;
                     case ("Five") :
                         this.Species = "Six";
                         break;
                }
                 break;
             case ("Angin") :
                 switch (Species) {
                     case ("Uno") :
                         this.Species = "Dos";
                         break;
                     case ("Dos") :
                         this.Species = "Tres";
                         break;
                     case ("Tres") :
                         this.Species = "Cuatro";
                         break;
                     case ("Cuatro") :
                         this.Species = "Cinco";
                         break;
                     case ("Cinco") :
                         this.Species = "Seis";
                  }
                break;
             case ("Tanah") :
                 switch (Species) {
                     case ("Een") :
                         this.Species = "Twee";
                         break;
                     case ("Twee") :
                         this.Species = "Drie";
                         break;
                     case ("Drie") :
                         this.Species = "Vier";
                         break;
                     case ("Vier") :
                         this.Species = "Vyf";
                         break;
                     case ("Vyf") :
                         this.Species = "Ses";
                         break;
                 }
                 break;
        }*/
    }
    
    public void ShowStatus(){
        System.out.println("Monster "+Nama);
        System.out.println("Level : "+Level);
        System.out.println("Experience : "+Exp);
        System.out.println("Species : "+Species);
        System.out.println("Element : "+Elemen);
        System.out.println("HP : "+CurrentHP+"/"+HP);
        System.out.println("MP : "+CurrentMP+"/"+MP);
        System.out.println("Status : "+Status);
        System.out.println("Umur : "+Umur);
    }

    public void StatusBattle(){
        System.out.println();
        System.out.println(Nama);
        System.out.println("----------------");
        System.out.println("Level : "+Level);
        System.out.println("HP : "+CurrentHP+"/"+HP);
        System.out.println("MP : "+CurrentMP+"/"+MP);
        System.out.println("Status : "+Status);
        System.out.println("----------------");
    }
    
    public boolean isChangeSpecies() {
        boolean temp = false;
        if (Level > 6) {
            if (Species.equals("Yi") || Species.equals("One") || Species.equals("Uno") || Species.equals("Een"))
            temp = true;
        } else if (Level > 11) {
            if (Species.equals("Er") || Species.equals("Two") || Species.equals("Dos") || Species.equals("Twee"))
            temp = true;
        } else if (Level > 16) {
            if (Species.equals("San") || Species.equals("Three") || Species.equals("Tres") || Species.equals("Drie"))
            temp = true;
        } else if (Level > 21) {
            if (Species.equals("Shi") || Species.equals("Four") || Species.equals("Cuatro") || Species.equals("Vier"))
            temp = true;
        } else if (Level > 26) {
            if (Species.equals("Wu") || Species.equals("Five") || Species.equals("Cinco") || Species.equals("Seis"))
            temp = true;
        } 
        return temp;
    }
    
    public Monster Combine(Monster M,String nm){
        Monster temp = new Monster();
        temp.setNama(nm);
        temp.setLevel(1);
        temp.setExp(0);
        if(M.getLevel() > this.Level){
            temp.setSpecies(M.getSpecies());
            temp.setElemen(M.getElemen());
        } else {
            temp.setSpecies(this.Species);
            temp.setElemen(this.Elemen);
        }
        temp.setHP(this.HP+M.getHP());
        temp.setCurrentHP(temp.getHP());
        temp.setMP(this.MP+M.getMP());
        temp.setCurrentMP(temp.getMP());
        temp.setSpeed(this.Speed+M.getSpeed());
        temp.setUmur(0);
        return temp;
    }
    
    public void addSkill(){
        Skill = new SkillMonster[4];
        int i = 0;
        File file = new File(Environment.getExternalStorageDirectory()+"/SkillMonster.pr");         
        try {
            Scanner input = new Scanner(file);
                if (Elemen.equals("Api")){
                    String nextLine = input.nextLine();
                    String temp[] = nextLine.split(" ");
                    if (Level > 1){
                        Skill[i] = new SkillMonster();
                        Skill[i].setNamaSkill(temp[0]);
                        Skill[i].setElemenSkill(temp[1]);
                        Skill[i].setDamage(Integer.parseInt(temp[2]));
                        Skill[i].setStatus(temp[3]);
                        Skill[i].setHPCost(Integer.parseInt(temp[4]));
                        Skill[i].setMPCost(Integer.parseInt(temp[5]));
                        noSkill++;
                    }
                    i++;
                    nextLine = input.nextLine();
                    temp = nextLine.split(" ");
                    if (Level > 7){
                        Skill[i] = new SkillMonster();
                        Skill[i].setNamaSkill(temp[0]);
                        Skill[i].setElemenSkill(temp[1]);
                        Skill[i].setDamage(Integer.parseInt(temp[2]));
                        Skill[i].setStatus(temp[3]);
                        Skill[i].setHPCost(Integer.parseInt(temp[4]));
                        Skill[i].setMPCost(Integer.parseInt(temp[5]));
                        noSkill++;
                    }
                    i++;
                    nextLine = input.nextLine();
                    temp = nextLine.split(" ");
                    if (Level > 14){
                        Skill[i] = new SkillMonster();
                        Skill[i].setNamaSkill(temp[0]);
                        Skill[i].setElemenSkill(temp[1]);
                        Skill[i].setDamage(Integer.parseInt(temp[2]));
                        Skill[i].setStatus(temp[3]);
                        Skill[i].setHPCost(Integer.parseInt(temp[4]));
                        Skill[i].setMPCost(Integer.parseInt(temp[5]));
                        noSkill++;
                    }
                 } else if (Elemen.equals("Air")){
                    String nextLine = input.nextLine();
                    nextLine = input.nextLine();
                    nextLine = input.nextLine();
                    nextLine = input.nextLine();
                    String temp[] = nextLine.split(" ");
                    if (Level > 1){
                        Skill[i] = new SkillMonster();
                        Skill[i].setNamaSkill(temp[0]);
                        Skill[i].setElemenSkill(temp[1]);
                        Skill[i].setDamage(Integer.parseInt(temp[2]));
                        Skill[i].setStatus(temp[3]);
                        Skill[i].setHPCost(Integer.parseInt(temp[4]));
                        Skill[i].setMPCost(Integer.parseInt(temp[5]));
                        noSkill++;
                    }
                    i++;
                    nextLine = input.nextLine();
                    temp = nextLine.split(" ");
                    if (Level > 7){
                        Skill[i] = new SkillMonster();
                        Skill[i].setNamaSkill(temp[0]);
                        Skill[i].setElemenSkill(temp[1]);
                        Skill[i].setDamage(Integer.parseInt(temp[2]));
                        Skill[i].setStatus(temp[3]);
                        Skill[i].setHPCost(Integer.parseInt(temp[4]));
                        Skill[i].setMPCost(Integer.parseInt(temp[5]));
                        noSkill++;
                    }
                    i++;
                    nextLine = input.nextLine();
                    temp = nextLine.split(" ");
                    if (Level > 14){
                        Skill[i] = new SkillMonster();
                        Skill[i].setNamaSkill(temp[0]);
                        Skill[i].setElemenSkill(temp[1]);
                        Skill[i].setDamage(Integer.parseInt(temp[2]));
                        Skill[i].setStatus(temp[3]);
                        Skill[i].setHPCost(Integer.parseInt(temp[4]));
                        Skill[i].setMPCost(Integer.parseInt(temp[5]));
                        noSkill++;
                    }
                 } else if (Elemen.equals("Angin")){
                    String nextLine = input.nextLine();
                    nextLine = input.nextLine();
                    nextLine = input.nextLine();
                    nextLine = input.nextLine();
                    nextLine = input.nextLine();
                    nextLine = input.nextLine();
                    nextLine = input.nextLine();
                    String temp[] = nextLine.split(" ");
                    if (Level > 1){
                        Skill[i] = new SkillMonster();
                        Skill[i].setNamaSkill(temp[0]);
                        Skill[i].setElemenSkill(temp[1]);
                        Skill[i].setDamage(Integer.parseInt(temp[2]));
                        Skill[i].setStatus(temp[3]);
                        Skill[i].setHPCost(Integer.parseInt(temp[4]));
                        Skill[i].setMPCost(Integer.parseInt(temp[5]));
                        noSkill++;
                    }
                    i++;
                    nextLine = input.nextLine();
                    temp = nextLine.split(" ");
                    if (Level > 7){
                        Skill[i] = new SkillMonster();
                        Skill[i].setNamaSkill(temp[0]);
                        Skill[i].setElemenSkill(temp[1]);
                        Skill[i].setDamage(Integer.parseInt(temp[2]));
                        Skill[i].setStatus(temp[3]);
                        Skill[i].setHPCost(Integer.parseInt(temp[4]));
                        Skill[i].setMPCost(Integer.parseInt(temp[5]));
                        noSkill++;
                    }
                    i++;
                    nextLine = input.nextLine();
                    temp = nextLine.split(" ");
                    if (Level > 14){
                        Skill[i] = new SkillMonster();
                        Skill[i].setNamaSkill(temp[0]);
                        Skill[i].setElemenSkill(temp[1]);
                        Skill[i].setDamage(Integer.parseInt(temp[2]));
                        Skill[i].setStatus(temp[3]);
                        Skill[i].setHPCost(Integer.parseInt(temp[4]));
                        Skill[i].setMPCost(Integer.parseInt(temp[5]));
                        noSkill++;
                    }
                 } else if (Elemen.equals("Tanah")){
                    String nextLine = input.nextLine();
                    nextLine = input.nextLine();
                    nextLine = input.nextLine();
                    nextLine = input.nextLine();
                    nextLine = input.nextLine();
                    nextLine = input.nextLine();
                    nextLine = input.nextLine();
                    nextLine = input.nextLine();
                    nextLine = input.nextLine();
                    nextLine = input.nextLine();
                    String temp[] = nextLine.split(" ");
                    if (Level > 1){
                        Skill[i] = new SkillMonster();
                        Skill[i].setNamaSkill(temp[0]);
                        Skill[i].setElemenSkill(temp[1]);
                        Skill[i].setDamage(Integer.parseInt(temp[2]));
                        Skill[i].setStatus(temp[3]);
                        Skill[i].setHPCost(Integer.parseInt(temp[4]));
                        Skill[i].setMPCost(Integer.parseInt(temp[5]));
                        noSkill++;
                    }
                    i++;
                    nextLine = input.nextLine();
                    temp = nextLine.split(" ");
                    if (Level > 7){
                        Skill[i] = new SkillMonster();
                        Skill[i].setNamaSkill(temp[0]);
                        Skill[i].setElemenSkill(temp[1]);
                        Skill[i].setDamage(Integer.parseInt(temp[2]));
                        Skill[i].setStatus(temp[3]);
                        Skill[i].setHPCost(Integer.parseInt(temp[4]));
                        Skill[i].setMPCost(Integer.parseInt(temp[5]));
                        noSkill++;
                    }
                    i++;
                    nextLine = input.nextLine();
                    temp = nextLine.split(" ");
                    if (Level > 14){
                        Skill[i] = new SkillMonster();
                        Skill[i].setNamaSkill(temp[0]);
                        Skill[i].setElemenSkill(temp[1]);
                        Skill[i].setDamage(Integer.parseInt(temp[2]));
                        Skill[i].setStatus(temp[3]);
                        Skill[i].setHPCost(Integer.parseInt(temp[4]));
                        Skill[i].setMPCost(Integer.parseInt(temp[5]));
                        noSkill++;
                    }
                 input.close();
                 }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Monster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }
    
    public void ShowListSkill(){
        for (int i = 0; i<noSkill;i++){
            Skill[i].ShowSkillStatus();
        }
    }
    
    
    /*---------------------------ditambah jo----------------------*/
    public int getNoSkill(){
    	return noSkill;
    }
    
    public void fullRecoverHPMP(){
    	CurrentHP = HP;
    	CurrentMP = MP;
    }
    
}
