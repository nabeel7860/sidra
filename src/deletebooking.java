import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javafx.event.EventHandler;
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
import javafx.stage.WindowEvent;

public class deletebooking {
	String url = "jdbc:mysql://127.0.0.1:8889/HallSoftware";
	String username = "root";
	String password = "root";
	
	deletebooking()
	{
		Group g = new Group();
		Group g2 = new Group();
		Scene s = new Scene(g,300,100);
		Scene s2 = new Scene(g2,300,300);
		Stage stage  = new Stage();
		
		Label deleting = new Label("Delete Form");
		deleting.setFont(Font.font("Times New Roman", 25));
		deleting.setAlignment(Pos.CENTER);
		deleting.setLayoutX(20);
		deleting.setLayoutY(10);
		Label label = new Label("Enter Password to prove identity");
		label.setLayoutX(40);
		label.setLayoutY(20);
		TextField pskey = new TextField();
		pskey.setLayoutX(60);
		pskey.setLayoutY(40);
		Button deletenow = new Button("Delete Now");
		deletenow.setLayoutX(60);
		deletenow.setLayoutY(120);
		deletenow.setOnAction((ActionEvent)->{
			if(pskey.getText().equals("admin"))
			{
				Connection updateconnect;
				try {
				updateconnect = DriverManager.getConnection(url,username,password);
				String query = "delete from booking";
			    PreparedStatement deletedStmt = updateconnect.prepareStatement(query);
				deletedStmt.execute();
			    updateconnect.close();
			    //System.out.println("now delete query will work here");
				s2.setFill(Color.GREEN);
				pskey.setText("");
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				}
			else
			{
				pskey.setText("");
				s2.setFill(Color.RED);
			}
		});
		
		Label warning = new Label("your are deleting whole record from database !!!");
		Button Yes = new Button("Agree");
		Yes.setLayoutX(20);
		Yes.setLayoutY(50);
		Button No = new Button("DisAgree");
		No.setLayoutX(100);
		No.setLayoutY(50);
		Yes.setOnAction((ActionEvent)->{
			stage.setScene(s2);
		});
		No.setOnAction((ACtionEvent)->{
			new IntermediaryClass();
			stage.hide();
		});
		File file = new File("C:/Users/user/Desktop/HallImages/delete.jpg");
		Image img = new Image(file.toURI().toString());
		ImageView iv = new ImageView(img);
		
		File file2 = new File("C:/Users/user/Desktop/HallImages/decision.jpg");
		Image img2 = new Image(file2.toURI().toString());
		ImageView iv2 = new ImageView(img2);
		
		g.getChildren().addAll(iv,deleting,Yes,No);
		g2.getChildren().addAll(iv2,pskey,deletenow,label);
		
		stage.setScene(s);
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			public void handle(WindowEvent arg0) {
			new IntermediaryClass();	
			}
		});
		stage.show();
	}
}
