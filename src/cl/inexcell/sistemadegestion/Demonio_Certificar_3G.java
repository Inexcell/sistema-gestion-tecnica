package cl.inexcell.sistemadegestion;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.IBinder;
import android.telephony.TelephonyManager;
//import android.telephony.gsm.GsmCellLocation;
import android.util.Log;


public class Demonio_Certificar_3G extends Service {
	private String TAG = "Certificar_3G"; 
	private LocationManager lm;
	private Location loc;
	private String provider, strength ="unknown";
	private Timer mTimer = null; 
	private TelephonyManager telephonyManager;
	
	 @Override
	 public IBinder onBind(Intent arg0) {
	  return null;
	 }
	 
	 @Override
	 public void onCreate(){
		 Log.i(TAG,"Inicio");
		 super.onCreate();
		 this.mTimer = new Timer();
		 this.mTimer.scheduleAtFixedRate(
				 new TimerTask(){
					 @Override
					 public void run() {
						 ejecutarTarea();
					 }      
				 }
				 , 0, 1000 * 60 * 60); //Tiempo en milisegundos son 60 minutos en este caso
	 	}
	 
	 private void ejecutarTarea(){
	  Thread t = new Thread(new Runnable() {
	   public void run() {
		Log.i(TAG, "DEMONIO");
		
		
		/**  UBICACION GPS o NETWORK  **/
		/** Reconoce solo la ubicacion via network **/
		/** Tengo problemas para utilizar GPS **/
		lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Criteria cri = new Criteria();
		cri.setAccuracy(Criteria.ACCURACY_FINE);
		provider = lm.getBestProvider(cri, true);
		loc = lm.getLastKnownLocation(provider);		
		Double d1 = loc.getLatitude();
		Double d2 = loc.getLongitude();
		String latitude = String.valueOf(Location.convert(d1,Location.FORMAT_DEGREES));
		String longitude = String.valueOf(Location.convert(d2,Location.FORMAT_DEGREES));
				
		
		/** DATOS DE 3G y PROVEEDOR **/
		telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
		
		/*GsmCellLocation cellLocation = (GsmCellLocation)telephonyManager.getCellLocation();
		String networkOperator = telephonyManager.getNetworkOperator();
		String mcc = networkOperator.substring(0, 3);
		String mnc = networkOperator.substring(3);
		int cid = cellLocation.getCid();		   
		int lac = cellLocation.getLac();*/
			
		String netOperatorName = telephonyManager.getNetworkOperatorName();
		
		/** CREAMOS EL STRING A MOSTRAR **/
		
		StringBuilder notificacion = new StringBuilder();		
		notificacion.append("Ubicacion: " + latitude + ", "+longitude +".");
		notificacion.append("Strength: "+ strength + ".\n");
		Log.i(TAG, notificacion.toString());
		
		/** MOSTRAR NOTIFICACION ANDROID **/		
		
		NotifyManager notify = new NotifyManager();
	    notify.playNotification(
	    		getApplicationContext(),
	    		Principal.class,
	    		notificacion.toString(),
	    		netOperatorName, R.drawable.ic_logo_icon);
	    
	   }
	  });  
	  t.start();
	  
	 }	
	 
	 
	}
