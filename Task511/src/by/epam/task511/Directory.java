package by.epam.task511;

import java.util.LinkedList;

public class Directory {
  private String name;
  private LinkedList<TextFile> files;

  public Directory(String name) {
    this.name = name;
    files = new LinkedList<TextFile>();
  }

  public Directory() {
    this.name = "no name";
    files = new LinkedList<TextFile>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TextFile getTextFiles(String name) {
    for (TextFile textFile : files) {
      if (name.equals(textFile.getName()))
        return textFile;
    }
    return null;
  }

  // доступ по индексу
  public TextFile getTextFiles(int index) {
    return files.get(index);
  }

  public LinkedList<TextFile> getFiles() {
    return files;
  }

  public int getSizeOfDirectory() {
    return files.size();
  }


  public void setFiles(LinkedList<TextFile> files) {
    this.files = files;
  }

  // создание текстового файла
  public boolean createTextFile(String name, String extension) {
    boolean resolution = true;
    // проверка на совпадение имен
    for (int i = 0; i < files.size(); i++) {
      if (name.equals(files.get(i).getName())) {
        resolution = false;
        break;
      }
    }
    if (resolution) {
      files.add(new TextFile(name, extension, false));
    } else {
      return false;
    }
    return true;
  }

  // удаление текстового файла
  public void deleteTextFile(String name) {
    for (int i = 0; i < files.size(); i++) {
      if (name.equals(files.get(i).getName())) {
        files.remove(i);
        break;
      }
    }
  }

}
