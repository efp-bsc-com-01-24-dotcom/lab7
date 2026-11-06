public  class StaticMethod{
    public static<T> void print(T[] array){
        for(T elem : array){
            System.out.println(elem);
        }
    public static void main(String[] args){
        Integer[] ints = new Integer[5];
        int  length = ints.length;

        for(int i = 0; i < length; i++){
            ints[i] = (int)(Math.random()*100);
        }
        print(ints);
        }
    }
}