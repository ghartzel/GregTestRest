package com.greg.test.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="GreetingName")
@JsonRootName(value = "namegreet")
public class Greeting {
	@ApiModelProperty(name="nameId", value="nameId", required = true, example = "1")
    private final long id;
    @ApiModelProperty(name="firstName", value="firstName", required = true, example = "Greg")
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty("nameID")
    public long getId() {
        return id;
    }

    @JsonProperty("firstName")
    public String getContent() {
        return content+" Hello v9";
    }
}
