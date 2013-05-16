package com.pokeranch;

import java.util.ArrayList;

import com.pokeranch.R;
import com.pokeranch.model.Item;
import com.pokeranch.model.Monster;
import com.pokeranch.model.Player;

import android.app.Activity;
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
	
	private Player player;
	private DatabaseHandler dbHandler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		DrawableManager.initInstance(getApplicationContext());
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);		
		Log.d(TAG,"start game activity");
		metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		Bundle extras = getIntent().getExtras();
		dbHandler = Cover.dbHandler;
		
		if(extras.getString("statusSwitch").equals("load")) {				
			player = dbHandler.getPlayer(dbHandler.getIDbyName(DatabaseHandler.TABLE_PLAYERS, extras.getString("loadPlayerName")));
			
		} else if(extras.getString("statusSwitch").equals("new")) {
			player = new Player(extras.getString("newPlayerName"));
//			player.setCurX(2);
		}
		
		Log.d("cek nama player", player.getNama());
		
		setMap(new CityScreenView(this, metrics.widthPixels, metrics.heightPixels, player));
	}
	
	@Override
	protected void onPause() {
		Log.d(TAG,"onPause()");
		screenView.thread.setRunning(false); //matiin thread
		super.onPause();			
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setMap(ScreenView map) {
		if (frameLayout == null) {
			screenView = map;
			player.setScreen(screenView);
			navigationButton = new NavigationButton(this, player);
			frameLayout = new FrameLayout(this);
			frameLayout.addView(screenView);
			frameLayout.addView(navigationButton);
			setContentView(frameLayout);
		} else {
			frameLayout.removeAllViews();
			screenView = map;
			player.setScreen(screenView);
			frameLayout.addView(screenView);
			frameLayout.addView(navigationButton);
		}
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
		if(dbHandler.isPlayerExists(player.getNama())) {
			/*
			 * save player
			 */
			dbHandler.updatePlayer(dbHandler.getIDbyName(DatabaseHandler.TABLE_PLAYERS, player.getNama()), player);
			/*
			 * save monster
			 */
			ArrayList<Monster> listMonsterLast = dbHandler.getListMonsterByPlayer(player.getNama());
			ArrayList<Monster> listMonsterCurrent = player.getListMonster();
			here: for(int i=0; i<listMonsterLast.size(); i++) {
				Log.d("monsterlast", String.valueOf(listMonsterLast.size()));
				Log.d("masuk for", String.valueOf(i));
				Monster monsterLast = listMonsterLast.get(i);
				for(int j=0; j<listMonsterCurrent.size(); j++) {
					Monster monsterCurrent = listMonsterCurrent.get(j);
					if(monsterCurrent.getNama().compareTo(monsterLast.getNama()) == 0) { 
						dbHandler.updateMonster(dbHandler.getIDbyName(DatabaseHandler.TABLE_MONSTERS, monsterCurrent.getNama()), monsterCurrent);
						Log.d("update", monsterCurrent.getNama());
						continue here;
					} else {
						if(j==listMonsterCurrent.size()-1) {
							dbHandler.deleteMonster(dbHandler.getIDbyName(DatabaseHandler.TABLE_MONSTERS, monsterLast.getNama()));
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
							dbHandler.addMonster(player, monsterCurrent);
							Log.d("add", monsterCurrent.getNama());	
						}
					}																										
				}
			}		
			
			/*
			 * save item
			 */
			ArrayList<Item> listItemLast = dbHandler.getListItemByPlayer(player.getNama());
			ArrayList<Item> listItemCurrent = player.getListItem();
			here: for(int i=0; i<listItemLast.size(); i++) {
//				Log.d("debug", String.valueOf(listItemLast.size()));
				Item itemLast = listItemLast.get(i);
//				Log.d("masuk for", String.valueOf(i));
				for(int j=0; j<listItemCurrent.size(); j++) {					
					Item itemCurrent = listItemCurrent.get(j);
					if(itemCurrent.getNama().compareTo(itemLast.getNama()) == 0) { 
						dbHandler.updateItem(dbHandler.getIDbyName(DatabaseHandler.TABLE_ITEMS, itemCurrent.getNama()), itemCurrent);
						Log.d("update", itemCurrent.getNama());	
						continue here;
					} else {
						if(j==listItemCurrent.size()-1) {
							dbHandler.deleteItem(dbHandler.getIDbyName(DatabaseHandler.TABLE_ITEMS, itemLast.getNama()));
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
							dbHandler.addItem(player, itemCurrent);
							Log.d("add", itemCurrent.getNama());
						}						
					}															
				}
			}
		} else {
			dbHandler.addPlayer(player);			
			for(int i=0; i<player.getListMonster().size(); i++) {
				dbHandler.addMonster(player, player.getListMonster().get(i));
			}	
			for(int i=0; i<player.getListItem().size(); i++) {
				dbHandler.addItem(player, player.getListItem().get(i));
			}
		}
	}
		
}
