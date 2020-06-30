import java.util.Arrays;

public class ColorSort {

    public enum Color {
        red(0),
        green(1),
        blue(2);

        public final int sizeArrayIndex;

        Color(int sizeArrayIndex) {
            this.sizeArrayIndex = sizeArrayIndex;
        }
    }

    public static void main(String[] param) {
        Color[] test = {Color.blue, Color.green, Color.blue, Color.red};
        reorder(test);
        System.out.println(Arrays.toString(test));
    }

    public static void reorder(Color[] balls) {
        int length = balls.length;
        Color[] output = new Color[length];
        int[] count = {0, 0, 0};

        for (Color color : balls) {
            int order = color.sizeArrayIndex;
            int cnt = count[order];
            count[order] = ++cnt;
        }

        count[2] = count[0] + count[1] + count[2] - 1;
        count[1] = count[0] + count[1] - 1;
        count[0] = count[0] - 1;

        for (int i = length - 1; i >= 0; i--) {
            output[count[balls[i].sizeArrayIndex]] = balls[i];
            --count[balls[i].sizeArrayIndex];
        }

        System.arraycopy(output, 0, balls, 0, length);
    }
}
