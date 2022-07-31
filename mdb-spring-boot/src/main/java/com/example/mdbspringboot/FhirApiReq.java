package com.example.mdbspringboot;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;

public class FhirApiReq {


    public String ApiPost(String serOrg,String ResourceType )
    {
        String result ="1";
        try{
            HttpClient httpClient    = HttpClientBuilder.create().build();
            HttpPost postreq = new HttpPost("http://fhir.dataqhealth.com/fhir/"+ResourceType);
            StringEntity postingString = new StringEntity(serOrg, ContentType.APPLICATION_JSON);
            postreq.setEntity(postingString);
            HttpResponse response = httpClient.execute(postreq);
            InputStream is = response.getEntity().getContent();
            Reader reader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder builder = new StringBuilder();
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        builder.append(line);
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String tempbuilder= builder.toString();
            JSONObject myResponse =  new JSONObject(tempbuilder.substring(tempbuilder.indexOf("{"), tempbuilder.lastIndexOf("}") + 1));
            System.out.println("success after api request: "+tempbuilder);
            result=myResponse.getString("id");
        }
        catch (ClientProtocolException | JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public boolean ApiGet(String ident,String ResourceType )
    {
        String result ="1";
        boolean found =false;
        int total=0;
        try{
            HttpClient httpClient    = HttpClientBuilder.create().build();
            HttpGet getreq = new HttpGet("http://fhir.dataqhealth.com/fhir/"+ResourceType+"?identifier="+ident);
            HttpResponse response = httpClient.execute(getreq);
            InputStream is = response.getEntity().getContent();
            Reader reader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder builder = new StringBuilder();
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        builder.append(line);
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String tempbuilder= builder.toString();
            JSONObject myResponse =  new JSONObject(tempbuilder.substring(tempbuilder.indexOf("{"), tempbuilder.lastIndexOf("}") + 1));
            System.out.println("success after api request: "+tempbuilder);
            total=Integer.parseInt(myResponse.getString("total"));
            if (total>0)
            {
                found=true;
            }
            else { found=false;}
        }
        catch (ClientProtocolException | JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return found;
    }
    public JSONObject ApiGetJson(Long id,String ResourceType )
    {
        String result ="1";
        JSONObject myResponse =null;
        String tempbuilder="";
        try{
            HttpClient httpClient    = HttpClientBuilder.create().build();
            HttpGet getreq = new HttpGet("http://fhir.dataqhealth.com/fhir/"+ResourceType+"/"+id);
            HttpResponse response = httpClient.execute(getreq);
            InputStream is = response.getEntity().getContent();
            Reader reader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder builder = new StringBuilder();
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        builder.append(line);
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            tempbuilder= builder.toString();
            myResponse =  new JSONObject(tempbuilder.substring(tempbuilder.indexOf("{"), tempbuilder.lastIndexOf("}") + 1));
            System.out.println("success after api request: "+tempbuilder);
            result=myResponse.getString("id");
        }
        catch (ClientProtocolException | JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myResponse;
    }
    public String ApiPostJson(String serOrg,String ResourceType )
    {
        String result ="1";
        JSONObject myResponse =null;

        String tempbuilder="";
        try{
            HttpClient httpClient    = HttpClientBuilder.create().build();
            HttpPost postreq = new HttpPost("http://fhir.dataqhealth.com/fhir/"+ResourceType);
            StringEntity postingString = new StringEntity(serOrg, ContentType.APPLICATION_JSON);
            postreq.setEntity(postingString);
            HttpResponse response = httpClient.execute(postreq);
            InputStream is = response.getEntity().getContent();
            Reader reader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuilder builder = new StringBuilder();
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        builder.append(line);
                    } else {
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
             tempbuilder= builder.toString();
             myResponse =  new JSONObject(tempbuilder.substring(tempbuilder.indexOf("{"), tempbuilder.lastIndexOf("}") + 1));
            System.out.println("success after api request: "+tempbuilder);


        }
        catch (ClientProtocolException | JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempbuilder;
    }

}
