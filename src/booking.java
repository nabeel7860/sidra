import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import javafx.event.EventHandler;
import javafx.print.PrinterJob;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class booking {
	String url = "jdbc:mysql://127.0.0.1:8889/HallSoftware";
	String username = "root";
	String password = "root";
	booking()
	{
		Group g = new Group();
		Scene s = new Scene(g,500,500);
		Stage stage = new Stage();

		Label form = new Label("Booking Form");
		form.setFont(Font.font("Times New Roman",65));
		Label id = new Label("Id number");	
		Label date = new Label("Date");
		Label function = new Label("Function");
		Label person_name = new Label("Person Name");
		Label person_cnic = new Label("Person CNIC");
		Label guests = new Label("Guests");
		Label caterings = new Label("Caterings");
		Label timingsfrom = new Label("Timings From ");
		Label timingsto = new Label("Timings To");
		Label order_booker_name = new Label("Order Booker Name");
		Label bill_amount = new Label("Bill Amount");
		Label contact_num = new Label("Contact Number");
		
		form.setLayoutX(10);
		id.setLayoutX(400);
		date.setLayoutX(10);
		function.setLayoutX(10);
		person_name.setLayoutX(10);
		person_cnic.setLayoutX(10);
		guests.setLayoutX(10);
		caterings.setLayoutX(10);
		timingsfrom.setLayoutX(10);
		timingsto.setLayoutX(10);
		order_booker_name.setLayoutX(10);
		bill_amount.setLayoutX(10);
		contact_num.setLayoutX(10);
		
		form.setLayoutY(20);
		id.setLayoutY(80);
		date.setLayoutY(100);
		function.setLayoutY(130);
		person_name.setLayoutY(160);
		person_cnic.setLayoutY(190);
		guests.setLayoutY(220);
		caterings.setLayoutY(250);
		timingsfrom.setLayoutY(280);
		timingsto.setLayoutY(310);
		order_booker_name.setLayoutY(340);
		bill_amount.setLayoutY(370);
		contact_num.setLayoutY(400);
		
		DatePicker dp = new DatePicker();	
		TextField idtext = new TextField();
		TextField functext = new TextField();
		TextField persontext = new TextField();
		TextField cnictext = new TextField();
		TextField gueststext = new TextField();
		TextField cateringtext = new TextField();	
		TextField tftext = new TextField();
		TextField totext = new TextField();
		TextField orderbookertext = new TextField();
		TextField billtext = new TextField();
		TextField contacttext = new TextField();
		/*Label dpl = new Label(dp.getValue().toString());
		Label fl = new Label(functext.getText());
		Label pl = new Label(persontext.getText());
		Label cl = new Label(cnictext.getText());
		Label gl = new Label(gueststext.getText());
		Label ctl = new Label(cateringtext.getText());
		Label tfl = new Label(tftext.getText());
		Label tol = new Label(totext.getText());
		Label ol = new Label(orderbookertext.getText());
		Label bl = new Label(billtext.getText());
		 */
		idtext.setLayoutX(400);
		dp.setLayoutX(180);
		functext.setLayoutX(180);
		persontext.setLayoutX(180);
		cnictext.setLayoutX(180);
		gueststext.setLayoutX(180);
		cateringtext.setLayoutX(180);
		tftext.setLayoutX(180);
		totext.setLayoutX(180);
		orderbookertext.setLayoutX(180);
		billtext.setLayoutX(180);
		contacttext.setLayoutX(180);
		
		idtext.setLayoutY(100);
		dp.setLayoutY(100);
		functext.setLayoutY(130);
		persontext.setLayoutY(160);
		cnictext.setLayoutY(190);
		gueststext.setLayoutY(220);
		cateringtext.setLayoutY(250);
		tftext.setLayoutY(280);
		totext.setLayoutY(310);
		orderbookertext.setLayoutY(340);
		billtext.setLayoutY(370);
		contacttext.setLayoutY(400);
		
		Button insert_print = new Button("Data Insert");
		insert_print.setLayoutX(50);
		insert_print.setLayoutY(440);
		
		Pane hbox = new Pane();
		hbox.getChildren().addAll(id,idtext,form,date,function,person_name,person_cnic,guests,caterings,timingsfrom,timingsto,order_booker_name,bill_amount,
		contact_num,dp,functext,persontext,cnictext,gueststext,cateringtext,tftext,totext,orderbookertext,billtext,contacttext);
		
		insert_print.setOnAction((ActionEvent)->{
		System.out.println("Insert Query Will be Written Here");
		try{
			//k = Integer.valueOf(patienttextid.getText());
			Connection inputconnect = DriverManager.getConnection(url,username,password);
			String string = "insert into Booking(bid,date,function,name,cnic,guests,catering,starttime,endtime,obname,bill,contact)" +"values(?,?,?,?,?,?,?,?,?,?,?,?)";
			java.sql.PreparedStatement ppinsert = inputconnect.prepareStatement(string);	
			ppinsert.setString(1,idtext.getText());				
			ppinsert.setString(2,dp.getValue().toString());
			ppinsert.setString(3, functext.getText());
			ppinsert.setString(4, persontext.getText());
			ppinsert.setString(5, cnictext.getText());
			ppinsert.setString(6,gueststext.getText());
			ppinsert.setString(7,cateringtext.getText());
			ppinsert.setString(8,tftext.getText());
			ppinsert.setString(9,totext.getText());
			ppinsert.setString(10,orderbookertext.getText());
			ppinsert.setString(11,billtext.getText());	
			ppinsert.setString(12, contacttext.getText());
			ppinsert.executeUpdate();
			inputconnect.close();
			System.out.println("insertion complete");
			idtext.setText("");
			dp.setAccessibleText("");
			functext.setText("");					
			persontext.setText("");
			cnictext.setText("");	
			gueststext.setText("");
			cateringtext.setText("");
			tftext.setText("");					
			totext.setText("");
			orderbookertext.setText("");	
			billtext.setText("");
			contacttext.setText("");
			
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		PrinterJob printerJob = PrinterJob.createPrinterJob();
		if(printerJob.showPrintDialog(stage.getOwner()) && printerJob.printPage(hbox));
		printerJob.endJob();	
		});     
		File file = new File("C:/Users/user/Desktop/HallImages/booking.jpg");
		Image img = new Image(file.toURI().toString());
		ImageView iv = new ImageView(img);
		
		
		
		g.getChildren().addAll(iv,hbox,insert_print);	
		stage.setScene(s);
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		
			public void handle(WindowEvent arg0) {
		new IntermediaryClass();
				
			}
		});
		stage.show();
	}}
