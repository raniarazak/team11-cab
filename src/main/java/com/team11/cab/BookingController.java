package com.team11.cab;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team11.cab.model.Booking;
import com.team11.cab.model.Facility;
import com.team11.cab.model.FacilityType;
import com.team11.cab.service.BookingService;
import com.team11.cab.service.FacilityService;
import com.team11.cab.service.FacilityTypeService;
import com.team11.cab.service.MemberService;

@RequestMapping(value = "/booking")
@Controller
public class BookingController {
	@Autowired
	private BookingService bookingService;
	@Autowired
	private FacilityService facilityService;
	@Autowired
	private FacilityTypeService facilityTypeService;
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "", method = RequestMethod.POST, params = { "refresh" })
	public ModelAndView refreshPage(HttpServletRequest request) {

		System.out.println(request.getParameter("typeId"));

		// Test Parameters
		String typeId = request.getParameter("typeId");

		ModelAndView mav = new ModelAndView("booking");

		ArrayList<FacilityType> ftypes = facilityTypeService.findAllFacilityTypes();

		// Display "Choose Room" dropdown by Facility Type
		if (request.getParameter("typeId") != null) {
			int typeIdNum = Integer.parseInt(typeId);
			ArrayList<Facility> rooms = facilityService.findFacilitiesByFacilityType(typeIdNum);
			mav.addObject("rooms", rooms);
		}

		mav.addObject("typeId", typeId);
		mav.addObject("ftypes", ftypes);
		mav.addObject("date", request.getParameter("date"));

		mav.addObject("stime", request.getParameter("stime"));
		mav.addObject("endtime", request.getParameter("endtime"));

		return mav;
	}

	@RequestMapping(value = "", method = RequestMethod.POST, params = { "submit" })
	public ModelAndView bookingPostPage(HttpServletRequest request) {

		// Make Booking
		int facilityId = Integer.parseInt(request.getParameter("room"));
		int userId = 1; // TODO: Change this when you can get userId

		// Convert POST attributes to the LocalDateTime objects
		LocalDate date = LocalDate.parse(request.getParameter("date"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalTime startTime = LocalTime.parse(request.getParameter("stime"), DateTimeFormatter.ofPattern("HH:mm"));
		LocalTime endTime = LocalTime.parse(request.getParameter("endtime"), DateTimeFormatter.ofPattern("HH:mm"));

		LocalDateTime startDateTime = LocalDateTime.of(date, startTime);
		LocalDateTime endDateTime = LocalDateTime.of(date, endTime);

		Booking b = new Booking();
		b.setFacility(facilityService.findFacilityById(facilityId));
		b.setStartDate(startDateTime);
		b.setEndDate(endDateTime);
		b.setMember(memberService.findMemberById(userId));

		bookingService.makeBooking(b);
		boolean bookingSuccess = true;

		// // Test booking
		// Booking b = new Booking();
		// b.setFacility(facilityService.findFacilityById(1));
		// b.setStartDate(LocalDateTime.of(2018, 6, 12, 8, 0));
		// b.setEndDate(LocalDateTime.of(2018, 6, 12, 10, 0));
		// b.setUser(memberService.findMemberById(1));

		// Render view
		ModelAndView mav = new ModelAndView("booking");

		ArrayList<FacilityType> ftypes = facilityTypeService.findAllFacilityTypes();

		// Display "Choose Room" dropdown by Facility Type
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		ArrayList<Facility> rooms = facilityService.findFacilitiesByFacilityType(typeId);

		mav.addObject("typeId", typeId);
		mav.addObject("ftypes", ftypes);
		mav.addObject("date", request.getParameter("date"));
		mav.addObject("rooms", rooms);
		mav.addObject("stime", request.getParameter("stime"));
		mav.addObject("endtime", request.getParameter("endtime"));

		mav.addObject("bookingSuccess", bookingSuccess);

		return mav;
	}

	/*
	 * TODO: Includes test for isBookingValid
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView bookingPage(HttpServletRequest request) {

		// LocalDateTime start1 = LocalDateTime.of(2018, 6, 12, 8, 0);
		// LocalDateTime end1 = LocalDateTime.of(2018, 6, 12, 9, 0);
		//
		// LocalDateTime start2 = LocalDateTime.of(2018, 6, 12, 10, 0);
		// LocalDateTime end2 = LocalDateTime.of(2018, 6, 12, 12, 0);
		//
		// System.out.println("--TEST 1--");
		// System.out.println(bookingService.isBookingValid(start1, end1, start2,
		// end2));
		//
		// end1 = LocalDateTime.of(2018, 6, 12, 10, 0);
		//
		// System.out.println("--TEST 2--");
		// System.out.println(bookingService.isBookingValid(start1, end1, start2,
		// end2));
		//
		// end1 = LocalDateTime.of(2018, 6, 12, 11, 0);
		//
		// System.out.println("--TEST 3--");
		// System.out.println(bookingService.isBookingValid(start1, end1, start2,
		// end2));

		ModelAndView mav = new ModelAndView("booking");

		ArrayList<FacilityType> ftypes = facilityTypeService.findAllFacilityTypes();

		mav.addObject("ftypes", ftypes);
		mav.addObject("date", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String bookingsList() {
		return "booking-list";
	}

}
