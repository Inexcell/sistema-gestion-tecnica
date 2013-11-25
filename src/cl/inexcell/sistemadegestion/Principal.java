package cl.inexcell.sistemadegestion;

import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;

public class Principal extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Activity sin parte superior
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_principal);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_principal, menu);
		return true;
	}
	
	/**
	 * 
	 * Intents de Activities 
     *
	 */
	
	public void show_instalacion(View view) {
        Intent i = new Intent(this, Instalacion.class );
        startActivity(i);
        
        // Vibrar al hacer click
        Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
	}
	
	public void show_notificar_averias(View view) {
        Intent i = new Intent(this, Notificar_Averias.class );
        startActivity(i);
        
        // Vibrar al hacer click        
        Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
	}
	
	public void show_reparacion(View view) {
        Intent i = new Intent(this, Reparacion.class );
        startActivity(i);
        
        // Vibrar al hacer click        
        Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
	}
	
	public void show_plantas_externas(View view) {
        Intent i = new Intent(this, Plantas_Externas.class );
        startActivity(i);
        
        // Vibrar al hacer click        
        Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
	}
	
	public void show_certificar_wifi(View view) {
        Intent i = new Intent(this, Certificar_Wifi.class );
        startActivity(i);
        
        // Vibrar al hacer click        
        Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
	}

}
