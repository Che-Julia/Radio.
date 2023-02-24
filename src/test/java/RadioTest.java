import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Radio;

public class RadioTest {

    @Test
    public void allowableStationValue() {
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(8);

        int expected = 8;
        int actual = radio.getCurrentRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void invalidStationValue() {
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(-7);

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void moreAllowedValue() {
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(10);

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void nextStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStationNumber(4);

        radio.next();

        int expected = 5;
        int actual = radio.getCurrentRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void maxStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStationNumber(9);

        radio.next();

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void previousStation() {
        Radio radio = new Radio();
        radio.setCurrentRadioStationNumber(7);

        radio.previous();

        int expected = 6;
        int actual = radio.getCurrentRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void lessZero() {
        Radio radio = new Radio();
        radio.setCurrentRadioStationNumber(0);
        radio.previous();
        int expected = 9;
        int actual = radio.getCurrentRadioStationNumber();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void volumeBelowZero() {
        Radio radio = new Radio();

        radio.setCurrentVolume(5);

        int expected = 5;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void maximumVolume() {
        Radio radio = new Radio();

        radio.setCurrentVolume(11);

        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(3);

        radio.increaseVolume();

        int expected = 4;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void increaseVolume1() {
        Radio radio = new Radio();
        radio.setCurrentVolume(10);

        radio.increaseVolume();

        int expected = 10;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void volumeBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-2);

        radio.reduceVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void volumeAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(8);

        radio.reduceVolume();

        int expected = 7;
        int actual = radio.getCurrentVolume();
        Assertions.assertEquals(expected, actual);
    }
}
