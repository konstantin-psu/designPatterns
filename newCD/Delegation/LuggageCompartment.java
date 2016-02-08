import java.util.Vector;

/**
 * Instances of this class represent the luggage compartment of an
 * aircraft during a flight.
 */
class LuggageCompartment {
    // Max weight for this luggage compartment in kg
    private float maxWeight;

    // Total weight of checked luggage
    private float weight = 0.0F;

    // The pieces of luggage in this LuggageCompartment
    private Vector pieces;

    /**
     * Constructor
     * @param maxWeight max weight for this luggage compartment in kg
     */
    LuggageCompartment(float maxWeight) {
        this.maxWeight = maxWeight;
        pieces = new Vector();
    } // Constructor(float)

    /**
     * Check a piece of luggage
     * @param piece The piece of luggage to be checked.
     * @exception LuggageException if piece cannot be checked.
     */
    synchronized void checkLuggage(Luggage piece) throws LuggageException {
        float pieceWeight = piece.getWeight();
        if (pieceWeight + weight > maxWeight)
          throw new LuggageException("Luggage compartment is full");
        weight += pieceWeight;
        pieces.addElement(piece);
    } // checkLuggage(Luggage)
} // class LuggageCompartment
