package com.example.mdbspringboot;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "patient", indexes = {
        @Index(name = "patient_user_id_key", columnList = "user_id", unique = true)
})
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id", nullable = false)
    private Long id;

    @Column(name = "firstName", nullable = false, length = 200)
    private String firstName;

    @Column(name = "middleName", nullable = false, length = 200)
    private String middleName;

    @Column(name = "lastName", nullable = false, length = 200)
    private String lastName;

    @Column(name = "dateOfBirth", nullable = false)
    private Instant dateOfBirth;

    @Column(name = "socialSecurityNumber", nullable = false)
    private Integer socialSecurityNumber;

    @Lob
    @Column(name = "email", nullable = false)
    private String email;

    @Lob
    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Lob
    @Column(name = "created_user", nullable = false)
    private String createdUser;

    @Column(name = "created_date", nullable = false)
    private Instant createdDate;

    @Column(name = "modified_date", nullable = false)
    private Instant modifiedDate;

    @Lob
    @Column(name = "gender", nullable = false)
    private String gender;

//    @Column(name = "dob", nullable = false)
//    private Instant dob;
//
//    @Lob
//    @Column(name = "ssn", nullable = false)
//    private String ssn;

    @Lob
    @Column(name = "marital_status", nullable = false)
    private String maritalStatus;

    @Lob
    @Column(name = "sexual_orientation", nullable = false)
    private String sexualOrientation;

    @Lob
    @Column(name = "sexual_orientation_code", nullable = false)
    private String sexualOrientationCode;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "access_restricted", nullable = false)
    private Boolean accessRestricted = false;

    @Lob
    @Column(name = "confid_contact", nullable = false)
    private String confidContact;

    @Lob
    @Column(name = "confid_contact_type", nullable = false)
    private String confidContactType;

    @Column(name = "disabled_date", nullable = false)
    private Instant disabledDate;

    @Lob
    @Column(name = "employement_status", nullable = false)
    private String employementStatus;

//    @Lob
//    @Column(name = "emrg_contact", nullable = false)
//    private String emrgContact;

    @Lob
    @Column(name = "emrg_contact_name", nullable = false)
    private String emrgContactName;

    @Lob
    @Column(name = "emrg_contact_relation", nullable = false)
    private String emrgContactRelation;

    @Lob
    @Column(name = "ethnicity", nullable = false)
    private String ethnicity;

    @Column(name = "expired_date", nullable = false)
    private Instant expiredDate;

//    @Lob
//    @Column(name = "guarantor_id", nullable = false)
//    private String guarantorId;
//
//    @Lob
//    @Column(name = "guarantor_relationship", nullable = false)
//    private String guarantorRelationship;

    @Lob
    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "patient_disabled", nullable = false)
    private Boolean patientDisabled = false;

    @Column(name = "patient_expired", nullable = false)
    private Boolean patientExpired = false;

    @ManyToOne(optional = false)
    @JoinColumn(name = "practice_id", nullable = false)
    private Practice practice;

//    @Lob
//    @Column(name = "previous_name", nullable = false)
//    private String previousName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

//    @Lob
//    @Column(name = "race", nullable = false)
//    private String race;
//
//    public String getRace() {
//        return race;
//    }
//
//    public void setRace(String race) {
//        this.race = race;
//    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

//    public String getPreviousName() {
//        return previousName;
//    }
//
//    public void setPreviousName(String previousName) {
//        this.previousName = previousName;
//    }

    public Practice getPractice() {
        return practice;
    }

    public void setPractice(Practice practice) {
        this.practice = practice;
    }

    public Boolean getPatientExpired() {
        return patientExpired;
    }

    public void setPatientExpired(Boolean patientExpired) {
        this.patientExpired = patientExpired;
    }

    public Boolean getPatientDisabled() {
        return patientDisabled;
    }

    public void setPatientDisabled(Boolean patientDisabled) {
        this.patientDisabled = patientDisabled;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

//    public String getGuarantorRelationship() {
//        return guarantorRelationship;
//    }
//
//    public void setGuarantorRelationship(String guarantorRelationship) {
//        this.guarantorRelationship = guarantorRelationship;
//    }
//
//    public String getGuarantorId() {
//        return guarantorId;
//    }
//
//    public void setGuarantorId(String guarantorId) {
//        this.guarantorId = guarantorId;
//    }

    public Instant getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Instant expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getEmrgContactRelation() {
        return emrgContactRelation;
    }

    public void setEmrgContactRelation(String emrgContactRelation) {
        this.emrgContactRelation = emrgContactRelation;
    }

    public String getEmrgContactName() {
        return emrgContactName;
    }

    public void setEmrgContactName(String emrgContactName) {
        this.emrgContactName = emrgContactName;
    }

//    public String getEmrgContact() {
//        return emrgContact;
//    }
//
//    public void setEmrgContact(String emrgContact) {
//        this.emrgContact = emrgContact;
//    }

    public String getEmployementStatus() {
        return employementStatus;
    }

    public void setEmployementStatus(String employementStatus) {
        this.employementStatus = employementStatus;
    }

    public Instant getDisabledDate() {
        return disabledDate;
    }

    public void setDisabledDate(Instant disabledDate) {
        this.disabledDate = disabledDate;
    }

    public String getConfidContactType() {
        return confidContactType;
    }

    public void setConfidContactType(String confidContactType) {
        this.confidContactType = confidContactType;
    }

    public String getConfidContact() {
        return confidContact;
    }

    public void setConfidContact(String confidContact) {
        this.confidContact = confidContact;
    }

    public Boolean getAccessRestricted() {
        return accessRestricted;
    }

    public void setAccessRestricted(Boolean accessRestricted) {
        this.accessRestricted = accessRestricted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSexualOrientationCode() {
        return sexualOrientationCode;
    }

    public void setSexualOrientationCode(String sexualOrientationCode) {
        this.sexualOrientationCode = sexualOrientationCode;
    }

    public String getSexualOrientation() {
        return sexualOrientation;
    }

    public void setSexualOrientation(String sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

//    public String getSsn() {
//        return ssn;
//    }
//
//    public void setSsn(String ssn) {
//        this.ssn = ssn;
//    }
//
//    public Instant getDob() {
//        return dob;
//    }
//
//    public void setDob(Instant dob) {
//        this.dob = dob;
//    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Instant getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public Integer getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(Integer socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Instant getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Instant dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}