package com.greg.test.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


//http://localhost:8080/swagger2-demo/v2/api-docs
//http://localhost:8080/swagger2-demo/swagger-ui.html

@RestController
@Api(value="Hello Greeting")
public class HelloController {


    private static final String template = "Hello again v3, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/greeting", method = RequestMethod.GET)
    @ApiOperation(value = "Greet a user",response = Greeting.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    public Greeting greeting(@RequestParam(value="firstName", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(value="/greeting", method = RequestMethod.POST)
    @ApiOperation(value = "Greet a user",response = Greeting.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    public Greeting greetingPost(@RequestBody(required = true) Name name ) {
        return new Greeting(counter.incrementAndGet(),
                            name.toString());
    }
}
