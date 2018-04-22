package lab.quantum.kevin.fibonacci;


public class Fibonacci {
    private Integer length; // length must be less than 46
    private Integer[] fibonacciSequence;

    public Fibonacci(int length) {
        this.length = length;
        fibonacciSequence = fibonacci(length);
    }

    public Integer getLength() {
        return length;
    }

    public Integer[] getFibonacciSequence() {
        return fibonacciSequence;
    }

    /**
     * Calculate Fibonacci sequence. Here provides a Recursive implement.
     *
     * @param length Fibonacci sequence, Must be less than 46.
     * @return Fibonacci sequence
     */
    private Integer[] fibonacci(int length) {
        Integer[] fibonacci = new Integer[length];
        fibonacci[0] = fibonacci[1] = 1;
        for (int i = 2; i < length; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci;
    }
}
