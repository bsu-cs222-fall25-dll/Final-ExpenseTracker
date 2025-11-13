package edu.bsu.cs;

import io.github.palexdev.materialfx.theming.JavaFXThemes;
import io.github.palexdev.materialfx.theming.MaterialFXStylesheets;
import io.github.palexdev.materialfx.theming.UserAgentBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {
        UserAgentBuilder.builder()
                .themes(JavaFXThemes.CASPIAN)
                .themes(MaterialFXStylesheets.forAssemble(true))
                .setDeploy(true)
                .setResolveAssets(true)
                .build()
                .setGlobal();

        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource("ExpenseTracker.fxml")));
        primaryStage.setTitle("Expense Tracker");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
