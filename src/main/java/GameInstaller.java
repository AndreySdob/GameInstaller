import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GameInstaller {
    private static final String BASE_PATH = "E://Games";
    private static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {
        List<String> dirNames = Arrays.asList("/src", "/res", "/savegames", "/temp", "/src/main", "/src/test");

        for (String dirName : dirNames) {
            createDirectory(BASE_PATH + dirName);
        }

        createFile(BASE_PATH + "/src/main/Main.java");
        createFile(BASE_PATH + "/src/main/Utils.java");
        createDirectory(BASE_PATH + "/res/drawables");
        createDirectory(BASE_PATH + "/res/vectors");
        createDirectory(BASE_PATH + "/res/icons");
        createFile(BASE_PATH + "/temp/temp.txt");

        writeLog(BASE_PATH + "/temp/temp.txt", log.toString());
    }

    public static void createDirectory(String path) {
        File dir = new File(path);
        if (dir.mkdirs()) {
            log.append("Директория ").append(path).append(" создана\n");
        } else {
            log.append("Не удалось создать директорию ").append(path).append("\n");
        }
    }

    public static void createFile(String path) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                log.append("Файл ").append(path).append(" создан\n");
            } else {
                log.append("Не удалось создать файл ").append(path).append("\n");
            }
        } catch (IOException e) {
            log.append("Ошибка при создании файла ").append(path).append(": ").append(e.getMessage()).append("\n");
        }
    }

    public static void writeLog(String filePath, String log) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(log);
            System.out.println("Лог записан в файл " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка при записи лога в файл " + filePath + ": " + e.getMessage());
        }
    }
}
