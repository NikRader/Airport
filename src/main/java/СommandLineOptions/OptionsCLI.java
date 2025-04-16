package СommandLineOptions;

import org.apache.commons.cli.*;

public class OptionsCLI {
    public static void showOptions(String[] args) {
        Options options = new Options();

        options.addOption(Option.builder()
                .longOpt("data")
                .hasArg()
                .argName("path-to-csv.csv")
                .desc("путь до файла airpors.csv")
                .build());

        options.addOption(Option.builder()
                .longOpt("data")
                .hasArg()
                .argName("path-to-csv.csv")
                .desc("index-column")
                .build());

        options.addOption(Option.builder()
                .longOpt("input-file")
                .hasArg()
                .argName("input-path-to-file.txt")
                .desc("путь до файла UserSearches.txt с входными строками поиска")
                .build());

        options.addOption(Option.builder()
                .longOpt("output-file")
                .hasArg()
                .argName("output-path-to-file.json")
                .desc("путь до файла output_gson.json с результатами поиска")
                .build());

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            // Форматированный вывод в требуемом стиле
            System.out.println("--data "+ "airpors.csv" );
            System.out.println("--index-column-id " );
            System.out.println("--input-file UserSearches.txt");

            System.out.println("--output-file " +
                    " output_gson.json");

        } catch (ParseException e) {
            System.err.println("Ошибка парсинга: " + e.getMessage());

            // Кастомный вывод help
            System.out.println("Использование:");
            System.out.println("--data path-to-csv.csv — путь до файла airpors.csv");
            System.out.println("--input-file input-path-to-file.txt — путь до файла UserSearches.txt с входными строками поиска.");
            System.out.println("--output-file output-path-to-file.json — путь до файла output_gson.json с результатами поиска.");

            System.exit(1);
        }
    }

    public static void main(String[] args) {
        showOptions(args);
    }
}