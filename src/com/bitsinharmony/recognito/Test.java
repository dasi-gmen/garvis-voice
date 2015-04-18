package com.bitsinharmony.recognito;

import java.io.File;
import java.io.*;
import java.util.*;
public class Test {



public static void main(String[] args) throws Exception {
	// Create a new Recognito instance defining the audio sample rate to be used
	Recognito<String> recognito = new Recognito<>(12500.0f);

	VoicePrint print = recognito.createVoicePrint("Elvis", new File("OldInterview.wav"));

	// handle persistence the way you want, e.g.:
	// myUser.setVocalPrint(print);
	// userDao.saveOrUpdate(myUser);
	
	// Now check if the King is back
	List<MatchResult<String>> matches = recognito.identify(new File("SomeFatGuy.wav"));
	MatchResult<String> match = matches.get(0);

	if(match.getKey().equals("Elvis")) {
	    if(match.getLikelihoodRatio()> 50){
		System.out.println("Elvis is back !!! " + match.getLikelihoodRatio() + "% positive about it...");
	}
	    else {
	    	System.out.println("No tienes permiso");
	    }
	}
	}
	
}
