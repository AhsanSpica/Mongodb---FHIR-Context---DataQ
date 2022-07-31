package com.example.mdbspringboot;
import org.mitre.hapifhir.BackendAuthorizationInterceptor;
import org.mitre.hapifhir.SMARTServerCapabilityStatementProvider;
//import com.example.mdbspringboot.model.Patient;
import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.server.IResourceProvider;
import ca.uhn.fhir.rest.server.RestfulServer;
import com.example.mdbspringboot.model.CustomPatient;
import com.example.mdbspringboot.model.Name;
import com.example.mdbspringboot.model.PatientContainer;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r5.model.Patient;
//import ca.uhn.fhir.rest.annotation.IdParam;
//import ca.uhn.fhir.rest.annotation.Read;
//import ca.uhn.fhir.rest.annotation.RequiredParam;
//import ca.uhn.fhir.rest.annotation.Search;
//import ca.uhn.fhir.rest.param.StringParam;
//import ca.uhn.fhir.rest.server.IResourceProvider;
//import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
//import org.hl7.fhir.dstu2.model.IdType;
//import org.hl7.fhir.instance.model.api.IBaseResource;
//import org.hl7.fhir.r5.model.Patient;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.mitre.hapifhir.BackendAuthorizationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.ServletException;
import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/api/custompatient")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
//@RequiredArgsConstructor
public class CustomController extends RestfulServer {
    // private final PatientService patientService;
    FhirContext ctx = FhirContext.forR4();

    @Override
    protected void initialize()throws ServletException {

        super.initialize();
     //   BackendAuthorizationInterceptor authorizationInterceptor =
              //  new BackendAuthorizationInterceptor(HapiProperties.getAuthServerCertsAddress());
     //   this.registerInterceptor(authorizationInterceptor);
    }

    //  @Autowired
    // public PatientController(PatientService patientService) {
    //     this.patientService = patientService;
    // }
    @GetMapping("/get-test")
    public ResponseEntity testPatient() {
        return ResponseEntity.ok("Test ok reached Patient controller");
    }
    @PostMapping()
    public PatientContainer addMyPatient(@RequestBody PatientContainer mypatient)
    {
        return mypatient;
    }
//    @PostMapping()
//    public String addMyPatient(@RequestBody PatientContainer mypatient)
//    {
//        String serverBase = "http://fhir.dataqhealth.com/fhir";
//
//        FhirApiReq far = new FhirApiReq();
//        IParser jsonparser = this.ctx.newJsonParser();
//        CustomPatient cusPatObj= new CustomPatient();
//        cusPatObj.setPetName(new StringType(mypatient.getPetName()));
//        HumanName hname = new HumanName();
//        List<StringType> namel = new ArrayList<StringType>();
//        List<Name> lname= mypatient.getName();
//        for(int i =0; i<lname.size(); i++){
//           namel.add(new StringType( lname.get(i).given.toString()));
//        }
//        hname.setUse(HumanName.NameUse.OFFICIAL);
//        hname.setGiven(namel);
//        cusPatObj.setName(Arrays.asList(hname));
//    //    cusPatObj.setAddress(mypatient.getAddress());
//    //    cusPatObj.setGender(mypatient.getGender());
//      //  cusPatObj.setTelecom(mypatient.getTelecom());
//        String serOrg = jsonparser.encodeResourceToString(cusPatObj);
//
//        String result= far.ApiPostJson(serOrg, "Patient");
//
//      //  return ResponseEntity.status(HttpStatus.CREATED).build();
//       return result;
//    }



    //  @GetMapping("/{Pid}")
    //  public ResponseEntity getPatient(@PathVariable String Pid) {
    //   return ResponseEntity.ok(patientService.getPatient(Pid));
    // }


    @GetMapping("/getPetName/{id}")
    public String getPatientPetName(@PathVariable Long id) {
        JSONObject subJson =null;
        String result = "";
        CustomPatient patient = new CustomPatient();
        try {
                FhirApiReq far = new FhirApiReq();
                JSONObject jsonres = far.ApiGetJson(id, "Patient");
            System.out.println("success after api request: "+jsonres);
            String ext = jsonres.getString("extension");
            subJson= new JSONObject(ext.substring(ext.indexOf("{"), ext.lastIndexOf("}") + 1));
            String pet = subJson.getString("valueString");
            System.out.println("success after api request pet: "+pet);

              patient.setPetName(new StringType(pet));
            IParser jsonparser = this.ctx.newJsonParser();
            result = jsonparser.encodeResourceToString(patient);
            }
            catch (Exception ex){

                System.out.println("error from message : "+ex);
            }

        // return ResponseEntity.status(HttpStatus.CREATED).build();

        return result;
        //  return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, jsonResult);
        // return Response.status(ok).entity(""+jsonResult+"").build();

        //     return ResponseEntity.created(uri)
        //              .body(createdStudent);
    }


    @PostMapping("/posthard")
    public String getPatient() {
        int ok = 200;
        CustomPatient patient = new CustomPatient();
        patient.setPetName(new StringType("Fido"));
        patient.getImportantDates().add(new DateTimeType("2010-01-02"));
        patient.getImportantDates().add(new DateTimeType("2014-01-26T11:11:11"));
        patient.addName().setFamily("Smith").addGiven("John").addGiven("Quincy").addSuffix("Jr");

        FhirApiReq far = new FhirApiReq();
        IParser jsonparser = this.ctx.newJsonParser();
        String serOrg = jsonparser.encodeResourceToString(patient);
        String result=far.ApiPostJson(serOrg, "Patient");
       // return ResponseEntity.status(HttpStatus.CREATED).build();
   //     URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                //.path("/{id}")
    //            .buildAndExpand(id)
    //            .toUri();
        return result;
      //  return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, jsonResult);
       // return Response.status(ok).entity(""+jsonResult+"").build();

        //     return ResponseEntity.created(uri)
  //              .body(createdStudent);
    }


}
//checked upto update 22-09-21


