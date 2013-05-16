package com.example.menugan;

import com.example.drivermenu.DriverActivity;

import com.pokeranch.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MenuCoy extends Activity {
	
	Player playerDiMenu;	
	String[] listMonsterPokedex=	{"Species : Yi \nElemen : Api \n",
									"Species : Er \nElemen : Api \n",									
									"Species : San \nElemen : Api \n",
									"Species : Shi \nElemen : Api \n",
									"Species : Wu \nElemen : Api \n",
									"Species : Liu \nElemen : Api \n",
									"Species : One \nElemen : Air \n",
									"Species : Two \nElemen : Air \n",
									"Species : Three \nElemen : Air \n",
									"Species : Four \nElemen : Air \n",
									"Species : Five \nElemen : Air \n",
									"Species : Six \nElemen : Air \n",
									"Species : Uno \nElemen : Angin \n",
									"Species : Dos \nElemen : Angin \n",
									"Species : Tres \nElemen : Angin \n",
									"Species : Cuatro \nElemen : Angin \n",
									"Species : Cinco \nElemen : Angin \n",
									"Species : Seis \nElemen : Angin \n",
									"Species : Een \nElemen : Tanah \n",
									"Species : Twee \nElemen : Tanah \n",
									"Species : Drie \nElemen : Tanah \n",
									"Species : Vier \nElemen : Tanah \n",
									"Species : Vyf \nElemen : Tanah \n",
									"Species : Ses \nElemen : Tanah \n",
								};
	
	Integer[] list_image = 	{R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,
							R.drawable.ic_launcher,	
							};

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        playerDiMenu = new Player();
        playerDiMenu = DriverActivity.playerDriver;
//        playerDiMenu = this.getIntent().getParcelableExtra("player");
        
//        int duitPlayer2 = this.getIntent().getIntExtra("duit", playerDiMenu.getUang());
//        playerDiMenu.setUang(duitPlayer2);                               
        
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_list_item, menu);
        return true;
    }
    
    public void klikBackToGame(View V){    	
    	Intent i = new Intent(getApplicationContext(),DriverActivity.class);    	
//    	i.putExtra("duit", playerDiMenu.getUang());
    	startActivity(i);
    }
    
    public void klikItem(View v){
    	setContentView(R.layout.activity_list_item);
//    	setContentView(new ListItemView(getApplicationContext()));    	    
    	
    	
//    	LinearLayout layoutUtama = new LinearLayout(this);
//    	LinearLayout layoutUtama = (LinearLayout) findViewById(R.id.layoutUtamaXML);
//    	layoutUtama.setOrientation(LinearLayout.VERTICAL);
//    	layoutUtama.setGravity(Gravity.BOTTOM);
    	
//    	RelativeLayout layoutUtama = new RelativeLayout(this);
//    	layoutUtama.setLayoutParams(new LayoutParams(1000,1000));    	
    	
//    	LinearLayout layoutBtnBack = new LinearLayout(this);
    	LinearLayout layoutBtnBack = (LinearLayout) findViewById(R.id.layoutBtnBackXML);
    	layoutBtnBack.setOrientation(LinearLayout.VERTICAL);
//    	layoutBtnBack.setGravity(Gravity.BOTTOM);
    	
//    	TableLayout layoutBtnItem = new TableLayout(this);
    	LinearLayout layoutBtnItem = (LinearLayout)findViewById(R.id.layoutBtnItemXML);
    	layoutBtnItem.setOrientation(LinearLayout.VERTICAL);
//    	layoutBtnItem.setGravity(Gravity.TOP);    	    	    	    	
    	
    	int maxItemSize = playerDiMenu.listItem.size(); 
    	Button [] arrayBtnItem= new Button[maxItemSize];
//    	TextView[] arrayTextItem = new TextView[maxItemSize];
//    	TableRow [] arrayRowItem = new TableRow[maxItemSize];
    	
    	for (int i=0;i<maxItemSize;i++){
    		arrayBtnItem[i]=new Button(this);
    		arrayBtnItem[i].setText(playerDiMenu.listItem.get(i).getNama());
//    		arrayTextItem[i]=new TextView(this);
//    		arrayTextItem[i].setText("Jumlah = 1");
//    		arrayBtnItem[i].setWidth();
//    		layoutBtnItem.addView(arrayBtnItem[i]);    		    	
//    		arrayRowItem[i] = new TableRow(this);
//    		arrayRowItem[i].addView(arrayBtnItem[i]);
//    		arrayRowItem[i].addView(arrayTextItem[i]);
//    		layoutBtnItem.addView(arrayRowItem[i]);
    		layoutBtnItem.addView(arrayBtnItem[i]);
    	}
    	
    	Button btnItemBack = new Button(this);
    	btnItemBack.setText("Back");    
    	
    	    	
    	btnItemBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.activity_menu);
			}
		});    		    	

    	layoutBtnBack.addView(btnItemBack);   
//    	layoutUtama.addView(layoutBtnItem);
//    	layoutUtama.addView(layoutBtnBack);
    	
//    	setContentView(layoutUtama);
    }
    
    public void klikMonster(View v){
    	setContentView(R.layout.activity_list_monster);		
    	LinearLayout layoutBtnBack = (LinearLayout) findViewById(R.id.layoutBtnBackXML);
    	layoutBtnBack.setOrientation(LinearLayout.VERTICAL);
    	
    	LinearLayout layoutBtnMonster = (LinearLayout)findViewById(R.id.layoutBtnMonsterXML);
    	layoutBtnMonster.setOrientation(LinearLayout.VERTICAL);
    	
    	int maxMonsterSize = playerDiMenu.listMonster.size(); 
    	Button [] arrayBtnMonster= new Button[maxMonsterSize];    	
    	
    	for (int i=0;i<maxMonsterSize;i++){
    		arrayBtnMonster[i]=new Button(this);
    		arrayBtnMonster[i].setText(playerDiMenu.listMonster.get(i).getNama());
    		arrayBtnMonster[i].setOnClickListener(new klikMonsterListener(i) {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					setContentView(R.layout.layout_monster);

					//klik set default monster
					Button setDefaultMon = (Button) findViewById(R.id.setDefaultMon);
					setDefaultMon.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							playerDiMenu.defaultMonster = playerDiMenu.listMonster.get(iterasi);
							DriverActivity.playerDriver = playerDiMenu;
						}
					});
					
					//klik dismiss
					Button dismissMon = (Button) findViewById(R.id.dismissMon);
					dismissMon.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							playerDiMenu.delMonster(playerDiMenu.listMonster.get(iterasi));
							playerDiMenu.defaultMonster=null;
							DriverActivity.playerDriver = playerDiMenu;
						}
					});
					
					
					TextView namaMon= (TextView) findViewById(R.id.namaMon);					
					namaMon.setText("Nama : "+playerDiMenu.listMonster.get(iterasi).getNama());
					
					TextView currentHPMPSpeedMon= (TextView) findViewById(R.id.currentHPMPSpeedMon);					
					currentHPMPSpeedMon.setText("HP/MP/Speed : "+playerDiMenu.listMonster.get(iterasi).getCurrentHP()+"/"+playerDiMenu.listMonster.get(iterasi).getCurrentMP()+"/"+playerDiMenu.listMonster.get(iterasi).getCurrentSpeed() );
					
					TextView levelMon= (TextView) findViewById(R.id.levelMon);					
					levelMon.setText("Level : "+playerDiMenu.listMonster.get(iterasi).getLevel());
					
					TextView expMon= (TextView) findViewById(R.id.expMon);					
					expMon.setText("Exp : "+playerDiMenu.listMonster.get(iterasi).getExp());
					
					TextView speciesMon= (TextView) findViewById(R.id.speciesMon);					
					speciesMon.setText("Species : "+playerDiMenu.listMonster.get(iterasi).getSpecies());
					
					TextView elemenMon= (TextView) findViewById(R.id.elemenMon);					
					elemenMon.setText("Elemen : "+playerDiMenu.listMonster.get(iterasi).getElemen());
					
					TextView HPMon= (TextView) findViewById(R.id.HPMon);					
					HPMon.setText("Max HP : "+playerDiMenu.listMonster.get(iterasi).getHP());
					
					TextView MPMon= (TextView) findViewById(R.id.MPMon);					
					MPMon.setText("Max MP : "+playerDiMenu.listMonster.get(iterasi).getMP());
					
					TextView speedMon= (TextView) findViewById(R.id.speedMon);					
					speedMon.setText("Speed : "+playerDiMenu.listMonster.get(iterasi).getSpeed());
					
					TextView statusMon= (TextView) findViewById(R.id.statusMon);					
					statusMon.setText("Status : "+playerDiMenu.listMonster.get(iterasi).getStatus());
					
					TextView umurMon= (TextView) findViewById(R.id.umurMon);					
					umurMon.setText("Umur : "+playerDiMenu.listMonster.get(iterasi).getUmur());
														
					LinearLayout layoutSkill = (LinearLayout) findViewById(R.id.layoutSkill);
					
					TextView[] namaSkillMon = new TextView[playerDiMenu.listMonster.get(iterasi).getNoSkill()];
					TextView[] HPMPSkillMon = new TextView[playerDiMenu.listMonster.get(iterasi).getNoSkill()];
					TextView[] dmgSkillMon = new TextView[playerDiMenu.listMonster.get(iterasi).getNoSkill()];					
					TextView[] statSkillMon = new TextView[playerDiMenu.listMonster.get(iterasi).getNoSkill()];
					
					for (int j=0;j<playerDiMenu.listMonster.get(iterasi).getNoSkill();j++){
						
						namaSkillMon[j]= new TextView(getApplicationContext());
						namaSkillMon[j].setText("\nSkill "+j+" : "+playerDiMenu.listMonster.get(iterasi).Skill[j].getNamaSkill());
						
						HPMPSkillMon[j] = new TextView(getApplicationContext());
						HPMPSkillMon[j].setText("HP/MP cost : "+ playerDiMenu.listMonster.get(iterasi).Skill[j].getHPCost()+"/"+playerDiMenu.listMonster.get(iterasi).Skill[j].getMPCost());

						dmgSkillMon[j]= new TextView(getApplicationContext());
						dmgSkillMon[j].setText("Damage "+" : "+playerDiMenu.listMonster.get(iterasi).Skill[j].getDamage());												
						
						statSkillMon[j]= new TextView(getApplicationContext());
						statSkillMon[j].setText("Status Effect "+" : "+playerDiMenu.listMonster.get(iterasi).Skill[j].getStatus());
						
						layoutSkill.addView(namaSkillMon[j]);
						layoutSkill.addView(HPMPSkillMon[j]);
						layoutSkill.addView(dmgSkillMon[j]);
						layoutSkill.addView(statSkillMon[j]);
						
					}//end for
					
//					TextView[] namaSkillMon = new TextView[2];
//					for(int j=0;j<2;j++){
//						namaSkillMon[j]=new TextView(getApplicationContext());
//						namaSkillMon[j].setText("Skill : tes"+j);						
//						layoutSkill.addView(namaSkillMon[j]);						
//					}
					
				}//end klik
			});
    		
    		layoutBtnMonster.addView(arrayBtnMonster[i]);
    	}
    	
    	Button btnMonsterBack = new Button(this);
    	btnMonsterBack.setText("Back");    
    	
    	    	
    	btnMonsterBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.activity_menu);
			}
		});    		    	

    	layoutBtnBack.addView(btnMonsterBack);   
    }
    
    public void klikStatusPlayer(View v){
    	setContentView(R.layout.layout_status_player);    	    	 
    	
    	TextView namaPlayer = (TextView) findViewById(R.id.namaPlayer);
    	namaPlayer.setText("Nama : "+playerDiMenu.getNama());
    	
    	TextView uangPlayer = (TextView) findViewById(R.id.uangPlayer);
    	uangPlayer.setText("Uang : "+playerDiMenu.getUang());    	    	    	    	
    	
    	TextView waktuPlayer = (TextView) findViewById(R.id.waktuPlayer);
    	waktuPlayer.setText("Waktu : "+playerDiMenu.getWaktu());
    	
    	TextView jumlahMenangPlayer = (TextView) findViewById(R.id.jumlahMenangPlayer);
    	jumlahMenangPlayer.setText("Jumlah Menang : "+playerDiMenu.getJumlahMenang());

    	TextView jumlahKalahPlayer = (TextView) findViewById(R.id.jumlahKalahPlayer);
    	jumlahKalahPlayer.setText("Jumlah Kalah : "+playerDiMenu.getJumlahKalah());

    	TextView jumlahKaburPlayer = (TextView) findViewById(R.id.jumlahKaburPlayer);
    	jumlahKaburPlayer.setText("Jumlah Kabur : "+playerDiMenu.getJumlahEscape());
    	
    	TextView defMonPlayer = (TextView) findViewById(R.id.defMonPlayer);
    	if(playerDiMenu.defaultMonster==null){
    		defMonPlayer.setText("Default monster : belum dipilih");
    	}else{
    		defMonPlayer.setText("Default Monster : "+playerDiMenu.defaultMonster.getNama());
    	}
    	
    	
    	
    }//end klik
    
    public void klikPokedex(View v){
    	setContentView(R.layout.activity_pokedex);
    	
    	 Gallery gallery = (Gallery) findViewById(R.id.gallery1);
    	         gallery.setAdapter(new ImageAdapter(this));
    	         gallery.setOnItemClickListener(new OnItemClickListener()
    	         {
    	             public void onItemClick(AdapterView parent,
    	             View v, int position, long id)
    	             {
    	                 Toast.makeText(getBaseContext(),
    	                        listMonsterPokedex[position],
    	                         Toast.LENGTH_SHORT).show();
    	             }    	 
    	         });

    }
   

    public abstract class klikMonsterListener implements OnClickListener{
    	public int iterasi;
    	
    	public klikMonsterListener(int i){
    		super();
    		iterasi = i;
    	}
    	
    }
    
    public class ImageAdapter extends BaseAdapter{
            private Context context;
            private int itemBackground;

            public ImageAdapter(Context c)
            {
                context = c;

                TypedArray a = obtainStyledAttributes(R.styleable.Gallery1);
                itemBackground = a.getResourceId(R.styleable.Gallery1_android_galleryItemBackground, 0);
                a.recycle();
            }

            public int getCount() {
                return list_image.length;
            }

            public Object getItem(int position) {
                return position;
            }

            public long getItemId(int position) {
                return position;
            }

            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView = new ImageView(context);
                imageView.setImageResource(list_image[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new Gallery.LayoutParams(150, 150));
                imageView.setBackgroundResource(itemBackground);
                return imageView;
            }
        }
   

    public void klikBackToMenu(View V){
    	setContentView(R.layout.activity_menu);
    }
    
}//end listitem
