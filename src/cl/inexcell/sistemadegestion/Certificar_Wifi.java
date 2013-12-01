package cl.inexcell.sistemadegestion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;


public class Certificar_Wifi extends Activity {
	
	String dwnload_file_path = "http://alumnos.inf.utfsm.cl/~abastias/test.jpg";
    
	@SuppressLint("SdCardPath")
	String dest_file_path = "/sdcard/test-download.png";
    Button b1;
    ProgressDialog dialog = null;
     
    public void onCreate(Bundle savedInstanceState) {
         
       super.onCreate(savedInstanceState);
       
       // Activity sin parte superior
       requestWindowFeature(Window.FEATURE_NO_TITLE);
       setContentView(R.layout.activity_certificar_wifi);
     
       
       b1 = (Button)findViewById(R.id.Button01);
       b1.setOnClickListener(new OnClickListener() {
           public void onClick(View v) {
                
               dialog = ProgressDialog.show(Certificar_Wifi.this, "", "Descargando archivo ...", true);
                new Thread(new Runnable() {
                       public void run() {
                            downloadFile(dwnload_file_path, dest_file_path);
                       }
                     }).start();               
           }
       });
    }
    
    public void downloadFile(String url, String dest_file_path) {
        try {
            File dest_file = new File(dest_file_path);
            URL u = new URL(url);
            URLConnection conn = u.openConnection();
            int contentLength = conn.getContentLength();
            DataInputStream stream = new DataInputStream(u.openStream());
            byte[] buffer = new byte[contentLength];
            stream.readFully(buffer);
            stream.close();
            DataOutputStream fos = new DataOutputStream(new FileOutputStream(dest_file));
            fos.write(buffer);
            fos.flush();
            fos.close();
            hideProgressIndicator();
             
        } catch(FileNotFoundException e) {
            hideProgressIndicator();
            return; 
        } catch (IOException e) {
            hideProgressIndicator();
            return; 
        }
  }
   
  void hideProgressIndicator(){
      runOnUiThread(new Runnable() {
          public void run() {
              dialog.dismiss();
          }
      });  
  }

	public void volver(View view) {
    	finish();
    	
    	// Vibrar al hacer click        
        Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(50);
    }
}