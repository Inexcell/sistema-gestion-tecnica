package cl.inexcell.sistemadegestion;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class Notificar_Averias extends Activity {
	
	private String observacion, objeto;
	private ArrayList<String> res;
	
	private Bitmap foto;
	private Spinner s;
	private EditText et;
	
	
	@SuppressWarnings("unused")
	private ImageButton ib;
	
	@SuppressWarnings("unused")
	private String TAG = "Localizar Avería";
	
	@SuppressWarnings("unused")
	private Bitmap b = null, bmini = null;
	private static int TAKE_PICTURE = 1;
	private static int SELECT_PICTURE = 2;
	final CharSequence[] opcionCaptura = {
    		"Tomar Fotografía"
    };
	final CharSequence[] SpinnerText = {
    		"Cable", "Armario","Caja","Tablero"
    };
	private String name = "";
	private LocationManager locManager;
	private Location loc;
	private String Lat,Lng;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		// Activity sin parte superior
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_notificar_averias);
		
		locManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		loc = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		Log.i("LOCALIZACION", loc.getLatitude()+"\n"+loc.getLongitude());
		if(loc != null){
			Lat = String.valueOf(loc.getLatitude());
			Lng = String.valueOf(loc.getLongitude());
		}
		s = (Spinner) findViewById(R.id.Spinner02);
		et = (EditText) findViewById(R.id.editText1);
		ib = (ImageButton) findViewById(R.id.ibtnImagen);
		name = Environment.getExternalStorageDirectory() + "/test.jpg";
	}
	
	/** Boton Guardar Información **/
	public void guardarInformacion (View view){
		
		if(et.getText().toString().compareTo("") == 0){
			Toast.makeText(getApplicationContext(), "Debe ingresar una observación.", Toast.LENGTH_LONG).show();
			return;
		}
		if(b == null){
			Toast.makeText(getApplicationContext(), "Debe tomar fotografía.", Toast.LENGTH_LONG).show();
			return;
		}
		
		observacion = et.getText().toString();
		objeto = SpinnerText[s.getSelectedItemPosition()].toString();
		foto = b;
		
		//Enviar_Averia ea = new Enviar_Averia();
		//ea.execute();
		Drawable d = new BitmapDrawable(getResources(), foto);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(" ");
        builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {//un listener que al pulsar, cierre la aplicacion
	          @Override
	          public void onClick(DialogInterface dialog, int which){
	            //Salir
	          	return;
	          }
	        });
        builder.setMessage("Tipo: "+SpinnerText[s.getSelectedItemPosition()]+"\nObservación: "+et.getText()+"\n\n¿Todo Correcto?");
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {//un listener que al pulsar, cierre la aplicacion
	          @Override
	          public void onClick(DialogInterface dialog, int which){
	            
	          	//Toast.makeText(getApplicationContext(), "BIEN", Toast.LENGTH_LONG).show();
	          	Enviar_Averia ea = new Enviar_Averia();
	    		ea.execute();
	    		
	          }
	        });
        
        builder.setIcon(d);
        
        AlertDialog alert = builder.create();
        alert.show();
	}
	
	/** Botón Cámara **/
	public void capturarImagen(View view){
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Escoja una Opcion:");
        builder.setIcon(R.drawable.ic_camera);
        builder.setItems(opcionCaptura, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
            	Intent intent =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            	int code = TAKE_PICTURE;
            	if (item==TAKE_PICTURE) {            		
            	    Uri output = Uri.fromFile(new File(name));
            	    intent.putExtra(MediaStore.EXTRA_OUTPUT, output);
            	} else if (item==SELECT_PICTURE){
            	    intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            	    code = SELECT_PICTURE;
            	}
            	startActivityForResult(intent, code);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
	}
	
	@Override 
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (requestCode == TAKE_PICTURE) {
	    	if (data != null) {
	    		if (data.hasExtra("data")) {
	    		    b = (Bitmap) data.getParcelableExtra("data");
	    		}
	    	} else {
	    			b = BitmapFactory.decodeFile(name);
	    			
	    		}
	    } else if (requestCode == SELECT_PICTURE){
	    	Uri selectedImage = data.getData();
	    	InputStream is;
	    	try {
	    	    is = getContentResolver().openInputStream(selectedImage);
	    	    BufferedInputStream bis = new BufferedInputStream(is);
	    	    b = BitmapFactory.decodeStream(bis);
	    	    
	    	} catch (FileNotFoundException e) {}
	    }
	    bmini = Bitmap.createScaledBitmap(b, 64, 64, true);
	    
	    
	}
	
	/** Boton Volver **/
	public void volver(View view) {
    	finish();
    	
    	// Vibrar al hacer click        
        Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
    }
	
private class Enviar_Averia extends AsyncTask<String,Integer,String> {
   		
   		private final ProgressDialog dialog = new ProgressDialog(Notificar_Averias.this);
   		
 		protected void onPreExecute() {
 			this.dialog.setMessage("Enviando Avería Localizada...");
 		    this.dialog.show();
             //super.onPreExecute();
         }
   		 
   	    protected String doInBackground(String... params) {
   	    	
 			String respuesta = null;
   			
   			try 
   			{
   				TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
   				String IMEI = telephonyManager.getDeviceId();
   				String IMSI =  telephonyManager.getSimSerialNumber();
   				
   				respuesta = SoapRequestMovistar.setLocation(String.valueOf(foto),
   																objeto,   																
   																Lat,
   																Lng,
   																observacion,
   																IMEI,
   																IMSI);
   				
   			} catch (Exception e1) {
   				e1.printStackTrace();
   			}

   	        return respuesta;
   	    }
   	    

 		protected void onPostExecute(String result) {
 			
 			if (this.dialog.isShowing()) {
 		        this.dialog.dismiss();
 		     }
   			
   	    	if (result != null)
   	    	{
   	    		try {
   	    			//ArrayList<String> res = XMLParser.getVendor(result);
   	    			res = XMLParser.setLocation(result);
   	    			Toast.makeText(getApplicationContext(), res.get(1), Toast.LENGTH_LONG).show();
   	    			et.setText("");
   	    			b = foto = null;
   	    			//final CharSequence[] fab = res.toArray(new CharSequence[res.size()]);
   	    			//ListarFabricantesBandaAncha(fab);
   	    			
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
   	    	}
   	    	else
   	    	{
   	    		//test_wsdl.setText("Error!");
   	    		//Toast.makeText(getApplicationContext(), "Error en la conexión del servicio. Revise su conexión de Internet o 3G.", Toast.LENGTH_LONG).show();
   	    	}
   	    }
   	}

}
