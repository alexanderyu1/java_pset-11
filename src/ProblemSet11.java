import java.util.ArrayList;

public class ProblemSet11 {

    public ArrayList<String> fizzBuzz(int start, int end) {
        if (start < end) {
            int countArray = start;
            ArrayList<String> temp = new ArrayList<>();

            while (countArray < end) {
                if (countArray % 3 == 0) {
                    if (countArray % 5 == 0) {
                        temp.add("FizzBuzz");
                    }
                    else {
                        temp.add("Fizz");
                    }
                }
                else if (countArray % 5 == 0) {
                    temp.add("Buzz");
                }
                else {
                    temp.add(String.valueOf(countArray));
                }
                countArray++;
            }
            return temp;
        }
        return null;
    }

    public int maxSpan(ArrayList<Integer> numbers) {
        if (numbers != null) {
            switch (numbers.size()) {
                case 0:
                case 1:
                    return numbers.size();
                default:
                    break;
            }

            int span = 1;
            for (int i = 0; i < numbers.size(); i++) {
                int num = numbers.get(i);

                for (int k = numbers.size() - 1; k > i; k--) {
                    if (numbers.get(k) == num && span < (k - i + 1)) {
                        span = k - i + 1;
                    }
                }
            }
            return span;
        }
        return -1;
    }

    public ArrayList<Integer> fix34(ArrayList<Integer> numbers) {
        if (numbers != null) {
            ArrayList<Integer> fours = new ArrayList<>();
            ArrayList<Integer> threes = new ArrayList<>();

            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) == 3) {
                    threes.add(i);
                }
                else if (numbers.get(i) == 4) {
                    fours.add(i);
                }
            }


            if (fours.size() == threes.size() && threes.get(0) < fours.get(0)) {
                boolean count = true;

                for (int i = 0; i < numbers.size() - 1; i++) {
                    if (numbers.get(i) == 3 && numbers.get(i + 1) == 3) {
                        count = false;
                    }
                }

                if (count) {
                    for (int i = 0; i < fours.size(); i++) {
                        numbers.remove(Integer.valueOf(4));
                    }
                    for (int i = 0; i < threes.size(); i++) {
                        numbers.remove(Integer.valueOf(3));
                    }
                    for (int i = 0; i < threes.size(); i++) {
                        numbers.add(threes.get(i), 3);
                        numbers.add(threes.get(i) + 1, 4);
                    }

                    return numbers;
                }
            }
        }
        return null;
    }

    public ArrayList<Integer> fix45(ArrayList<Integer> numbers) {
        if (numbers != null) {
            ArrayList<Integer> fours = new ArrayList<>();
            ArrayList<Integer> fives = new ArrayList<>();

            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) == 5) {
                    fives.add(i);
                } else if (numbers.get(i) == 4) {
                    fours.add(i);
                }
            }

            if (fours.size() == fives.size()) {
                boolean count = true;

                for (int i = 0; i < numbers.size() - 1; i++) {
                    if (numbers.get(i) == 4 && numbers.get(i + 1) == 4) {
                        count = false;
                    }
                }

                if (count) {
                    for (int i = 0; i < fours.size(); i++) {
                        numbers.remove(Integer.valueOf(4));
                    }
                    for (int i = 0; i < fives.size(); i++) {
                        numbers.remove(Integer.valueOf(5));
                    }
                    for (int i = 0; i < fives.size(); i++) {
                        numbers.add(fours.get(i), 4);
                        numbers.add(fours.get(i) + 1, 5);
                    }
                    return numbers;
                }
            }
        }
        return null;
    }

    public boolean canBalance(ArrayList<Integer> numbers) {
        if (numbers != null && numbers.size() > 0) {
            for (int i = 0; i < numbers.size(); i++) {
                ArrayList<Integer> start = new ArrayList<>(numbers.subList(0, i + 1));
                ArrayList<Integer> end = new ArrayList<>(numbers.subList(i + 1, numbers.size()));
                int startingsum = 0;
                int endingsum = 0;

                for (int n : start) {
                    startingsum += n;
                }
                for (int n : end) {
                    endingsum += n;
                }
                if (startingsum == endingsum) return true;
            }
        }
        return false;
    }

    public boolean linearIn(ArrayList<Integer> outer, ArrayList<Integer> inner) {
        if (outer != null && inner != null && outer.size() > 0 && inner.size() > 0) {
            for (int i = 0; i < inner.size() - 1; i++) {
                if (inner.get(i) > inner.get(i + 1))
                    return false;
            }
            for (int i = 0; i < outer.size() - 1; i++) {
                if (outer.get(i) > outer.get(i + 1)) {
                    return false;
                }
            }
            int count = 0;
            for (Integer integer : inner) {
                for (int z : outer) {
                    if (z == integer) {
                        count++;
                        break;
                    }
                }
            }
            return count >= inner.size();
        }
        return false;
    }

    public ArrayList<Integer> squareUp(int n) {
        if (n >= 0) {
            if (n == 0) {
                return new ArrayList<>(0);
            }
            ArrayList<Integer> out = new ArrayList<>();
            for (int i = n; i > 0; i--) {
                int sub = i - 1;

                for (int k = 0; k < n; k++) {
                    if (sub > 0) {
                        out.add(0);
                    } else {
                        out.add(n - k);
                    }
                    sub--;
                }
            }
            return out;
        }
        return null;
    }

    public ArrayList<Integer> seriesUp(int n) {
        if (n >= 0) {
            if (n == 0) {
                return new ArrayList<>(0);
            }
            ArrayList<Integer> arr = new ArrayList<>();
            int length = 1;
            for (int i = 0; i < n; i++) {
                int count = 1;

                for (int z = 0; z < length; z++) {
                    arr.add(count);
                    count++;
                }
                length++;
            }

            return arr;
        }
        return null;
    }

    public int maxMirror(ArrayList<Integer> numbers) {
        if (numbers != null) {
            int firstList = numbers.size();

            int[][] LCSuff = new int[firstList + 1][firstList + 1];
            int count = 0;

            for (int i = 0; i <= firstList; i++) {
                for (int k = 0; k <= firstList; k++) {
                    if (i == 0 || k == 0) {
                        LCSuff[i][k] = 0;
                    }
                    else if (numbers.get(i - 1).equals(numbers.get(firstList - k))) {
                        LCSuff[i][k] = LCSuff[i - 1][k - 1] + 1;
                        count = Math.max(count, LCSuff[i][k]);
                    }
                    else {
                        LCSuff[i][k] = 0;
                    }
                }
            }
            return count;
        }
        return -1;
    }

    public int countClumps(ArrayList<Integer> numbers) {
        if (numbers != null) {
            int cur = numbers.get(0);
            int past = cur;
            int past1;
            int count = 0;

            if (numbers.get(0).equals(numbers.get(1))) count++;
            for (Integer number : numbers) {
                past1 = past;
                past = cur;
                cur = number;

                if (cur == past && past != past1) {
                    count++;
                }
            }
            return count;
        }
        return -1;
    }
}