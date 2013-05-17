package com.pokeranch.maps;

import com.pokeranch.GV;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

@SuppressLint("ViewConstructor")
public class NavigationButton extends RelativeLayout {
	
	public NavigationButton(Context context) {
		super(context);
		
		Button btnRight = new Button(context);
		btnRight.setText("RIGHT");
		btnRight.setId(1111);
		LayoutParams paramRight = new LayoutParams(120,60);
		LayoutParams btnParam = new LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
		setLayoutParams(btnParam);
		addView(btnRight);
		paramRight.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
		paramRight.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
		btnRight.setLayoutParams(paramRight);
		btnRight.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				GV.player.moveHorizontal(1);
				if (GV.activeActivity instanceof LuarActivity) {
					((LuarActivity)GV.activeActivity).moveMonsters();
				}
			}
		});
		
		Button btnDown = new Button(context);
		btnDown.setText("DOWN");
		btnDown.setId(2222);
		addView(btnDown);
		LayoutParams paramDown = new LayoutParams(120,60);
		paramDown.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
		paramDown.addRule(RelativeLayout.LEFT_OF, 1111);
		btnDown.setLayoutParams(paramDown);
		btnDown.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				GV.player.moveVertical(1);
				if (GV.activeActivity instanceof LuarActivity) {
					((LuarActivity)GV.activeActivity).moveMonsters();
				}
			}
		});
		
		Button btnLeft = new Button(context);
		btnLeft.setText("LEFT");
		btnLeft.setId(3333);
		addView(btnLeft);
		LayoutParams paramLeft = new LayoutParams(120,60);
		paramLeft.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
		paramLeft.addRule(RelativeLayout.LEFT_OF, 2222);
		btnLeft.setLayoutParams(paramLeft);
		btnLeft.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				GV.player.moveHorizontal(-1);
				if (GV.activeActivity instanceof LuarActivity) {
					((LuarActivity)GV.activeActivity).moveMonsters();
				}
			}
		});
		
		Button btnUp = new Button(context);
		btnUp.setText("UP");
		btnUp.setId(4444);
		addView(btnUp);
		LayoutParams paramUp = new LayoutParams(120, 60);
		paramUp.addRule(RelativeLayout.ABOVE, 2222);
		paramUp.addRule(RelativeLayout.LEFT_OF, 1111);
		btnUp.setLayoutParams(paramUp);
		btnUp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				GV.player.moveVertical(-1);
				if (GV.activeActivity instanceof LuarActivity) {
					((LuarActivity)GV.activeActivity).moveMonsters();
				}
			}
		});
	}

}
