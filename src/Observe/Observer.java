package Observe;

import java.io.IOException;

public class Observer {
    public static void main(String[] args) throws IOException {
//        Editor editor = new Editor();
//
//        editor.events.subscribe("open", new LogOpenListener("log_file.txt"));
//        editor.events.subscribe("save", new EmailNotificationListener(""));
//        editor.events.subscribe("save", new EmailNotificationListener(""));
//        editor.events.subscribe("open", new EmailNotificationListener(""));
//
//        try {
//            // calling methods from editor class
//            editor.openFile(""); // opens the file
//            editor.saveFile(""); // saves to the file
//            editor.deleteFile(""); // deletes the file
//        } catch (Exception e){
//            e.printStackTrace();
//            System.out.println("Error: " + e.getMessage());

        // modified main to test all the functionalities implemented in this assignment
        try {
            Editor editor = new Editor();
            String filePath = "src/Observe/observerExample.txt";

            System.out.println("\n1: opening file w/ listener subscribed... ");
            editor.openFile(filePath);

            System.out.println("\n2: saving data to file... ");
            editor.saveFile("example data: 'highly sensitive nuclear launch code' ");

            System.out.println("\n3: unsubscribing the DeletesFileListener... ");
            editor.unsubscribeListener();

            System.out.println("\n4 opening file once more after unsubscribing... ");
            editor.openFile(filePath);

            System.out.println("\n5: deleting file... ");
            editor.deleteFile("");

            System.out.println("\n6 created new file after deletion, feel free to run the program again");
            editor.CreateNewFile();


        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}