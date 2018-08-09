
 
import java.lang.instrument.Instrumentation;
 

public class Agent {



    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("Im 1st premain,My agentAges = [" + agentArgs + "].");
    }


    public static void premain(String agentArgs) {
        System.out.println("Im 2ed premain,My agentAges = [" + agentArgs + "].");
    }
}
