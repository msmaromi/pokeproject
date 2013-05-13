package com.pokeranch;

import com.pokeranch.model.Player;

import android.annotation.SuppressLint;
import android.content.Context;

@SuppressLint("ViewConstructor")
public class CityScreenView extends ScreenView {
	
	public CityScreenView(Context context, int screenWidth, int screenHeight, Player player) {
		super(context, screenWidth, screenHeight, player);
		map = new String[] {
				"AAAAAAACAAAA",
				"ABBAAAACAAAA",
				"ABKAAAAAACAA",
				"AAAAACAAAAAA",
				"ACAAAAAAAAAA",
				"AAACAAAAAAAC",
				"AAAAAAAAAAAA",
				"CAAACCAACAAA",
				"AAAACCACAAAA",
				"AAAAAAAAACAA",
				"ACAAAAAAAAAA",
				"AAAABBBBBAAA",
				"AACABBBBBAAA",
				"AAAABBBBBAAA",
				"CAAAACAAAAAC",
				"AAACAAAACAAA",
				"AAAAAAACAACA",
				"AACAAAAACAAA",
				"AAAAAAAACAAA",
				"ACAAACAAAAAA"
			};
	}

}
