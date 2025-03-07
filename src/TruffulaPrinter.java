import java.util.List;
import java.io.File;
import java.io.PrintStream;

/**
 * TruffulaPrinter is responsible for printing a directory tree structure
 * with optional colored output. It supports sorting files and directories
 * in a case-insensitive manner and cycling through colors for visual clarity.
 */
public class TruffulaPrinter {
  
  /**
   * Configuration options that determine how the tree is printed.
   */
  private TruffulaOptions options;
  
  /**
   * The sequence of colors to use when printing the tree.
   */
  private List<ConsoleColor> colorSequence;
  
  /**
   * The output printer for displaying the tree.
   */
  private ColorPrinter out;

  /**
   * Default color sequence used when no custom colors are provided.
   */
  private static final List<ConsoleColor> DEFAULT_COLOR_SEQUENCE = List.of(
      ConsoleColor.WHITE, ConsoleColor.PURPLE, ConsoleColor.YELLOW
  );

  /**
   * Constructs a TruffulaPrinter with the given options, using the default
   * output stream and the default color sequence.
   *
   * @param options the configuration options for printing the tree
   */
  public TruffulaPrinter(TruffulaOptions options) {
    this(options, System.out, DEFAULT_COLOR_SEQUENCE);
  }

  /**
   * Constructs a TruffulaPrinter with the given options and color sequence,
   * using the default output stream.
   *
   * @param options the configuration options for printing the tree
   * @param colorSequence the sequence of colors to use when printing
   */
  public TruffulaPrinter(TruffulaOptions options, List<ConsoleColor> colorSequence) {
    this(options, System.out, colorSequence);
  }

  /**
   * Constructs a TruffulaPrinter with the given options and output stream,
   * using the default color sequence.
   *
   * @param options the configuration options for printing the tree
   * @param outStream the output stream to print to
   */
  public TruffulaPrinter(TruffulaOptions options, PrintStream outStream) {
    this(options, outStream, DEFAULT_COLOR_SEQUENCE);
  }

  /**
   * Constructs a TruffulaPrinter with the given options, output stream, and color sequence.
   *
   * @param options the configuration options for printing the tree
   * @param outStream the output stream to print to
   * @param colorSequence the sequence of colors to use when printing
   */
  public TruffulaPrinter(TruffulaOptions options, PrintStream outStream, List<ConsoleColor> colorSequence) {
    this.options = options;
    this.colorSequence = colorSequence;
    out = new ColorPrinter(outStream);
  }

  /**
   * WAVE 4: Prints a tree representing the directory structure, with directories and files
   * sorted in a case-insensitive manner. The tree is displayed with 3 spaces of
   * indentation for each directory level.
   * 
   * WAVE 5: If hidden files are not to be shown, then no hidden files/folders will be shown.
   *
   * WAVE 6: If color is enabled, the output cycles through colors at each directory level
   * to visually differentiate them. If color is disabled, all output is displayed in white.
   *
   * WAVE 7: The sorting is case-insensitive. If two files have identical case-insensitive names,
   * they are sorted lexicographically (Cat.png before cat.png).
   *
   * Example Output:
   *
   * myFolder/
   *    Apple.txt
   *    banana.txt
   *    Documents/
   *       images/
   *          Cat.png
   *          cat.png
   *          Dog.png
   *       notes.txt
   *       README.md
   *    zebra.txt
   */
  public void printTree() {
    // TODO: Implement this!
    // REQUIRED: ONLY use java.io, DO NOT use java.nio
    
    // Hints:
    // - Add a recursive helper method
    // - For Wave 6: Use AlphabeticalFileSorter
    // DO NOT USE SYSTEM.OUT.PRINTLN
    // USE out.println instead (will use your ColorPrinter)

  File root = options.getRoot();

  // check if the root directory exists
  if (root == null || !root.exists() || !root.isDirectory()) {
    out.println("Directory does not exist");
    return;
  }

  out.println(root.getName() + "/");
  printTreeHelper(root, 1);
}

// create a helper method
private void printTreeHelper(File dir, int level) {
  File[] files = dir.listFiles();

  if (files == null) {
    return;
  }

  // sort the files
  for (File file : files) {
    out.print("   ".repeat(level));

    if (file.isDirectory()) {
      out.println(file.getName() + "/");
      printTreeHelper(file, level + 1);
    } else {
      out.println(file.getName());
    }
  }
}
}



  //   if (root == null || !root.exists()) {
  //     out.println("Directory does not exist");
  //     return;
  //   }

  //   printTreeHelper(root, 0);

    //out.println("printTree was called!");
    //out.println("My options are: " + options);

    // File rootDir = options.getRoot();
    // if (rootDir.exists() && rootDir.isDirectory()) {
    //   printTreeHelper(rootDir, 1);
    // } else {
    //   out.println("Invalid root directory:");
    // }

//     printTreeHelper(options.getRoot(), 0);
//   }

//   // create a helper method
//   private void printTreeHelper(File current, int level) {
//     if (current == null || !current.exists()) {
//       return;
//     }
    
//     if (current.isDirectory()) {
//       out.println(current.getName());
//     }

//     // getting the file from the directory
//     File[] files = current.listFiles();
//     if (files == null) {
//       return;
//     }

//     // sorting the files
//     for (File file : files) {
//       printTreeHelper(file, level + 1);
//     }
//   }

//   private void printSpaces(String name, int level) {
//     String indent = "   ".repeat(level);
//     out.println(indent + name);
//   }
// }

  // }

  // private void printTreeHelper(File file, int level) {

  //   // base case
  //   String indent = "   ".repeat(level);

  //   out.println(indent + file.getName());

  //   // recursive case
  //   if (file.isDirectory()) {
  //     File[] files = file.listFiles();

  //     for (File f : files) {
  //       printTreeHelper(f, level + 1);
  //     }
  //   }
  

