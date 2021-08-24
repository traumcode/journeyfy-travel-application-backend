package com.journeyfy.journeyfytravelapplication.hotels;

import com.journeyfy.journeyfytravelapplication.posts.Post;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@DynamicUpdate
@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    @Id
    @SequenceGenerator(
            name = "hotel_sequence",
            sequenceName = "hotel_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "hotel_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String name;
    private double hotelClass;
    private String pictureLink;
    private String description;
    private double price;
    private double rating;
    private String cityName;
    private String siteLink;
}