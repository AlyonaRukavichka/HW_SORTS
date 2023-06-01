
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    AviaSouls avia = new AviaSouls();
    Ticket item1 = new Ticket("Воронеж", "Москва", 1200, 12, 15);
    Ticket item2 = new Ticket("Питер", "Москва", 1600, 2, 24); //22
    Ticket item3 = new Ticket("Питер", "Москва", 2600, 6, 9); //3
    Ticket item4 = new Ticket("Белгород", "Москва", 1600, 2, 22);
    Ticket item5 = new Ticket("Архангельск", "Каспийск", 5550, 23, 1);
    Ticket item6 = new Ticket("Питер", "Москва", 1100, 17, 22); //5

    @Test
    public void shouldSearchToLargest() {
        avia.add(item1);
        avia.add(item2);
        avia.add(item3);
        avia.add(item4);
        avia.add(item5);
        avia.add(item6);

        Ticket[] expected = {item6, item2, item3};
        Ticket[] actual = avia.search("Питер", "Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchZero() {
        avia.add(item1);
        avia.add(item2);
        avia.add(item3);
        avia.add(item4);
        avia.add(item5);
        avia.add(item6);

        Ticket[] expected = {};
        Ticket[] actual = avia.search("Питер", "Каспийск");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneTicket() {
        avia.add(item1);
        avia.add(item2);
        avia.add(item3);
        avia.add(item4);
        avia.add(item5);
        avia.add(item6);

        Ticket[] expected = {item4};
        Ticket[] actual = avia.search("Белгород", "Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTime() {
        avia.add(item1);
        avia.add(item2);
        avia.add(item3);
        avia.add(item4);
        avia.add(item5);
        avia.add(item6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {item3, item6, item2};
        Ticket[] actual = avia.searchAndSortBy("Питер", "Москва", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTimeZero() {
        avia.add(item1);
        avia.add(item2);
        avia.add(item3);
        avia.add(item4);
        avia.add(item5);
        avia.add(item6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = avia.searchAndSortBy("Питер", "Каспийск", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTimeOneTicket() {
        avia.add(item1);
        avia.add(item2);
        avia.add(item3);
        avia.add(item4);
        avia.add(item5);
        avia.add(item6);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {item1};
        Ticket[] actual = avia.searchAndSortBy("Воронеж", "Москва", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }


}
