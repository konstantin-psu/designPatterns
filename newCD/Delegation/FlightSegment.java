/**
 * Instance of this class represent a flight segment.
 */
class FlightSegment {
    //...
    LuggageCompartment luggage;
    //...
    /**
     * Check a piece of luggage
     * @param piece The piece of luggage to be checked.
     * @exception LuggageException if piece cannot be checked.
     */
    void checkLuggage(Luggage piece) throws LuggageException {
        luggage.checkLuggage(piece);
    } // checkLuggage(Luggage)
} // class FlightSegment
