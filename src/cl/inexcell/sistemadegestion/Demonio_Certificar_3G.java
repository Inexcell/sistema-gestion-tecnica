package cl.inexcell.sistemadegestion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
//import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import android.widget.Toast;


public class Demonio_Certificar_3G extends Service{
	private String TAG = "Certificar_3G"; 
	private LocationManager locManager;
	private LocationListener locListener;
	private Location loc;
	private String operador, strength, latitud, longitud, provider;
	private Timer mTimer = null; 
	private TelephonyManager tm;
	private MyPhoneStateListener MyListener;
	private int netType;
	
	private File directory;
	private Criteria req;
	
	 @Override
	 public IBinder onBind(Intent arg0) {
	  return null;
	 }
	 
	 @Override
	 public void onCreate(){
		 Log.i(TAG,"Inicio");
		 super.onCreate();
		 
		 
		 
		 setupGPS();
		 setup3G();
		 this.mTimer = new Timer();
		 this.mTimer.scheduleAtFixedRate(
				 new TimerTask(){
					 @Override
					 public void run() {
						 ejecutarTarea();
					 }      
				 }
				 , 1000*10, 1000 * 60 * 5); //Tiempo en milisegundos son 60 minutos en este caso
	 	}
	 
	 private void ejecutarTarea(){
		 Thread t = new Thread(new Runnable() {
			 public void run() {
				
				File sdCard, file = null;
				Log.i(TAG, "DENTRO DEL TASK");
	        	String NT = "Desconocido";
	        	
	        	/**Tipo de Network */
	        	
	        	if(netType == TelephonyManager.NETWORK_TYPE_1xRTT)NT = "1xRTT";
	        	if(netType == TelephonyManager.NETWORK_TYPE_CDMA)NT = "CDMA";
	        	if(netType == TelephonyManager.NETWORK_TYPE_EDGE)NT = "EDGE";
	        	if(netType == TelephonyManager.NETWORK_TYPE_EHRPD)NT = "eHRPD";
	        	if(netType == TelephonyManager.NETWORK_TYPE_EVDO_0)NT = "EVDO revision 0";
	        	if(netType == TelephonyManager.NETWORK_TYPE_EVDO_A)NT = "EVDO revision A";
	        	if(netType == TelephonyManager.NETWORK_TYPE_EVDO_B)NT = "EVDO revision B";
	        	if(netType == TelephonyManager.NETWORK_TYPE_GPRS)NT = "GPRS";
	        	if(netType == TelephonyManager.NETWORK_TYPE_HSDPA)NT = "HSDPA";
	        	if(netType == TelephonyManager.NETWORK_TYPE_HSPA)NT = "HSPA";
	        	if(netType == TelephonyManager.NETWORK_TYPE_HSPAP)NT = "HSPA+";
	        	if(netType == TelephonyManager.NETWORK_TYPE_HSUPA)NT = "HSUPA";
	        	if(netType == TelephonyManager.NETWORK_TYPE_IDEN)NT = "iDen";
	        	if(netType == TelephonyManager.NETWORK_TYPE_LTE)NT = "LTE";
	        	if(netType == TelephonyManager.NETWORK_TYPE_UMTS)NT = "UMTS";
	        	if(netType == TelephonyManager.NETWORK_TYPE_UNKNOWN)NT = "Desconocido";
	        	
	        	
        		loc = locManager.getLastKnownLocation(provider);
        		if(loc == null || latitud == null){
        			if((loc = locManager.getLastKnownLocation(provider))!= null){
	        			latitud = String.valueOf(loc.getLatitude());
	        			longitud = String.valueOf(loc.getLongitude());
        			}
        		}
        		else{
        			latitud = String.valueOf(loc.getLatitude());
        			longitud = String.valueOf(loc.getLongitude());
        		}
				//String p = loc.getProvider();
				/** ESCRIBIR EN ARCHIVO*/				
		       String contenido = "\nLAT: " + latitud +
		        					"; LON: " + longitud +
		        					"; PROV: " + operador + 
		        					"; TIPORED: " + NT +
		        					"; INTENSIDAD: " + strength+"\n";
		       Looper.prepare();
		       Log.i(TAG, contenido);
		       Looper.loop();
		       
		       /**Aqui se deben enviar los datos **/
		       
		       Looper.prepare();
		       try {
		        	
		        	if (Environment.getExternalStorageState().equals("mounted")) {
		        		sdCard = Environment.getExternalStorageDirectory();
		        		FileWriter fw = null;
		        		try {
		        			directory = new File(sdCard.getAbsolutePath()
		        					+ "/SGT");
		        			if(!directory.exists())		        					
		        					directory.mkdirs();
							
							
							file = new File(directory, "3GCERT.txt");
							
							
		        			fw = new FileWriter(file,true);
		        			BufferedWriter out = new BufferedWriter(fw);
		        			out.write(contenido);
		        			out.close();
	 	 
						} catch (IOException e) {
							// TODO: handle exception
							e.printStackTrace();
							Log.e(TAG,"Error al escribir:"+e);
							Toast.makeText(getApplicationContext(), "ERROR AL ESCRIBIR", Toast.LENGTH_LONG).show();
						}
		        	}
		        }catch (Exception ie) {
		        	// TODO: handle exception

					Log.e(TAG,"Error:"+ie);
		        	Toast.makeText(getApplicationContext(), "ERROR AL ESCRIBIR", Toast.LENGTH_LONG).show();
		        }
		       Toast.makeText(getApplicationContext(), contenido, Toast.LENGTH_LONG).show();

				Log.i(TAG,"Archivo actualizado-> '"+contenido+"'.");
		        Looper.loop();
		        
			 }
			      
		
	  });  
	  t.start();
	  
	 }	
	 
public void setup3G(){
	Log.i(TAG, "setup3G");
	try{	 
		 /** DATOS DE 3G y PROVEEDOR **/
		tm = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
		/* Update the listener, and start it */
		MyListener   = new MyPhoneStateListener();
		tm.listen(MyListener ,PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
		
		netType = tm.getNetworkType();	 
		operador = String.valueOf(tm.getNetworkOperatorName());
		
		/*
	 	GsmCellLocation cellLocation = (GsmCellLocation)telephonyManager.getCellLocation();
	 	String networkOperator = telephonyManager.getNetworkOperator();
	 	String mcc = networkOperator.substring(0, 3);
	 	String mnc = networkOperator.substring(3);
	 	int cid = cellLocation.getCid();		   
	 	int lac = cellLocation.getLac();
	 	*/
		
	 }catch(Exception e){
	 	Log.i(TAG, e.toString());
	 	//Toast.makeText(getApplicationContext(), "Setup3G Error", Toast.LENGTH_LONG).show();
	}
	Log.i(TAG,"operator: "+operador);
}
	 
	 public void setupGPS(){
		 Log.i(TAG,"SetupGPS");	
		 /**  UBICACION GPS **/
		try{
			
			req = new Criteria();
			req.setAccuracy(Criteria.ACCURACY_FINE);
			
			locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
			
			
		    provider = locManager.getBestProvider(req, false);
		    loc = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		    //Nos registramos para recibir actualizaciones de la posición
		    locListener = new LocationListener() {
		        public void onLocationChanged(Location location) {
		        	// TODO Auto-generated method stub
		        	latitud = Double.toString(location.getLatitude());
		        	longitud = Double.toString(location.getLongitude());
		        	loc.setLatitude(location.getLatitude());
		        	loc.setLongitude(location.getLongitude());
		        }
	
				@Override
				public void onProviderDisabled(String arg0) {
					// TODO Auto-generated method stub
					Log.i(TAG,"GPS OFF");
					provider = locManager.getBestProvider(req, true);
				}
	
				@Override
				public void onProviderEnabled(String arg0) {
					// TODO Auto-generated method stub
					Log.i(TAG,"GPS ON");

					
					provider = locManager.getBestProvider(req, true);
				}
	
				@Override
				public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
					// TODO Auto-generated method stub
					Log.i(TAG,"STATUSCHANGE: "+arg0);
					
				}

		    };

		    locManager.requestLocationUpdates(provider, 1000*30, 0, locListener);
		}catch(Exception e){
			Log.e(TAG, e.toString());

		 	//Toast.makeText(getApplicationContext(), "SETUP GPS Error", Toast.LENGTH_LONG).show();
		}
	 }
	 	 
	 	 
	 private class MyPhoneStateListener extends PhoneStateListener
	    {
	      /* Get the Signal strength from the provider, each time there is an update */
	      @Override
	      public void onSignalStrengthsChanged(SignalStrength signalStrength)
	      {
	    	  super.onSignalStrengthsChanged(signalStrength);
	    	  try{
	    		  int asu = signalStrength.getGsmSignalStrength();
	    		  int signal = -113 + 2*asu;
	    		  strength = String.valueOf(signal);
	    	  }catch(Exception e){
	    		  Log.e(TAG,"Error:"+e);
	    	  }
	    	 
	    	  
	      }
	    };
	 
}
