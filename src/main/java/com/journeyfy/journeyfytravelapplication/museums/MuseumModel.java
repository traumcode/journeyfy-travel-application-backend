package com.journeyfy.journeyfytravelapplication.museums;
import lombok.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MuseumModel {
    private Long id;
    private String pictureLink;
    private String name;
    private String description;
    private double rating;
    private double price;
    private String cityName;
    private String siteLink;
}
