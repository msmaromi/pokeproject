package com.pokeranch;

import java.util.Random;
import java.util.Vector;

import com.pokeranch.maps.LuarActivity;

import android.util.Pair;

public class MonsterNPC {

	private int curX;
	private int curY;
	
	private String type;
	
	public MonsterNPC(String type, int x, int y) {
		this.type = type;
		curX = x;
		curY = y;
	}
	
	public int getX() {
		return curX;
	}
	
	public int getY() {
		return curY;
	}
	
	public String getType() {
		return type;
	}
	
	public void move() {
		ScreenView screen = GV.activeActivity.getScreenView();
		Vector<Pair<Integer, Integer>> v = new Vector<Pair<Integer, Integer>>();
		for (int i = -1; i <= 1; i += 1 ) {
			for (int j = -1; j <= 1; j += 1) {
				if ((i == 0 && j != 0) || (i != 0 && j == 0)) {
					if (screen.getMapId(curX + i, curY + j) == 0) {
						v.add(new Pair<Integer, Integer>(i, j));
					}
				}
			}
		}
		
		int dx = curX - GV.player.getX();
		int dy = curY - GV.player.getY();
		
		int px = dx == 0 ? 0 : dx / Math.abs(dx);
		int py = dy == 0 ? 0 : dy / Math.abs(dy);
		
		Vector<Pair<Integer, Integer>> rv = new Vector<Pair<Integer, Integer>>();
		for (int i = 0; i < v.size(); i++) {
			if (((px != 0 && v.elementAt(i).first == -px) || (py != 0 && v.elementAt(i).second == -py)) && type == "mendekat") {
				if (!((GV.player.getX() == curX + px && GV.player.getY() == curY + py) || (((LuarActivity)GV.activeActivity).checkExist(curX + px, curY + py)))) {
					rv.add(v.elementAt(i));
				}
			} else if (((px != 0 && v.elementAt(i).first == px) || (py != 0 && v.elementAt(i).second == py)) && type == "menjauh") {
				if (!((GV.player.getX() == curX + px && GV.player.getY() == curY + py) || (((LuarActivity)GV.activeActivity).checkExist(curX + px, curY + py)))) {
					rv.add(v.elementAt(i));
				}
			} else if (type == "random") {
				if (!((GV.player.getX() == curX + px && GV.player.getY() == curY + py) || (((LuarActivity)GV.activeActivity).checkExist(curX + px, curY + py)))) {
					rv.add(v.elementAt(i));
				}
			}
		}
		
		if (rv.size() > 0) {
			Random rand = new Random();
			int  n = rand.nextInt(rv.size());
			if (rv.elementAt(n).first != 0) {
				moveHorizontal(rv.elementAt(n).first);
			} else if (rv.elementAt(n).second != 0) {
				moveVertical(rv.elementAt(n).second);
			}
		}
	}
	
	private void moveHorizontal(int tile) {
		ScreenView screen = GV.activeActivity.getScreenView();
		int absTile = Math.abs(tile);
		int mod = tile / absTile;
		for (int i = 0; i < absTile; i++) {
			if (screen.getMapId(curX + mod, curY) != 0) {
				break;
			}
			if (curX + mod < 0 || curX + mod >= screen.getMapWidth()) {
				break;
			}
			curX += mod;
		}
	}
	
	private void moveVertical(int tile) {
		ScreenView screen = GV.activeActivity.getScreenView();
		int absTile = Math.abs(tile);
		int mod = tile / absTile;
		for (int i = 0; i < absTile; i++) {
			if (screen.getMapId(curX, curY + mod) != 0) {
				break;
			}
			if (curY + mod < 0 || curY + mod >= screen.getMapHeight()) {
				break;
			}
			curY += mod;
		}
	}
	
}
