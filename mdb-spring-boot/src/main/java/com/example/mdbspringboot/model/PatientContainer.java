package com.example.mdbspringboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Document("patient")
public class PatientContainer {

    @Field("resourceType")
    private String resourceType;
    @Id
    @JsonProperty("pid")
    private String pid;
    @Field("Active")
    private Boolean Active;
    //  @Indexed(unique = true)
    @Field("name")
    private List<Name> name;
    @Field ("telecom")
    private List<ContactPoint> telecom;
    @Field ("gender")
    private Gender gender;
    @Field ("address")
    private List<Address> address;
    @Field ("link")
    private Link link;
    @Field ("linkcode")
    private int linkcode;
    @Field ("petName")
    private String petName;
}
