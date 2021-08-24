package com.journeyfy.journeyfytravelapplication.hotels;

import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    private Long id;
    private String name;
    private double hotelClass;
    private String picture;
    private String description;
    private double price;
    private double rating;
    private String cityName;
    private String siteAddress;
}