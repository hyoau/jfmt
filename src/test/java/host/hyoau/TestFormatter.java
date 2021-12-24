package host.hyoau;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import com.google.googlejavaformat.java.JavaFormatterOptions;
import com.google.googlejavaformat.java.JavaFormatterOptions.Style;

public class TestFormatter {

    public static void main(String[] args) throws Exception {
        JavaFormatterOptions options = JavaFormatterOptions.builder().style(Style.AOSP).build();
        Formatter formatter = new Formatter(options);
        ArrayList<File> files = new ArrayList<>();
        walk(args[0], files);
        for (File file : files) {
            formatFile(file.getPath(), formatter);
        }
    }

    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static void formatFile(String path, Formatter formatter)
            throws IOException, FormatterException {
        String sourceString = readFile(path, Charset.defaultCharset());
        String formattedSource = formatter.formatSource(sourceString);
        System.out.println(formattedSource);
        PrintWriter out = new PrintWriter(path);
        out.println(formattedSource);
        out.close();
    }

    public static void walk(String path, ArrayList<File> files) {
        File root = new File(path);
        File[] list = root.listFiles();

        if (list == null)
            return;

        for (File f : list) {

            if (f.isDirectory()) {

                walk(f.getAbsolutePath(), files);
                System.out.println("Dir:" + f.getAbsoluteFile());
            } else {
                System.out.println("File:" + f.getAbsoluteFile());
                String fileName = f.getName();
                if (fileName.substring(fileName.length() - 5, fileName.length()).equals(".java")) {
                    files.add(f);
                }
            }
        }
    }
}
