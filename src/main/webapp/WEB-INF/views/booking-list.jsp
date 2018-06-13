<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Insert title here</title>
</head>
<body>
	<h3>Bookings Page</h3>
	<div class="row">
		<a href="${pageContext.request.contextPath}/booking"
			class="btn btn-primary">Add New Booking</a> <a
			href="${pageContext.request.contextPath}/booking"
			class="btn btn-primary">Maintenance Booking</a>
	</div>
	<div class="row">
		<table id="bTable" style="width: 100%"
			class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Booking ID</th>
					<th>Facility Name</th>
					<th>Start Date</th>
					<th>Start Time</th>
					<th>End Date</th>
					<th>End Time</th>
					<th>Status</th>
					<th>Book</th>
					<th>Cancel</th>
					<th>Maintenance</th>
				</tr>

			</thead>
		</table>

	</div>



</body>
</html>



