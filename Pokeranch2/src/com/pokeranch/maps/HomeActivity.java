package com.pokeranch.maps;

import java.util.ArrayList;

import com.example.menugan.Item;
import com.example.menugan.MenuCoy;
import com.example.menugan.Monster;
import com.example.menugan.Player;
import com.example.menuhome.MenuHomeActivity;
import com.pokeranch.DatabaseHandler;
import com.pokeranch.GV;
import com.pokeranch.R;
import com.pokeranch.ScreenActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class HomeActivity extends ScreenActivity {
	
	private static Bundle extras;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		if(extras == null) {
		extras = getIntent().getExtras();
		
		if(extras.getString("statusSwitch").equals("load")) {
			GV.player = GV.dbHandler.getPlayer(GV.dbHandler.getIDbyName(DatabaseHandler.TABLE_PLAYERS, extras.getString("loadPlayerName")));

		} else if(extras.getString("statusSwitch").equals("new")) {
			Log.d("d", extras.getString("newPlayerName"));
			GV.player.setNama(extras.getString("newPlayerName"));
			GV.player.setPosition(6, 9);
			Log.d("d", GV.player.getNama());
			// player.setCurX(2);
		}
		}
		setId("home");
		super.onCreate(savedInstanceState);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tombol_menu_home, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {	
				
			case R.id.menu_utama_gan:
				Intent i2 = new Intent(getApplicationContext(),MenuCoy.class);
				i2.putExtra("posisiSebelum", "home");
				startActivity(i2);
				return true;
				
			case R.id.menu_save:
				save();
				return true;
				
			default:
				return super.onOptionsItemSelected(item);
		}
	}

	public void save() {
		Log.d("debug gan", GV.player.getNama());
		if(GV.dbHandler.isPlayerExists(GV.player.getNama())) {
			/*
			 * save player
			 */
			GV.dbHandler.updatePlayer(GV.dbHandler.getIDbyName(DatabaseHandler.TABLE_PLAYERS, GV.player.getNama()), GV.player);
			/*
			 * save monster
			 */
			ArrayList<Monster> listMonsterLast = GV.dbHandler.getListMonsterByPlayer(GV.player.getNama());
			ArrayList<Monster> listMonsterCurrent = GV.player.listMonster;
			here: for(int i=0; i<listMonsterLast.size(); i++) {
				Log.d("monsterlast", String.valueOf(listMonsterLast.size()));
				Log.d("masuk for", String.valueOf(i));
				Monster monsterLast = listMonsterLast.get(i);
				for(int j=0; j<listMonsterCurrent.size(); j++) {
					Monster monsterCurrent = listMonsterCurrent.get(j);
					if(monsterCurrent.getNama().compareTo(monsterLast.getNama()) == 0) { 
						GV.dbHandler.updateMonster(GV.dbHandler.getIDbyName(DatabaseHandler.TABLE_MONSTERS, monsterCurrent.getNama()), monsterCurrent);
						Log.d("update", monsterCurrent.getNama());
						continue here;
					} else {
						if(j==listMonsterCurrent.size()-1) {
							GV.dbHandler.deleteMonster(GV.dbHandler.getIDbyName(DatabaseHandler.TABLE_MONSTERS, monsterLast.getNama()));
							Log.d("delete", monsterLast.getNama());
						}						
					}																
				}
			}
									
			here: for(int i=0; i<listMonsterCurrent.size(); i++) {
				Log.d("monster current", String.valueOf(listMonsterCurrent.size()));
				Log.d("masuk for", String.valueOf(i));
				Monster monsterCurrent = listMonsterCurrent.get(i);
				for(int j=0; j<listMonsterLast.size(); j++) {
					Monster monsterLast = listMonsterLast.get(j);
					if(monsterCurrent.getNama().compareTo(monsterLast.getNama()) == 0) 
						continue here;
					else {
						if(j==listMonsterLast.size()-1) {
							GV.dbHandler.addMonster(GV.player, monsterCurrent);
							Log.d("add", monsterCurrent.getNama());	
						}
					}																										
				}
			}		
			
			/*
			 * save item
			 */
			ArrayList<Item> listItemLast = GV.dbHandler.getListItemByPlayer(GV.player.getNama());
			ArrayList<Item> listItemCurrent = GV.player.listItem;
			here: for(int i=0; i<listItemLast.size(); i++) {
//				Log.d("debug", String.valueOf(listItemLast.size()));
				Item itemLast = listItemLast.get(i);
//				Log.d("masuk for", String.valueOf(i));
				for(int j=0; j<listItemCurrent.size(); j++) {					
					Item itemCurrent = listItemCurrent.get(j);
					if(itemCurrent.getNama().compareTo(itemLast.getNama()) == 0) { 
						GV.dbHandler.updateItem(GV.dbHandler.getIDbyName(DatabaseHandler.TABLE_ITEMS, itemCurrent.getNama()), itemCurrent);
						Log.d("update", itemCurrent.getNama());	
						continue here;
					} else {
						if(j==listItemCurrent.size()-1) {
							GV.dbHandler.deleteItem(GV.dbHandler.getIDbyName(DatabaseHandler.TABLE_ITEMS, itemLast.getNama()));
							Log.d("delete", itemLast.getNama());
						}						
					}															
				}
			}
									
			here: for(int i=0; i<listItemCurrent.size(); i++) {
				Item itemCurrent = listItemCurrent.get(i);
				for(int j=0; j<listItemLast.size(); j++) {
					Item itemLast = listItemLast.get(j);
					if(itemCurrent.getNama().compareTo(itemLast.getNama()) == 0) {
						continue here;
					} else {
						if(j==listItemLast.size()-1) {
							GV.dbHandler.addItem(GV.player, itemCurrent);
							Log.d("add", itemCurrent.getNama());
						}						
					}															
				}
			}
		} else {
			GV.dbHandler.addPlayer(GV.player);			
			for(int i=0; i<GV.player.listMonster.size(); i++) {
				GV.dbHandler.addMonster(GV.player, GV.player.listMonster.get(i));
			}	
			for(int i=0; i<GV.player.listItem.size(); i++) {
				GV.dbHandler.addItem(GV.player, GV.player.listItem.get(i));
			}
		}
	}//end save
	
}//end class
