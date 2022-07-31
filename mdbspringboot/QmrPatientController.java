package com.example.mdbspringboot;

import ca.uhn.fhir.parser.IParser;
import com.example.mdbspringboot.model.CustomPatient;
import com.example.mdbspringboot.model.Name;
import com.example.mdbspringboot.model.PatientContainer;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.mdbspringboot.Patient;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.mdbspringboot.model.EntityType.Patient;

@RestController
@RequestMapping("/api/qmr-patient")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class QmrPatientController {

@Autowired
private QmrPatientDaoService qmrPatientDaoService;

    @GetMapping("/gettest")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity testPatient() {
        String msg = "Test ok reached Patient controller";

        return ResponseEntity.ok("Test ok reached Patient controller");
    }
    @PostMapping("/posttest")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity testPost() {
        String msg = "Test ok reached Patient controller";

        return ResponseEntity.ok("Test ok reached Patient post controller");
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public Patient savePatient(@RequestBody Patient mypatient) {
        String msg = "Test ok reached Patient controller";


        return mypatient;
    }
//    @PostMapping("/savePatient")
//    public String addMyPatient(@RequestBody Patient mypatient)
//    {
//        String result="";
//           long insertedid= qmrPatientDaoService.insert(mypatient);
//           return String.valueOf(insertedid);
//    }


}

