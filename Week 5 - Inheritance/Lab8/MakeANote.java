//NAME: JYOTI KHANCHANDANI
// ANDREW ID : jkhancha

import NotePackage.*;

import java.util.ArrayList;
import java.util.Scanner;

// Driver for Lab8
public class MakeANote {

    // Keyboard scanner for user input
    private static Scanner keyboard = new Scanner(System.in);

    // String values for the main menu - title first
    private static final String[] mainMenu = {"Main Menu", "Create a new Note",
            "Display existing Note(s)", "Quit"};

    // String  values for the create sub-menu - title first
    private static final String[] createMenu = {"Note Creation", "Create a Memo",
            "Create a Timed Memo", "Create a Polite Memo", "Return to previous menu"};

    // String values for the display sub-menu - title first
    private static final String[] displayMenu = {"Display Options", "Display all Notes",
            "Display Note by Number", "Display Notes by Name", "Return to previous menu"};

    // getMenuChoice(String[] menu)
    //      Displays menu[]
    //      Prompts the user for a choice
    //      Returns choice without error checking
    private static int getMenuChoice(String[] menu) {
        int choice;
        System.out.println(menu[0]);
        // Display the menu, whatever its size is
        for (int i = 1; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
        System.out.print("Enter your choice: ");
        choice = Integer.parseInt(keyboard.nextLine());
        return choice;
    }

    // main()
    //      Display the main menu, get a choice
    //      Create: get information for a new Memo
    //      Submenus: tbd

    public static void main(String[] args) {

        // Create an empty NoteCollection
        NoteCollection noteCollection = new NoteCollection();
        // Menu choice
        int choice;
        // Memo values
        String name = null, body = null, from = null, to = null;
        // Note object to be new-ed up below
        Note note = null;
        // Submenu choice
        int subchoice;

        // Loop until the user chooses quit
        do {

            // Get the main menu choice
            choice = getMenuChoice(mainMenu);

            // What did they choose?
            switch (choice) {


                case 1:
                    // Loop until the user chooses quit

                    do {

                        // Get the create submenu choice
                        subchoice = getMenuChoice(createMenu);

                        // For now, create only a Memo
                        if (subchoice == 1 || subchoice == 2 || subchoice == 3) {
                            System.out.print("Enter memo name: ");
                            name = keyboard.nextLine();

                            System.out.print("Enter memo body: ");
                            body = keyboard.nextLine();
                            System.out.print("Enter who this is from: ");
                            from = keyboard.nextLine();
                            System.out.print("Enter who this is to: ");
                            to = keyboard.nextLine();
                        }
                        switch (subchoice) {
                            // Create a Memo
                            case 1:
                                // Your code here: create a Memo object and add
                                Memo m = new Memo(name,body,from,to);
                                System.out.println("Memo Created ");
                                // it to the Notecollection
                                noteCollection.add(m);
                                System.out.println(m.toString());
                                break;


                            // Create a TimedMemo

                            case 2:

                                TimedMemo tm= new TimedMemo(name,body,from,to);
                                System.out.println("TimedMemo Created ");
                                System.out.println(tm.toString());
                                noteCollection.add(tm);
                                break;

                            // Create a PoliteTimedMemo
                            case 3:
                                PoliteTimedMemo ptm =new PoliteTimedMemo(name,body,from,to);
                                System.out.println("PoliteTimedMemo Created! ");
                                System.out.println(ptm.toString());
                                noteCollection.add(ptm);
                                break;

                            // Quit
                            case 4:
                                break;
                        }
                    } while (subchoice != 4);
                    break;

                // Display Notes
                case 2:

                    // Loop until the user chooses quit
                    do {

                        // Get the display submenu choice
                        subchoice = getMenuChoice(displayMenu);
                        switch (subchoice) {

                            // Display all notes
                            case 1:

                                ArrayList <Note> displayallnotes= new ArrayList<Note>();
                                displayallnotes=noteCollection.getAllNotes();
                                for(int i=0;i<displayallnotes.size();i++)
                                {
                                    System.out.println(displayallnotes.get(i).toString());
                                }

                                break;

                            // Display a note by number
                            case 2:
                                Note fn = null;
                                System.out.println("Enter the notenumber to find :");
                                int f = Integer.parseInt(keyboard.nextLine());
                                fn=noteCollection.getNoteByNumber(f);
                                if(fn!=null)
                                {
                                    System.out.println("Note Number Found");
                                    System.out.println(fn.toString());
                                }
                                else
                                    System.out.println("Note not found in the Note Collection");
                                break;

                            // Display a note by name
                            case 3:
                                System.out.println("Enter the note to search");
                                String s = keyboard.nextLine();
                                ArrayList <Note> sbn = new ArrayList<Note> ();
                                sbn= noteCollection.getNoteByName(s);
                                if(sbn.size()!= 0 ) {
                                    System.out.println("Note Found!");
                                    for (int i = 0; i < sbn.size(); i++) {
                                        //Displaying all elements found in arraylist of names found
                                        System.out.println(sbn.get(i).toString());
                                    }
                                }
                                else
                                {
                                    System.out.println("Note Name not found in list");
                                }

                                break;

                            // Quit
                            case 4:
                                System.out.println("Returning to main menu");
                                break;
                        }
                    } while (subchoice != 4);
            }

        } while (choice != 3);
    }
}
