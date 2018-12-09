package com.akoca.mvc.model;

import javax.validation.constraints.*;

public class Customer {

    private String firstName;

    @NotNull(message = "required")
    @Size(min = 1 , max = 15 , message = "outside allowed size")
    private String lastName;

    @NotNull(message = "required")
    @Min(value = 0 , message = "must be non-negative")
    @Max(value = 20 , message = "must be <= 20")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}" , message = "must be 5 chars , only alpha chars and digits allowed")
    private String postalCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
