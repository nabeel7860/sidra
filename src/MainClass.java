import java.io.File;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainClass extends Application {

	public void start(Stage mainstage) throws Exception {
		Group group = new Group();
		Scene scene = new Scene(group,550,400);
		mainstage.setScene(scene);
		
		Label title = new Label("Hall Management Software");
		title.setLayoutX(20);
		title.setLayoutY(20);
		title.setFont(Font.font("Times New Roman",45));
		title.setAlignment(Pos.CENTER);
		
		Label username = new Label("Username");
		username.setLayoutX(20);
		username.setLayoutY(100);
		Label password = new Label("Password");
		password.setLayoutX(20);
		password.setLayoutY(150);
		
		TextField usertext = new TextField();
		usertext.setLayoutX(100);
		usertext.setLayoutY(100);
		PasswordField passwordtext = new PasswordField();
		passwordtext.setLayoutX(100);
		passwordtext.setLayoutY(150);
		
		Button login = new Button("  Login  ");
		login.setLayoutX(100);
		login.setLayoutY(250);
		login.setOnAction((ActionEvent)->{
			if(usertext.getText().equals("admin") && passwordtext.getText().equals("admin"))
			{
				new IntermediaryClass();
				usertext.setText("");
				passwordtext.setText("");				
			//	mainstage.hide();
			System.out.println("Login Successfully");
			mainstage.hide();
			}
		});
		
		File file = new File("C:/Users/user/Desktop/HallImages/mainhall.jpg");
		Image img = new Image(file.toURI().toString());
		ImageView iv = new ImageView(img);
		
		group.getChildren().addAll(iv,title,username,password,usertext,passwordtext,login);
		mainstage.show();
	}

	public static void main(String[] a)
	{
		Application.launch(a);
	}	
}
