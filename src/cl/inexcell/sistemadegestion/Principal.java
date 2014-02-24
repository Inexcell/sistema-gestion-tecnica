package cl.inexcell.sistemadegestion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class Principal extends Activity {

	private String TAG = "Principal Activity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG,"INICIANDO APLICACION");
		// Activity sin parte superior
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_principal);
		/** Se inicia el DEMONIO **/
		//LocationManager locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		//if(locManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
			try{
				Log.i(TAG,"GPS OK");
				Intent service = new Intent(this, Demonio_Certificar_3G.class);
				startService(service);
			}catch(Exception e){
				

				
				Toast.makeText(getApplicationContext(), "START SERVICE ERROR", Toast.LENGTH_LONG).show();
			}
		/*}else{
			Log.i(TAG,"GPS OFF");
			 new AlertDialog.Builder(this)
		      .setIcon(android.R.drawable.ic_dialog_alert)
		      .setTitle("GPS está desactivado!")
		      .setMessage("Active GPS e inicie la aplicación.")
		      .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {//un listener que al pulsar, cierre la aplicacion
		          @Override
		          public void onClick(DialogInterface dialog, int which){
		            //Salir
		          	Principal.this.finish();
		          }
		        }).show();
		}*/
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
		
		 ConnectivityManager conMan = (ConnectivityManager) 
			      getSystemService(Context.CONNECTIVITY_SERVICE);
		 	
		 State senal3g = conMan.getNetworkInfo(0).getState();
		 State wifi = conMan.getNetworkInfo(1).getState();
		 
		 if (senal3g == NetworkInfo.State.CONNECTED || wifi == NetworkInfo.State.CONNECTED)
		 {
			 Intent i = new Intent(this, Instalacion.class );
		     startActivity(i);
		        
		        // Vibrar al hacer click
		     Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		     vibrator.vibrate(50);
			 			 
		 }
		 else
		 {
			 Toast.makeText(getApplicationContext(), "No existe conexión a internet para utilizar el Programa", Toast.LENGTH_LONG).show();			 
		 }  
	}
	
	public void show_notificar_averias(View view) {
		
		 ConnectivityManager conMan = (ConnectivityManager) 
			      getSystemService(Context.CONNECTIVITY_SERVICE);
		 	
		 State senal3g = conMan.getNetworkInfo(0).getState();
		 State wifi = conMan.getNetworkInfo(1).getState();
		 
		 if (senal3g == NetworkInfo.State.CONNECTED || wifi == NetworkInfo.State.CONNECTED)
		 {
			 Intent i = new Intent(this, Notificar_Averias.class );
		     startActivity(i);
		        
		        // Vibrar al hacer click
		     Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		     vibrator.vibrate(50);
			 			 
		 }
		 else
		 {
			 Toast.makeText(getApplicationContext(), "No existe conexión a internet para utilizar el Programa", Toast.LENGTH_LONG).show();			 
		 }  
	}
	
	public void show_reparacion(View view) {
		
		ConnectivityManager conMan = (ConnectivityManager) 
			      getSystemService(Context.CONNECTIVITY_SERVICE);
		 	
		 State senal3g = conMan.getNetworkInfo(0).getState();
		 State wifi = conMan.getNetworkInfo(1).getState();
		 
		 if (senal3g == NetworkInfo.State.CONNECTED || wifi == NetworkInfo.State.CONNECTED)
		 {
			 Intent i = new Intent(this, Reparacion.class );
		     startActivity(i);
		        
		        // Vibrar al hacer click
		     Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		     vibrator.vibrate(50);
			 			 
		 }
		 else
		 {
			 Toast.makeText(getApplicationContext(), "No existe conexión a internet para utilizar el Programa", Toast.LENGTH_LONG).show();			 
		 }  
	}
	
	public void show_plantas_externas(View view) {
		
		ConnectivityManager conMan = (ConnectivityManager) 
			      getSystemService(Context.CONNECTIVITY_SERVICE);
		 	
		 State senal3g = conMan.getNetworkInfo(0).getState();
		 State wifi = conMan.getNetworkInfo(1).getState();
		 
		 if (senal3g == NetworkInfo.State.CONNECTED || wifi == NetworkInfo.State.CONNECTED)
		 {
			 Intent i = new Intent(this, Plantas_Externas.class );
		     startActivity(i);
		        
		        // Vibrar al hacer click
		     Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		     vibrator.vibrate(50);
			 			 
		 }
		 else
		 {
			 Toast.makeText(getApplicationContext(), "No existe conexión a internet para utilizar el Programa", Toast.LENGTH_LONG).show();			 
		 }        
	}
	
//	public void show_certificar_wifi(View view) {
//        Intent i = new Intent(this, Certificar_Wifi.class );
//        startActivity(i);
//        
//        // Vibrar al hacer click        
//        Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
//        vibrator.vibrate(50);
//	}

}
