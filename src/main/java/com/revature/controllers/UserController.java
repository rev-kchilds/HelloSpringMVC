package com.revature.controllers;

import com.revature.models.JsonResponse;
import com.revature.models.User;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
* What is Spring MVC?
*   We use the spring mvc module for manipulating the http requests and responses
*
*   @Controller - stereotype to reference this is a controller bean
*       @RestController - stereotype that guarantees every endpoint returns a json response
*   @RequestMapping - specifies our endpoint and determines the http verb.
*       @GetMapping
*       @PostMapping
*       etc...
*   @ResponseBody - converts the return of the object to a json string using jackson under the hood
*   @RequestBody - converts the json string from the body to an object
*
*   @PathVariable - to retrieve path parameters from the uri
*
*   @RequestParam:
*       - retrieve query parameters
*       - retrieve form data
*
*
*
* http verbs and what they are typically used for:
*   - GET - retrieving something from a datasource
*   - POST - creating something to put in the db
*   -
* */

@RestController
@RequestMapping(value = "api")
public class UserController {


    //http://localhost:9000/HelloSpringMVC/api/user
    //@ResponseBody
    @GetMapping("user")
    public JsonResponse getAllUsers(){
        List<User> users = new ArrayList<>();

        users.add(new User("kev123", "pass123", "Kevin", "Childs"));
        users.add(new User("Michael123", "pass123", "Michael", "Lee"));
        users.add(new User("Joshua123", "pass123", "Joshua", "Cho"));

        return new JsonResponse(true, "retrieving all users", users);
    }

    @PostMapping("user")
    public JsonResponse createUser(@RequestBody User user){
        String reversedName = new StringBuilder(user.getUsername()).reverse().toString();
        user.setUsername(reversedName);
        return new JsonResponse(true, "user created", user);
    }

    //What is a path param?
    /*
    * http://localhost:9000/HelloSpringMVC/api/user/3   <---- the id is the path parameter
    *
    * as long as the value in the {} matches the variable name after @PathVariable, it will make the connection.
    * */
    @GetMapping("user/{id}/{cheese}")
    public JsonResponse getOneUser(@PathVariable Integer id, @PathVariable String cheese){
        return new JsonResponse(true, "just return the path param id sent", id);
    }


    //What is a Query param?

    /*
    * http://localhost:9000/HelloSpringMVC/api/user?id=3
    * */

    @GetMapping("user/queryparamexample")
    public JsonResponse queryParamExample(@RequestParam Integer id){
        return new JsonResponse(true, "just return the query param id sent", id);
    }


    /*
    * form endpoint
    *
    * the variables names are matching the form keys in postman
    * */
    @PostMapping("user/form")
    public JsonResponse formExample(@RequestParam String username, @RequestParam String password){
        User user = new User(username, password, null, null);

        return new JsonResponse(true, "user that was sent from a form", user);
    }





}
