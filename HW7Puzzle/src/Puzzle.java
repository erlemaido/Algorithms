import java.util.*;

// Used for reference
// https://www.geeksforgeeks.org/heaps-algorithm-for-generating-permutations/

public class Puzzle {

    private List<Character> characterList = new ArrayList<>();
    private String[] strings;
    private int solutionCounter = 0;
    private List<Integer> notZero = new ArrayList<>();
    private HashSet<String> stringHashSet = new HashSet<>();
    private long[] exampleSet;

    public static void main(String args[]) {
        long[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Puzzle puzzle = new Puzzle();
        puzzle.strings = new String[]{"ABCDEFGHIJAB", "ABCDEFGHIJA", "ACEHJBDFGIAC"};
        puzzle.createSet(puzzle.strings);
        long stime = System.nanoTime();
        puzzle.heapPermutation(a, a.length, a.length);
        long ftime = System.nanoTime();
        long diff = ftime - stime;
        System.out.println("\n Time (ms): " + diff / 1000000);
        puzzle.printResult();
    }

    private void printResult() {
        System.out.println("Print amount of solutions: " + solutionCounter);
        if (solutionCounter > 0) {
            System.out.println("Sample solution" + Arrays.toString(exampleSet));
        }
    }

    public void createSet(String[] wordsSet) {
        List<Character> chars = new ArrayList<>();
        chars.add(wordsSet[0].charAt(0));
        chars.add(wordsSet[1].charAt(0));
        chars.add(wordsSet[2].charAt(0));
        String word = String.join("", wordsSet);
        List<Character> characters = new ArrayList<>();
        for (Character c : word.toCharArray()) {
            if (!characters.contains(c)) {
                characters.add(c);
            }
        }
        for (Character character : chars) {
            notZero.add(characters.indexOf(character));
        }
        characterList = characters;
    }

    //Generating permutation using Heap Algorithm
    private void heapPermutation(long a[], int size, long n) {
        // if size becomes 1 then checks the obtained
        // permutation
        if (size == 1)
            arrayAdder(a, n);
        for (int i = 0; i < size; i++) {
            heapPermutation(a, size - 1, n);
            if (size % 2 == 1)
            {
                swap(a, 0, size - 1);
            }
            else {
                swap(a, i, size - 1);
            }
        }
    }

    private long[] swap(long[] a, int left, int right) {
        long temp = a[left];
        a[left] = a[right];
        a[right] = temp;
        return a;
    }

    private void arrayAdder(long a[], long n) {
        if (checkValidity(a)) {
            if (checkIfArrayNotAlreadyAdded(a)) {
                solutionCounter++;
            }
        }
    }

    private boolean checkValidity(long[] a) {
        if (isNotSafe(a)) return false;
        HashMap<Character, Long> map = createMap(a);
        long[] longs = createEquation(map);
        return testEquation(longs);
    }

    private boolean checkIfArrayNotAlreadyAdded(long[] a) {
        String string = Arrays.toString(Arrays.copyOfRange(a, 0, characterList.size()));
        if (stringHashSet.contains(string)) {
            return false;
        }
        stringHashSet.add(string);
        return true;
    }

    private boolean isNotSafe(long[] longs) {
        return !(longs[notZero.get(0)] != 0 && longs[notZero.get(1)] != 0 && longs[notZero.get(2)] != 0);
    }

    private HashMap<Character, Long> createMap(long[] longs) {
        HashMap<Character, Long> characterLongHashMap = new HashMap<>();
        for (int i = 0; i < characterList.size(); i++) {
            characterLongHashMap.put(characterList.get(i), longs[i]);
        }
        return characterLongHashMap;
    }

    private long[] createEquation(HashMap<Character, Long> map) {
        long[] longs = new long[3];
        for (int i = 0; i < 3; i++) {
            StringBuilder number = new StringBuilder();
            for (char character : strings[i].toCharArray()) {
                number.append(map.get(character));
            }
            longs[i] = Long.parseLong(number.toString());
        }
        return longs;
    }

    private boolean testEquation(long[] numbers) {
        long sum = numbers[0] + numbers[1];
        boolean valid = sum == numbers[2];
        if (valid) exampleSet = numbers;
        return valid;
    }
}
