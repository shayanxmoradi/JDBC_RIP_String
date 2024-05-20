package rip_string;

import java.util.Arrays;
import java.util.Objects;

public class Sequence {
    private Character[] value = new Character[100];

    public Sequence(Character[] value) {
        this.value = value;
    }

    public void concatenate(Sequence other) {
        Character[] newValue = new Character[value.length + other.value.length];
        System.arraycopy(value, 0, newValue, 0, value.length);
        System.arraycopy(other.value, 0, newValue, value.length, other.value.length);
        this.value = newValue;
    }

    public int indexOf(Character character) {
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(character)) {
                return i;
            }
        }
        System.out.println("not found");
        return -1;
    }

    /**
     * step 1. check wether we have oldvalue arry of char in our this.value if not exit
     * step 2. if true -> change does indexes to new char indexs ( this requires begin and end
     * index)
     * ste
     *
     * @param oldValue
     * @param newChars
     */
    public void replace(Sequence oldValue, Sequence newChars) {
        int beginIndex = findSequenceStartIndex(oldValue);
        if (beginIndex != -1) {
            int endIndex = beginIndex + oldValue.value.length - 1;
            Character[] newValue = new Character[this.value.length - (oldValue.value.length - newChars.value.length)];

            System.arraycopy(this.value, 0, newValue, 0, beginIndex);
            for (int i = 0; i < newChars.value.length; i++) {
                newValue[beginIndex + i] = newChars.value[i];
            }
            System.arraycopy(this.value, endIndex + 1, newValue, beginIndex + newChars.value.length, this.value.length - endIndex - 1);

            this.value = newValue;
        }else {
            System.out.println(oldValue.toString()+"  not found :(");

        }
    }

    private int findSequenceStartIndex(Sequence sequence) {
        for (int i = 0; i <= this.value.length - sequence.value.length; i++) {
            if (isEqualSequenceAt(i, sequence)) {
                return i;
            }
        }
      //  System.out.println("not found :(");
        return -1;
    }

    private boolean isEqualSequenceAt(int startIndex, Sequence sequence) {
        for (int i = 0; i < sequence.value.length; i++) {
            if (!this.value[startIndex + i].equals(sequence.value[i])) {

                return false;
            }
        }
        return true;
    }


public Character[] getValue() {
    return value;
}

public void setValue(Character[] value) {
    this.value = value;
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Sequence sequence)) return false;
    return Objects.deepEquals(value, sequence.value);
}


@Override
public String toString() {
    return "" +
            "" + Arrays.toString(value)
          ;
}
}

