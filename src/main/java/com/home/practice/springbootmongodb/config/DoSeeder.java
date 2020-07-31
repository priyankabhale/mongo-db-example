package com.home.practice.springbootmongodb.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.home.practice.springbootmongodb.document.Address;
import com.home.practice.springbootmongodb.document.Hotel;
import com.home.practice.springbootmongodb.document.Review;
import com.home.practice.springbootmongodb.repositories.HotelRepository;

@Component
public class DoSeeder implements CommandLineRunner {

	private HotelRepository repo;

	public DoSeeder(HotelRepository repo) {
		this.repo = repo;
	}

	@Override
	public void run(String... args) throws Exception {
		Hotel mariot = new Hotel("Mariot", 400, new Address("Paris", "France"),
				Arrays.asList(new Review("John", 8, false), new Review("Kit", 10, false)));

		Hotel ibis = new Hotel("Ibis", 90, new Address("Buchares", "Romania"),
				Arrays.asList(new Review("Teddy", 8, false)));

		Hotel sofitel = new Hotel("Sofitel", 80, new Address("Rome", "Italy"), new ArrayList<>());

//		drop all hotels
		repo.deleteAll();

//		add all hotels
		List<Hotel> hotels = Arrays.asList(mariot, ibis, sofitel);
		repo.saveAll(hotels);

	}

}
