package garvis;

import java.io.File;
import java.util.List;
import java.io.*;

import com.bitsinharmony.recognito.MatchResult;
import com.bitsinharmony.recognito.Recognito;
import com.bitsinharmony.recognito.VoicePrint;

public class Reconocer_voz {

	public void reconocer() throws Exception {
		Recognito<String> recognito = new Recognito<>(8000.0f);

		VoicePrint print = recognito.createVoicePrint("Oscar", new File("Grabacion_voz.wav"));//Asigna la voz al string Oscar
		List<MatchResult<String>> matches = recognito.identify(new File("Grabacion.wav"));
		MatchResult<String> match = matches.get(0);
		Saludo_Voz su = new Saludo_Voz();
	    
	    su.init("kevin16");
	    // high quality
	    String x = "Oscar";
	    String y = "No tienes permiso";

		if(match.getKey().equals("Oscar")) {//Si son iguales 
		    if(match.getLikelihoodRatio()> 50){
			System.out.println("Bienvenido Oscar ");// + match.getLikelihoodRatio() + "% positive about it...");
			su.doSpeak("Hola  " + x);
		    su.terminate();
		}
		    else {
		    	System.out.println(y);
		    	su.doSpeak(y);
			    su.terminate();
		    }
		}
	}
		

}


