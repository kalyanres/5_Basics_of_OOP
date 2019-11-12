package by.epam.task511;

public class TextFile extends File {

  private StringBuilder text;

  public TextFile() {
  }

  public TextFile(String name, String extension, boolean readOnly) {
    super(name, extension, readOnly);
    this.text = new StringBuilder();
  }

  public TextFile(String name, String extension, boolean readOnly, StringBuilder text) {
    super(name, extension, readOnly);
    this.text = text;
  }

  public StringBuilder getText() {
    return this.text;
  }

  public boolean addText(String text) {
    if (super.isReadOnly())
      return false;
    else
      this.text.append(text);
    return true;
  }

  public void changeName(String text) {
    super.setName(text);
  }

}
