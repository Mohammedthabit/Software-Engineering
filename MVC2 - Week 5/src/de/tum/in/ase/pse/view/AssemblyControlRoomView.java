package de.tum.in.ase.pse.view;

import de.tum.in.ase.pse.controller.AssemblyTerminal;
import de.tum.in.ase.pse.model.AssemblyMachine;
import de.tum.in.ase.pse.model.ChipType;
import de.tum.in.ase.pse.model.Machine;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssemblyControlRoomView extends ControlRoomView {

	private static final int SCENE_WIDTH = 410;
	private static final int SCENE_HEIGHT = 280;

	private static final int CORNER_RADIUS = 2;
	private static final int BORDER_WIDTH = 3;
	private static final int DISPLAY_TITLE_FONT_SIZE = 20;

	// controller
	private final AssemblyTerminal terminal;

	// GUI objects
	private TextField spaceBetweenInput;
	private ComboBox<ChipType> chipTypeInput;
	private Label spaceBetweenDisplay;
	private Label chipTypeDisplay;
	private Button spaceBetweenSubmit;
	private Button chipTypeSubmit;

	public AssemblyControlRoomView(AssemblyMachine machine, AssemblyTerminal terminal) {
		super(machine, SCENE_WIDTH, SCENE_HEIGHT);
		this.terminal = terminal;
		machine.removeObserver(this);
		machine.addObserver(this);
	}

	@Override
	public void update(Machine currMachine) {
		getCurrentTemperatureDisplay().setText(currMachine.getCurrentTemperature() + "");
		getCurrentVoltageDisplay().setText(currMachine.getCurrentVoltage() + "");
		spaceBetweenDisplay.setText(((AssemblyMachine) currMachine).getSpaceBetweenTrans() + "");
		chipTypeDisplay.setText(((AssemblyMachine) currMachine).getChipType().toString());
	}

	protected void setButtonActions() {
		spaceBetweenSubmit.setOnAction(event -> terminal.setSpaceBetweenTrans(Integer.parseInt(spaceBetweenInput.getText())));
		chipTypeSubmit.setOnAction(event -> terminal.setChipType(chipTypeInput.getValue()));
	}

	protected Label displayTitle() {
		Label title = new Label("CONTROL VIEW - ASSEMBLY MACHINE");
		title.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(CORNER_RADIUS), new BorderWidths(BORDER_WIDTH))));
		title.setFont(new Font(DISPLAY_TITLE_FONT_SIZE));
		title.setAlignment(Pos.CENTER);
		return title;
	}

	protected List<GridPane> createMachineControlViews() {
		List<GridPane> panes = new ArrayList<>();
		panes.add(createSpecificValueView());
		panes.add(createSpecificInputView());
		return panes;
	}

	private GridPane createSpecificValueView() {
		GridPane gridPane = createGridPane();

		Label spaceBetweenLabel = createLabel("Current space between T.:", 0, 0);
		spaceBetweenDisplay = createLabelWithBorder("", 1, 0);

		Label chipTypeLabel = createLabel("Current chip type:", 0, 1);
		chipTypeDisplay = createLabelWithBorder("", 1, 1);

		gridPane.getChildren().addAll(spaceBetweenLabel, spaceBetweenDisplay, chipTypeLabel, chipTypeDisplay);

		return gridPane;
	}

	private GridPane createSpecificInputView() {
		GridPane gridPane = createGridPane();

		//"fin pitch"
		Label spaceBetweenLabel = createLabel("Set new space between T.:", 0, 0);
		spaceBetweenInput = createIntegerTextField(1, 0);
		spaceBetweenSubmit = createButton("Update", 2, 0);

		Label chipTypeLabel = createLabel("Set new chip type:", 0, 1);
		chipTypeInput = createComboBox(Arrays.asList(ChipType.values()), 1, 1);
		chipTypeSubmit = createButton("Update", 2, 1);

		gridPane.getChildren().addAll(spaceBetweenLabel, spaceBetweenInput, spaceBetweenSubmit, chipTypeLabel, chipTypeInput, chipTypeSubmit);

		return gridPane;
	}
}
