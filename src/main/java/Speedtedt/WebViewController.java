package Speedtedt;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class WebViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private WebView webView;

    @FXML
    void initialize() {
        webView.setZoom(1.3);
        URL helpURL;
        helpURL = Main.class.getResource(
                "/Instrukcjadlaagentw.html");
        WebEngine engine = webView.getEngine();
        engine.load( String.valueOf( helpURL ) );

    }
}
