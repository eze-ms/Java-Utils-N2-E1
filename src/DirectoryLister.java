import java.io.*;
import java.nio.file.*;
import java.util.Properties;
import java.util.stream.Stream;
import auxiliar.Utils;

public class DirectoryLister {

    private static String directoryToRead;
    private static String outputFileName;
    private static String outputPath;

    static {
        try {
            // Cargar el archivo de configuración
            Properties prop = new Properties();
            FileInputStream fis = new FileInputStream("src/properties/config.properties");
            prop.load(fis);

            // Cargar los valores del archivo de configuración
            directoryToRead = prop.getProperty("DIRPATH");
            outputFileName = prop.getProperty("TXTFILE");
            outputPath = prop.getProperty("OUTPUTPATH");

            // Verificar y crear la carpeta "test path" y su contenido
            createTestPath(directoryToRead);

        } catch (IOException e) {
            System.out.println("Error loading configuration: " + e.getMessage());
        }
    }

    // Función para verificar y crear test path y su contenido
    private static void createTestPath(String basePath) {
        Path path = Paths.get(basePath);

        // Verificar si "test path" existe
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path); // Crear la carpeta test path
                System.out.println("Directory 'test path' created at: " + path);

                // Crear sample.txt dentro de test path
                Path sampleFile = path.resolve("sample.txt");
                if (!Files.exists(sampleFile)) {
                    Files.createFile(sampleFile);
                    System.out.println("File 'sample.txt' created at: " + sampleFile);
                }

                // Crear la subcarpeta "subfolder" dentro de test path
                Path subfolder = path.resolve("subfolder");
                if (!Files.exists(subfolder)) {
                    Files.createDirectories(subfolder);
                    System.out.println("Subfolder 'subfolder' created at: " + subfolder);
                }

            } catch (IOException e) {
                System.out.println("Error creating directory or files: " + e.getMessage());
            }
        } else {
            System.out.println("Directory 'test path' already exists at: " + path);
        }
    }

    //! Punto de inicio del programa.
    static void init(String[] args) {
        if (args.length < 1) {
            listDirectoryTreeAndSave(directoryToRead); // Usar el directorio desde el archivo de configuración
        } else {
            listDirectoryTreeAndSave(Utils.argsToString(args));
        }
    }

    //! Lista recursivamente el contenido de un árbol de directorios y guarda el resultado en un archivo TXT.
    public static void listDirectoryTreeAndSave(String directoryPath) {
        Path path = Utils.validatePath(directoryPath);

        if (path == null) return; // Si el Path no es válido, detiene la ejecución.

        Path outputFile = Path.of(outputPath, outputFileName); // Ruta completa para el archivo de salida
        try {
            Files.createDirectories(outputFile.getParent()); // Crear directorios si no existen
        } catch (IOException e) {
            System.out.println("Error creating output directory: " + e.getMessage());
        }

        try (BufferedWriter writer = Files.newBufferedWriter(outputFile, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            writer.write("Directory listing for: " + path + "\n\n");
            listDirectoryTreeRecursive(path, 0, writer);
            System.out.println("Directory listing saved to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

    //! Metodo recursivo para listar un árbol de directorios con detalles y guardar en un archivo.
    public static void listDirectoryTreeRecursive(Path path, int level, BufferedWriter writer) {
        try (Stream<Path> pathStream = Files.list(path).sorted()) {
            pathStream.forEach(file -> {
                try {
                    String type = Files.isDirectory(file) ? "D" : "F";
                    String date = Utils.formatLastModified(file.toFile().lastModified());

                    // Formato de la información
                    String line = String.format("%s[%s] %s (Last Modified: %s)%n", "  ".repeat(level), type, file.getFileName(), date);

                    // Escribe la información en el archivo
                    writer.write(line);

                    // Si es un directorio, llamar recursivamente
                    if (Files.isDirectory(file)) {
                        listDirectoryTreeRecursive(file, level + 1, writer);
                    }
                } catch (IOException e) {
                    System.out.println("Error processing file: " + e.getMessage());
                }
            });
        } catch (IOException e) {
            System.out.println("Error reading the directory: " + e.getMessage());
        }
    }
}
