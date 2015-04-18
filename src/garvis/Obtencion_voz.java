package garvis;
import java.io.File;

import javax.sound.sampled.*;

public class Obtencion_voz {
	String[]palabras=new String [100];
	AudioFileFormat.Type aFF_T = AudioFileFormat.Type.WAVE;
	AudioFormat aF = new AudioFormat(8000.0F, 16, 1, true, false);
	TargetDataLine tD;
	File f = new File("Grabacion_voz.wav");
	public Obtencion_voz() {
	try {
	DataLine.Info dLI = new DataLine.Info(TargetDataLine.class,aF);
	tD = (TargetDataLine)AudioSystem.getLine(dLI);
	new CapThread().start();
	System.out.println("Grabando durante 5s...");
	Thread.sleep(5000);
	tD.close();
	}catch (Exception e) {}
	}
	class CapThread extends Thread {
	public void run() {
	try {
	tD.open(aF);
	tD.start();
	AudioSystem.write(new AudioInputStream(tD), aFF_T, f);
	}catch (Exception e){}
	}
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String z= "Hola soy Garvis , quien eres ";
		Saludo_Voz gar = new Saludo_Voz();//Saluda 
	    gar.init("kevin16");//Tipo de Voz
	    gar.doSpeak(z);
		new Obtencion_voz();//Obtiene la voz y la guarda como :Grabacion_voz.wav
		Reconocer_voz reconocer1 = new Reconocer_voz(); 
		reconocer1.reconocer();//Compara la voz
		
	}

}
