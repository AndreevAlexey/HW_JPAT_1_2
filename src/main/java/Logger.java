import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger logger = null;
    private static File logFile;
    private static int cnt;
    // конструктор
    private Logger(){
        logFile = new File("log.txt");
        try {
            logFile.createNewFile();
            add("Начало работы");
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }
    // получить объект класса
    public static Logger get() {
        if(logger == null) logger = new Logger();
        return logger;
    }
    // запись в лог сообщения
    public void add(String message) {
        // текущая дата
        Date dateNow = new Date();
        // формат отображения даты
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("[yyyy.MM.dd HH:mm:ss]");
        // запись в лог-файл сообщения
        try(FileWriter fw = new FileWriter(logFile, true)) {
            // номер сообщения
            cnt++;
            // запись
            fw.write("\n"+formatForDateNow.format(dateNow)+"["+cnt+"] "+message);
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }
}
