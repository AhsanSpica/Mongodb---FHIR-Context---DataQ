package com.example.mdbspringboot;


//import org.hl7.fhir.r4.model.Patient;
import com.example.mdbspringboot.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Patient")
public class PatientController  {
   private final PatientService patientService;


    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping()
    public ResponseEntity addPatient(@RequestBody Patient patient)
    {
        patientService.addPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity updatePatient(@RequestBody Patient patient)
    {
        patientService.updatePatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{Pid}")
    public ResponseEntity deletePatient(@PathVariable String Pid) {
        patientService.deletePatient(Pid);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{Pid}")
    public ResponseEntity getPatient(@PathVariable String Pid) {
        return ResponseEntity.ok(patientService.getPatient(Pid));
    }
    @GetMapping()
    public ResponseEntity testPatient() {
        return ResponseEntity.ok("Test ok reached Patient controller");
    }
    }
    //checked upto update 22-09-21
