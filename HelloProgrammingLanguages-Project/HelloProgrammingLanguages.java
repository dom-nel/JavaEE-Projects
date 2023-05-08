import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.geometry.*;

public class HelloProgrammingLanguages extends Application
{

   public static void main(String[] args)
   {
      launch(args);
   }

   public void start(Stage primaryStage)
   {
      Label messageLabel = new Label("Hello World");
      
      Label messageLabel2 = new Label("Click any button to change the language:");
      
      Button java = new Button("Java");
      
      java.setOnAction(e ->{
         messageLabel.setText("System.out.println('Hello World');");
      });
      
      Button cPlusPlus = new Button("C++");
      
      cPlusPlus.setOnAction(e ->{
         messageLabel.setText("std:: << 'Hello World';");
      });
      
      Button python = new Button("Python");
      
      python.setOnAction(e ->{
         messageLabel.setText("print('Hello World')");
      });
      
      Button javaScript = new Button("JavaScript");
      
      javaScript.setOnAction(e ->{
         messageLabel.setText("console.log('Hello World')");
      });
      
      Button cSharp = new Button("C#");
      
      cSharp .setOnAction(e ->{
         messageLabel.setText("Console.WriteLine('Hello World');");
      });
      
      Button exit = new Button("Exit");
      
      exit.setOnAction(e ->{
         System.exit(0);
      });




      
      HBox hbox = new HBox(messageLabel);
      
      VBox vbox = new VBox(10, hbox, messageLabel2, java, cPlusPlus, python, javaScript, cSharp,exit);
      
      hbox.setAlignment(Pos.TOP_CENTER);
      vbox.setAlignment(Pos.TOP_CENTER);
      
      Scene scene = new Scene(vbox, 300, 325);
      
      primaryStage.setScene(scene);
      
      primaryStage.setTitle("Programming languages");
      primaryStage.show();
   }
}//Hello gui end