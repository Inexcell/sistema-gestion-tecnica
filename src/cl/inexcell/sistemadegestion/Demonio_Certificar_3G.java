package cl.inexcell.sistemadegestion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
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
	@SuppressWarnings("unused")
	private Timer m2Timer = null; 
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
						 ConnectivityManager conMan = (ConnectivityManager) 
							      getSystemService(Context.CONNECTIVITY_SERVICE);
							
						 State senal3g = conMan.getNetworkInfo(0).getState();
						 State wifi = conMan.getNetworkInfo(1).getState();
						 if (senal3g == NetworkInfo.State.CONNECTED )
						 {
							// ejecutarTarea();
						 }else if (wifi == NetworkInfo.State.CONNECTED )
						 {
							 //enviarDatos3G();
						 };
					 }      
				 }
				 , 1000*10, 1000 * 60 *5); //Tiempo en milisegundos son 60 minutos en este caso
		 //, 1000*10, 10000); //Tiempo en milisegundos son 60 minutos en este caso
		 
		
	}
	 
	 @SuppressWarnings("unused")
	private void enviarDatos3G(){
		 Thread t = new Thread(new Runnable() {
			 @SuppressWarnings({ "resource" })
			public void run() {
				
				File sdCard, file = null;
				Log.i(TAG, "DENTRO DEL TASK");
	        	String NT = "Desconocido";
	        	
	        	
				
		       Looper.prepare();
		      // Log.i(TAG, contenido);
		       
		       
		       /**Aqui se deben enviar los datos **/
		       
		      
		       try {
		        	Log.i(TAG, "Comenzando la lectura");
		        	if (Environment.getExternalStorageState().equals("mounted")) {
		        		sdCard = Environment.getExternalStorageDirectory();
		        		FileReader re = null;
		        		
		        		try {
		        			directory = new File(sdCard.getAbsolutePath()
		        					+ "/SGT");		        			
							
							file = new File(directory, "3GCERT_AUX.txt");					          
							BufferedReader buffer = new BufferedReader(new FileReader(file));

					        int value=0;
			
							int largo = 0;
							boolean cargoOk = true;
							
							String thisLine = "";
							String latitud;
							String longitud;
							String proveedor;
							String tipo_red;
							String intensidad;
							String fecha;
					         // reads to the end of the stream 
							buffer.readLine();							
							while ((thisLine = buffer.readLine()) != null) { // while loop begins here
						        //LEER CADA LINEA Y HACER UN SPLIT
								//PARA LUEGO ENVIAR LA LINEA AL SERVIDOR
								if(thisLine != "" && thisLine != "[]" && thisLine != "\n" )
								{
									//HACERUN SPLIT;								
									
									latitud = thisLine.substring(thisLine.indexOf("LAT: ", 0) + 5,thisLine.indexOf("; LON: ", 0));
									longitud = thisLine.substring(thisLine.indexOf("; LON: ", 0) + 7,thisLine.indexOf("; PROV: ", 0));
									proveedor = thisLine.substring(thisLine.indexOf("; PROV: ", 0) + 8,thisLine.indexOf("; TIPORED: ", 0));
									
									tipo_red = thisLine.substring(thisLine.indexOf("; TIPORED: ", 0) + 11,thisLine.indexOf("; FECHA: ", 0));
									fecha = thisLine.substring(thisLine.indexOf("; FECHA: ", 0) + 9,thisLine.indexOf("; INTENSIDAD: ", 0));
									intensidad = thisLine.substring(thisLine.indexOf("; INTENSIDAD: ", 0) + 14);
									TelephonyManager fono = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
									
								//	Si la respuesta está ok--- entonces pasar al siguiente
									String respuesta = SoapRequestMovistar.setNotification3G(latitud, longitud, proveedor, intensidad,  tipo_red, fecha, fono.getDeviceId(), fono.getSimSerialNumber());
									if(Integer.valueOf(XMLParser.setNotificacion3G(respuesta).get(0)) != 0)
									{										
										cargoOk = false;	
									}									
								}								
						       } // end while	
							//Si se completa sin errores se debe limpiar el archivo
							
							if(cargoOk == true)
							{//Limpiar el archivo
							 //															
								
								File file_del = new File(directory, "3GCERT.txt");
			        			
			        			try
			        			{
			        				file_del.delete();
			        			}catch (Exception e )
			        			{		        					
			        			}		
			        			
			        			
							}	 	 
						} catch (IOException e) {
							// TODO: handle exception
						/*	e.printStackTrace();
							Log.e(TAG,"Error al escribir:"+e);
							Toast.makeText(getApplicationContext(), "ERROR AL LEER DESDE EL ARCHIVO", Toast.LENGTH_LONG).show();*/
						}
		        	}
		        }catch (Exception ie) {
		        	// TODO: handle exception

					Log.e(TAG,"Error:"+ie);
		        	Toast.makeText(getApplicationContext(), "ERROR AL ESCRIBIR", Toast.LENGTH_LONG).show();
		        }
		       //Toast.makeText(getApplicationContext(), contenido, Toast.LENGTH_LONG).show();

	//			Log.i(TAG,"Archivo actualizado-> '"+contenido+"'.");
		        Looper.loop();
		        
			 }
			      
		
	  });  
	  t.start();
	  
	 }	
	 
	 @SuppressLint("SimpleDateFormat")
	private void ejecutarTarea(){
		 Thread t = new Thread(new Runnable() {
			 public void run() {
				
				File sdCard, file, file_to, file_del = null;
				Log.i(TAG, "DENTRO DEL TASK");
	        	String NT = "Desconocido";
	        	DateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
	        	 
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
	        	Date fecha = Calendar.getInstance().getTime();
	        	
	        	
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
		        					"; FECHA: " + formatter.format(fecha).toString() +
		        					"; INTENSIDAD: " + strength+"";
		       Looper.prepare();
		       Log.i(TAG, contenido);
		       
		       
		       /**Aqui se deben enviar los datos **/
		      
		      
		       try {
		        	Log.i(TAG, "Comenzando la escritura");
		        	if (Environment.getExternalStorageState().equals("mounted")) {
		        		sdCard = Environment.getExternalStorageDirectory();
		        		FileWriter fw = null;
		        		FileWriter fw_to = null;
		        		try {
		        			directory = new File(sdCard.getAbsolutePath()
		        					+ "/SGT");
		        			if(!directory.exists())		        					
		        					directory.mkdirs();
							
							
							file = new File(directory, "3GCERT.txt");							
							
							
		        			fw = new FileWriter(file,true);
		        			@SuppressWarnings("resource")
							BufferedWriter out = new BufferedWriter(fw);
		        			
		        			out.write(contenido);
		        			out.flush();
		        			//out.close();
		        			
		        			file_del = new File(directory, "3GCERT_AUX.txt");
		        			
		        			try
		        			{
		        				file_del.delete();
		        			}catch (Exception e )
		        			{		        					
		        			}
		        			
		        			
		        			file_to = new File(directory, "3GCERT_AUX.txt");
		        			
		        			
		        			//FUNCION DISCRIMINA FECHA ANTERIOR A AYER
		        			@SuppressWarnings("resource")
							BufferedReader buffer = new BufferedReader(new FileReader(file));
		        			
		        			buffer.readLine();
		        			String thisLine;
		        			
		        			Date fechaActual = Calendar.getInstance().getTime();
		        			long tiempoActual = fechaActual.getTime();
		        			long unDia = 24 * 60 * 60 * 1000;
		        			Date fechaAyer = new Date(tiempoActual - unDia);	
		        			
		        			fw_to = new FileWriter(file_to,true);
		        			BufferedWriter out_to = new BufferedWriter(fw_to);
		        			
		        			
							while ((thisLine = buffer.readLine()) != null) { // while loop begins here
						        //LEER CADA LINEA Y HACER UN SPLIT
								//PARA LUEGO ENVIAR LA LINEA AL SERVIDOR
								if(thisLine != "" && thisLine != "[]" && thisLine != "\n" )
								{
																		
									String texto = thisLine.substring(thisLine.indexOf("; FECHA: ", 0) + 9,thisLine.indexOf("; INTENSIDAD: ", 0));
									fecha = (Date)formatter.parse(texto);
									
									Date fechaReg = new Date(fecha.getTime());
									
									if (fechaAyer.before(fechaReg) ){
										// GRABA REGISTO
										out_to.write("\n" + thisLine);					        			
									}
								}								
						       } // end while	
							
							//out.flush();
							
							//out.write(out_to.toString().toCharArray(), 0, out_to.toString().length());
							out = out_to;
							out_to.close();
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
		       //Toast.makeText(getApplicationContext(), contenido, Toast.LENGTH_LONG).show();

		       
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
