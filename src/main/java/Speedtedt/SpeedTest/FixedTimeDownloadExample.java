/*
 * The MIT License (MIT)
 * <p/>
 * Copyright (c) 2016-2017 Bertrand Martel
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package Speedtedt.SpeedTest;

import fr.bmartel.speedtest.SpeedTestReport;
import fr.bmartel.speedtest.SpeedTestSocket;
import fr.bmartel.speedtest.inter.ISpeedTestListener;
import fr.bmartel.speedtest.model.SpeedTestError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Speedtedt.Conector.Connector;
import Speedtedt.Conector.SetLable2;
import Speedtedt.Conector.SetLable3;
import Speedtedt.Conector.SetProgresBar;
import Speedtedt.Ping.Ping;

/**
 * Begin to download a file from server & stop downloading when test duration is elapsed.
 *
 * @author Bertrand Martel
 */
public class FixedTimeDownloadExample {

    /**
     * spedd examples server uri.
     */
    private final static String SPEED_TEST_SERVER_URI_DL = "http://ipv4.ikoula.testdebit.info/100M.iso";

    /**
     * amount of time between each speed test reports set to 1s.
     */
    private static final int REPORT_INTERVAL = 1000;

    /**
     * speed test duration set to 15s.
     */
    private static final int SPEED_TEST_DURATION = 15000;

    /**
     * logger.
     */
    private final static Logger LOGGER = LogManager.getLogger(FixedTimeDownloadExample.class.getName());


    public static void main() {
        SetProgresBar.setProgress1( 0 );

        final SpeedTestSocket speedTestSocket = new SpeedTestSocket();

        //speedTestSocket.setUploadStorageType(UploadStorageType.FILE_STORAGE);

        speedTestSocket.addSpeedTestListener(new ISpeedTestListener() {

            @Override
            public void onCompletion(final SpeedTestReport report) {
                //called when download/upload is complete
                LogUtils.logFinishedTask(report.getSpeedTestMode(), report.getTotalPacketSize(),
                        report.getTransferRateBit(),
                        report.getTransferRateOctet(), LOGGER);
            }

            @Override
            public void onError(final SpeedTestError speedTestError, final String errorMessage) {
                if (LOGGER.isErrorEnabled()) {
                    LOGGER.error(errorMessage);
                    System.out.println("test Download er"  );
                    Ping.pingclon.setText( "Połączenie jest słabe" );
                    Ping.pingclon.setText3( "(Wysokie prawdopodobieństwo wystąpienia błędów technicznych podczas wystawienia wniosku)" );

                    Connector.work1++;
                    SetLable2.work++;
                    SetLable3.work++;
                    SetProgresBar.work++;
//                    FixedTimeUploadExample.main();
                }
            }

            @Override
            public void onProgress(final float percent, final SpeedTestReport downloadReport) {
                LogUtils.logSpeedTestReport(downloadReport, LOGGER);
            }
        });

        speedTestSocket.startFixedDownload(SPEED_TEST_SERVER_URI_DL,
                SPEED_TEST_DURATION, REPORT_INTERVAL);
    }
}
