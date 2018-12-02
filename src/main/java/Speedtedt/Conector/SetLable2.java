package Speedtedt.Conector;

import javafx.concurrent.Task;
import Speedtedt.Ping.Ping;

public class SetLable2 extends Task<Boolean> {
    public static int work;



    @Override
    protected Boolean call() throws Exception {
        updateMessage( "" );
        while (work < 2) {
            Thread.sleep( 500 );
        }
        updateMessage( Ping.pingclon.getText3() );
        work=0;
        System.out.println( "Lab2 ok" );
        return true;
    }

}