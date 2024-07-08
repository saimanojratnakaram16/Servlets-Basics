
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.Servlet;

public class Main {
    public static void main(String[] args) throws LifecycleException {
        System.out.println("Hello world!");
        Tomcat tomcat = new Tomcat();


        // Create a context with a dummy docBase
        Context context = tomcat.addContext("", null);

        Tomcat.addServlet(context, "HelloServlet", new HelloServlet());
        context.addServletMappingDecoded("/hello", "HelloServlet");

        // Start the Tomcat server
        tomcat.start();
        tomcat.getServer().await();
    }
}
