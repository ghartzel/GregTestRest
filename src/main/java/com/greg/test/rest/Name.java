package com.greg.test.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="GreetingName")
@JsonRootName(value = "user")
public class Name {
	@ApiModelProperty(value="firstName", required = true, example = "Greg")
	@JsonProperty("firstName")
	private String name;

    public Name(String name) {
        this.name = name;
    }
    
    public Name() {
    }


    public void setName(String name) {
    	this.name=name;
    }

    public String getName() {
        return name;
    }
    public String toString() {
    	return name;
    }
}
