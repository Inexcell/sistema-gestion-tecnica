package cl.inexcell.sistemadegestion;

import java.util.Timer;
import java.util.Vector;

import android.app.ProgressDialog;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
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
import android.widget.Toast;

public class Plantas_Externas extends FragmentActivity implements SwipeInterface{

	private Fragment frag;
	private Button m,n,p;
	private int cantidad, posicion = 1;
	private String TAG = "Plantas_Externas";
	public String[] id, type, gps, addStreet, addNum, addCode,
			feasibility, site, cable, cabinet, pairFrom, pairOcup, 
			pairVacant, pairRes, pairBad;
	
	private LocationManager locManager;
	private Location loc;
	private Vector resutado;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// Activity sin parte superior
		requestWindowFeature(Window.FEATURE_NO_TITLE);		
		
		setContentView(R.layout.activity_plantas_externas);
		declararvariables();	
			
		locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		loc = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
	    
	    
		Log.i(TAG, loc.toString());
		buscar_plantas_externas();
		
		ActivitySwipeDetector swipe = new ActivitySwipeDetector(this,this);		
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction t = fm.beginTransaction();
		frag = fm.findFragmentById(R.id.fragment);
		frag.getView().setOnTouchListener(swipe);
		cambiar();
		t.commit();
			
		
	}
	
	/**Aqui se hace el request y los resultados son guardados en strings[] para cada variable**/
	public void buscar_plantas_externas(){
		
		cantidad = 4;
		id = new String[cantidad];
		type = new String[cantidad];
		gps = new String[cantidad];
		addStreet= new String[cantidad];
		addNum= new String[cantidad];
		addCode= new String[cantidad];
		feasibility= new String[cantidad];
		site= new String[cantidad];
		cable= new String[cantidad];
		cabinet= new String[cantidad];
		pairFrom= new String[cantidad];
		pairOcup= new String[cantidad];
		pairVacant= new String[cantidad];
		pairRes= new String[cantidad];
		pairBad= new String[cantidad];
		
		String[] tipos = {"Armario","Caja","Tablero"};
		for(int i = 0;i<cantidad;i++){
			id[i] = String.valueOf(i);
			type[i] = tipos[i%3];
			gps[i] = "asd "+i;
			addStreet[i]="calle "+i;
			addNum[i]="num "+i;
			addCode[i]="code "+i;
			feasibility[i]=""+i;
			site[i]="site "+i;
			cable[i]="cable "+i;
			cabinet[i]="cab "+i;
			pairFrom[i]=""+i;
			pairOcup[i]=""+i;
			pairVacant[i]=""+i;
			pairRes[i]=""+i;
			pairBad[i]=""+i;
		}
	}
	
	public void cambiar(){
		((TextView) frag.getView().findViewById(R.id.peTipo)).setText(type[posicion-1]);
		((TextView) frag.getView().findViewById(R.id.peDireccion)).setText(addStreet[posicion-1]+" "+addNum[posicion-1]);
		((TextView) frag.getView().findViewById(R.id.peFactibilidad)).setText(feasibility[posicion-1]);
		((TextView) frag.getView().findViewById(R.id.peCable)).setText(cable[posicion-1]);
		((TextView) frag.getView().findViewById(R.id.peGabinete)).setText(cabinet[posicion-1]);
		((TextView) frag.getView().findViewById(R.id.peOcupados)).setText(pairOcup[posicion-1]);
		((TextView) frag.getView().findViewById(R.id.peVacantes)).setText(pairVacant[posicion-1]);
		((TextView) frag.getView().findViewById(R.id.peReservados)).setText(pairRes[posicion-1]);
		((TextView) frag.getView().findViewById(R.id.peMalos)).setText(pairBad[posicion-1]);
		((TextView) frag.getView().findViewById(R.id.peResultados)).setText("(Resultado "+posicion+" de "+cantidad+" encontrados)");
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


}
