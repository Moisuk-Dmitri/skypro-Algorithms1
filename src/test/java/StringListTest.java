import exception.IncorrectIndexGivenException;
import exception.EmptyParameterGivenException;
import exception.IncorrectParameterGivenException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class StringListTest {

    StringList stringList;
    String strEmpty;
    String str1;
    String str2;

    @BeforeEach
    public void setup() {
        stringList = new StringListImpl();

        strEmpty = "";
        str1 = "123";
        str2 = "1234";
    }

    @Test
    @DisplayName("Положительный тест на добавление элемента")
    public void shouldReturnStringElement() {
        assertEquals(stringList.add(str1), str1);
        assertEquals(stringList.add(str2), str2);
    }

    @Test
    @DisplayName("Отрицательный тест на добавление элемента с пустым параметром")
    public void shouldThrowExceptionWhenParameterIsEmpty() {
        assertThrows(EmptyParameterGivenException.class, () -> stringList.add(0, strEmpty));
    }

    @Test
    @DisplayName("Положительный тест на добавление элемента через индекс")
    public void shouldReturnStringElementViaIndex() {
        assertEquals(stringList.add(0, str1), str1);
        assertEquals(stringList.add(0, str2), str2);
    }

    @Test
    @DisplayName("Отрицательный тест на добавление элемента с некорректным индексом")
    public void shouldThrowExceptionWhenIndexIsOutOfBoundsWhenAdd() {
        assertThrows(IncorrectIndexGivenException.class, () -> stringList.add(5, str1));
    }

    @Test
    @DisplayName("Отрицательный тест на добавление элемента с пустым параметром через индекс")
    public void shouldThrowExceptionWhenParameterIsEmptyViaIndexWhenAdd() {
        assertThrows(EmptyParameterGivenException.class, () -> stringList.add(0, strEmpty));
    }

    @Test
    @DisplayName("Положительный тест на замену элемента через индекс")
    public void shouldReturnStringElementWhenSet() {
        stringList.add(0, str1);
        assertEquals(stringList.set(0, str2), str2);
    }

    @Test
    @DisplayName("Отрицательный тест на замену элемента с некорректным индексом")
    public void shouldThrowExceptionWhenIndexIsOutOfBoundsWhenSet() {
        assertThrows(IncorrectIndexGivenException.class, () -> stringList.set(5, str1));
    }

    @Test
    @DisplayName("Отрицательный тест на замену элемента с пустым параметром через индекс")
    public void shouldThrowExceptionWhenParameterIsEmptyViaIndexWhenSet() {
        stringList.add(str1);
        assertThrows(EmptyParameterGivenException.class, () -> stringList.set(0, strEmpty));
    }

    @Test
    @DisplayName("Положительный тест на удаление элемента через параметр")
    public void shouldReturnStringElementWhenRemoveViaParameter() {
        stringList.add(0, str1);
        assertEquals(stringList.remove(str1), str1);
    }

    @Test
    @DisplayName("Отрицательный тест на удаление элемента с некорректным параметром")
    public void shouldThrowExceptionWhenEmptyParameterWhenRemove() {
        assertThrows(IncorrectParameterGivenException.class, () -> stringList.remove(str1));
    }

    @Test
    @DisplayName("Положительный тест на удаление элемента через индекс")
    public void shouldReturnStringElementWhenRemoveViaIndex() {
        stringList.add(0, str1);
        assertEquals(stringList.remove(0), str1);
    }

    @Test
    @DisplayName("Отрицательный тест на удаление элемента с некорректным индексом")
    public void shouldThrowExceptionWhenIndexIsOutOfBoundsWhenRemove() {
        assertThrows(IncorrectIndexGivenException.class, () -> stringList.remove(5));
    }

    @Test
    @DisplayName("Положительный тест на успешный поиск элемента")
    public void shouldReturnTrueWhenContains() {
        stringList.add(0, str1);
        assertTrue(stringList.contains(str1));
    }

    @Test
    @DisplayName("Положительный тест на неудачный поиск элемента")
    public void shouldReturnFalseWhenContains() {
        stringList.add(0, str1);
        assertFalse(stringList.contains(str2));
    }

    @Test
    @DisplayName("Отрицательный тест на поиск элемента с пустым параметром")
    public void shouldThrowExceptionWhenIndexIsOutOfBoundsWhenContains() {
        assertThrows(EmptyParameterGivenException.class, () -> stringList.contains(strEmpty));
    }

    @Test
    @DisplayName("Положительный тест на поиск индекса элемента с начала")
    public void shouldReturnIndexWhenIndexOf() {
        stringList.add(0, str1);
        assertEquals(stringList.indexOf(str1), 0);
    }

    @Test
    @DisplayName("Отрицательный тест на поиск индекса элемента с начала")
    public void shouldReturnNegativeIndexWhenIndexOf() {
        assertEquals(stringList.indexOf(str1), -1);
    }

    @Test
    @DisplayName("Отрицательный тест на поиск индекса элемента с пустым параметром с начала")
    public void shouldThrowExceptionWhenIndexIsOutOfBoundsWhenIndexOf() {
        assertThrows(EmptyParameterGivenException.class, () -> stringList.indexOf(strEmpty));
    }

    @Test
    @DisplayName("Положительный тест на поиск индекса элемента c конца")
    public void shouldReturnIndexWhenLastIndexOf() {
        stringList.add(0, str1);
        assertEquals(stringList.lastIndexOf(str1), 0);
    }

    @Test
    @DisplayName("Отрицательный тест на поиск индекса элемента c конца")
    public void shouldReturnNegativeIndexWhenLastIndexOf() {
        assertEquals(stringList.lastIndexOf(str1), -1);
    }

    @Test
    @DisplayName("Отрицательный тест на поиск индекса элемента с пустым параметром c конца")
    public void shouldThrowExceptionWhenIndexIsOutOfBoundsWhenLastIndexOf() {
        assertThrows(EmptyParameterGivenException.class, () -> stringList.lastIndexOf(strEmpty));
    }

    @Test
    @DisplayName("Положительный тест на получение элемента по запросу")
    public void shouldReturnStringWhenGet() {
        stringList.add(str1);
        assertEquals(stringList.get(0), str1);
    }

    @Test
    @DisplayName("Отрицательный тест на получение элемента по запросу")
    public void shouldThrowExceptionWhenGet() {
        assertThrows(IncorrectIndexGivenException.class, () -> stringList.get(0));
    }

    @Test
    @DisplayName("Положительный тест на успешное сравнение объектов")
    public void shouldReturnTrueWhenEquals() {
        StringList otherStringList = new StringListImpl();
        otherStringList.add(str1);

        stringList.add(str1);
        assertTrue(stringList.equals(otherStringList));
    }

    @Test
    @DisplayName("Положительный тест на неудачное сравнение объектов")
    public void shouldReturnFalseWhenEquals() {
        StringList otherStringList = new StringListImpl();
        otherStringList.add(str2);

        stringList.add(str1);
        assertFalse(stringList.equals(otherStringList));
    }

    @Test
    @DisplayName("Отрицательный тест на сравнение объектов")
    public void shouldThrowExceptionWhenEquals() {
        StringList otherStringList = new StringListImpl();
        assertThrows(EmptyParameterGivenException.class, () -> stringList.equals(otherStringList));
    }

    @Test
    @DisplayName("Положительный тест на получение размера листа")
    public void shouldReturnsSize() {
        stringList.add(str1);
        assertEquals(stringList.size(), 1);
    }

    @Test
    @DisplayName("Положительный тест на очистку листа")
    public void shouldClearArray() {
        stringList.add(str1);
        stringList.clear();
        assertEquals(stringList.size(), 0);
    }

    @Test
    @DisplayName("Положительный тест на получение копии листа")
    public void shouldReturnStringArray() {
        stringList.add(str1);

        String[] otherStringArray = new String[1];
        otherStringArray[0] = str1;
        assertTrue(Arrays.equals(stringList.toArray(), otherStringArray));
    }
}
