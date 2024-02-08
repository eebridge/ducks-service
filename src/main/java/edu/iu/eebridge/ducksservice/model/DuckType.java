package edu.iu.eebridge.ducksservice.model;

public enum DuckType {
    MALLARD, REDHEAD, RUBBER_DUCK, DECOY_DUCK;

    @Override
    public String toString() {
        switch (this) {
            case MALLARD: return "Mallard";
            case REDHEAD: return "Redhead";
            case RUBBER_DUCK: return "Rubber";
            case DECOY_DUCK: return "Decoy";
            default: return "unspecified";
        }
    }


    public static DuckType toEnum(String value) {
        switch (value.toLowerCase()) {
            case "mallard": return DuckType.MALLARD;
            case "redhead": return DuckType.REDHEAD;
            case "decoy": return DuckType.DECOY_DUCK;
            case "rubber": return DuckType.RUBBER_DUCK;
            default: return null;
        }
    }
}