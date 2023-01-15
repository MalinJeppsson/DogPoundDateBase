package com.example.DogPound.Services;

//
//@Service
//public class BookingServiceOld {
//
//    @Autowired
//    BookingRepository repository;
//
//
//    public void addBooking(User user, Day day) {
//        repository.save(new Booking(user, day));
//    }
//
//    public List<String> convertBookingsToStringList(User user) {
//        List<String> returnList = new ArrayList<>();
//        List<Booking> userBookings = user.getBookings();
//        for (int i = 0; i < userBookings.size(); i++) {
//            // Loops through bookings, gets its Day object and checks its name. Returns string like "Tisdag" etc.
//            String dayName = userBookings.get(i).getDay().getName();
//            String weekString = returnWeekNumAsString(userBookings.get(i));
//            returnList.add(dayName + ", " + weekString);
//        }
//        return returnList;
//    }
//
//    public String returnWeekNumAsString(Booking booking) {
//        return "Vecka " + booking.getDay().getWeek().getName(); // this is gonna be a week number like 44 or 45 etc. So Vecka 44 etc.
//    }
//
//}
