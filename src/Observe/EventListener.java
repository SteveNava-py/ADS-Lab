package Observe;

import java.io.File;

public interface EventListener {
    void update(String eventType, File file);

    //create event listener here for deleting file created by the open event

    class DeletesFileListener implements EventListener{
        @Override
        public void update(String eventType, File file) {
            if ("open".equals(eventType) && file != null && file.exists()) {
                boolean deleted = file.delete();
                if (deleted) {
                    System.out.println(file.getAbsolutePath() + " has been deleted by the DeletesFileListener class");
                } else {
                    System.out.println("Failed to delete: " + file.getAbsolutePath());
                }
            }
        }
    }
}

