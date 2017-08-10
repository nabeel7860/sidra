import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

public class oldbooking {

	oldbooking()
	{
		Group group = new Group();
		Scene scene = new Scene(group,400,400,Color.BLUE);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Booking Data");
		Group g = new Group();
		Scene scn = new Scene(g);
		stage.setScene(scn);
			
		TableView table = new TableView();
		ObservableList<ObservableList> data;
		data = FXCollections.observableArrayList();
		try
		{
Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:8889/HallSoftware","root","root");		
java.sql.Statement stmt = conn.createStatement();			
ResultSet rslt = stmt.executeQuery("select * from Booking");
	while(rslt.next())
		{
ObservableList<String> row = FXCollections.observableArrayList();
for(int i=1;i<=rslt.getMetaData().getColumnCount();i++)
{

	row.add(rslt.getString(i));
}
	data.add(row);
		}
		table.setItems(data);
		rslt.close();			
		}catch(Exception e)
		{
			e.printStackTrace();
		}		
		TableColumn id = new TableColumn("ID");
		id.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>> (){                    
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                return new SimpleStringProperty(param.getValue().get(0).toString());                        
            }                    
        });
		TableColumn date = new TableColumn("Date");
		date.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>> (){                    
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                return new SimpleStringProperty(param.getValue().get(1).toString());                        
            }                    
        });
		TableColumn function = new TableColumn("Function");
		function.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>> (){                    
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                return new SimpleStringProperty(param.getValue().get(2).toString());                        
            }                    
        });
		
		TableColumn name = new TableColumn("Name");
		name.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>> (){                    
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                return new SimpleStringProperty(param.getValue().get(3).toString());                        
            }                    
        });
		TableColumn cnic = new TableColumn("CNIC #");
		cnic.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>> (){                    
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                return new SimpleStringProperty(param.getValue().get(4).toString());                        
            }                    
        });
		TableColumn guests = new TableColumn("GUESTS");
		guests.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>> (){                    
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                return new SimpleStringProperty(param.getValue().get(5).toString());                        
            }                    
        });
		TableColumn catering = new TableColumn("Caterings");
		catering.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>> (){                    
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                return new SimpleStringProperty(param.getValue().get(6).toString());                        
            }                    
        });
		TableColumn tf = new TableColumn("Timings From");
		tf.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>> (){                    
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                return new SimpleStringProperty(param.getValue().get(7).toString());                        
            }                    
        });
		TableColumn tt = new TableColumn("Timings to");
		tt.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>> (){                    
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                return new SimpleStringProperty(param.getValue().get(8).toString());                        
            }                    
        });
		TableColumn on = new TableColumn("Order Booker Name");
		on.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>> (){                    
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                return new SimpleStringProperty(param.getValue().get(9).toString());                        
            }                    
        });
		TableColumn ba = new TableColumn("Bill Amount");
		ba.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>> (){                    
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                return new SimpleStringProperty(param.getValue().get(10).toString());                        
            }                    
        });
		TableColumn contact = new TableColumn("Contact Number");
		contact.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>> (){                    
            public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                return new SimpleStringProperty(param.getValue().get(11).toString());                        
            }                    
        });
		
		table.getColumns().addAll(id,date,function,name,cnic,guests,catering,tf,tt,on,ba,contact);
		g.getChildren().add(table);
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent arg0) {
			new IntermediaryClass();
				
			}
		});
		stage.show();		
	}
	
	
}
