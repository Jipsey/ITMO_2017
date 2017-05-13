package Date;

import java.time.*;

import static java.time.OffsetDateTime.now;

public class DateTask {

    private Year year = Year.of(2017);
    private LocalDate firstDayOfYear = LocalDate.of(year.getValue(), Month.JANUARY, 1);
    private LocalDate lastDayOfYear = LocalDate.of(year.getValue(), Month.DECEMBER, 31);

    private LocalDate targetDate = LocalDate.of(year.getValue(), 6, 13);
    private LocalTime targetTime = LocalTime.of(17, 00);
    private LocalDateTime target = LocalDateTime.of(targetDate, targetTime); // дата события 13 июня 2017


    private int holidays = 0;
    private int friday13 = 0;
    private int qtyDays = lastDayOfYear.getDayOfYear();

    public static void main(String[] args) {

        DateTask dt = new DateTask();

        dt.calculate(dt.getTarget());

        System.out.println("пятниц 13ое: " + dt.getFriday13() + " шт");
        System.out.println("суббот и воскресений: " + dt.getHolidays() + " шт");

    }

    private void incrFriday13() {
        friday13++;
    }

    private void incrHolidays() {
        holidays++;
    }

    public int getHolidays() {
        return holidays;
    }

    public int getFriday13() {
        return friday13;
    }

    public LocalDateTime getTarget() {
        return target;
    }

    public void calculate(LocalDateTime date) {

        LocalDate temp = firstDayOfYear;
        for (int i = 0; i < qtyDays; i++) {

            checkDay(temp.plusDays(i));

        }

        int year, month, days, hours, minutes, seconds;
        year = Math.abs(date.getYear() - now().getYear());
        month = Math.abs(date.getMonthValue() - now().getMonthValue());
        days = Math.abs(date.getDayOfMonth() - now().getDayOfMonth());
        hours = Math.abs(date.getHour() - now().getHour());
        minutes = Math.abs(date.getMinute() - now().getMinute());
        seconds = Math.abs(date.getSecond() - now().getSecond());

        System.out.printf("До события осталось %s лет, %s месяцев, %s дней, %s часов, %s минут, %s секунд\n", year, month, days, hours, minutes, seconds);


    }

    private void checkDay(LocalDate date) {

        if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
            incrHolidays();
        }
        if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY) && date.getDayOfMonth() == 13) {
            incrFriday13();
        }
    }
}
