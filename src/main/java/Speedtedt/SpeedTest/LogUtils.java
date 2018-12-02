package Speedtedt.SpeedTest;

import fr.bmartel.speedtest.SpeedTestReport;
import fr.bmartel.speedtest.model.SpeedTestMode;
import javafx.scene.control.Label;
import org.apache.logging.log4j.Logger;
import Speedtedt.Conector.Connector;
import Speedtedt.Conector.SetLable2;
import Speedtedt.Conector.SetLable3;
import Speedtedt.Conector.SetProgresBar;
import Speedtedt.Controller;
import Speedtedt.Ping.Ping;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LogUtils {

    private static final int DEFAULT_SCALE = 4;
    private static final RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_EVEN;
    private static final BigDecimal VALUE_PER_SECONDS = new BigDecimal( 1000 );
    private static final BigDecimal MEGA_VALUE_PER_SECONDS = new BigDecimal( 1000000 );
    public static int i = 1;
    public static int s1;
    public static boolean s22=false;
    public static int s2;

    private static Label label;
    public static String wwww;

    public LogUtils(Controller controller) {
//        label = controller.getLable1();
    }

    public static final String LOG_REPORT_SEPARATOR = "--------------------------------------------------------";

    public static void logSpeedTestReport(final SpeedTestReport report, final Logger logger) {
        if (logger.isDebugEnabled()) {
            switch (report.getSpeedTestMode()) {
                case DOWNLOAD:
                    logger.debug( "--------------current download report--------------------" );
                    SetProgresBar.setProgress1( SetProgresBar.getProgress1()+1 );

                    System.out.println(Ping.pingclon.getTimer()  );

                    break;
                case UPLOAD:
                    logger.debug( "---------------current upload report--------------------" );
                    SetProgresBar.setProgress1( SetProgresBar.getProgress1()+1 );
                    System.out.println(Ping.pingclon.getTimer()  );

                    break;
                default:
                    try {
                        Thread.sleep( 0 );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
            }
            logReport( report, logger );
        }

    }

    public static void logFinishedTask(final SpeedTestMode mode, final long packetSize, final BigDecimal
            transferRateBitPerSeconds, final BigDecimal transferRateOctetPerSeconds, final Logger logger) {

        if (logger.isDebugEnabled()) {

            switch (mode) {
                case DOWNLOAD:
                    logger.debug( "======== Download [ OK ] =============" );

                    Connector.download = transferRateBitPerSeconds.divide( MEGA_VALUE_PER_SECONDS ).setScale(2, RoundingMode.HALF_UP).floatValue();


//                    Test.jLabel2.setText(Ping.pingclon.getText());
//                    Test.jLabel3.setText(Ping.pingclon.getText1());
//                    Test.jLabel5.setText(Ping.pingclon.getText3());


//                    Test.jLabel1.setText(Test.jLabel1.getText()+"          Download  "+transferRateBitPerSeconds.intValue()/500000 + " Mbit/second");
                    s1=(int)transferRateBitPerSeconds.divide( MEGA_VALUE_PER_SECONDS ).setScale(2, RoundingMode.HALF_UP).floatValue();
                    FixedTimeUploadExample.main();


                    break;
                case UPLOAD:
                    logger.debug( "========= Upload [ OK ]  =============" );
//                    .setScale(2, RoundingMode.HALF_UP).floatValue()

                    Connector.upload = transferRateBitPerSeconds.divide( MEGA_VALUE_PER_SECONDS ).setScale(2, RoundingMode.HALF_UP).floatValue();
                    System.out.println( wwww );
//                    Connector.upload ="lll";
//                     Connector.newLabel.setText( "ggggggggg" );
//                  label.setText("  Upload  "+transferRateBitPerSeconds.intValue()/500000 + " Mbit/second");
                    s2=(int)transferRateBitPerSeconds.divide( MEGA_VALUE_PER_SECONDS ).intValue();
////
                    break;
                default:

                    break;

            }

            logger.debug( "packetSize     : " + packetSize + " octet(s)" );
            logger.debug( "transfer rate  : " + transferRateBitPerSeconds + " bit/second   | " +
                    transferRateBitPerSeconds.divide( VALUE_PER_SECONDS, DEFAULT_SCALE, DEFAULT_ROUNDING_MODE )
                    + " Kbit/second  | " + transferRateBitPerSeconds.divide( MEGA_VALUE_PER_SECONDS ) + " Mbit/second" );
            System.out.print( transferRateBitPerSeconds.divide( MEGA_VALUE_PER_SECONDS ) );
            BigDecimal i = transferRateBitPerSeconds.divide( MEGA_VALUE_PER_SECONDS );
            transferRateBitPerSeconds.divide( MEGA_VALUE_PER_SECONDS );
            ;


        }
        ;


        logger.debug( "transfer rate  : " + transferRateOctetPerSeconds + " octet/second | " +
                transferRateOctetPerSeconds.divide( VALUE_PER_SECONDS, DEFAULT_SCALE, DEFAULT_ROUNDING_MODE )
                + " Koctet/second | " + transferRateOctetPerSeconds.divide( MEGA_VALUE_PER_SECONDS, DEFAULT_SCALE,
                DEFAULT_ROUNDING_MODE ) + " " +
                "Moctet/second" );
        logger.debug( "##################################################################" );




        if (s1<1) {
            Ping.pingclon.setText( "Połączenie jest słabe" );
            Ping.pingclon.setText3("(Wysokie prawdopodobieństwo wystąpienia błędów technicznych podczas wystawienia wniosku)");
            System.out.println( "Баг 1" );

        }else {if (s1<1&& Ping.pingclon.getText()!="Połączenie jest słabe"){
            Ping.pingclon.setText("Połączenie jest średnie");
            Ping.pingclon.setText3("");
        }}

        if (s22==true){if (s2<1) {
            Ping.pingclon.setText( "Połączenie jest słabe" );
            Ping.pingclon.setText3("(Wysokie prawdopodobieństwo wystąpienia błędów technicznych podczas wystawienia wniosku)");
            System.out.println( "Баг 2" );

        }else {if (s2<3&& Ping.pingclon.getText()!="Połączenie jest słabe"){
            Ping.pingclon.setText("Połączenie jest średnie");
            Ping.pingclon.setText3("");
        }}};
s22=true;

        System.out.print( s1+"    "+s2 );

        Connector.work1++;
        SetLable2.work++;
        SetLable3.work++;
        SetProgresBar.work++;
    }

    public static void logReport(final SpeedTestReport report, final Logger logger) {

        if (logger.isDebugEnabled()) {

            logger.debug( "progress             : " + report.getProgressPercent() + "%" );
//            SetProgresBar.setProgress1( (int) report.getProgressPercent() );
//            Test.jProgressBar1.setValue((int)report.getProgressPercent());
            logger.debug( "transfer rate bit    : " + report.getTransferRateBit() + "b/s" );
            logger.debug( "transfer rate octet  : " + report.getTransferRateOctet() + "B/s" );
            switch (report.getSpeedTestMode()) {
                case DOWNLOAD:
                    logger.debug( "downloaded for now   : " + report.getTemporaryPacketSize()
                            + "/" + report.getTotalPacketSize() );

                    break;
                case UPLOAD:
                    logger.debug( "uploaded for now     : " + report.getTemporaryPacketSize()
                            + "/" + report.getTotalPacketSize() );
                    break;
                default:

                    break;
            }
            if (report.getStartTime() > 0) {

                logger.debug( "amount of time       : " +
                        ((report.getReportTime() - report.getStartTime()) / 1000000000) + "s" );
            }

            logger.debug( LOG_REPORT_SEPARATOR );
        }
    }
}
