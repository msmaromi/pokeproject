package com.example.menucombinatorium;

import com.example.drivermenu.DriverActivity;
import com.example.menugan.Monster;
import com.example.menugan.Player;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuCombinatorium extends ListActivity {

	Player playerDiMenu;
	String[] stringMenu = new String[]{"Combine","Back"};
	String[] combineMonster;
	public Monster Monster1;
	public Monster Monster2;
	public Monster MonsterGabungan;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_menu_combinatorium);
		// Show the Up button in the action bar.
//		getActionBar().setDisplayHomeAsUpEnabled(true);
//		playerDiMenu = new Player();
		playerDiMenu = DriverActivity.playerDriver;
		
//		Monster m1 = new Monster("monster 1");
//	    Monster m2 = new Monster("monster 2");
//	    Monster m3 = new Monster("monster 3");
//	    Monster m4 = new Monster("monster 4");
//	    	    
//	    playerDiMenu.addMonster(m1);
//	    playerDiMenu.addMonster(m2);
//	    playerDiMenu.addMonster(m3);
//	    playerDiMenu.addMonster(m4);
//	    playerDiMenu.addMonster(m1);
	    
		combineMonster = new String[playerDiMenu.listMonster.size()+1];		
		for (int i=0; i<playerDiMenu.listMonster.size();i++){
			combineMonster[i]=playerDiMenu.listMonster.get(i).getNama();
		}
		combineMonster[playerDiMenu.listMonster.size()]="Back";
		this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,stringMenu));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id){
		super.onListItemClick(l, v, position, id);
		Object o = this.getListAdapter().getItem(position);
		String pilihan = o.toString();
		
		
		if(pilihan.equals("Combine")){
			this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,combineMonster));
		}
		else if(pilihan.equals("Back")){
			this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,stringMenu));
			Monster1=null;
			Monster2=null;
		}
		else {
			for(int j=0;j<playerDiMenu.listMonster.size();j++){				
				if(pilihan.equals(playerDiMenu.listMonster.get(j).getNama())){
					
					if(Monster1 == null && playerDiMenu.listMonster.size()==1){
						
					}
					else if(Monster1 == null){
						Monster1 = playerDiMenu.listMonster.get(j);
						playerDiMenu.delMonster(Monster1);
					}else{
						Monster2 = playerDiMenu.listMonster.get(j);
						MonsterGabungan = Monster1.Combine(Monster2, Monster1.getNama()+Monster2.getNama());						
						playerDiMenu.delMonster(Monster2);
						playerDiMenu.addMonster(MonsterGabungan);
						DriverActivity.playerDriver=playerDiMenu;
						Monster1=null;
						Monster2=null;
					}
					
//					String s1 = "Monster "+playerDiMenu.listMonster.get(j).getNama()+" dipilih";
//					String[] s2 = new String[]{s1,"Back"};		
					combineMonster = new String[playerDiMenu.listMonster.size()+1];		
					for (int i=0; i<playerDiMenu.listMonster.size();i++){
						combineMonster[i]=playerDiMenu.listMonster.get(i).getNama();
					}
					combineMonster[playerDiMenu.listMonster.size()]="Back";
					
					this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,combineMonster));
				}
			}//end for
		}
		
	}
	

}
