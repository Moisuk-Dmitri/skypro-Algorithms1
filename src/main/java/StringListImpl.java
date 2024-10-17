import exception.IncorrectIndexGivenException;
import exception.EmptyParameterGivenException;
import exception.IncorrectParameterGivenException;

public class StringListImpl implements StringList {

    private String[] stringArray;
    private int size;

    public StringListImpl() {
        stringArray = new String[5];
        size = 0;
    }

    @Override
    public String add(String item) {
        if (item.isEmpty()) {
            throw new EmptyParameterGivenException("Empty parameter given");
        }

        if (size < stringArray.length) {
            stringArray[size] = item;
            size++;
        } else {
            String[] otherStringArray = new String[size + 5];
            System.arraycopy(stringArray, 0, otherStringArray, 0, size);
            stringArray = new String[size + 5];
            System.arraycopy(otherStringArray, 0, stringArray, 0, size);

            stringArray[size] = item;
            size++;
        }

        return stringArray[size - 1];
    }

    @Override
    public String add(int index, String item) {
        if (index > size || index < 0) {
            throw new IncorrectIndexGivenException("Incorrect index given");
        }
        if (item.isEmpty()) {
            throw new EmptyParameterGivenException("Empty parameter given");
        }

        if (size < stringArray.length) {
            for (int i = size; i > index; i--) {
                stringArray[i] = stringArray[i - 1];
            }

            stringArray[index] = item;
            size++;
        } else {
            String[] otherStringArray = new String[size + 5];
            System.arraycopy(stringArray, 0, otherStringArray, 0, size);
            stringArray = new String[size + 5];
            System.arraycopy(otherStringArray, 0, stringArray, 0, size);

            for (int i = size; i > index; i--) {
                stringArray[i] = stringArray[i - 1];
            }

            stringArray[index] = item;
            size++;
        }

        return stringArray[index];
    }

    @Override
    public String set(int index, String item) {
        if (index >= size || index < 0) {
            throw new IncorrectIndexGivenException("Incorrect index given");
        }
        if (item.isEmpty()) {
            throw new EmptyParameterGivenException("Empty parameter given");
        }

        stringArray[index] = item;

        return stringArray[index];
    }

    @Override
    public String remove(String item) {
        if (item.isEmpty()) {
            throw new EmptyParameterGivenException("Empty parameter given");
        }
        if (!contains(item)) {
            throw new IncorrectParameterGivenException("No such parameter in list");
        }

        String str = stringArray[indexOf(item)];
        remove(indexOf(item));

        return str;
    }

    @Override
    public String remove(int index) {
        if (index >= size || index < 0) {
            throw new IncorrectIndexGivenException("Incorrect index given");
        }

        String str = stringArray[index];
        while (stringArray[index + 1] != null) {
            stringArray[index] = stringArray[index + 1];
        }
        stringArray[index + 1] = null;

        return str;
    }

    @Override
    public boolean contains(String item) {
        if (item.isEmpty()) {
            throw new EmptyParameterGivenException("Empty parameter given");
        }

        int i = 0;
        while (!item.equals(stringArray[i]) && i < size) {
            i++;
        }

        if (i >= size) {
            return false;
        }

        return true;
    }

    @Override
    public int indexOf(String item) {
        if (item.isEmpty()) {
            throw new EmptyParameterGivenException("Empty parameter given");
        }

        int i = 0;
        while (!item.equals(stringArray[i]) && i < size) {
            i++;
        }

        if (i == size) {
            return -1;
        }

        return i;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item.isEmpty()) {
            throw new EmptyParameterGivenException("Empty parameter given");
        }

        int i = size;
        while (i >= 0 && !item.equals(stringArray[i])) {
            i--;
        }

        if (i == -1) {
            return -1;
        }

        return i;
    }

    @Override
    public String get(int index) {
        if (index >= size || index < 0) {
            throw new IncorrectIndexGivenException("Incorrect index given");
        }

        return stringArray[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList.isEmpty()) {
            throw new EmptyParameterGivenException("Empty parameter given");
        }

        for (int i = 0; i < size; i++) {
            if (!otherList.get(i).equals(stringArray[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            stringArray[i] = null;
        }
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] otherStringArray = new String[size];

        System.arraycopy(stringArray, 0, otherStringArray, 0, size);

        return otherStringArray;
    }
}
