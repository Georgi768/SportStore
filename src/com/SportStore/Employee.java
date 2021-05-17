package com.SportStore;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

abstract public class Employee extends Person {
    private boolean available;
    private LocalDate vacationStartDate;
    private LocalDate getVacationEndDate;

    public Employee(int id, String name, String dateOfBirth, SportStore sportStore) {
        super(id, name, dateOfBirth, sportStore);
    }

    public boolean isAvailable() {
        return available;
    }

    public String toString() {
        return "Name: " + this.getName() + " DateOfBirth: " + this.getDateOfBirth();
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * The methods sets the start date of the vacation
     * @param date date in string type
     * @return localDate of the date
     */
    public LocalDate setVacationStart(String date) {
        LocalDate startDate = parseDate(date);
        return this.vacationStartDate = startDate;
    }

    /**
     * The methods sets the end date of the vacation
     * @param date date in string type
     * @return localDate of the date
     */
    public LocalDate setVacationEnd(String date) {
        LocalDate endDate = parseDate(date);
        if (endDate.isAfter(this.vacationStartDate)) {
            this.getVacationEndDate = endDate;
            this.setAvailable(false);
        }
        return this.getVacationEndDate;
    }

    /**
     * The method calculate the days between the start and end date
     * @return returns the days
     */
    public long calculateDaysGone() {
        if (this.vacationStartDate == null || this.getVacationEndDate == null) {
            return 0;
        } else if (this.getVacationEndDate.isAfter(this.vacationStartDate)) {
            return ChronoUnit.DAYS.between(this.vacationStartDate, this.getVacationEndDate);
        } else {
            return 0;
        }
    }

    public abstract double paymentPerHour();
}
