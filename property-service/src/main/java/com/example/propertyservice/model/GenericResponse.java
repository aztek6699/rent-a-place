package com.example.propertyservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class GenericResponse implements Serializable {

    Boolean isSuccess;
    String msg;
    int respCode;
    List<?> respData;
}
