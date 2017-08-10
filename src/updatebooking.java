import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class updatebooking {
	String url = "jdbc:mysql://127.0.0.1:8889/HallSoftware";
	String username = "root";
	String password = "root";
	updatebooking()
	{
		Group g = new Group();
		Scene scene = new Scene(g,500,650);
		Stage stage = new Stage();
		stage.setTitle("Specific Data");
		
		Label bd = new Label("Booked Data of Specific Person");
		Label id = new Label("ID");
		Label date = new Label("Date");	
		Label function = new Label("function");
		Label name = new Label("Name");	
		Label cnic = new Label("CNIC #");	
		Label guests = new Label("Guests");
		Label catering = new Label("Catering ");
		Label tf = new Label("Start Time");
		Label tt = new Label("End Time");
		Label on = new Label("Booker Name");
		Label ba = new Label("Bill Amount");
		Label contact = new Label("Contact #");
		
		
		TextField idt = new TextField();
		TextField namet = new TextField();
		TextField datet= new TextField();
		TextField cnict = new TextField();
		TextField guestst = new TextField();
		TextField cateringt = new TextField();
		TextField tft = new TextField();
		TextField ttt = new TextField();
		TextField ont = new TextField();
		TextField bat = new TextField();
		TextField contt = new TextField();
		TextField functext = new TextField();
		
		
		
		bd.setLayoutX(10);
		bd.setLayoutY(0);
		bd.setFont(Font.font("Times New Roman", 25));
		bd.setAlignment(Pos.CENTER);
		
		id.setLayoutX(10);
		id.setLayoutY(40);
		idt.setLayoutX(150);
		idt.setLayoutY(40);
		
		name.setLayoutX(10);
		name.setLayoutY(70);
		namet.setLayoutX(150);
		namet.setLayoutY(70);
		
		date.setLayoutX(10);
		date.setLayoutY(120);
		datet.setLayoutX(150);
		datet.setLayoutY(120);
		
		cnic.setLayoutX(10);
		cnic.setLayoutY(170);
		cnict.setLayoutX(150);
		cnict.setLayoutY(170);
		
		guests.setLayoutX(10);
		guests.setLayoutY(220);
		guestst.setLayoutX(150);
		guestst.setLayoutY(220);
		
		catering.setLayoutX(10);
		catering.setLayoutY(270);
		cateringt.setLayoutX(150);
		cateringt.setLayoutY(270);
		
		tf.setLayoutX(10);
		tf.setLayoutY(320);
		tft.setLayoutX(150);
		tft.setLayoutY(320);
		
		tt.setLayoutX(10);
		tt.setLayoutY(370);
		ttt.setLayoutX(150);
		ttt.setLayoutY(370);
		
		on.setLayoutX(10);
		on.setLayoutY(420);
		ont.setLayoutX(150);
		ont.setLayoutY(420);
		
		ba.setLayoutX(10);
		ba.setLayoutY(470);
		bat.setLayoutX(150);
		bat.setLayoutY(470);
		
		contact.setLayoutX(10);
		contact.setLayoutY(510);
		contt.setLayoutX(150);
		contt.setLayoutY(510);
		
		function.setLayoutX(10);
		function.setLayoutY(540);
		functext.setLayoutX(150);
		functext.setLayoutY(540);
		
		
		Button update = new Button("UPDATE Data");
		update.setLayoutX(20);
		update.setLayoutY(620);
		update.setOnAction((ActionEvent)->{
			Connection updatedata;
			try{
			String userinput = idt.getText();		
			updatedata = DriverManager.getConnection(url,username,password);
		String set=	("update Booking set date = ? , function = ? , name = ? , cnic =? , guests = ? , catering = ? ,starttime = ? , endtime = ? , obname = ? , bill =? , contact = ?  " + " where bid ="+userinput);
			PreparedStatement preparedStmt = updatedata.prepareStatement(set);
	 	    preparedStmt.setString(3, namet.getText());
	 	    preparedStmt.setString(1, datet.getText());
	 	    preparedStmt.setString(4, cnict.getText());    
	 	    preparedStmt.setString(5, guestst.getText());
		    preparedStmt.setString(6, cateringt.getText());
		    preparedStmt.setString(7, tft.getText());    
		    preparedStmt.setString(8, ttt.getText());    
		    preparedStmt.setString(9, ont.getText());    
		    preparedStmt.setString(10, bat.getText());    
		    preparedStmt.setString(11, contt.getText());
		    preparedStmt.setString(2, functext.getText());
		    
		    preparedStmt.executeUpdate();	
			namet.setText("");
	 	    datet.setText("");
			cnict.setText("");
			guestst.setText("");
			cateringt.setText("");
			tft.setText("");		
			ttt.setText("");
			ont.setText("");
			bat.setText("");
			contt.setText("");
			functext.setText("");
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		});
		
		Button delete = new Button("DELETE Data");
		delete.setLayoutX(150);
		delete.setLayoutY(620);
		delete.setOnAction((ActionEvent)->{
			String deletetext = idt.getText();
			Connection updateconnect;
			try {
			updateconnect = DriverManager.getConnection(url,username,password);
			String query = "delete from booking where bid ="+ deletetext ;
		      PreparedStatement deletedStmt = updateconnect.prepareStatement(query);
			deletedStmt.execute();
			namet.setText("");
	 	    datet.setText("");
			cnict.setText("");
			guestst.setText("");
			cateringt.setText("");
			tft.setText("");		
			ttt.setText("");
			ont.setText("");
			bat.setText("");
			contt.setText("");
			functext.setText("");
			updateconnect.close();
			
		} catch(Exception ex)
			{
			ex.printStackTrace();
			}
		});
		
		
		
		Button fetch = new Button("FETCH Data");
		fetch.setLayoutX(280);
		fetch.setLayoutY(620);
		fetch.setOnAction((ActionEvnet)->{
			String userinput = idt.getText();
			Connection updateconnect;
			try{
				updateconnect = DriverManager.getConnection(url,username,password);
				Statement stmt = updateconnect.createStatement();
				ResultSet rs = stmt.executeQuery("select * from booking where bid=" + userinput );	
				while(rs.next())
				{			
				String one = rs.getString(2);
				String two = rs.getString(3);
				String three = rs.getString(4);
				String four = rs.getString(5);
				String five = rs.getString(6);
				String six = rs.getString(7);
				String seven = rs.getString(8);
				String eight = rs.getString(9);
				String nine = rs.getString(10);
				String ten = rs.getString(11);
				String eleven = rs.getString(12);
			
				namet.setText(three);
		 	    datet.setText(one);
				cnict.setText(four);
				guestst.setText(five);
				cateringt.setText(six);
				tft.setText(seven);		
				ttt.setText(eight);
				ont.setText(nine);
				bat.setText(ten);
				contt.setText(eleven);
				functext.setText(two);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		});
		
		
		
		File file = new File("C:/Users/user/Desktop/HallImages/update.jpg");
		Image img = new Image(file.toURI().toString());
		ImageView iv = new ImageView(img);
		
		g.getChildren().addAll(iv,bd,id,name,date,cnic,guests,catering,tf,tt,on,ba,contact,idt,namet,datet,cnict,guestst,cateringt,tft,ttt,ont,bat,contt,function,functext,update,delete,fetch);
		stage.setScene(scene);
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent arg0) {
				new IntermediaryClass();
				
			}
		});
		stage.show();
	}
	
}
