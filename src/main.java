
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class main extends Application {

    private double dragOffsetX;
    private double dragOffsetY;
    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button("Close");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.hide();
            }
        });
        HBox root = new HBox(button);
        root.setBackground(Background.EMPTY);
        
        Scene scene = new Scene(root);
        
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dragOffsetX = event.getScreenX() - primaryStage.getX();
                dragOffsetY = event.getScreenY() - primaryStage.getY();
                
            }
        });
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               primaryStage.setX(event.getScreenX() - dragOffsetX);
               primaryStage.setY(event.getScreenY() - dragOffsetY);
            }
        });
        
        scene.setFill(new Color(0.2, 0.3, 0.3, 1));
        
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.setWidth(400);
        primaryStage.setHeight(100);

        primaryStage.centerOnScreen();
        
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double x = bounds.getMinX() +(bounds.getWidth() - primaryStage.getWidth()) / 2.0;
        double y = bounds.getMinY() +(bounds.getHeight() - primaryStage.getHeight()) / 2.0;
        primaryStage.setX(x);
        primaryStage.setY(y);
        
        
        primaryStage.show();
    }

}
