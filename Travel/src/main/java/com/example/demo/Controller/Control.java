package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.travel.Travel;
import com.example.demo.repo.Repos;

@RestController
public class Control {
	@Autowired
	private Repos repos;
	@GetMapping("/getAllTravel")
	public ResponseEntity<List<Travel>> getTravel()
	{
		try
		{
			List<Travel>TravelList = new ArrayList<>();
			repos.findAll().forEach(TravelList::add);
			if(TravelList.isEmpty())
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(TravelList, HttpStatus.OK);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/getTravelbyId/{id}")
	public ResponseEntity<Travel> getTravelbyId(@PathVariable Long id)
	{
		Optional<Travel>TravelData=repos.findById(id);
		if(TravelData.isPresent())
		{
			return new ResponseEntity<>(TravelData.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@PostMapping("/addTravel")
	public ResponseEntity<Travel> addTravel(@RequestBody Travel travel)
	{
		Travel travelobj = repos.save(travel);
		return new ResponseEntity<>(travelobj, HttpStatus.OK);
		
	}
	@PutMapping("/updateTravelbyId/{id}")
	public ResponseEntity<Travel> updateGymbyId(@PathVariable Long id,@RequestBody Travel newTravelData)
	{
		Optional<Travel>oldTravelData=repos.findById(id);
		if(oldTravelData.isPresent())
		{
			Travel updateTravel = oldTravelData.get();
			updateTravel.setSource(newTravelData.getSource());
			updateTravel.setDestination(newTravelData.getDestination());
			updateTravel.setPassenger_name(newTravelData.getPassenger_name());
			updateTravel.setCost(newTravelData.getCost());
			Travel travelobj= repos.save(updateTravel);
			return new ResponseEntity<>(travelobj, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/deleteTravelbyId/{id}")
	public ResponseEntity<HttpStatus> DeleteTravelbyId(@PathVariable Long id)
	{
		repos.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
