import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class GameInstallerTest {

    @Test
    public void testCreateDirectory_Success() {
        // Подготовка к тесту
        String path = "E://Games/testDir";

        // Вызов тестируемого метода
        GameInstaller.createDirectory(path);

        // Проверка результата
        assertTrue(new File(path).exists());
    }

    @Test
    public void testCreateFile_Success() {
        // Подготовка к тесту
        String path = "E://Games/testFile.txt";

        // Вызов тестируемого метода
        GameInstaller.createFile(path);

        // Проверка результата
        assertTrue(new File(path).exists());
    }

    @Test
    public void testWriteLog_Success() throws IOException {
        // Подготовка к тесту
        String path = "E://Games/tempLog.txt";
        String log = "Test log content";

        // Вызов тестируемого метода
        GameInstaller.writeLog(path, log);

        // Проверка файла лога
        String content = new String(Files.readAllBytes(Paths.get(path)));
        assertEquals(log, content);
    }
}