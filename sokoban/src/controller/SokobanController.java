package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import view.View;
import model.Model;

public class SokobanController implements Observer
{
	private Model model;
	private View view;
	private Controller controller;
	private Map<String, Command> commands;
	
	public SokobanController(Model model, View view) 
	{
		this.model = model;
		this.view = view;
		
		initCommands();
		controller = new MyController();
		controller.start();
	}
	
	protected void initCommands() 
	{
		commands = new HashMap<String, Command>();
		commands.put("Move", new MoveCommand(model));
	}	

	@Override
	public void update(Observable o, Object arg) 
	{
		List<String> params = (List<String>) arg;
		String commandKey = params.remove(0);
		Command c = commands.get(commandKey);
		if (c == null) {
			view.displayError("Command " + commandKey + " not found");
			return;
		}
		c.setParams(params);
		controller.insertCommand(c);
	}
}
