package com.revature.models;

import lombok.*;

/*
* lombok is a dependency that allows us to abstract away boilerplate code like getters and setters in models
* */

@AllArgsConstructor
@NoArgsConstructor
/*@Getter
@Setter
@ToString*/
@Data
public class User {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
}
