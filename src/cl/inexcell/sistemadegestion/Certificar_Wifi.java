package cl.inexcell.sistemadegestion;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;

import org.apache.axis.AxisFault;

import cl.inexcell.sistemadegestion.webservices.OperationType;
import cl.inexcell.sistemadegestion.webservices.Prototype;
import cl.inexcell.sistemadegestion.webservices.PrototypeBindingStub;
import cl.inexcell.sistemadegestion.webservices.PrototypeLocator;
import cl.inexcell.sistemadegestion.webservices.PrototypePortType;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Certificar_Wifi extends Activity {
	
	public static final int DIALOG_DOWNLOAD_PROGRESS = 0;
    private Button startBtn;
    private ProgressDialog mProgressDialog;
    private TextView tdown;
    private TextView test;
        
    public void onCreate(Bundle savedInstanceState) {
         
	   super.onCreate(savedInstanceState);
	   
	   // Activity sin parte superior
	   requestWindowFeature(Window.FEATURE_NO_TITLE);
	   setContentView(R.layout.activity_certificar_wifi);
	   
	   tdown = (TextView)findViewById(R.id.tdown);
	   startBtn = (Button)findViewById(R.id.startBtn);
	   
	   
	   
	   /*
	   Weather w = new WeatherLocator();
	   WeatherSoap ws = new WeatherSoapStub(new URL(w.getWeatherSoapAddress()),w);
	   String zip = "97867";
	   WeatherReturn resp = ws.getCityWeatherByZIP(zip);
	   System.out.println("Ciudad: "+resp.getCity());
	   System.out.println("Temperatura: "+resp.getTemperature());
	   */
	   
	   // Implementar y aprender Web Services !!!
	   /*
	   Prototype p = new PrototypeLocator();
	   try {
		   PrototypePortType d = new PrototypeBindingStub(new URL(p.getPrototypePortAddress()),p);
		   String id ="XML-001";
		   //OperationType resp = d.customer();
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   */
	   
	   
	   ///////////////////////////////////////////////////////////////////////////////
	   
	   TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
	   
	   test = (TextView)findViewById(R.id.test);
	   test.setText("\n\nDatos Telefono:\n\nIMEI: "+telephonyManager.getDeviceId()
			   +"\nIMSI: "+telephonyManager.getSimSerialNumber());
	   
	   
	   //////////////////////////////////////////////////////////////
	   
	   startBtn.setOnClickListener(new OnClickListener(){
	       	public void onClick(View v) {
	       			
	       		startDownload();
	       		muestra_descarga(0);
		      
	       	}
       	});
    }
    
    
    private void startDownload() {
        String url = "http://alumnos.inf.utfsm.cl/~abastias/test_android/test.jpg";
        new DownloadFileAsync().execute(url);
    }
    


	@SuppressLint("SdCardPath")
	class DownloadFileAsync extends AsyncTask<String, String, String> {

        @SuppressWarnings("deprecation")
		@Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(DIALOG_DOWNLOAD_PROGRESS);
        }

        @Override
        protected String doInBackground(String... aurl) {
            int count;

        try {

        URL url = new URL(aurl[0]);
        URLConnection conexion = url.openConnection();
        conexion.connect();

        int lenghtOfFile = conexion.getContentLength();
        Log.d("ANDRO_ASYNC", "Largo del archivo: " + lenghtOfFile);

        InputStream input = new BufferedInputStream(url.openStream());
        OutputStream output = new FileOutputStream("/sdcard/test-download1.jpg");

        byte data[] = new byte[1024];

        long total = 0;
        
        	long tiempoInicio_down = System.currentTimeMillis();
        
            while ((count = input.read(data)) != -1) {
                total += count;
                publishProgress(""+(int)((total*100)/lenghtOfFile));
                output.write(data, 0, count);
            }
            
            long tiempoFin_down = System.currentTimeMillis();
            long tiempo_down = tiempoFin_down - tiempoInicio_down; 
            
            muestra_descarga(tiempo_down);

            output.flush();
            output.close();
            input.close();
        } catch (Exception e) {}
        return null;

        }
        

		protected void onProgressUpdate(String... progress) {
             Log.d("ANDRO_ASYNC",progress[0]);
             mProgressDialog.setProgress(Integer.parseInt(progress[0]));
        }

        @SuppressWarnings("deprecation")
		@Override
        protected void onPostExecute(String unused) {
            dismissDialog(DIALOG_DOWNLOAD_PROGRESS);
        }
    }
    
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case DIALOG_DOWNLOAD_PROGRESS:
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setTitle("Certificación Wifi");
            mProgressDialog.setIcon(R.drawable.ic_wifi);
            mProgressDialog.setMessage("Midiendo Descarga ...");
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgressDialog.setCancelable(true);
            mProgressDialog.show();
            return mProgressDialog;
        default:
            return null;
        }
    }
    
	public void muestra_descarga(long tiempo_down) {
			//String resultado=String.valueOf(tiempo_down);
			long size_jpg = 1065297;
			float bw;
			bw = (float)(size_jpg*8)/(float) (tiempo_down*1000);
			DecimalFormat df = new DecimalFormat("0.00");
			String res_bw = df.format(bw);
	        tdown.setText("\n\nAncho de Banda:\n\nDescarga: "+res_bw+" Mbps\nSubida: XX Mpbs");
			
		}

	public void volver(View view) {
    	finish();
    	
    	// Vibrar al hacer click        
        Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
    }
}