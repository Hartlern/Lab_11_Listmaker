import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner scanner = new Scanner( System.in );

    public static void main( String[] args )
    {
        boolean endList = false;
        while(endList == false)
        {
            displayMenu();
            String command = SafeInput.getRegExString( scanner, "Enter a command: ", "[AaDdIiPpQq]" );

            if( command.equalsIgnoreCase( "A" ) )
            {
                addItem();
            }
            else if( command.equalsIgnoreCase( "D" ) )
            {
                deleteItem();
            }
            else if( command.equalsIgnoreCase( "I" ) )
            {
                insertItem();
            }
            else if( command.equalsIgnoreCase( "P" ) )
            {
                printList();
            }
            else if( command.equalsIgnoreCase( "Q" ) )
            {
                if( SafeInput.getYNConfirm( scanner, "Are you sure you want to quit? (Y/N): " ) )
                {
                    System.out.println( "Exiting program." );
                    return;
                }
            }
            else
            {
                System.out.println( "Invalid command." );
            }
        }
    }

    private static void displayMenu()
    {
        System.out.println( "\nCurrent List:" );
        printList();
        System.out.println( "\nMenu Options:" );
        System.out.println( "A - Add an item" );
        System.out.println( "D - Delete an item" );
        System.out.println( "I - Insert an item" );
        System.out.println( "P - Print the list" );
        System.out.println( "Q - Quit" );
    }

    private static void addItem()
    {
        String item = SafeInput.getRegExString( scanner, "Enter item to add: ", ".*" );
        list.add( item );
        System.out.println( "Item added." );
    }

    private static void deleteItem()
    {
        if( list.isEmpty() )
        {
            System.out.println( "The list is empty. Nothing to delete." );
            return;
        }

        printList();
        int index = SafeInput.getRangedInt( scanner, "Enter the item number to delete: ", 1, list.size() ) - 1;
        String removedItem = list.remove( index );
        System.out.println( "Item removed: " + removedItem );
    }

    private static void insertItem()
    {
        if( list.isEmpty() )
        {
            System.out.println( "The list is empty. Inserting an item at position 1." );
        }

        printList();
        int index = SafeInput.getRangedInt( scanner, "Enter the position to insert the item: ", 1, list.size() + 1 ) - 1;
        String item = SafeInput.getRegExString( scanner, "Enter item to insert: ", ".*" );
        list.add( index, item );
        System.out.println( "Item inserted." );
    }

    private static void printList()
    {
        if( list.isEmpty() )
        {
            System.out.println( "The list is empty." );
            return;
        }

        for( int i = 0; i < list.size(); i++ )
        {
            System.out.println( ( i + 1 ) + ". " + list.get( i ) );
        }
    }
}

