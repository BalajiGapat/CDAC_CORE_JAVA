package p2;

public class FilePrinter implements Printer 
{
	@Override
	public void print(String message) 
	{
		System.out.println("Saving  a message " + message + "in the file with speed::  "+Printer.SPEED);
	}
	public void openFile()
	{
		System.out.println("opening a file");
	}
	public void closeFile()
	{
		System.out.println("closing a file");
	}

}
