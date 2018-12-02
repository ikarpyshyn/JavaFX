package Speedtedt.Conector;

import javafx.concurrent.Task;

public class SetProgresBar extends Task<Boolean> {
    public static int progress = 0;
    public static int progress1 = 0;

    public static int getProgress1() {
        return progress1;
    }

    public static int work;



    public static void setProgress1(int progress1) {
        SetProgresBar.progress1 = progress1;
    }

    @Override
    protected Boolean call() throws Exception {

        while (progress <= 10) {
            updateProgress( progress, 17 );
            Thread.sleep( 50 );
//            System.out.println( progress );
//            System.out.println( "nnnnnnnn    " );
        }
        while (work< 3) {
            updateProgress( progress1, 15 );
            Thread.sleep( 50 );
//            System.out.println( progress1 );
//            System.out.println( work );
        }
        updateProgress( 100, 100 );


        progress = 0;
        updateMessage( Integer.toString( 1 ) );
        work=0;
        System.out.println( "Bar ok" );
        return false;

    }

    public static void setProgress(int progress) {
        SetProgresBar.progress = progress;
    }
}