package com.journeyfy.journeyfytravelapplication;

import com.journeyfy.journeyfytravelapplication.hotels.Hotel;
import com.journeyfy.journeyfytravelapplication.hotels.HotelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@SpringBootTest
class JourneyfyTravelApplicationTests {

	@Autowired
	HotelRepository hotelRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testAddHotel() {
		Hotel hotel = new Hotel();
		hotel.setSiteAddress("yuhu");
		hotel.setRating(5.0);
		hotel.setHotelClass(4);
		hotel.setPrice(10.000);
		hotel.setPicture("picture");
		hotel.setDescription("description");
		hotel.setCityName("Colentina");
		hotel.setName("Colentinu");

		hotelRepository.save(hotel);
	}

	@Test
	public void testEditHotel() {
		Hotel hotel = hotelRepository.findById(2L).orElseThrow();
		hotel.setName("pisicoși");
		hotel.setHotelClass(5);
		hotel.setDescription("pisici-descrise");
		hotel.setPicture("picture cu pisici");
		hotel.setPrice(20000);
		hotel.setRating(5);
		hotel.setCityName("Pisicești");
		hotel.setSiteAddress("http://pisici.com");
		hotelRepository.save(hotel);
	}

	@Test
	public void testDeleteHotel() {
		Hotel hotel = hotelRepository.findById(3L).orElseThrow();
		hotelRepository.delete(hotel);
	}
}