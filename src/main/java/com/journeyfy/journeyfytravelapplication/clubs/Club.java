package com.journeyfy.journeyfytravelapplication.clubs;

import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Club {
    private Long id;
    private String name;
    private String address;
    private String cityName;
    private String description;
    private String pictureLink;
    private double rating;
}
