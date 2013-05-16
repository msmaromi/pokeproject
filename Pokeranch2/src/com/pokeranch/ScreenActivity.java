package com.pokeranch;

import java.util.ArrayList;

import com.example.menugan.Item;
import com.example.menugan.Monster;
import com.pokeranch.maps.CityActivity;
import com.pokeranch.maps.CombinatoriumActivity;
import com.pokeranch.maps.HomeActivity;
import com.pokeranch.maps.NavigationButton;
import com.pokeranch.maps.StadiumActivity;
import com.pokeranch.maps.StoreActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class ScreenActivity extends Activity {
	
	private static final String TAG = ScreenActivity.class.getSimpleName();
	private DisplayMetrics metrics;
	
	private ScreenView screenView;
	private NavigationButton navigationButton;
	private FrameLayout frameLayout;
	
	protected String id;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {	
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		DrawableManager.initInstance(getApplicationContext());
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);		
		Log.d(TAG,"start game activity");
		metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		
		navigationButton = new NavigationButton(this);
		frameLayout = new FrameLayout(this);
		frameLayout.addView(screenView);
		frameLayout.addView(navigationButton);
		setContentView(frameLayout);
		
		GV.activeActivity = this;
	}
	
	@Override
	protected void onPause() {
		Log.d(TAG,"onPause()");
		screenView.thread.setRunning(false); //matiin thread
		super.onPause();			
	}
	
	protected void setId(String id) {
		this.id = id;
		screenView = new ScreenView(this, 480, 800, id);
	}
	
	public ScreenView getScreenView() {
		return screenView;
	}
	
	public void switchScreen(String id) {
		Intent i = new Intent();
		if (id == "home") {
			i = new Intent(getApplicationContext(), HomeActivity.class);
			GV.player.setPosition(6, 11);
		} else if (id == "home-start") {
			i = new Intent(getApplicationContext(), HomeActivity.class);
			GV.player.setPosition(6, 9);
		} else if (id == "store") {
			i = new Intent(getApplicationContext(), StoreActivity.class);
			GV.player.setPosition(5, 7);
		} else if (id == "combinatorium") {
			i = new Intent(getApplicationContext(), CombinatoriumActivity.class);
			GV.player.setPosition(1, 9);
		} else if (id == "stadium") {
			i = new Intent(getApplicationContext(), StadiumActivity.class);
			GV.player.setPosition(10, 10);
		} else if (id == "city-home") {
			i = new Intent(getApplicationContext(), CityActivity.class);
			GV.player.setPosition(2, 3);
		} else if (id == "city-store") {
			i = new Intent(getApplicationContext(), CityActivity.class);
			GV.player.setPosition(6, 4);
		} else if (id == "city-combinatorium") {
			i = new Intent(getApplicationContext(), CityActivity.class);
			GV.player.setPosition(3, 11);
		} else if (id == "city-stadium") {
			i = new Intent(getApplicationContext(), CityActivity.class);
			GV.player.setPosition(7, 16);
		}
		startActivity(i);
		finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
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
	}

}
