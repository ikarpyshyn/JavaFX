package Speedtedt;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import Speedtedt.Conector.Connector;
import Speedtedt.Conector.SetLable2;
import Speedtedt.Conector.SetLable3;
import Speedtedt.Conector.SetProgresBar;
import Speedtedt.SpeedTest.LogUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Controller {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public Label Lable1;

    @FXML
    public ProgressBar Progressbar;

    @FXML
    public Label Lable2;

    @FXML
    private Button BtnSprawdźpolaczenie;

    @FXML
    private Button BtnZobaczjakpolepszyćswojepołączenie;


    @FXML
    public Label Lale3;


//    @FXML
//    private void radio2(ActionEvent event) throws IOException {
//        //графический контейнер
//        Stage stage = new Stage();
//
//        FXMLDocumentController(stage);
//    }

    //Метод запуска формы 2 для дальнейшего диалога
    protected void FXMLDocumentController(Stage stage) throws IOException {
        Parent root = FXMLLoader.load( getClass().getResource( "/WebView.fxml" ) );
        stage.setTitle( "Aviva SpeedTest" );
//        stage.setResizable(false);
        stage.setScene( new Scene( root, 1200, 700 ) );
        stage.show();
        LogUtils logUtils = new LogUtils( new Controller() );

    }


    @FXML
    void initialize() {
        BtnZobaczjakpolepszyćswojepołączenie.setOnAction( event -> {
            System.out.print( System.getProperty("user.dir") );
            Stage stage = new Stage();

            try {
                FXMLDocumentController(stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });



        BtnSprawdźpolaczenie.setOnAction( event -> {
            BtnSprawdźpolaczenie.setText( "Sprawdź ponownie" );


            /////////////////LEBEL_1//////////////////////////////////
            try {
                Connector task = new Connector();
                Lable1.textProperty().bind( task.messageProperty() );
                task.setOnRunning( (succeesesEvent) -> {
                    task.messageProperty();
                } );
                ExecutorService executorService
                        = Executors.newFixedThreadPool( 1 );
                executorService.execute( task );
                executorService.shutdown();

            } catch (NumberFormatException e) {
            }
            ///////////////LEBEL_2///////////////////////////////////////

            try {
                SetLable2 task = new SetLable2();
                task.setOnRunning( (succeesesEvent) -> {
                    Lable2.textProperty().bind( task.messageProperty() );
                } );
                ExecutorService executorService
                        = Executors.newFixedThreadPool( 1 );
                executorService.execute( task );
                executorService.shutdown();
            } catch (NumberFormatException e) {
            }
            //////////////////////////////LEBEL_3/////////////////////////////////////
            try {
                SetLable3 task = new SetLable3();
                task.setOnRunning( (succeesesEvent) -> {
                    Lale3.textProperty().bind( task.messageProperty() );
                } );
                ExecutorService executorService
                        = Executors.newFixedThreadPool( 1 );
                executorService.execute( task );
                executorService.shutdown();
            } catch (NumberFormatException e) {
            }
            //////////////////////////////PROGRESS/////////////////////////////////////
            try {
                SetProgresBar task = new SetProgresBar();
                task.setOnRunning( (succeesesEvent) -> {
                    Progressbar.progressProperty().bind( task.progressProperty() );

                } );
                ExecutorService executorService
                        = Executors.newFixedThreadPool( 1 );
                executorService.execute( task );
                executorService.shutdown();
            } catch (NumberFormatException e) {
            }
//            CounterTask counterTask = new CounterTask();
//            System.out.println("Count Started");
//            Progressbar.progressProperty().bind(countTask.progressProperty());
//            es.execute(t);


//while (Integer.toString( Tex )!=100)
//            Progressbar.setProgress(Double.parseDouble(Lale3.getText()) );

//            Task<Boolean> connector = new Connector();
//            connector.setOnSucceeded(e -> {
//
//                Lable1.setText( "lllllllllllllllllllllllllll" );
//
////                String s1=Connector.upload;
////                String s2=Connector.download;
//
//
//                Lable1.setText( "Super");
//
////                Lale3.setText(  );
////
//////                Lable1.textProperty().unbind();
////
////                String oooo =LogUtils.wwww;
////
////
////                    Lale3.setText( oooo );
//
//
//
////
////                Progressbar.progressProperty().unbind();
////                Progressbar.setProgress((double)result );
//
////                Speed sp = new Speed(Lale3);
////                sp.main();
//
//            });
//
//
//            new Thread(connector).start();
            //////////////////////////////////////////////////////
//            ExecutorService executor = Executors.newSingleThreadExecutor();
//            executor.submit(() -> {
//                String threadName = Thread.currentThread().getName();
//                System.out.println("Hello " + threadName);
//            });

            ///////////////////////////////////////////////////
//            new Thread(new Runnable() {

//                @Override
//                public void run() {
//                    PingComand.run();
//
//
//
//                    Lable2.setText( "lllllllll" );
//                             }
//            }).start();

            // выполняем в бесконечном цикле, пока
            // executor service не закончит выполнение всех future тасков
//            Callable task = () -> {
////
//                while (Connector.download==1000){
//                    System.out.print( "She nie" );
//                    Thread.sleep(500);
//                }
//                try {
//                    TimeUnit.SECONDS.sleep(500);
//                    return 123;
//                }
//                catch (InterruptedException e) {
//                    throw new IllegalStateException("task interrupted", e);
//                }
//            };
//
//            ExecutorService executor = Executors.newFixedThreadPool(1);
//            Future<Integer> future = executor.submit(task);
//
//            System.out.println("future done? " + future.isDone());
//
//            Integer result = null;
//            try {
//                result = future.get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println("future done? " + future.isDone());
//            System.out.print("result: " + result);
//            Lable1.setText( Integer.toString(result) );

//            Lale3.setText( "  Upload  "+Integer.toString( Connector.upload )+ " Mbit/second          Download  "+Integer.toString( Connector.download )+" Mbit/second");


            /////////////bekap////////////


//            PingComand mSecondThread;
//            mSecondThread = new PingComand();	//Создание потока
//            mSecondThread.start();
//            ControllerAll controllerAll;
//            controllerAll =new ControllerAll(getLable1());
//            controllerAll.start();
//            ControllerAll controllerAll =new ControllerAll(getLable1());

//            controllerAll.main();


//            DownloadFileExampleBecap downloadFileExample=new DownloadFileExampleBecap(getLable1());


//            Task<Boolean> downloadFileExample = new DownloadFileExampleBecap();
//                     Lable1.textProperty().bind(connector.messageProperty());
//                    connector.setOnSucceeded(e -> {
//                        Lable1.textProperty().unbind();
//                    });
//                    new Thread(connector).start();
//            Connector connector;
//            connector = new Connector(getLable1());	//Создание потока
//            connector.start();
//            UploadFileExample.main();

//            Speed sp = new Speed(Lale3);
//            downloadFileExample.main();


        } );
    }


}
