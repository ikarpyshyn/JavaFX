package Speedtedt.Conector;

import javafx.concurrent.Task;

public class SetLable3 extends Task<Boolean> {
    public static int work;



    @Override
    protected Boolean call() throws Exception {

        while (work< 2) {
            Thread.sleep( 50 );
        }
        Thread.sleep( 10 );
        updateMessage( "  Upload  " + Float.toString( Connector.upload ) + " Mbit/second          Download  " + Float.toString( Connector.download ) + " Mbit/second" );
        work=0;
        System.out.println( "Lab3 ok" );
        return true;
    }

}