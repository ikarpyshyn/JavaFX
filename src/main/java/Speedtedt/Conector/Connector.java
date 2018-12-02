package Speedtedt.Conector;

import javafx.concurrent.Task;
import Speedtedt.Ping.Ping;
import Speedtedt.Ping.PingComand;

public class Connector extends Task<Boolean> {
    public static float upload;
    public static float download;
    public static float work1;

    public static void setWork1(int work1) {
        Connector.work1 = work1;
    }

    @Override
    protected Boolean call() throws Exception {

//        work=0;
        updateMessage( "Proszę czekać. Trwa weryfikacja jakości połączenia" );
        PingComand mSecondThread;
        mSecondThread = new PingComand();    //Создание потока
        mSecondThread.start();

        while (work1 < 2) Thread.sleep( 50 );
        updateMessage( Ping.pingclon.getText() );

        System.out.println( "Conector ok" );

        return true;
    }
}
