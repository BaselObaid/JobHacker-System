<%@page import="java.time.LocalDateTime"%>
<%@ page import="java.time.*" %>
<%@ page import="java.time.temporal.ChronoUnit" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	 String birthDateStr = request.getParameter("birth-date");
    String dateStr = request.getParameter("date");

    LocalDateTime birthDateTime = LocalDateTime.parse(birthDateStr);
    LocalDateTime dateTime = LocalDateTime.parse(dateStr);

    // Calculate the age using Period
    Period age = Period.between(birthDateTime.toLocalDate(), dateTime.toLocalDate());

    int years = age.getYears();
    int months = age.getMonths();
    int days = age.getDays();

    // Calculate the time difference using Duration
    Duration duration = Duration.between(birthDateTime, dateTime);
    long daysDuration = duration.toDays();
    long hours = duration.toHours();
    long minutes = duration.toMinutes();
    long seconds = duration.getSeconds();

    // Set attributes
    request.setAttribute("years", years);
    request.setAttribute("months", months);
    request.setAttribute("days", days);
    request.setAttribute("daysDuration", daysDuration);
    request.setAttribute("hours", hours);
    request.setAttribute("minutes", minutes);
    request.setAttribute("seconds", seconds);

	%>
	
	<h2 style="color: green;">Age Calculation Result</h2>
		<p>Age : <%= request.getAttribute("years") %> years, <%= request.getAttribute("months") %> months, <%= request.getAttribute("days") %> days</p>
		<p>Age by Days: <%= request.getAttribute("daysDuration") %> days</p>
		<p>Age by hours: <%= request.getAttribute("hours") %> hours</p>
		<p>Age by minutes: <%= request.getAttribute("minutes") %> minutes</p>
		<p>Age by seconds: <%= request.getAttribute("seconds") %> seconds</p>

</body>
</html>