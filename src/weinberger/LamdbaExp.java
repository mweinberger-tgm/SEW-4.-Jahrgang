package weinberger;

import java.util.function.Consumer;

/**
 * Beispiele zum Nachschlagen rueberkopieren !
 * 
 * @author Guys @ Oracle
 *
 */
public class LamdbaExp {

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            
            // The following statement causes the compiler to generate
            // the error "local variables referenced from a lambda expression
            // must be final or effectively final" in statement A:
            //
            // x = 99;
            
            Consumer<Integer> myConsumer = (y) -> 
            {
                System.out.println("x = " + x); // Statement A
                System.out.println("y = " + y);
                System.out.println("this.x = " + this.x);
                System.out.println("LambdaScopeTest.this.x = " +
                    LamdbaExp.this.x);
            };

            myConsumer.accept(x);

        }
    }

    public static void main(String... args) {
        LamdbaExp st = new LamdbaExp();
        LamdbaExp.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}