package com.ibridotechnologies.billingapp.getJson.spinnerstate;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by Rahul on 22-Jul-18.
 */

public class JSONDownloaderSP extends AsyncTask<Void,Void,String> {

        Context c;
        String jsonURL;
        Spinner sp,spinnerDistrict;
        ProgressDialog pg;

    public JSONDownloaderSP(Context c, String jsonURL, Spinner sp, Spinner spinnerDistrict, ProgressDialog pg) {
        this.c = c;
        this.jsonURL = jsonURL;
        this.sp = sp;
        this.spinnerDistrict = spinnerDistrict;
        this.pg = pg;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... voids) {
        return download();
    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);

        if(jsonData.toString().startsWith("Error")){
            String error = jsonData;
            Toast.makeText(c,error, Toast.LENGTH_SHORT).show();
        }
        else{
            //PARSE
            Log.w("Download State JSON",jsonData);
            new JSONParser(c,jsonData,sp,spinnerDistrict,pg).execute();
        }
    }

    private String download(){
        Object connection= Connector.connect(jsonURL);
        if(connection.toString().startsWith("Error")){
            return connection.toString();
        }

        try{
            HttpURLConnection con = (HttpURLConnection) connection;
            if(con.getResponseCode()==con.HTTP_OK){
                //Get input from stream
                InputStream is=new BufferedInputStream(con.getInputStream());
                BufferedReader br =new BufferedReader(new InputStreamReader(is));

                String line;
                StringBuffer jsonData=new StringBuffer();

                //READ
                while ((line=br.readLine()) != null) {
                    jsonData.append(line+"\n");
                }

                //CLOSE RESOURCES
                br.close();
                is.close();

                //RETURN JSON
                return jsonData.toString();
            }
            else {
                return "Error "+con.getResponseMessage();
            }
        }
        catch (IOException e){
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
    }
}
