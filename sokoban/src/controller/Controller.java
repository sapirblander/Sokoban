package controller;

import java.util.Observable;
import java.util.Observer;

public interface Controller extends Observer 
{
	void update(Observable arg0,Object arg1);
	void start();
	void stop();
	void insertCommand(Command command);
}
