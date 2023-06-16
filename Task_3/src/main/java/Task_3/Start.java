package Task_3;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

public class Start {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context ctx = tomcat.addContext("", null);

        Tomcat.addServlet(ctx, "time", new TimeServlet());
        ctx.addServletMapping("/time", "time");

        tomcat.start();
        tomcat.getServer().await();
    }
}