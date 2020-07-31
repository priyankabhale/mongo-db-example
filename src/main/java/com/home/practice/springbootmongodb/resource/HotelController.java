package com.home.practice.springbootmongodb.resource;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.practice.springbootmongodb.document.Hotel;
import com.home.practice.springbootmongodb.document.QHotel;
import com.home.practice.springbootmongodb.repositories.HotelRepository;
import com.querydsl.core.types.dsl.BooleanExpression;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	private HotelRepository repo;
	
	public HotelController(HotelRepository repo) {
		super();
		this.repo = repo;
	}

	@GetMapping("/all")
	public List<Hotel> getAll() {
		List<Hotel> hotels = repo.findAll();
		return hotels;
	}
	
	@PutMapping
	public void insert(@RequestBody Hotel hotel) {
		repo.insert(hotel);
	}
	
	@PostMapping
	public void update(@RequestBody Hotel hotel) {
		repo.save(hotel);
	}
	
	
	@DeleteMapping("/{id}")
	public void update(@PathVariable("id") String id) {
		repo.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Hotel getById(@PathVariable("id") String id) {
		return repo.findById(id).get();
	}
	
	@GetMapping("/price/{maxPrice}")
	public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice) {
		return repo.findByPricePerNightLessThan(maxPrice);
	}
	
	@GetMapping("/address/{city}")
	public List<Hotel> getByCity(@PathVariable("city") String city) {
		return repo.findByCity(city);
	}
	
	@GetMapping("/country/{country}")
	public List<Hotel> getByCountry(@PathVariable("country") String country) {
//		create a query class
		QHotel qHotel = new QHotel("hotel");
		
//		using the query class we can create filters
		BooleanExpression booleanExpression = qHotel.address.country.eq(country);
		
//		we can then pass the filters to findAll method of the repository
		List<Hotel> hotels = (List<Hotel>) repo.findAll(booleanExpression);
		
		return hotels;
	}
	
	@GetMapping("/recommended")
	public List<Hotel> getRecommended() {
		final int maxPrice = 100;
		final int maxRating = 7;
		
		QHotel qHotel = new QHotel("hotel");
		BooleanExpression maxPriceExpression = qHotel.pricePerNight.lt(maxPrice);
		BooleanExpression maxRatingExpression = qHotel.reviews.any().rating.gt(maxRating);
		
		List<Hotel> hotels = (List<Hotel>) repo.findAll(maxPriceExpression.and(maxRatingExpression));
		
		return hotels;
	}

}
