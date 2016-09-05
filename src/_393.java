public class _393 {
    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; ) {
            int prefixOne = 0;
            for (int bit = 7; bit >= 0; bit--)
                if ((data[i] & (1 << bit)) != 0) prefixOne++;
                else break;
            if (prefixOne == 1 || prefixOne > 4 || i + prefixOne > data.length) return false;
            if (prefixOne == 0) i++;
            else {
                for (int j = i + 1; j < i + prefixOne; j++)
                    if ((data[j] >> 6) != 0b10) return false;
                i += prefixOne;
            }
        }
        return true;
    }
}