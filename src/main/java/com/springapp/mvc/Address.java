package com.springapp.mvc;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by honkwon on 15-10-12.
 */

@AllArgsConstructor
public class Address {
    @Getter private String city;
    @Getter private String province;
    @Getter private String country;
    @Getter private String address;
    @Getter private String postalCode;
}
