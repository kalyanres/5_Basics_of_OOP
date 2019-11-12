package by.epam.task511;

public class File {

  private String name;
  private String extension;
  private boolean readOnly;


  public File() {
  }

  public File(String name, String extension, boolean readOnly) {
    this.name = name;
    this.extension = extension;
    this.readOnly = readOnly;
  }

  public String getName() {
    return name;
  }

  public String getFile() {
    return name + "." + extension;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public boolean isReadOnly() {
    return readOnly;
  }

  public void setReadOnly(boolean readOnly) {
    this.readOnly = readOnly;
  }

  @Override
  public String toString() {
    return "File{" +
            "'" + name + '\'' +
            ", extension='" + extension + '\'' +
            ", readOnly=" + readOnly +
            '}';
  }
}
