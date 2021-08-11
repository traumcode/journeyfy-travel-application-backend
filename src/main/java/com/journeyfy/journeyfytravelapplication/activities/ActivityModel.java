package com.journeyfy.journeyfytravelapplication.activities;


import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ActivityModel {
    private Long id;
    private String pictureLink;
    private String name;
    private String description;
    private double rating;
    private double price;
    private String cityName;

}
