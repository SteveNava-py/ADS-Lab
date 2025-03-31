package Observe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.*;

public class Editor {
    public EventManager events; // handle events like "open" and "save"

    private File file; // file object (ex.txt)

    private EventListener.DeletesFileListener deleteListener; //stores reference to DeletesFileListener class in EventListener interface

    public Editor() {
        this.events = new EventManager("open", "save", "delete");
        this.deleteListener = new EventListener.DeletesFileListener();
        events.subscribe("open", deleteListener); // subscribes the DeletesFileListener to the open event
    }

    public void openFile(String filePath) throws IOException {
        this.file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filePath);
        }
        events.notify("open", file);
        System.out.println("File opened: " + file.getAbsolutePath());
    }

    // delete file method that notifies the observer that the file is deleted
    public void deleteFile(String filePath) throws IOException {
//        if (this.file != null && this.file.getPath().equals(filePath)) {
//            this.file = null;
//            events.notify("delete", file);

        // new logic for handling actual physical file instead of reference text
        if (this.file == null) {
            throw new IOException("No file is opened right now");
        }

        if (this.file.delete()) {
            events.notify("delete", file);
            System.out.println("File: " + file.getAbsolutePath() + " has been deleted");
            this.file = null;
        } else {
            throw new IOException("File could not be deleted");
        }
    }

    public void saveFile(String data) throws IOException {
//        if(this.file != null) {
//            events.notify("save", file);
//        } else {
//            throw new Exception("Please open a file first");

        // modified logic for implementation of reading actual physical file
        if (this.file == null) {
            throw new IOException("Please open a file first");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(data);
            events.notify("save", file);
            System.out.println("File: " + file.getAbsolutePath() + " has been saved");
        }
    }

    // create new example txt file after the delete file function is tested
    public void CreateNewFile () {
        try {
            this.file = new File("src/Observe/observerExample.txt");
            if (file.createNewFile()) {
                System.out.print("New File created after deletion: " + file.getName());
            } else{
                System.out.println("File exists");
            }
        } catch (IOException e) {
            System.out.println("Error creating file");
            e.printStackTrace();
        }
    }

    public void unsubscribeListener() {
        events.unsubscribe("open", deleteListener);
        System.out.println("DeletesFileListener unsubscribed from 'open'");
    }
}
