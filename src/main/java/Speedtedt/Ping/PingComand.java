package Speedtedt.Ping;

import Speedtedt.Conector.Connector;
import Speedtedt.Conector.SetLable2;
import Speedtedt.Conector.SetLable3;
import Speedtedt.Conector.SetProgresBar;
import Speedtedt.SpeedTest.FixedTimeDownloadExample;
import Speedtedt.SpeedTest.FixedTimeUploadExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PingComand extends Thread {


    public void run() {
        Connector.setWork1( 0 );
        Connector.download=0;
        Connector.upload=0;
        SetLable2.work= 0;
        SetLable3.work= 0;
        SetProgresBar.work=0;
//        System.out.println( "22222222222" );

        String a = "";
        String xx = "";
        int timer = 0;
        try {
            Process p = Runtime.getRuntime().exec( "ping -n 10 52.49.153.118 " );
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader( p.getInputStream() ) );
            String d = "";

            while ((d = inputStream.readLine()) != null) {
                Ping.main( "", d, xx, timer );
                timer++;

                a += d;
//                System.out.println( timer );
                SetProgresBar.setProgress( timer );
                System.out.println( d );
                Ping.pingclon.setText( "" );
                Ping.pingclon.setText1( xx );
                Ping.pingclon.setTimer( timer );
//                System.out.println( Ping.pingclon.timer );
            }
        } catch (IOException e) {
        }
        if (a.contains( "(0% loss)" ) == true) {
            System.out.println( "Połączenie jest dobre" );
            Ping.pingclon.setText( "Połączenie jest dobre." );
            Ping.pingclon.setText3( "Można bez przeszkód zrealizować sprzedaż w Sales Cloud." );
            Ping.pingclon.setText1( " " );
            FixedTimeDownloadExample.main();
//            FixedTimeUploadExample.main();
        } else {
            if (a.contains( "(10% loss)" ) == true) {
                System.out.println( "Połączenie jest srednie-%" );
                Ping.pingclon.setText( "Połączenie jest średnie" );
                Ping.pingclon.setText1( "Połączenie jest średnie" );

                FixedTimeDownloadExample.main();

                FixedTimeUploadExample.main();

            } else {
                if (a.contains( "(20% loss)" ) == true) {
                    System.out.println( "Połączenie jest słabe%" );
                    Ping.pingclon.setText( "Połączenie jest słabe" );
                    Ping.pingclon.setText3( "(Wysokie prawdopodobieństwo wystąpienia błędów technicznych podczas wystawienia wniosku)" );


                    FixedTimeDownloadExample.main();
                    FixedTimeUploadExample.main();
                } else {
                    if (a.contains( "(30% loss)" ) == true) {
                        System.out.println( "Połączenie jest słabe" );
                        Ping.pingclon.setText( "Połączenie jest słabe" );
                        Ping.pingclon.setText3( "(Wysokie prawdopodobieństwo wystąpienia błędów technicznych podczas wystawienia wniosku)" );
                        FixedTimeDownloadExample.main();
                            FixedTimeUploadExample.main();
                    } else {
                        if (a.contains( "(40% loss)" ) == true) {
                            System.out.println( "Połączenie jest słabe" );
                            Ping.pingclon.setText( "Połączenie jest słabe" );
                            Ping.pingclon.setText3( "(Wysokie prawdopodobieństwo wystąpienia błędów technicznych podczas wystawienia wniosku)" );
                            FixedTimeDownloadExample.main();
                            FixedTimeUploadExample.main();
                        } else {
                            if (a.contains( "(40% loss)" ) == true) {
                                System.out.println( "Połączenie jest słabe" );
                                Ping.pingclon.setText( "Połączenie jest słabe" );
                                Ping.pingclon.setText3( "(Wysokie prawdopodobieństwo wystąpienia błędów technicznych podczas wystawienia wniosku)" );
                                FixedTimeDownloadExample.main();
                                FixedTimeUploadExample.main();
                            } else {
                                if (a.contains( "(50% loss)" ) == true) {
                                    System.out.println( "Połączenie jest słabe" );
                                    Ping.pingclon.setText( "Połączenie jest słabe" );
                                    Ping.pingclon.setText3( "(Wysokie prawdopodobieństwo wystąpienia błędów technicznych podczas wystawienia wniosku)" );
                                    FixedTimeDownloadExample.main();
                                    FixedTimeUploadExample.main();
                                } else {
                                    if (a.contains( "(50% loss)" ) == true) {
                                        System.out.println( "Połączenie jest słabe" );
                                        Ping.pingclon.setText( "Połączenie jest słabe" );
                                        Ping.pingclon.setText3( "(Wysokie prawdopodobieństwo wystąpienia błędów technicznych podczas wystawienia wniosku)" );
                                        FixedTimeDownloadExample.main();
                                        FixedTimeUploadExample.main();
                                    } else {
                                        if (a.contains( "(60% loss)" ) == true) {
                                            System.out.println( "Połączenie jest słabe" );
                                            Ping.pingclon.setText( "Połączenie jest słabe" );
                                            Ping.pingclon.setText3( "(Wysokie prawdopodobieństwo wystąpienia błędów technicznych podczas wystawienia wniosku)" );
                                            FixedTimeDownloadExample.main();
                                            FixedTimeUploadExample.main();
                                        } else {
                                            if (a.contains( "(70% loss)" ) == true) {
                                                System.out.println( "Połączenie jest słabe" );
                                                Ping.pingclon.setText( "Połączenie jest słabe" );
                                                Ping.pingclon.setText3( "(Wysokie prawdopodobieństwo wystąpienia błędów technicznych podczas wystawienia wniosku)" );
                                                FixedTimeDownloadExample.main();
                                                FixedTimeUploadExample.main();
                                            } else {
                                                if (a.contains( "(80% loss)" ) == true) {
                                                    System.out.println( "Połączenie jest słabe" );
                                                    Ping.pingclon.setText( "Połączenie jest słabe" );
                                                    Ping.pingclon.setText3( "(Wysokie prawdopodobieństwo wystąpienia błędów technicznych podczas wystawienia wniosku)" );
                                                    FixedTimeDownloadExample.main();
                                                    FixedTimeUploadExample.main();
                                                } else {
                                                    if (a.contains( "(90% loss)" ) == true) {
                                                        System.out.println( "Połączenie jest słabe%" );
                                                        Ping.pingclon.setText( "Połączenie jest słabe" );
                                                        Ping.pingclon.setText3( "(Wysokie prawdopodobieństwo wystąpienia błędów technicznych podczas wystawienia wniosku)" );
                                                        FixedTimeDownloadExample.main();
                                                        FixedTimeUploadExample.main();
                                                    } else {
                                                        System.out.println( "Brak połączenia" );
                                                        Ping.pingclon.setText( "Brak połączenia" );
                                                        Ping.pingclon.setText3( "(Brak połączenia z siecią. Sprzedaż nie jest możliwa) " );
//                                                        Ping.pingclon.setText("Brak połączenia");
//                                                        Ping.pingclon.setText3("(Brak połączenia z siecią. Sprzedaż nie jest możliwa)");
                                                        Connector.work1+=2;
                                                        SetLable2.work+=2;
                                                        SetLable3.work+=2;
                                                        SetProgresBar.work+=2;
                                                    }
                                                }
                                            }
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
//            DownloadFileExampleBecap.main();
//            FixedTimeUploadExample.main();
//        if (Ping.pingclon.getText().contains("Połączenie jest dobre") == true) {
//            Test.jLabel2.setText("<html>"+Ping.pingclon.getText()+" ok </html>");
//        }
//        Test.jLabel2.setText(Ping.pingclon.getText());
//        Test.jLabel3.setText(Ping.pingclon.getText1());
    }

    ;

}
