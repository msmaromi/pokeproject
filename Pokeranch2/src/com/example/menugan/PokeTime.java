package com.example.menugan;

import java.util.Timer;
import java.util.TimerTask;

import android.util.Log;

public class PokeTime {	
	public final int ONE_SECOND = 1000;		//dalam ms
	public final int POKE_HALF_DAY = 60;	//dalam s

	private int pokeSecond;
	private int pokeDay;
	private Timer timer;

	public PokeTime() {
		pokeSecond = 0;
		pokeDay = 0;
		timer = new Timer();
	}

	public PokeTime(int second, int day, Timer t) {
		pokeSecond = second;
		pokeDay = day;
		timer = t;
	}

	public int getPokeSecond() {
		return pokeSecond;
	}

	public void setPokeSecond(int newPokeSecond) {
		pokeSecond = newPokeSecond;
	}

	public int getPokeDay() {
		return pokeDay;
	}

	public void setPokeDay(int newPokeDay) {
		pokeDay = newPokeDay;
	}

	public void start() {
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub				
				if(pokeSecond>2*POKE_HALF_DAY) {
					pokeDay++;
					pokeSecond = 1;					
				}
				pokeSecond++;
				Log.d("second ke", String.valueOf(pokeSecond));
				Log.d("day ke", String.valueOf(pokeDay));
			}
		}, ONE_SECOND, ONE_SECOND);
	}

	public void pause() {
		timer.cancel();
	}

	public void stop() {
		timer.cancel();
		timer.purge();
	}
}