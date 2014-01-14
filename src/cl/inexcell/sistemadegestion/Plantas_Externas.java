package cl.inexcell.sistemadegestion;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Plantas_Externas extends FragmentActivity implements SwipeInterface{

	private ArrayList<String> res;
	private Fragment frag;
	@SuppressWarnings("unused")
	private Button m,n,p;
	private int cantidad, posicion = 1;
	@SuppressWarnings("unused")
	private String TAG = "Plantas_Externas";
	public String[] id, type, gps, addStreet, addNum, addCode,
			feasibility, site, cable, cabinet, pairFrom, pairOcup, 
			pairVacant, pairRes, pairBad;
	
	private LocationManager locManager;
	private Location loc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// Activity sin parte superior
		requestWindowFeature(Window.FEATURE_NO_TITLE);		
		
		setContentView(R.layout.activity_plantas_externas);
			
			
		locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		loc = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		Log.i("LOCALIZACION", loc.getLatitude()+"\n"+loc.getLongitude());
		Consulta_P_Externas cpe = new Consulta_P_Externas();
		cpe.execute();
		declararvariables();
		//buscar_plantas_externas();
		ActivitySwipeDetector swipe = new ActivitySwipeDetector(this,this);		
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction t = fm.beginTransaction();
		frag = fm.findFragmentById(R.id.fragment);
		frag.getView().setOnTouchListener(swipe);
		
		if(cantidad != 0){
			
			cambiar();
			
		}
		else{
			cambiar(true);
			
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
	        builder.setTitle("Error:");
	        builder.setMessage(res.get(0).split(";")[1].split(": ")[1]);
	        builder.setIcon(android.R.drawable.ic_dialog_alert);
	        builder.setPositiveButton("Salir", new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int item) {
	            	finish();
	            }
	        });
	        AlertDialog alert = builder.create();
	        alert.show();
		}
		
		t.commit();
			
			
		
	}
	
//	/**Aqui se hace el request y los resultados son guardados en strings[] para cada variable**/
//	public void buscar_plantas_externas(){
//				
//		id = new String[cantidad];
//		type = new String[cantidad];
//		gps = new String[cantidad];
//		addStreet= new String[cantidad];
//		addNum= new String[cantidad];
//		addCode= new String[cantidad];
//		feasibility= new String[cantidad];
//		site= new String[cantidad];
//		cable= new String[cantidad];
//		cabinet= new String[cantidad];
//		pairFrom= new String[cantidad];
//		pairOcup= new String[cantidad];
//		pairVacant= new String[cantidad];
//		pairRes= new String[cantidad];
//		pairBad= new String[cantidad];
//		
//		String[] tipos = {"Armario","Caja","Tablero"};
//		for(int i = 0;i<cantidad;i++){
//			id[i] = String.valueOf(i);
//			type[i] = tipos[i%3];
//			gps[i] = "asd "+i;
//			addStreet[i]="calle ";
//			addNum[i]="#"+i;
//			addCode[i]="code "+i;
//			feasibility[i]=""+i;
//			site[i]="site "+i;
//			cable[i]="Valor Cable "+i;
//			cabinet[i]="Valor Gabinete "+i;
//			pairFrom[i]=""+i;
//			pairOcup[i]=""+i;
//			pairVacant[i]=""+i;
//			pairRes[i]=""+i;
//			pairBad[i]=""+i;
//		}
//	}
	
	public void cambiar(){
		String[] datos = res.get(posicion).split(";");
		((TextView) frag.getView().findViewById(R.id.peTipo)).setText(datos[1]);//1		
		((TextView) frag.getView().findViewById(R.id.peDireccion)).setText(datos[4]);//4+5+6
		((TextView) frag.getView().findViewById(R.id.peFactibilidad)).setText(datos[7]);//7+8+9
		((TextView) frag.getView().findViewById(R.id.peCable)).setText(datos[11]);//11
		((TextView) frag.getView().findViewById(R.id.peGabinete)).setText(datos[12]);//12
		((TextView) frag.getView().findViewById(R.id.peOcupados)).setText(datos[15]);//15
		((TextView) frag.getView().findViewById(R.id.peVacantes)).setText(datos[16]);//16
		((TextView) frag.getView().findViewById(R.id.peReservados)).setText(datos[17]);//17
		((TextView) frag.getView().findViewById(R.id.peMalos)).setText(datos[18]);//18
		((TextView) frag.getView().findViewById(R.id.peResultados)).setText("(Resultado "+posicion+" de "+cantidad+" encontrados)");
	}
	public void cambiar(Boolean vacio){
		((TextView) frag.getView().findViewById(R.id.peTipo)).setText("--");
		((TextView) frag.getView().findViewById(R.id.peDireccion)).setText("--");
		((TextView) frag.getView().findViewById(R.id.peFactibilidad)).setText("--");
		((TextView) frag.getView().findViewById(R.id.peCable)).setText("--");
		((TextView) frag.getView().findViewById(R.id.peGabinete)).setText("--");
		((TextView) frag.getView().findViewById(R.id.peOcupados)).setText("--");
		((TextView) frag.getView().findViewById(R.id.peVacantes)).setText("--");
		((TextView) frag.getView().findViewById(R.id.peReservados)).setText("--");
		((TextView) frag.getView().findViewById(R.id.peMalos)).setText("--");
		((TextView) frag.getView().findViewById(R.id.peResultados)).setText("--");
		p.setEnabled(false);
		n.setEnabled(false);
		
	}
	
	public void next (View v){
		posicion++;
		if(posicion == cantidad)
			n.setEnabled(false);
		if(posicion > 1)
			p.setEnabled(true);
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction t = fm.beginTransaction();
		frag = fm.findFragmentById(R.id.fragment);
		t.hide(frag);
		cambiar();
		t.show(frag);
		t.commit();
	}
	
	public void prev (View v){
		posicion--;
		if(posicion == 1)
			p.setEnabled(false);
		if(posicion < cantidad)
			n.setEnabled(true);
		
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction t = fm.beginTransaction();
		frag = fm.findFragmentById(R.id.fragment);
		t.hide(frag);
		cambiar();
		t.show(frag);
		t.commit();
	}
	public void declararvariables (){
		n = (Button) findViewById(R.id.siguiente);
		p = (Button) findViewById(R.id.anterior);
		p.setEnabled(false);
		if(cantidad == 1)
			n.setEnabled(false);
		
	}
	
	@Override
	public void onLeftToRight(View v) {
		// TODO Auto-generated method stub
		if(posicion>1){
			p.performClick();			
		}
	}

	@Override
	public void onRightToLeft(View v) {
		// TODO Auto-generated method stub
		if(posicion < cantidad){
			this.n.performClick();
		}
	}
	
	
	public void volver(View view) {
    	finish();
    	
    	// Vibrar al hacer click        
        Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
    }
	
private class Consulta_P_Externas extends AsyncTask<String,Integer,String> {
   		
   		private final ProgressDialog dialog = new ProgressDialog(Plantas_Externas.this);
   		
 		protected void onPreExecute() {
 			this.dialog.setMessage("Consultando Plantas Externas Cercanas");
 		    this.dialog.show();
             //super.onPreExecute();
 		    	TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
				String IMEI = telephonyManager.getDeviceId();
				String IMSI =  telephonyManager.getSimSerialNumber();
				
				String respuesta = null;
				try {
					respuesta = SoapRequestMovistar.getNeighborNode(String.valueOf(loc.getLatitude()),
																	String.valueOf(loc.getLongitude()),
																	IMEI,
																	IMSI);
					res = XMLParser.getNeighborNode(respuesta);
					//res.add("810768;ARMARIO;-33.5435;-70.5737;AV SANTA AMALIA;null;18355;null;null;null;SINE;3;null;1939;1964;2;15;9;0");
					cantidad = res.size()-1;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
         }
   		 
   	    protected String doInBackground(String... params) {
   	    	
 			String respuesta = null;
   			
   			try 
   			{
//   				TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
//   				String IMEI = telephonyManager.getDeviceId();
//   				String IMSI =  telephonyManager.getSimSerialNumber();
//   				
//   				respuesta = SoapRequestMovistar.getNeighborNode(String.valueOf(loc.getLatitude()),
//   																String.valueOf(loc.getLongitude()),
//   																IMEI,
//   																IMSI);
//   				res = XMLParser.getNeighborNode(respuesta);
//   				cantidad = res.size()-1;
   				
   				
   			} catch (Exception e1) {
   				e1.printStackTrace();
   			}

   	        return respuesta;
   	    }
   	    

 		protected void onPostExecute(String result) {
 			
 			if (this.dialog.isShowing()) {
 		        this.dialog.dismiss();
 		     }
   	    }
   	}


}
