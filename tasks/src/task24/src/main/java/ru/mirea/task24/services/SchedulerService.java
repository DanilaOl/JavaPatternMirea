package ru.mirea.task24.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.List;
import java.util.Objects;

@Service
@ManagedResource
public class SchedulerService {
    private final String BACKUP_DIR = "src/main/resources/backups";

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    @Async
    @Scheduled(cron = "0 0/30 * * * *")
    @ManagedOperation
    public void backup() throws FileNotFoundException {
        File dir = ResourceUtils.getFile(BACKUP_DIR);

        if (clear(dir)) {
            write(BACKUP_DIR + "/books.txt", bookService.getBooks());
            write(BACKUP_DIR + "/authors.txt", authorService.getAuthors());
        }
    }

    private boolean clear(File dir) {
        boolean result = true;
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file.isFile() || file.isDirectory()) {
                result &= file.delete();
            }
        }
        return result;
    }

    private <T> void write(String fileName, List<T> objectList) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (T object : objectList) {
                writer.write(object.toString());
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException ignored) {}
    }
}
