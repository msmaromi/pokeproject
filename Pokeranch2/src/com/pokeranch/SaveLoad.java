package com.pokeranch;
//package com.example.pokeranch;
//
//import java.sql.Date;
//import java.util.ArrayList;
//import java.util.List;
//
//import android.os.Bundle;
//import android.app.Activity;
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.util.Log;
//import android.view.Menu;
//import android.view.MenuItem;
//
//public class SaveLoad extends Activity {
//	private static Context context;
//	private DatabaseHandler dbHandler;
//	private Player currentPlayer;
//	private LoadPlayerDialogFragment loadPlayer;
//	public static CharSequence[] playersChoose;
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_save_load);
//		SaveLoad.context = getApplicationContext();
//		
//		dbHandler = DatabaseHandler.getInstance(getContext());
//				
//		currentPlayer = new Player("sohibul");
//		Monster monster1 = new Monster("pikacu", 0, 0, "pokemon", "listrik", 100, 100, 10, 10, 10, 5, 5, "capek", 1);
//		Monster monster2 = new Monster("piacu", 0, 0, "pokemon", "listrik", 100, 100, 10, 10, 10, 5, 5, "capek", 1);
//		Item item1 = new Item(100, "potion");
//		Item item2 = new Item(200, "monsterball");
////		currentPlayer.addMonster(monster1);
//		currentPlayer.addMonster(monster2);
////		currentPlayer.addItem(item1);
//		currentPlayer.addItem(item2);		
////        currentPlayer.setUang(10);
////        dbHandler.updatePlayer("3", currentPlayer);
////        dbHandler.deletePlayer("3");
////        dbHandler.addPlayer(currentPlayer);
////        Player p = dbHandler.getPlayer("6");
////        Log.d("debug", p.getNama());
//        
//        
//        
////        ArrayList<Monster> monsters = dbHandler.getListMonsterByPlayer("sohibul");
////        for(int i=0; i<monsters.size(); i++) {
////        	Log.d("debug", monsters.get(i).getNama());
////        }
////		Log.d("debug", dbHandler.getIDbyName(DatabaseHandler.TABLE_MONSTERS, "piacu"));		
//	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.activity_save_load, menu);
//		return true;
//	}
//	
//	public boolean onOptionsItemSelected(MenuItem item) {
//		switch(item.getItemId()) {
//			case R.id.menu_save:
//				save();
//				return true;
//			case R.id.menu_load:				
//				/*ArrayList<Player> players = dbHandler.getAllPlayer();
//				for(int i=0; i<players.size(); i++) {
//					playersChoose[i] = players.get(i).getNama();
//				}
//				loadPlayer = new LoadPlayerDialogFragment();*/
//				load("sohibul");
//				return true;
//			default:
//				return super.onOptionsItemSelected(item);
//		}
//	}	
//	
//	public static Context getContext() {
//		return SaveLoad.context;
//	}
//	
//	public void save() {
//		if(dbHandler.isPlayerExists(currentPlayer.getNama())) {
//			/*
//			 * save player
//			 */
//			dbHandler.updatePlayer(dbHandler.getIDbyName(DatabaseHandler.TABLE_PLAYERS, currentPlayer.getNama()), currentPlayer);
//			/*
//			 * save monster
//			 */
//			ArrayList<Monster> listMonsterLast = dbHandler.getListMonsterByPlayer(currentPlayer.getNama());
//			ArrayList<Monster> listMonsterCurrent = currentPlayer.getListMonster();
//			here: for(int i=0; i<listMonsterLast.size(); i++) {
//				Log.d("monsterlast", String.valueOf(listMonsterLast.size()));
//				Log.d("masuk for", String.valueOf(i));
//				Monster monsterLast = listMonsterLast.get(i);
//				for(int j=0; j<listMonsterCurrent.size(); j++) {
//					Monster monsterCurrent = listMonsterCurrent.get(j);
//					if(monsterCurrent.getNama().compareTo(monsterLast.getNama()) == 0) { 
//						dbHandler.updateMonster(dbHandler.getIDbyName(DatabaseHandler.TABLE_MONSTERS, monsterCurrent.getNama()), monsterCurrent);
//						Log.d("update", monsterCurrent.getNama());
//						continue here;
//					} else {
//						if(j==listMonsterCurrent.size()-1) {
//							dbHandler.deleteMonster(dbHandler.getIDbyName(DatabaseHandler.TABLE_MONSTERS, monsterLast.getNama()));
//							Log.d("delete", monsterLast.getNama());
//						}						
//					}																
//				}
//			}
//									
//			here: for(int i=0; i<listMonsterCurrent.size(); i++) {
//				Log.d("monster current", String.valueOf(listMonsterCurrent.size()));
//				Log.d("masuk for", String.valueOf(i));
//				Monster monsterCurrent = listMonsterCurrent.get(i);
//				for(int j=0; j<listMonsterLast.size(); j++) {
//					Monster monsterLast = listMonsterLast.get(j);
//					if(monsterCurrent.getNama().compareTo(monsterLast.getNama()) == 0) 
//						continue here;
//					else {
//						if(j==listMonsterLast.size()-1) {
//							dbHandler.addMonster(currentPlayer, monsterCurrent);
//							Log.d("add", monsterCurrent.getNama());	
//						}
//					}																										
//				}
//			}		
//			
//			/*
//			 * save item
//			 */
//			ArrayList<Item> listItemLast = dbHandler.getListItemByPlayer(currentPlayer.getNama());
//			ArrayList<Item> listItemCurrent = currentPlayer.getListItem();
//			here: for(int i=0; i<listItemLast.size(); i++) {
////				Log.d("debug", String.valueOf(listItemLast.size()));
//				Item itemLast = listItemLast.get(i);
////				Log.d("masuk for", String.valueOf(i));
//				for(int j=0; j<listItemCurrent.size(); j++) {					
//					Item itemCurrent = listItemCurrent.get(j);
//					if(itemCurrent.getNama().compareTo(itemLast.getNama()) == 0) { 
//						dbHandler.updateItem(dbHandler.getIDbyName(DatabaseHandler.TABLE_ITEMS, itemCurrent.getNama()), itemCurrent);
//						Log.d("update", itemCurrent.getNama());	
//						continue here;
//					} else {
//						if(j==listItemCurrent.size()-1) {
//							dbHandler.deleteItem(dbHandler.getIDbyName(DatabaseHandler.TABLE_ITEMS, itemLast.getNama()));
//							Log.d("delete", itemLast.getNama());
//						}						
//					}															
//				}
//			}
//									
//			here: for(int i=0; i<listItemCurrent.size(); i++) {
//				Item itemCurrent = listItemCurrent.get(i);
//				for(int j=0; j<listItemLast.size(); j++) {
//					Item itemLast = listItemLast.get(j);
//					if(itemCurrent.getNama().compareTo(itemLast.getNama()) == 0) {
//						continue here;
//					} else {
//						if(j==listItemLast.size()-1) {
//							dbHandler.addItem(currentPlayer, itemCurrent);
//							Log.d("add", itemCurrent.getNama());
//						}						
//					}															
//				}
//			}
//		} else {
//			dbHandler.addPlayer(currentPlayer);			
//			for(int i=0; i<currentPlayer.getListMonster().size(); i++) {
//				dbHandler.addMonster(currentPlayer, currentPlayer.getListMonster().get(i));
//			}	
//			for(int i=0; i<currentPlayer.getListItem().size(); i++) {
//				dbHandler.addItem(currentPlayer, currentPlayer.getListItem().get(i));
//			}
//		}
//	}
//	
//	public void load(String playerName) {
//		Log.d("debug", "masuk load");
//		currentPlayer = dbHandler.getPlayer(dbHandler.getIDbyName(DatabaseHandler.TABLE_PLAYERS, playerName));
//	}
//	
//}
