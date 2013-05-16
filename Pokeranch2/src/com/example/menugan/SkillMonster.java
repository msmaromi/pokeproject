
package com.example.menugan;
/**
 *
 * @author Rian
 */
public class SkillMonster {
    private String NamaSkill;
    private String ElemenSkill;
    private int Damage;
    private String Status;
    private int HPCost;
    private int MPCost;
    
    public SkillMonster(){
        NamaSkill = "xxxx";
        ElemenSkill = "xxxx";
        Damage = 0;
        Status = "xxxx";
        HPCost = 0;
        MPCost = 0;
    }
    
    public SkillMonster(String nm, String el,int dmg,String st,int hpc,int mpc){
        NamaSkill = nm;
        ElemenSkill = el;
        Damage = dmg;
        Status = st;
        HPCost = hpc;
        MPCost = mpc;
    }
    
    public String getNamaSkill(){
        return NamaSkill;
    }
    
    public void setNamaSkill(String ns){
        NamaSkill = ns;
    }
    
    public String getElemenSkill(){
        return ElemenSkill;
    }
    
    public void setElemenSkill(String es){
        ElemenSkill = es;
    }
    
    public int getDamage(){
        return Damage;
    }
    
    public void setDamage(int dmg){
        Damage = dmg;
    }
    
    public String getStatus(){
        return Status;
    }
    
    public void setStatus(String st){
        Status = st;
    }
    
    public int getHPCost(){
        return HPCost;
    }
    
    public void setHPCost(int hpc){
        HPCost = hpc;
    }
    
    public int getMPCost(){
        return MPCost;
    }
    
    public void setMPCost(int mpc){
        MPCost = mpc;
    }

//    public void CastSkill(Monster M){
//        switch (ElemenSkill) {
//            case "Fire":
//                switch (M.getElemen()) {
//                    case "Fire":
//                        M.setCurrentHP(M.getCurrentHP()-(Damage/2));
//                        break;
//                    case "Water":
//                        M.setCurrentHP(M.getCurrentHP()-(Damage/2));
//                        break;
//                    case "Earth":
//                        M.setCurrentHP(M.getCurrentHP()-(Damage*3/2));
//                        break;
//                }
//            case "Water":
//                switch (M.getElemen()) {
//                    case "Water":
//                        M.setCurrentHP(M.getCurrentHP()-(Damage/2));
//                        break;
//                    case "Wind":
//                        M.setCurrentHP(M.getCurrentHP()-(Damage/2));
//                        break;
//                    case "Fire":
//                        M.setCurrentHP(M.getCurrentHP()-(Damage*3/2));
//                        break;
//                }
//            case "Wind":
//                switch (M.getElemen()) {
//                    case "Wind":
//                        M.setCurrentHP(M.getCurrentHP()-(Damage/2));
//                        break;
//                    case "Earth":
//                        M.setCurrentHP(M.getCurrentHP()-(Damage/2));
//                        break;
//                    case "Water":
//                        M.setCurrentHP(M.getCurrentHP()-(Damage*3/2));
//                        break;
//                }
//            case "Earth":
//                switch (M.getElemen()) {
//                    case "Earth":
//                        M.setCurrentHP(M.getCurrentHP()-(Damage/2));
//                        break;
//                    case "Fire":
//                        M.setCurrentHP(M.getCurrentHP()-(Damage/2));
//                        break;
//                    case "Wind":
//                        M.setCurrentHP(M.getCurrentHP()-(Damage*3/2));
//                        break;
//                }
//            default:
//                M.setCurrentHP(M.getCurrentHP()-Damage);
//                break;
//        }
//        M.setStatus(this.Status);
//    }

    public void ShowSkillStatus(){
        System.out.println("Nama Skill : "+NamaSkill);
        System.out.println("Elemen : "+ElemenSkill);
        System.out.println("Damage : "+Damage);
        System.out.println("Efek : "+Status);
        System.out.println("MPCost : "+MPCost);
        System.out.println("HPCost : "+HPCost);
    }
}
