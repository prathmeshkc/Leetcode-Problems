class MyCalendarTwo {
    
    private List<Pair> doubleBookings;
    private List<Pair> bookings;

    public MyCalendarTwo() {
        this.doubleBookings = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }
    
    private boolean checkOverlap(int start1, int end1, int start2, int end2) {
        return Math.max(start1, start2) < Math.min(end1, end2);
    }
    
    private Pair findOverlap(int start1, int end1, int start2, int end2) {
        return new Pair(Math.max(start1, start2), Math.min(end1, end2));
    }
    
    public boolean book(int start, int end) {
        for(Pair pair: this.doubleBookings) {
            if(checkOverlap(pair.start, pair.end, start, end)) return false;
        }
        
        for(Pair booking: this.bookings) {
            if(checkOverlap(booking.start, booking.end, start, end)) {
                this.doubleBookings.add(findOverlap(booking.start, booking.end, start, end));
            }
        }
        this.bookings.add(new Pair(start, end));
        return true;
    }
    
    private static class Pair {
        int start;
        int end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */