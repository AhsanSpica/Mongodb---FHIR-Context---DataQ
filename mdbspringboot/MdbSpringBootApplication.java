package com.example.mdbspringboot;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import org.hl7.fhir.r4.model.Location.LocationStatus;
import org.hl7.fhir.r4.model.Type;
import org.hl7.fhir.r4.model.Enumerations;
import org.json.JSONException;
import org.json.JSONObject;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Practitioner;
import com.example.mdbspringboot.model.ContactPoint;
import com.example.mdbspringboot.model.Encounter;
import org.hl7.fhir.r5.model.*;

//import com.example.mdbspringboot.model.*;

import org.hl7.fhir.r4.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.hl7.fhir.r5.model.ContactPoint.ContactPointSystem.PHONE;
import static org.hl7.fhir.r5.model.ContactPoint.ContactPointUse.HOME;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.client.discovery.DiscoveryClient;

@SpringBootApplication
@EnableMongoRepositories

@EnableAutoConfiguration()
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@EnableEurekaClient
public class MdbSpringBootApplication{

	public static void main(String[] args) {
		SpringApplication.run(MdbSpringBootApplication.class, args);
	}

}

