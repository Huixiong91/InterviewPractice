public class LimitClass {

    private static int count = 0;
    public LimitClass() throws OverLimitException {
        if (count++ >= 2) throw new OverLimitException("Over limit!!");
    }

    public static void main(String[] args) throws OverLimitException {
        LimitClass obj1 = new LimitClass();
        LimitClass obj2 = new LimitClass();
        System.out.println(obj1);
        System.out.println(obj2);
    }

    class OverLimitException extends Exception
    {
        public OverLimitException(String message)
        {
            super(message);
        }
    }

}
