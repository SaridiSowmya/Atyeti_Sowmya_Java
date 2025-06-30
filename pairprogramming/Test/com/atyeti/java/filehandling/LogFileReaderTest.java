package com.atyeti.filehandling;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogFileReaderTest {

        private static Path tempDir;

        @BeforeAll
        static void setup() throws IOException {
            tempDir = Files.createTempDirectory("logtest");
        }

//        @AfterAll
//        void cleanup() throws IOException {
//            Files.walk(tempDir)
//                    .map(Path::toFile)
//                    .forEach(File::delete);
//        }

        @BeforeEach
        void resetCounters() {
            LogFileReader.errorCount = 0;
            LogFileReader.warnCount = 0;
            LogFileReader.infoCount = 0;
            LogFileReader.threads.clear();
        }

        @Test
        void testLogFileReadingAndCounting() throws Exception {
            // Create a log file with known content
            Path logFile = Files.createFile(tempDir.resolve("test.log"));
            Files.writeString(logFile,
                    "2023-01-01 00:00:00 ERROR Something bad happened\n" +
                            "2023-01-01 00:00:01 INFO Starting process\n" +
                            "2023-01-01 00:00:02 WARNING Disk space low\n" +
                            "2023-01-01 00:00:03 INFO Still running\n" +
                            "2023-01-01 00:00:04 ERROR Another error\n");

            LogFileReader.readLogs(tempDir.toString());

            // Wait for all threads to complete
            for (Thread thread : LogFileReader.threads) {
                thread.join(1000); // wait for 1 sec max
            }

            assertEquals(2, LogFileReader.errorCount);
            assertEquals(1, LogFileReader.warnCount);
            assertEquals(2, LogFileReader.infoCount);
        }

        @Test
        void testEmptyDirectory() throws Exception {
            Path emptyDir = Files.createTempDirectory(tempDir, "empty");

            LogFileReader.readLogs(emptyDir.toString());

            assertEquals(0, LogFileReader.errorCount);
            assertEquals(0, LogFileReader.warnCount);
            assertEquals(0, LogFileReader.infoCount);
        }

        @Test
        void testNoLogFiles() throws Exception {
            Path noLogDir = Files.createTempDirectory(tempDir, "nologs");
            Files.createFile(noLogDir.resolve("notalog.txt"));

            LogFileReader.readLogs(noLogDir.toString());

            assertEquals(0, LogFileReader.errorCount);
            assertEquals(0, LogFileReader.warnCount);
            assertEquals(0, LogFileReader.infoCount);
        }

        @Test
        void testInvalidDirectoryPath() throws Exception {
            LogFileReader.readLogs("invalid/path/to/directory");

            assertEquals(0, LogFileReader.errorCount);
            assertEquals(0, LogFileReader.warnCount);
            assertEquals(0, LogFileReader.infoCount);
        }
    }
