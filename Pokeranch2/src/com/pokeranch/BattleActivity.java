package com.pokeranch;
//package com.hottest.pokeranch;
//
//import java.util.ArrayList;
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.view.Gravity;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.View;
//import android.view.ViewGroup.LayoutParams;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.LinearLayout;
//import android.widget.ListView;
//import android.widget.RelativeLayout;
//import android.widget.ScrollView;
//import android.widget.TextView;
//
//public class BattleActivity extends Activity {
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.battle_general);
//	}
//	
//	public void showBattleMenu(View v) {
////		setContentView(R.layout.battle_daftar_menu);
//		RelativeLayout menuLayout = (RelativeLayout) findViewById(R.id.option_menu);
//		menuLayout.removeAllViews();
//		
//		LayoutInflater inflater = getLayoutInflater();
//		menuLayout.addView(inflater.inflate(R.layout.battle_daftar_menu, null));
//	}
//	
//	public void doEscape(View v) {
//		setContentView(R.layout.escape_submitted);
//	}
//	
//	public void showAllMonster(View v) {
////		menghilangkan daftar menu
//		RelativeLayout menuLayout = (RelativeLayout) findViewById(R.id.option_menu);
//		menuLayout.removeAllViews();
//	}
//	
//	public void showMonsterSkill(View v) {
//		//menghilangkan daftar menu
//		RelativeLayout menuLayout = (RelativeLayout) findViewById(R.id.option_menu);
//		menuLayout.removeAllViews();
//		
//		ArrayList<String> skillList = new ArrayList<String>();
//		skillList.add("Bunuh");
//		skillList.add("Cium");
//		skillList.add("Bacok");
//		skillList.add("Tiup");
//		skillList.add("Tiup");
//		skillList.add("Tiup");
//		skillList.add("Tiup");
//		skillList.add("Tiup");
//		skillList.add("Tiup");
//		skillList.add("Tiup");
//		skillList.add("Tiup");
//		skillList.add("Tiup");
//		skillList.add("Tiup");
//		skillList.add("Tiup");
//		
//		ScrollView skillView = new ScrollView(this);
//		LinearLayout skillLayout = new LinearLayout(this);
//		skillLayout.setOrientation(LinearLayout.VERTICAL);
//		skillLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//		skillLayout.setGravity(Gravity.CENTER);
//		
//		for (int i=0; i<skillList.size(); i++) {
//			Button skillName = new Button(this);
//			skillName.setText(skillList.get(i));
//			skillName.setLayoutParams(new LayoutParams(300,LayoutParams.WRAP_CONTENT));
//			skillLayout.addView(skillName);
//		}
//			
//		skillView.addView(skillLayout);
//		setContentView(skillView);
//	}
//	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.battle, menu);
//		return true;
//	}
//}
