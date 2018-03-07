package me.puneetghodasara.validation.validator;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

public class Temperature implements Comparable<Temperature> {

    @NotNull
    @Range(min = 5, max = 105)
    private Double reading;
    @NotNull
    private TEMP_UNIT unit;

    public Temperature(Double reading) {
        super();
        this.reading = reading;
        this.unit = TEMP_UNIT.C;
    }

    @Override
    public int compareTo(Temperature o) {
        if (o == null)
            return -1;

        if (o.unit != this.unit) {
            // Convert temperature
            throw new IllegalStateException("Not yet supported.");
        }

        return this.reading.compareTo(o.reading);
    }

    @Override
    public String toString() {
        return "Temperature [" + reading + " " + unit + "]";
    }

    enum TEMP_UNIT {
        C, F
    }

}
