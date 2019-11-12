package by.epam.task511;

public class DirectoryView {
  private Directory directory;

  public DirectoryView() {
  }

  public DirectoryView(Directory directory) {
    this.directory = directory;
  }

  public Directory getDirectory() {
    return directory;
  }

  public void setDirectory(Directory directory) {
    this.directory = directory;
  }

  public void showDirectory() {
    for (int i = 0; i < directory.getSizeOfDirectory(); i++) {
      System.out.println(directory.getTextFiles(i).getFile());
    }
  }
}
