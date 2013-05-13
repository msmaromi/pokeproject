package com.pokeranch;

import java.util.ArrayList;

import com.pokeranch.model.*;

import com.pokeranch.model.Player;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Cover extends Activity {	
	private OnClickListener clickListener;
	public static DatabaseHandler dbHandler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cover);
		dbHandler = DatabaseHandler.getInstance(getApplicationContext());
		Player player = new Player("ancas");
//		Monster monster1 = new Monster("pikacu", 0, 0, "pokemon", "listrik", 100, 100, 10, 10, 10, 5, 5, "capek", 1);
//		Monster monster2 = new Monster("piacu", 0, 0, "pokemon", "listrik", 100, 100, 10, 10, 10, 5, 5, "capek", 1);
//		Item item1 = new Item(100, "potion");
//		Item item2 = new Item(200, "monsterball");
//		
//		dbHandler.addMonster(player, monster2);		

//		dbHandler.addPlayer(new Player("asem"));
//		dbHandler.addPlayer(new Player("tahas"));
//		dbHandler.addPlayer(new Player("yoooi"));
//		dbHandler.addPlayer(new Player("ceeek"));
//		ArrayList<Player> players = dbHandler.getAllPlayer();
//		Log.d("debug",String.valueOf(players.size()));
//		Log.d("database", dbHandler.getPlayer("1").getNama());
		
		Button buttonLoad = (Button) findViewById(R.id.button_load);
		buttonLoad.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				loadClick(v);
			}
		});
		
		Button buttonNew = (Button) findViewById(R.id.button_new_game);
		buttonNew.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				newClick(v);
			}
		});
		
				
	}		
		
	public void loadClick(View v) {
		setContentView(R.layout.activity_choose_player);		
		LinearLayout layoutButtonPlayer = (LinearLayout) findViewById(R.id.layout_button_player);
		layoutButtonPlayer.setOrientation(LinearLayout.VERTICAL);
		DatabaseHandler dbHandler = DatabaseHandler.getInstance(getApplicationContext());				
		final ArrayList<Player> players = dbHandler.getAllPlayer();
		clickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub				
				int id = ((Button) v).getId();
				load(players.get(id).getNama());
			}
		};		
		for(int i=0; i<players.size(); i++) {
			Button button = new Button(this);
			button.setText(players.get(i).getNama().toUpperCase());	
			button.setId(i);
			button.setOnClickListener(clickListener);
			layoutButtonPlayer.addView(button);			
		}	
	}
	
	public void newClick(View v) {
		setContentView(R.layout.activity_create_player);
		Button buttonOk = (Button) findViewById(R.id.buttonOk);
		final EditText newPlayerTextField = (EditText) findViewById(R.id.editText1);
		buttonOk.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name = newPlayerTextField.getText().toString();
				Intent newIntent = new Intent(getApplicationContext(), ScreenActivity.class);
				newIntent.putExtra("statusSwitch", "new");
				newIntent.putExtra("newPlayerName", name);
				startActivity(newIntent);
			}
		});
					
	}
	
	public void load(String playerName) {
		Player player = dbHandler.getPlayer(dbHandler.getIDbyName(DatabaseHandler.TABLE_PLAYERS, playerName));
		Intent newIntent = new Intent(getApplicationContext(), ScreenActivity.class);
		newIntent.putExtra("statusSwitch", "load");
		newIntent.putExtra("playerName", player.getNama());
		startActivity(newIntent);
	}
}
