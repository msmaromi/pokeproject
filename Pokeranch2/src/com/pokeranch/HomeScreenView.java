package com.pokeranch;

import com.pokeranch.model.Player;

import android.annotation.SuppressLint;
import android.content.Context;

@SuppressLint("ViewConstructor")
public class HomeScreenView extends ScreenView {
	
	public HomeScreenView(Context context, int screenWidth, int screenHeight, Player player) {
		super(context, screenWidth, screenHeight, player);
		map = new String[] {
				"AAAAAAACAAAA",
				"BBBAAAACAAAA",
				"BBBAAAAAACAA",
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
		player.setPosition(0, 0);
	}

}
