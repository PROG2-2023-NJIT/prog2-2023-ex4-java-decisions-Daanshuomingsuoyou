package prog2.exercise4.flight.booking.system;

import java.util.Random;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FlightBooking {
    public String getRandomString(int length) {
        String range = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(range.charAt(number));
        }
        return sb.toString();
    }

    private static final String flightCompany = "Flights-of-Fancy";
    private String ID = getRandomString(9);
    private String pFullName;
    private static final String tripSource = "NANJING";
    private static final String sourceAirport = "NANJING LUKOU INTERNATIONAL AIRPORT";
    private static final String tripDestination = "OULU";
    private static final String destinationAirport = "OULU AIRPORT";
    private LocalDate departureDate;
    private LocalDate returnDate;
    private int childPassengers;
    private int adultPassengers;
    private int totalPassengers;

    private double departingTicketPrice = 100;
    private double returnTicketPrice = 100;
    private double totalTicketPrice;
    private String ticketNumber = getRandomString(4);


    public enum BookingClass {
        FIRST, BUSINESS, ECONOMY;
    }

    public enum TripType {
        ONE_WAY, RETURN;
    }

    public enum TripSource {
        NANJING, BEIJING, SHANGHAI, OULU, HELSINKI, PARIS;
    }

    public enum TripDestination {
        NANJING, BEIJING, SHANGHAI, OULU, HELSINKI, PARIS;;
    }

    public enum SourceAirport {
        Nanjing_Lukou_International_Airport, Beijing_Capital_International_Airport, Shanghai_Pudong_International_Airport, Oulu_Airport, Helsinki_Airport, Paris_Charles_de_Gaulle_Airport;
    }

    public enum DestinationAirport {
        Nanjing_Lukou_International_Airport, Beijing_Capital_International_Airport, Shanghai_Pudong_International_Airport, Oulu_Airport, Helsinki_Airport, Paris_Charles_de_Gaulle_Airport;
    }

    private TripType tot;
    private TripSource sot;
    private TripDestination dot;
    private BookingClass bookingClass;
    private SourceAirport aos;
    private DestinationAirport aod;

    private int flag1;

    public FlightBooking(String pFullName, LocalDate departureDate, LocalDate returnDate, int childPassengers, int adultPassengers) {
        this.pFullName = pFullName;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.childPassengers = childPassengers;
        this.adultPassengers = adultPassengers;
    }

    public String getFlightCompany() {
        return flightCompany;
    }
    public String getID() {
        return ID;
    }
    public String getpFullName() {
        return pFullName;
    }
    public String getSourceAirport() {
        return sourceAirport;
    }
    public String getTripDestination() {
        return tripDestination;
    }
    public String getDestinationAirport() {
        return destinationAirport;
    }
    public int getAdultPassengers() {
        return adultPassengers;
    }
    public int getChildrenPassengers() {
        return childPassengers;
    }
    public int getTotalPassengers() {
        return childPassengers + adultPassengers;
    }

    public void setTotalPassengers(int childPassengers, int adultPassengers) {
        this.totalPassengers = childPassengers + adultPassengers;
    }

    public LocalDate getDepartingDate() {
        return departureDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public TripSource getTripSource() {
        return sot;
    }
    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        long dayDifference = ChronoUnit.DAYS.between(departureDate, returnDate);
        if (dayDifference == 1) {
            System.out.println("If departure date is " + departureDate + "and the return date is "
                    + returnDate + " , Then the program should automatically change the return date to "
                    + departureDate.plusDays(2) + ".");
            this.returnDate = departureDate.plusDays(2);
            this.flag1 = 1;
        } else if (dayDifference == 0) {
            System.out.println("If both the departure date and return date are "
                    + departureDate + " , "
                    + "Then the program should automatically change the return date to "
                    + departureDate.plusDays(2) + ".");
            this.returnDate = departureDate.plusDays(2);
            this.flag1 = 2;
        } else {
            this.returnDate = returnDate;
            this.flag1 = 0;
        }

    }

    public void setBookingClass(String classType) {
        int choice = Integer.parseInt(classType);
        switch (choice) {
            case 1:
                bookingClass = BookingClass.FIRST;
                break;
            case 2:
                bookingClass = BookingClass.BUSINESS;
                break;
            case 3:
                bookingClass = BookingClass.ECONOMY;
                break;
            default:
                System.out.println("Error input.");
        }
    }

    public void setTripType(String type) {
        int choice = Integer.parseInt(type);
        switch (choice) {
            case 1:
                tot = TripType.ONE_WAY;
                break;
            case 2:
                tot = TripType.RETURN;
                break;
            default:
                System.out.println("Error input.");
        }
    }

    public void setTripSource(String tripSource) {
        int choice = Integer.parseInt(tripSource);
        switch (choice) {
            case 1:
                sot = TripSource.NANJING;
                break;
            case 2:
                sot = TripSource.BEIJING;
                break;
            case 3:
                sot = TripSource.SHANGHAI;
                break;
            case 4:
                sot = TripSource.OULU;
                break;
            case 5:
                sot = TripSource.HELSINKI;
                break;
            case 6:
                sot = TripSource.PARIS;
                break;
            default:
                System.out.println("Error input.");
        }
    }

    public void setTripDestination(String tripSource, String tripDestination) {
        int srcChoice = Integer.parseInt(tripSource);
        int desChoice = Integer.parseInt(tripDestination);
        if (srcChoice != desChoice) {
            switch (desChoice) {
                case 1:
                    dot = TripDestination.NANJING;
                    break;
                case 2:
                    dot = TripDestination.BEIJING;
                    break;
                case 3:
                    dot = TripDestination.SHANGHAI;
                    break;
                case 4:
                    dot = TripDestination.OULU;
                    break;
                case 5:
                    dot = TripDestination.HELSINKI;
                    break;
                case 6:
                    dot = TripDestination.PARIS;
                    break;
                default:
                    System.out.println("Error input.");
            }
        } else {
            System.out.println("The trip source and the trip destination should not be the same!");
        }

    }

    public String getTicketNumber() {
        String ticketNum;
        if (tot == TripType.ONE_WAY) {
            ticketNum = "11";
            if (bookingClass == BookingClass.FIRST) {
                ticketNum = ticketNum + "F" + ticketNumber;
                if (sot == TripSource.PARIS || dot == TripDestination.PARIS) {
                    ticketNum = ticketNum + "INT";

                } else if ((sot == TripSource.OULU && dot == TripDestination.HELSINKI) || (sot == TripSource.HELSINKI && dot == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";

                } else if ((sot == TripSource.NANJING || sot == TripSource.BEIJING || sot == TripSource.SHANGHAI) && (dot == TripDestination.NANJING || dot == TripDestination.BEIJING || dot == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";

                } else {
                    ticketNum = ticketNum + "INT";
                }

            } else if (bookingClass == BookingClass.BUSINESS) {
                ticketNum = ticketNum + "B" + ticketNumber;
                if (sot == TripSource.PARIS || dot == TripDestination.PARIS) {
                    ticketNum = ticketNum + "INT";

                } else if ((sot == TripSource.OULU && dot == TripDestination.HELSINKI) || (sot == TripSource.HELSINKI && dot == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";

                } else if ((sot == TripSource.NANJING || sot == TripSource.BEIJING || sot == TripSource.SHANGHAI) && (dot == TripDestination.NANJING || dot == TripDestination.BEIJING || dot == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";

                } else {
                    ticketNum = ticketNum + "INT";
                }

            } else if (bookingClass == BookingClass.ECONOMY) {
                ticketNum = ticketNum + "E" + ticketNumber;
                if (sot == TripSource.PARIS || dot == TripDestination.PARIS) {
                    ticketNum = ticketNum + "INT";

                } else if ((sot == TripSource.OULU && dot == TripDestination.HELSINKI) || (sot == TripSource.HELSINKI && dot == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";

                } else if ((sot == TripSource.NANJING || sot == TripSource.BEIJING || sot == TripSource.SHANGHAI) && (dot == TripDestination.NANJING || dot == TripDestination.BEIJING || dot == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";

                } else {
                    ticketNum = ticketNum + "INT";
                }
            }
        } else {
            ticketNum = "22";
            if (bookingClass == BookingClass.FIRST) {
                ticketNum = ticketNum + "F" + ticketNumber;
                if (sot == TripSource.PARIS || dot == TripDestination.PARIS) {
                    ticketNum = ticketNum + "INT";
                } else if ((sot == TripSource.OULU && dot == TripDestination.HELSINKI) || (sot == TripSource.HELSINKI && dot == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";
                } else if ((sot == TripSource.NANJING || sot == TripSource.BEIJING || sot == TripSource.SHANGHAI) && (dot == TripDestination.NANJING || dot == TripDestination.BEIJING || dot == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";
                } else {
                    ticketNum = ticketNum + "INT";
                }
            } else if (bookingClass == BookingClass.BUSINESS) {
                ticketNum = ticketNum + "B" + ticketNumber;
                if (sot == TripSource.PARIS || dot == TripDestination.PARIS) {
                    ticketNum = ticketNum + "INT";
                } else if ((sot == TripSource.OULU && dot == TripDestination.HELSINKI) || (sot == TripSource.HELSINKI && dot == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";
                } else if ((sot == TripSource.NANJING || sot == TripSource.BEIJING || sot == TripSource.SHANGHAI) && (dot == TripDestination.NANJING || dot == TripDestination.BEIJING || dot == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";
                } else {
                    ticketNum = ticketNum + "INT";
                }
            } else if (bookingClass == BookingClass.ECONOMY) {
                ticketNum = ticketNum + "E" + ticketNumber;
                if (sot == TripSource.PARIS || dot == TripDestination.PARIS) {
                    ticketNum = ticketNum + "INT";
                } else if ((sot == TripSource.OULU && dot == TripDestination.HELSINKI) || (sot == TripSource.HELSINKI && dot == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";
                } else if ((sot == TripSource.NANJING || sot == TripSource.BEIJING || sot == TripSource.SHANGHAI) && (dot == TripDestination.NANJING || dot == TripDestination.BEIJING || dot == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";
                } else {
                    ticketNum = ticketNum + "INT";
                }
            }
        }

        return ticketNum;
    }

    public void setDepartingTicketPrice(int childPassengers, int adultPassengers) {
        double departingTicketPrice = 0.0;
        if ((sot == TripSource.OULU && dot == TripDestination.HELSINKI) || (sot == TripSource.HELSINKI && dot == TripDestination.OULU) || ((sot == TripSource.NANJING || sot == TripSource.BEIJING || sot == TripSource.SHANGHAI) && (dot == TripDestination.NANJING || dot == TripDestination.BEIJING || dot == TripDestination.SHANGHAI))) {
            departingTicketPrice = (300 + 0.1 * 300) + 0.05 * 300;
        } else {
            departingTicketPrice = 300 * (1 + 0.15 + 0.1);
        }
        if (bookingClass == BookingClass.FIRST) {
            this.departingTicketPrice = departingTicketPrice * childPassengers + departingTicketPrice * adultPassengers + 250;
        } else if (bookingClass == BookingClass.BUSINESS) {
            this.departingTicketPrice = departingTicketPrice * childPassengers + departingTicketPrice * adultPassengers + 150;
        } else if (bookingClass == BookingClass.ECONOMY) {
            this.departingTicketPrice = departingTicketPrice * childPassengers + departingTicketPrice * adultPassengers + 50;
        }
    }

    public void setReturnTicketPrice() {
        if (tot == TripType.ONE_WAY) {
            this.returnTicketPrice = 0;
        } else {
            this.returnTicketPrice = this.departingTicketPrice;
        }
    }

    public void setTotalTicketPrice() {
        this.totalTicketPrice = this.departingTicketPrice + this.returnTicketPrice;
    }

    public double getTotalTicketPrice() {
        return this.totalTicketPrice;
    }

    public String StringOption1() {
        if (flag1 == 1 || flag1 == 2) {
            return "Thank you for booking your flight with " + getFlightCompany()
                    + ". Following are the details of your bookingand the trip:\n\n"
                    + "Ticket Number: " + ticketNumber + "\n"
                    + "Passenger Name: " + pFullName + "\n"
                    + "From " + sot + " to " + dot + "\n"
                    + "Date of departure: " + departureDate + "\n"
                    + "Date of return: " + returnDate + " (Changed from old " + returnDate.minusDays(flag1)
                    + " to new " + returnDate + ")" + "\n" + "Total ticket price in Euros: "
                    + totalTicketPrice + "\n\n"
                    + "IMPORTANT NOTICE: As per our policy, the returnDate was changed because it was less than two days apart from your departure date.";
        } else {
            return "Thank you for booking your flight with " + getFlightCompany()
                    + ". Following are the details of your bookingand the trip:\n\n"
                    + "Ticket Number: " + ticketNumber + "\n" + "Passenger Name: "
                    + pFullName + "\n" + "From " + sot + " to "
                    + dot + "\n" + "Date of departure: " + departureDate + "\n"
                    + "Date of return: " + returnDate + "\n" + "Total ticket price in Euros: "
                    + totalTicketPrice + "\n";
        }

    }

}
