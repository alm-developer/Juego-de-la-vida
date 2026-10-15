import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.CrearPartida;

public class MainApp extends Application {



    @Override
    public void start(Stage stage) {
        CrearPartida vista = new CrearPartida();
        Scene scene = new Scene(vista, 1200, 800);
        stage.setTitle("Life Lab - Simulador de la vida");
        stage.setScene(scene);
        stage.setMinWidth(900);
        stage.setMinHeight(600);
        stage.setFullScreen(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

