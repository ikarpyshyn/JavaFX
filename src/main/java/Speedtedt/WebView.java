package Speedtedt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Speedtedt.SpeedTest.LogUtils;

public class WebView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load( getClass().getResource( "/WebView.fxml" ) );
        primaryStage.setTitle( "Aviva SpeedTest" );
        primaryStage.setResizable(false);
        primaryStage.setScene( new Scene( root, 1200, 700 ) );
        primaryStage.show();
        LogUtils logUtils = new LogUtils( new Controller() );
    }


    public static void main(String[] args) {
        launch( args );
    }
}
