package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import pojos.Patient;

public class PatientViewController implements Initializable {

	@FXML private TableView<Patient> patientTable = null;

	@FXML private TableColumn<Patient, Integer> idColumn;
	@FXML private TableColumn<Patient, String> nameColumn;
	@FXML private TableColumn<Patient, String> sexColumn;
	@FXML private TableColumn<Patient, String> nifColumn;
	@FXML private TableColumn<Patient, String> emailColumn;
	@FXML private TableColumn<Patient, String> adressColumn;
	@FXML private TableColumn<Patient, String> internColumn;
	@FXML private TableColumn<Patient, String> phoneNumberColumn;
	@FXML private TableColumn<Patient, LocalDate> dobColumn;


	@FXML private Button editPatientButton;
	
	private ObservableList<Patient> patients = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	//disable the edit button until the patient has been selected
	this.editPatientButton.setDisable(true);

	//patientTable.setEditable(true);

	idColumn.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("id"));
	nameColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("name"));
	sexColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("sex"));
	nifColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("nif"));
	emailColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("email"));
	adressColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("adress"));
	phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("phoneNumber"));
	internColumn.setCellValueFactory(new PropertyValueFactory<Patient, String>("intern"));
	dobColumn.setCellValueFactory(new PropertyValueFactory<Patient, LocalDate>("dob"));

	//set  the table editable in order to update it
	patientTable.setEditable(true);

	//lo silencio para desactivar la posibilidad de editar directamente desde la tabla
	/*nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	nifColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	sexColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	adressColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	phoneNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	internColumn.setCellFactory(TextFieldTableCell.forTableColumn());
*/
	//load data
	patientTable.setItems(loadPatients());

	}

//if the editbutton es pushed, pass the selected patient to the newPatientView and preload it with data

	public void editButtonPushed(ActionEvent event) throws IOException{

		SceneChanger sc = new SceneChanger();
		Patient patient = this.patientTable.getSelectionModel().getSelectedItem(); //return the selected patient in the table
		NewPatientController npc = new NewPatientController();
		sc.changeScenesWithData(event, "newPatient.fxml", "Edit Patient", patient, npc);
	}

//if a patient has been selected in the table, enable editPatientButon
public void patientSelected(){

		editPatientButton.setDisable(false);
	}

public void changeNameCellEvent (CellEditEvent edditedCell){

		Patient patientSelected = patientTable.getSelectionModel().getSelectedItem();
		patientSelected.setName(edditedCell.getNewValue().toString());

	}


public void changeNifCellEvent (CellEditEvent edditedCell){

		Patient patientSelected = patientTable.getSelectionModel().getSelectedItem();
		patientSelected.setNif(edditedCell.getNewValue().toString());

	}

public void changeEmailCellEvent (CellEditEvent edditedCell){

	Patient patientSelected = patientTable.getSelectionModel().getSelectedItem();
	patientSelected.setEmail(edditedCell.getNewValue().toString());

}

public void changePhoneNumberCellEvent (CellEditEvent edditedCell){

	Patient patientSelected = patientTable.getSelectionModel().getSelectedItem();
	patientSelected.setPhoneNumber(edditedCell.getNewValue().toString());

}

public void changeAdressCellEvent (CellEditEvent edditedCell){

	Patient patientSelected = patientTable.getSelectionModel().getSelectedItem();
	patientSelected.setAdress(edditedCell.getNewValue().toString());

}

public void changeInternCellEvent (CellEditEvent edditedCell){

	Patient patientSelected = patientTable.getSelectionModel().getSelectedItem();
	patientSelected.setIntern(edditedCell.getNewValue().toString());

}

public void changeSexCellEvent (CellEditEvent edditedCell){

	Patient patientSelected = patientTable.getSelectionModel().getSelectedItem();
	patientSelected.setSex(edditedCell.getNewValue().toString());

}

public void changeDobCellEvent (CellEditEvent edditedCell){

	Patient patientSelected = patientTable.getSelectionModel().getSelectedItem();
	//patientSelected.setSex(edditedCell.getNewValue());

}

public ObservableList<Patient>loadPatients(){



		Patient patient1 = new Patient(1, "juan", "54448314T", "male",LocalDate.of(1995,Month.APRIL,9), "paseo del parque 4", "jjhua@gmail.com", "662223636", "YES");
		Patient patient2 = new Patient(2, "yoan", "54448314T", "male", LocalDate.of(1998,Month.APRIL,23), "pase castellana", "jjhua@gmail.com", "662223636", "YES");


		patients.add(new Patient(3, "javi", "55555", "male",LocalDate.of(2019, Month.AUGUST, 30), "madrid", "jjhua@gmail.com", "662223636", "YES" ));
		patients.add(patient2);
		patients.add(patient1);


		patients.add(new Patient(4, "javi", "55555", "male", LocalDate.of(2019, Month.AUGUST, 30), "paseo del barcelona 2", "jjhua@gmail.com", "662223636", "YES"));


		return patients;

	}

public void newPatientButton(ActionEvent event) throws IOException{

		SceneChanger sceneChanger = new SceneChanger();
		sceneChanger.changeScenes(event, "newPatient.fxml", "New Patient");
	}



}
