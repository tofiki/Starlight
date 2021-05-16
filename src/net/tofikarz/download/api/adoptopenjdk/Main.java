package net.tofikarz.download.api.adoptopenjdk;

import org.apache.commons.io.FileUtils;

import java.nio.file.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.lingala.zip4j.*;

public class Main {

    public static void main(String[] args) {

        Path to_remove = Paths.get("C:/Program Files/JDKDownloader/AdoptOpenJDK/JDK-16-hotspot-windows-x64");
        Path to_remove2 = Paths.get("C:/Program Files/JDKDownloader/AdoptOpenJDK/JDK-16-hotspot-windows-x64.zip");
        try {
            Files.deleteIfExists(to_remove);
                    System.out.println("Removed JDK 16 folder to prevent issues...");
        } catch (IOException e) {
            System.out.println("JDK 16 folder doesn't exist, aborting delete...");
        }

        try {
            Files.deleteIfExists(to_remove2);
                    System.out.println("Removed JDK 16 zip folder to prevent issues...");
        } catch (IOException e) {
            System.out.println("JDK 16 zip folder doesn't exist, aborting delete...");
        }
        
        System.out.println("Starting JDK 16 download...");
        String fromFile = "https://api.adoptopenjdk.net/v3/binary/latest/16/ga/windows/x64/jdk/hotspot/normal/adoptopenjdk";
        String toFile = "C:/Program Files/JDKDownloader/AdoptOpenJDK/JDK-16-hotspot-windows-x64.zip";

        try {
            FileUtils.copyURLToFile(new URL(fromFile), new File(toFile), 10000, 10000);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong , please see the stacktrace and report it");
        }

        System.out.println("Downloaded JDK 16");
        System.out.println("Unzipping the archive...");

        Path source = Paths.get("C:/Program Files/JDKDownloader/AdoptOpenJDK/JDK-16-hotspot-windows-x64.zip");
        Path target = Paths.get("C:/Program Files/JDKDownloader/AdoptOpenJDK/JDK-16-hotspot-windows-x64");

        try {
            new ZipFile(source.toFile())
                    .extractAll(target.toString());
            System.out.println("Done unzipping");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to unzip the archive! , please see the stacktrace and report it");
        }

    }
}