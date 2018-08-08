


import java.io.IOException;
aspect AppAspect {
    void around():call(void App.sayHello()){
        System.out.println("before transaction....");
        new IOException().printStackTrace();
        proceed();
        System.out.println("after transaction....");
    }
}
public class App
{

    public void sayHello(){
        System.out.println("Hello AspectJ.");
    }
    public static void main( String[] args )
    {
        App app = new App();
        app.sayHello();
    }
}