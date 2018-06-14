<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Make Booking</h3>

<c:if test="${bookingSuccess == true}">
	<div class="alert alert-success">
		Booking Successful!
	</div>
</c:if>
<c:if test="${bookingSuccess == false}">
	<div class="alert alert-danger">
<<<<<<< HEAD
		There is already a booking at that slot...
=======
		Invalid booking.
>>>>>>> refs/remotes/origin/master
	</div>
</c:if>

<div class="form-group">
<form:form action="" method="POST">
	<div class="row">
		<div class="col-md-5">
			<label>Choose Facility Type</label>
			<select name="typeId" class="form-control" data-validation="required">
				<option value="-1" selected disabled hidden>- Select a Facility Type -</option>
				<c:forEach var="facilityType" items="${ftypes}">
					<option value="${facilityType.typeId}"
						${facilityType.typeId == typeId ? 'selected="selected"' : ''}>
						${facilityType.typeName}</option>
				</c:forEach>
			</select>
<<<<<<< HEAD
			<input id="submit" type="submit" name="refresh" value="Load">
			<br>
			<label class="${hideFacility ? 'hidden' : '' }">Choose Facility</label>
			<select id="choose-room" name="facility" class="form-control ${hideFacility == true ? 'hidden' : '' }" data-validation="required">
=======
			<input id="submit" type="submit" value="Load">
			<br>
			<label class="${showFacility == true ? '' : 'hidden' }">Choose Facility</label>
			<select id="choose-room" name="facility" class="form-control ${showFacility == true ? '' : 'hidden' }" data-validation="required">
>>>>>>> refs/remotes/origin/master
				<c:forEach var="facility" items="${facilities}">
					<option value="${facility.facilityId}">${facility.facilityName}</option>
				</c:forEach>
			</select>
		</div>
		<div class="col-md-5">
			<label>Date</label> <input id="datepicker" name="date" type="text"
				class="form-control datepicker" value="${date}" autocomplete="off" data-validation="required">
			<label>Start Time</label>
			<input class="timepicker form-control" name="stime" id="starttime" type="text" step=3600 value="${stime}" autocomplete="off" data-validation="required">
			<label>End Time</label>
			<input class="timepicker form-control" name="endtime" id="endtime" type="text" step=3600 value="${endtime}" autocomplete="off" data-validation="required">
		</div>
		<div class="col-md-2">
			<input class="btn btn-primary btn-block" type="submit" name="submit" value="Submit" ${hideFacility ? 'disabled' : '' }>
		</div>
	</div>
</form:form>
</div>

<c:if test="${facilitySchedules != null}">
	<p>Click table below to select.</p>
</c:if>


<!-- Generate tables for each facility -->
<c:forEach var="facilitySchedule" items="${facilitySchedules}">
	<h4>${facilitySchedule.facilityName}</h4>
	<div class="container booking-grid">
		<div class="row" data-value="${facilitySchedule.facilityId}">
			<c:forEach var="schedule" items="${facilitySchedule.schedule}">
				<div class="col-sm-2 ${schedule.booked ? 'booked' : ''}">${schedule.slotName}</div>
			</c:forEach>
		</div>
	</div>
</c:forEach>


<<<<<<< HEAD
<script type="text/javascript" src="<c:url value="/js/booking.js" />"></script>
=======
<script type="text/javascript" src="<c:url value="/js/booking.js" />"></script>
>>>>>>> refs/remotes/origin/master
