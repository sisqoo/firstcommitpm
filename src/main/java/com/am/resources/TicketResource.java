package com.am.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.am.entity.Tproduct;
import com.am.entity.Tticket;
import com.am.entity.Tview;
import com.am.entityfilter.MyFilter;
import com.am.entityfilter.OpCriteria;
import com.am.entityfilter.SearchCriteria;
import com.am.service.TicketService;
import com.am.util.ClassInfo;
import com.am.util.Graph2d;

//http://localhost:8181/user/userlist
@RestController
@RequestMapping("/ticket")
public class TicketResource {
	@Autowired
	private TicketService ticketService;

	@RequestMapping(value = "/ticketlist", method = RequestMethod.GET)
	@CrossOrigin
	public List<Tticket> ticketList() {
		return ticketService.findAll();
	}

	@RequestMapping(value = "/ticketlist2", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<List<Tticket>> ticketlist2(@RequestBody Tticket tticket) {
		MyFilter<Tticket> myfilter = new MyFilter<>();

		List<Tticket> find;
		find = ticketService.findAll(myfilter.getSpecificationFromEntity(tticket, OpCriteria.likeIgnoreCase));

		return new ResponseEntity<List<Tticket>>(find, HttpStatus.OK);

	}

	@RequestMapping(value = "/countgroupmonth", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<List<Graph2d>> countgroupmonth() {
		List<Graph2d> list = ticketService.findCountGroupMonth();
		return new ResponseEntity<List<Graph2d>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/countgroupproductstatus", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<List<Graph2d>> countgroupproductstatus() {
		List<Graph2d> list = ticketService.findCountGroupProductStatus();
		return new ResponseEntity<List<Graph2d>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/countfxornbgrpreportertype", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<List<Graph2d>> countfxornbgrpreportertype() {
		List<Graph2d> list = ticketService.findFXorNBGrpReportertype();
		return new ResponseEntity<List<Graph2d>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public Tticket getTicket(@RequestParam(required = false, value = "id") long id) {
		return ticketService.findByIdticket(id);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Tticket> save(@RequestBody Tticket tticket) {
		Tticket ticketsave = ticketService.save(tticket);
		return new ResponseEntity<Tticket>(ticketsave, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@CrossOrigin
	public void delete(@PathVariable("id") long id) {
		ticketService.delete(id);
	}

	// utilisation de la recherche par programmation à partir bu front : injection
	// de searchCriteria
	@RequestMapping(value = "/searchbycriteria", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<List<Tticket>> searchbycriteria(
			@RequestBody(required = false) SearchCriteria[] searchCriterias) {
		MyFilter<Tticket> myfilter = new MyFilter<>();
		for (SearchCriteria c : searchCriterias) {
			System.out.println("SearchCriteria: " + c.getKey() + " " + c.getOperation() + " " + c.getValue());
		}
		if (searchCriterias != null) {
			for (SearchCriteria s : searchCriterias) {
				myfilter.addCondition(s);
			}
		}

		List<Tticket> find;

		find = ticketService.findAll(myfilter.getSpecification());
		// find = viewService.findAll();

		return new ResponseEntity<List<Tticket>>(find, HttpStatus.OK);

	}

}
