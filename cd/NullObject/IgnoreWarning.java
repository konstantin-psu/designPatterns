class IgnoreWarning implements WarningRouter {
    /**
     * This method sends a warning message to whatever destination it
     * considers appropriate.
     * @return true If caller should proceed with its current operation.
     */
    public boolean routeWarning(String warning) {
        return true;
    } // routeWarning(String)
} // class IgnoreWarning
