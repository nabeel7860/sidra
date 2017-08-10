import java.io.File;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class IntermediaryClass {

	IntermediaryClass()
	{
	Group g = new Group();
	Scene s = new Scene(g,400,400);
	Stage stage = new Stage();
	Label welcome = new Label("W E L C O M E ");
	welcome.setLayoutX(20);
	welcome.setLayoutY(20);	
	welcome.setFont(Font.font("Times New Roman",50));
	Button newbooking = new Button("Add New");
	newbooking.setOnAction((ActionEvent)->{
		new booking();
		stage.hide();
	});
	Button oldbooking = new Button(" Bookings ");
	oldbooking.setOnAction((ActionEvent)->{
		new oldbooking();
		stage.hide();
	});
	Button updatebooking = new Button("Update Booking");
	updatebooking.setOnAction((ActionEvent)->{
		new updatebooking();
		stage.hide();
	});
	Button deletebooking = new Button("Delete all Booking");
	deletebooking.setOnAction((ActionEvnet)->{
		new deletebooking();
		stage.hide();
	});
	newbooking.setLayoutX(20);
	newbooking.setLayoutY(100);
	oldbooking.setLayoutX(20);
	oldbooking.setLayoutY(150);
	updatebooking.setLayoutX(20);
	updatebooking.setLayoutY(200);
	deletebooking.setLayoutX(20);
	deletebooking.setLayoutY(250);
	
	File file = new File("C:/Users/user/Desktop/HallImages/intermediary.jpg");
	Image img = new Image(file.toURI().toString());
	ImageView iv = new ImageView(img);
	
	g.getChildren().addAll(iv,welcome,newbooking,oldbooking,updatebooking,deletebooking);
	stage.setScene(s);
	stage.show();
	}
}
